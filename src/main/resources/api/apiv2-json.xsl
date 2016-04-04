<?xml version="1.0" encoding="UTF-8"?>
<!--
    Transforms Eve Online API v2 XML into more humane JSON
    XML API: http://ned.karbowiak.dk/API
-->
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output indent="no" method="text"/>
    <xsl:variable name="quote">"</xsl:variable>
    <xsl:variable name="escaped">\\"</xsl:variable>

    <xsl:template match="*">
        "<xsl:value-of select="name()"/>": "<xsl:value-of select="normalize-space(text())"/>"
        <xsl:if test="not(position() = last())">,</xsl:if>
    </xsl:template>

    <xsl:template match="result">
        <xsl:apply-templates select="*"/>
    </xsl:template>

    <xsl:template match="rowset">
        "<xsl:value-of select="@name"/>": [<xsl:apply-templates select="row"/>]
        <xsl:if test="not(position() = last())">,</xsl:if>
    </xsl:template>

    <xsl:template match="row">
        {
        <xsl:for-each select="@*">
            "<xsl:value-of select="name()"/>": "<xsl:value-of select="normalize-space(replace(., $quote, $escaped))"/>"
            <xsl:if test="not(position() = last())">,</xsl:if>
        </xsl:for-each>
        <xsl:for-each select="rowset">
            ,
            <xsl:apply-templates select="."/>
        </xsl:for-each>
        }
        <xsl:if test="not(position() = last())">,</xsl:if>
    </xsl:template>

    <xsl:template match="error">
        "errorCode": "<xsl:value-of select="@code"/>",
        "errorMessage": "<xsl:value-of select="normalize-space(text())"/>"
    </xsl:template>

    <xsl:template match="eveapi">
        "createdTime": "<xsl:value-of select="currentTime"/>",
        "cachedUntil": "<xsl:value-of select="cachedUntil"/>",

        <xsl:apply-templates select="result"/>
        <xsl:apply-templates select="error"/>
    </xsl:template>

    <xsl:template match="/">
        {<xsl:apply-templates/>}
    </xsl:template>

</xsl:stylesheet>