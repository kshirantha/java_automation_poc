public class Start {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chrome/chromedriver.exe");

        Actions actions = new Actions();
        actions.Visit_Aura_Go_to_URL();
    }
}