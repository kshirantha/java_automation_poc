import org.testng.TestNG;
import org.w3c.dom.*;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.util.*;

public class TestNgRunner {
    public static Map<String, Element> classesMap;

    public static void main(String[] args) {
        classesMap = new HashMap<String, Element>();
        readXmlToPopulateMap("./src/profiles/saudi/CountryLevelTestSuite.xml");
        readXmlToPopulateMap("./src/profiles/saudi/sfc/BrokerLevelTestSuite.xml");
        updateMultiLevelXml();
        executeMultiLevelXml();
    }

    private static void readXmlToPopulateMap(String xml) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(new File(xml));
            doc.getDocumentElement().normalize();

            NodeList list = doc.getElementsByTagName("class");

            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    classesMap.put(element.getAttribute("id"), element);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void updateMultiLevelXml() {
        List<String> replacedClasses = new ArrayList<String>();

        try (InputStream is = new FileInputStream("./src/profiles/core/CoreLevelTestSuite.xml")) {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(is);

            doc.getDocumentElement().setAttribute("name", "MultiLevelTestSuite");
            doc.getElementsByTagName("test").item(0).getAttributes().getNamedItem("name").setTextContent("Automation");

            Node coreClassesNode = doc.getElementsByTagName("classes").item(0);
            NodeList coreClassesList = doc.getElementsByTagName("class");
            boolean replaced = false;

            Iterator iterator = classesMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry pair = (Map.Entry) iterator.next();

                for (int i = 0; i < coreClassesList.getLength(); i++) {
                    Node coreNode = coreClassesList.item(i);

                    if (coreNode.getNodeType() == Node.ELEMENT_NODE) {
                        String id = coreNode.getAttributes().getNamedItem("id").getTextContent();

                        if (id.equals(pair.getKey()) && !replacedClasses.contains(id)) {
                            Node nextSibling = coreNode.getNextSibling();
                            coreClassesNode.removeChild(coreNode);

                            Node replacingNode = doc.importNode(classesMap.get(id), true);
                            coreClassesNode.insertBefore(replacingNode, nextSibling);

                            replacedClasses.add(id);
                            replaced = true;
                            break;
                        }
                    }
                }

                if (!replaced) {
                    Node additionalNode = doc.importNode((Node)pair.getValue(), true);
                    coreClassesNode.appendChild(additionalNode);
                }

                replaced = false;
            }

            try (FileOutputStream output =
                         new FileOutputStream("./src/profiles/MultiLevelTestSuite.xml")) {
                writeXml(doc, output);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void writeXml(Document doc,
                                 OutputStream output) {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();

            Transformer transformer = transformerFactory.newTransformer(
                    new StreamSource(new File("./format.xslt")));

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.STANDALONE, "no");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(output);

            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void executeMultiLevelXml(){
        TestNG runner=new TestNG();
        List<String> suites=new ArrayList<String>();
        suites.add("./src/profiles/MultiLevelTestSuite.xml");
        runner.setTestSuites(suites);
        runner.run();
    }
}