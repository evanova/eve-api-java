<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="text"/>
<xsl:template match="tr">
    {
        "regionName" : "<xsl:value-of select="normalize-space(./td[position()=2])"/>",
        "solarSystemName" : "<xsl:value-of select="normalize-space(./td[position()=3])"/>",
        "securityStatus" : "<xsl:value-of select="normalize-space(./td[position()=4])"/>",
        "holderName" : "<xsl:value-of select="normalize-space(./td[position()=5]/i)"/>",
        "shipKills" : "<xsl:value-of select="normalize-space(./td[position()=6]/b)"/>",
        "shipJumps" : "<xsl:value-of select="normalize-space(./td[position()=7]/b)"/>"
   }
    <xsl:if test="position() != last() - 1">,</xsl:if>
</xsl:template>


<xsl:template match="/">
    [<xsl:apply-templates select="./table"/>]
</xsl:template>

</xsl:stylesheet>