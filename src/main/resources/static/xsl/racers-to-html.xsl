<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html" indent="yes" encoding="UTF-8"/>
    <xsl:template match="/">
        <html>
            <head>
                <title>Racers Information</title>
                <style>
                    body {
                    font-family: Arial, sans-serif;
                    }
                    table {
                    width: 100%;
                    border-collapse: collapse;
                    }
                    th, td {
                    border: 1px solid #ddd;
                    padding: 8px;
                    text-align: left;
                    }
                    th {
                    background-color: #f2f2f2;
                    }
                </style>
            </head>
            <body>
                <h1>Racers Information</h1>
                <table>
                    <tr>
                        <th>ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Phone Number</th>
                        <th>Status</th>
                    </tr>
                    <xsl:for-each select="racers/racer">
                        <tr>
                            <td><xsl:value-of select="id"/></td>
                            <td><xsl:value-of select="first_name"/></td>
                            <td><xsl:value-of select="last_name"/></td>
                            <td><xsl:value-of select="phone_number"/></td>
                            <td><xsl:value-of select="status"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
