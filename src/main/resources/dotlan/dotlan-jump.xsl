<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="text"/>
    <!-- {
    "1": "1.",
    "2": "Stain",
    "3": "1H4V-O",
    "4": "-0.10",
    "5": "Sansha's Nation",
    "6": "",
    "7": ""
  },
  {
    "1": "",
    "2": "Jump to",
    "3": "Distance: 1.826 ly (2 jumps)",
    "4": "Fuel needed: 1,369 Oxygen Isotopes",
    "5": "",
    "6": "",
    "7": ""
  } -->
    <xsl:template match="tr" mode="start">
        "regionName" : "<xsl:value-of select="normalize-space(./td[position()=2])"/>",
        "solarSystemName" : "<xsl:value-of select="normalize-space(./td[position()=3])"/>",
        "securityStatus" : "<xsl:value-of select="normalize-space(./td[position()=4])"/>",
        "holderName" : "<xsl:value-of select="normalize-space(./td[position()=5])"/>"
    </xsl:template>

    <xsl:template match="tr" mode="end">
        "distanceToNext" : "<xsl:value-of select="normalize-space(./td[position()=3])"/>",
        "fuelToNext" : "<xsl:value-of select="normalize-space(./td[position()=4])"/>"
    </xsl:template>

    <xsl:template match="tr">
        <xsl:choose>
            <xsl:when test="normalize-space(./td[position()=1]) = ''">
                <xsl:apply-templates select="." mode="end"/>
                }
                <xsl:if test="position() != last() - 1">,</xsl:if>
            </xsl:when>
            <xsl:otherwise>
                {
                <xsl:apply-templates select="." mode="start"/>
                <xsl:choose>
                    <xsl:when test="position() = last() - 1">}</xsl:when>
                    <xsl:otherwise>,</xsl:otherwise>
                </xsl:choose>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:template>


    <xsl:template match="/">
        [<xsl:apply-templates select="./table"/>]
    </xsl:template>

</xsl:stylesheet>