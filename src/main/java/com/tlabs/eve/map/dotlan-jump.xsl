<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="tr">
   <tr>   
    <td><xsl:value-of select="./td[position()=2]"/></td> <!-- region -->
    <td><xsl:value-of select="./td[position()=3]"/></td> <!-- System --> 
    <td><xsl:value-of select="./td[position()=4]"/></td> <!-- Security -->
    <td><xsl:value-of select="./td[position()=5]/i"/></td> <!-- Holder -->
    <td><xsl:value-of select="./td[position()=6]/b"/></td> <!-- Kills -->
    <td><xsl:value-of select="./td[position()=7]/b"/></td> <!-- Jumps -->
    
    
   </tr>
</xsl:template>
<xsl:template match="/">  
    <table>    
    	<xsl:apply-templates select="./table"/>
    </table>
</xsl:template>

</xsl:stylesheet>