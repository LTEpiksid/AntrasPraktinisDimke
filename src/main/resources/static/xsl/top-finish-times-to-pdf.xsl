<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fo="http://www.w3.org/1999/XSL/Format">
    <xsl:template match="/top_finishes">
        <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
            <fo:layout-master-set>
                <fo:simple-page-master master-name="A4" page-height="29.7cm" page-width="21cm" margin="2cm">
                    <fo:region-body margin-top="2cm" margin-bottom="2cm"/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="A4">
                <fo:flow flow-name="xsl-region-body">
                    <!-- Header -->
                    <fo:block text-align="center" font-size="18pt" font-family="sans-serif" font-weight="bold" space-after.optimum="12pt">
                        Top 10 Fastest Finishes
                    </fo:block>

                    <!-- Table Header -->
                    <fo:table table-layout="fixed" width="100%">
                        <fo:table-column column-width="2cm"/>
                        <fo:table-column column-width="5cm"/>
                        <fo:table-column column-width="5cm"/>
                        <fo:table-column column-width="3cm"/>
                        <fo:table-header>
                            <fo:table-row background-color="#f2f2f2">
                                <fo:table-cell padding="5pt" border="solid 1pt black">
                                    <fo:block font-weight="bold">ID</fo:block>
                                </fo:table-cell>
                                <fo:table-cell padding="5pt" border="solid 1pt black">
                                    <fo:block font-weight="bold">First Name</fo:block>
                                </fo:table-cell>
                                <fo:table-cell padding="5pt" border="solid 1pt black">
                                    <fo:block font-weight="bold">Last Name</fo:block>
                                </fo:table-cell>
                                <fo:table-cell padding="5pt" border="solid 1pt black">
                                    <fo:block font-weight="bold">Finish Time</fo:block>
                                </fo:table-cell>
                            </fo:table-row>
                        </fo:table-header>
                        <fo:table-body>
                            <xsl:for-each select="finish">
                                <fo:table-row>
                                    <fo:table-cell padding="5pt" border="solid 1pt black">
                                        <fo:block><xsl:value-of select="racer_id"/></fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="5pt" border="solid 1pt black">
                                        <fo:block><xsl:value-of select="first_name"/></fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="5pt" border="solid 1pt black">
                                        <fo:block><xsl:value-of select="last_name"/></fo:block>
                                    </fo:table-cell>
                                    <fo:table-cell padding="5pt" border="solid 1pt black">
                                        <fo:block><xsl:value-of select="finish_time"/></fo:block>
                                    </fo:table-cell>
                                </fo:table-row>
                            </xsl:for-each>
                        </fo:table-body>
                    </fo:table>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>
