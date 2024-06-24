<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fo="http://www.w3.org/1999/XSL/Format">
    <xsl:template match="/racer">
        <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
            <fo:layout-master-set>
                <fo:simple-page-master master-name="A4" page-height="29.7cm" page-width="21cm" margin="2cm">
                    <fo:region-body margin-top="2cm" margin-bottom="2cm"/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="A4">
                <fo:flow flow-name="xsl-region-body">
                    <!-- Helmet Image -->
                    <fo:block text-align="center" font-family="sans-serif">
                        <fo:external-graphic src="{helmet_image_path}" content-width="150px" content-height="150px"/>
                    </fo:block>

                    <!-- ID -->
                    <fo:block text-align="right" font-size="8pt" font-family="sans-serif" space-after.optimum="12pt">
                        ID: <xsl:value-of select="id"/>
                    </fo:block>

                    <!-- Name -->
                    <fo:block text-align="center" font-size="18pt" font-family="sans-serif" font-weight="bold" space-after.optimum="12pt">
                        <xsl:value-of select="first_name"/> <xsl:value-of select="last_name"/>
                    </fo:block>

                    <!-- Phone Number -->
                    <fo:block text-align="center" font-size="12pt" font-family="sans-serif" space-after.optimum="12pt">
                        Phone Number: <xsl:value-of select="phone_number"/>
                    </fo:block>

                    <!-- Status, Races Involved, Wins -->
                    <fo:block font-size="12pt" font-family="sans-serif" space-after.optimum="12pt">
                        <fo:block text-align="left">
                            <xsl:value-of select="status"/> Racer
                        </fo:block>
                        <fo:block text-align="left">
                            Races involved: <xsl:value-of select="races_involved"/>
                        </fo:block>
                        <fo:block text-align="left">
                            Wins: <xsl:value-of select="wins"/>
                        </fo:block>
                    </fo:block>

                    <!-- Badge Image Conditional -->
                    <xsl:if test="wins > 0">
                        <fo:block text-align="right" font-family="sans-serif" space-before.optimum="100pt">
                            <fo:external-graphic src="{win_image_path}" content-width="100px" content-height="100px"/>
                        </fo:block>
                    </xsl:if>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>
