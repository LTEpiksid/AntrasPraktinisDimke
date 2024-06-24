<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html xmlns:th="http://www.thymeleaf.org">
            <head>
                <meta charset="UTF-8"/>
                <title>Racers Table</title>
                <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&amp;display=swap" rel="stylesheet"/>
                <style>
                    body {
                    position: relative;
                    color: white;
                    font-family: 'Montserrat', Arial, sans-serif;
                    display: flex;
                    flex-direction: column;
                    align-items: center;
                    justify-content: center;
                    height: 100vh;
                    margin: 0;
                    }
                    body::before {
                    content: '';
                    position: absolute;
                    top: 0;
                    left: 0;
                    width: 100%;
                    height: 100%;
                    background: url('/Image/checker.gif') repeat;
                    z-index: -2;
                    }
                    body::after {
                    content: '';
                    position: absolute;
                    top: 0;
                    left: 0;
                    width: 100%;
                    height: 100%;
                    background: url('/Image/Background.png') no-repeat center center;
                    background-size: cover;
                    z-index: -1;
                    }
                    h1 {
                    color: white;
                    margin: 20px 0;
                    text-align: left;
                    font-size: 3em; /* Twice as big */
                    }
                    table {
                    width: 80%;
                    margin: 20px auto;
                    border-collapse: collapse;
                    background-color: white;
                    color: black;
                    font-family: 'Montserrat', Arial, sans-serif;
                    }
                    th, td {
                    padding: 10px;
                    text-align: left;
                    border: 1px solid #ddd;
                    }
                    th {
                    background-color: #f2f2f2;
                    }
                    .logo {
                    position: absolute;
                    top: 20px;
                    left: 20px;
                    width: 250px; /* 2.5 times bigger */
                    height: auto;
                    }
                    .container {
                    text-align: left;
                    position: absolute;
                    top: 200px; /* Adjusted to be below the logo */
                    left: 30%;
                    transform: translate(-50%, 0);
                    }
                </style>
            </head>
            <body>
                <img src="/Image/Logo.png" alt="Logo" class="logo"/>
                <div class="container">
                    <h1>Racers Table</h1>
                    <table>
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Phone Number</th>
                                <th>Status</th>
                            </tr>
                        </thead>
                        <tbody>
                            <xsl:for-each select="//racer">
                                <tr>
                                    <td><xsl:value-of select="id"/></td>
                                    <td><xsl:value-of select="firstName"/></td>
                                    <td><xsl:value-of select="lastName"/></td>
                                    <td><xsl:value-of select="phoneNumber"/></td>
                                    <td><xsl:value-of select="status/statusName"/></td>
                                </tr>
                            </xsl:for-each>
                        </tbody>
                    </table>
                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
