<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html xmlns:th="http://www.thymeleaf.org">
            <head>
                <title>Main Page</title>
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
                    font-size: 3em;
                    }
                    button {
                    color: black;
                    display: block;
                    margin: 10px 0;
                    width: 100%;
                    max-width: 400px;
                    padding: 20px;
                    font-family: 'Montserrat', Arial, sans-serif;
                    font-size: 1.5em;
                    }
                    form {
                    margin: 10px 0;
                    text-align: left;
                    }
                    .logo {
                    position: absolute;
                    top: 20px;
                    left: 20px;
                    width: 250px;
                    height: auto;
                    }
                    .container {
                    text-align: left;
                    position: absolute;
                    top: 200px;
                    left: 30%;
                    transform: translate(-50%, 0);
                    }
                </style>
            </head>
            <body>
                <img src="/Image/Logo.png" alt="Logo" class="logo"/>
                <div class="container">
                    <h1>VIKO Racing Database</h1>
                    <form method="get" action="/database">
                        <button type="submit">Database</button>
                    </form>
                    <form method="get" action="/pdf-main">
                        <button type="submit">PDF</button>
                    </form>
                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
