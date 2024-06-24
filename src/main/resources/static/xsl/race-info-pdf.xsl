<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fo="http://www.w3.org/1999/XSL/Format">
    <xsl:template match="/race">
        <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
            <fo:layout-master-set>
                <fo:simple-page-master master-name="A4" page-height="29.7cm" page-width="21cm" margin="2cm">
                    <fo:region-body margin-top="2cm" margin-bottom="2cm"/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="A4">
                <fo:flow flow-name="xsl-region-body">
                    <!-- Flag Image -->
                    <fo:block text-align="right" font-family="sans-serif">
                        <fo:external-graphic src="{flag_image_path}" content-width="200px" content-height="200px"/>
                    </fo:block>

                    <!-- Race Name -->
                    <fo:block text-align="center" font-size="18pt" font-family="sans-serif" font-weight="bold" space-after.optimum="12pt">
                        Race: <xsl:value-of select="name"/>
                    </fo:block>

                    <!-- Race Location -->
                    <fo:block text-align="center" font-size="12pt" font-family="sans-serif" space-after.optimum="12pt">
                        Location: <xsl:value-of select="location"/>
                    </fo:block>

                    <!-- Race Date -->
                    <fo:block text-align="center" font-size="12pt" font-family="sans-serif" space-after.optimum="12pt">
                        Date: <xsl:value-of select="date"/>
                    </fo:block>

                    <!-- Participants Header -->
                    <fo:block text-align="left" font-size="14pt" font-family="sans-serif" font-weight="bold" space-before.optimum="12pt" space-after.optimum="12pt">
                        Participants:
                    </fo:block>

                    <!-- Participant List -->
                    <fo:table table-layout="fixed" width="100%">
                        <fo:table-column column-width="5cm"/>
                        <fo:table-column column-width="5cm"/>
                        <fo:table-column column-width="3cm"/>
                        <fo:table-column column-width="2cm"/>
                        <fo:table-header>
                            <fo:table-row background-color="#f2f2f2">
                                <fo:table-cell padding="5pt" border="solid 1pt black">
                                    <fo:block font-weight="bold">First Name</fo:block>
                                </fo:table-cell>
                                <fo:table-cell padding="5pt" border="solid 1pt black">
                                    <fo:block font-weight="bold">Last Name</fo:block>
                                </fo:table-cell>
                                <fo:table-cell padding="5pt" border="solid 1pt black">
                                    <fo:block font-weight="bold">Finish Time</fo:block>
                                </fo:table-cell>
                                <fo:table-cell padding="5pt" border="solid 1pt black">
                                    <fo:block font-weight="bold">Position</fo:block>
                                </fo:table-cell>
                            </fo:table-row>
                        </fo:table-header>
                        <fo:table-body>
                            <xsl:for-each select="participants/participant">
                                <fo:table-row>
                                    <fo:table-cell padding="5pt" border="solid 1pt black">
                                        <fo:block><xsl:value-of select="first_name"/></fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="5pt" border="solid 1pt black">
                                        <fo:block><xsl:value-of select="last_name"/></fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="5pt" border="solid 1pt black">
                                        <fo:block><xsl:value-of select="finish_time"/></fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="5pt" border="solid 1pt black">
                                        <fo:block><xsl:value-of select="position"/></fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </xsl:for-each>
                        </fo:table-body>
                    </fo:table>

                    <!-- Race Winner -->
                    <xsl:variable name="winner" select="participants/participant[position=1]"/>
                    <fo:block text-align="left" font-size="14pt" font-family="sans-serif" font-weight="bold" space-before.optimum="12pt" space-after.optimum="12pt">
                        Winner:
                    </fo:block>
                    <fo:block text-align="left" font-size="12pt" font-family="sans-serif">
                        <xsl:value-of select="$winner/first_name"/> <xsl:value-of select="$winner/last_name"/> with a finish time of <xsl:value-of select="$winner/finish_time"/>
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>
