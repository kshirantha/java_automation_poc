<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"   xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <suite>
            <xsl:variable name="name" select="/suite/@name"/>
            <xsl:attribute name="name"><xsl:value-of select="$name"/></xsl:attribute>
            <test>
                <xsl:variable name="name" select="/suite/test/@name"/>
                <xsl:attribute name="name"><xsl:value-of select="$name"/></xsl:attribute>
                <classes>
                    <xsl:for-each select="/suite/test/classes/class">
                        <class>
                            <xsl:variable name="name" select="./@name"/>
                            <xsl:attribute name="name"><xsl:value-of select="$name"/></xsl:attribute>
                            <xsl:attribute name="id"><xsl:value-of select="./@id"/></xsl:attribute>
                            <methods>
                                <exclude>
                                    <xsl:value-of   select="./methods/exclude"/>
                                    <xsl:variable name="name" select="./methods/exclude/@name"/>
                                    <xsl:attribute name="name"><xsl:value-of select="$name"/></xsl:attribute>
                                </exclude>
                            </methods>
                        </class>
                    </xsl:for-each>
                </classes>
            </test>
        </suite>
    </xsl:template>
</xsl:stylesheet>