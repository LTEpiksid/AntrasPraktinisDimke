<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fo="http://www.w3.org/1999/XSL/Format">

    <xsl:template match="/">
        <html xmlns:th="http://www.thymeleaf.org">
            <head>
                <meta charset="UTF-8"/>
                <title>Database Tables</title>
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

                    button {
                    color: black;
                    display: block;
                    margin: 10px 0;
                    width: 100%;
                    max-width: 400px; /* Twice as wide */
                    padding: 20px; /* Twice the padding */
                    font-family: 'Montserrat', Arial, sans-serif;
                    font-size: 1.5em; /* Larger font size */
                    }

                    form {
                    margin: 10px 0;
                    text-align: left;
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
                    <h1>Database Tables</h1>
                    <form method="get" action="/races">
                        <button type="submit">Show Races Table</button>
                    </form>
                    <form method="get" action="/racers">
                        <button type="submit">Show Racers Table</button>
                    </form>
                    <form method="get" action="/statuses">
                        <button type="submit">Show Statuses Table</button>
                    </form>
                    <form method="get" action="/raceinfos">
                        <button type="submit">Show RaceInfo Table</button>
                    </form>
                    <form id="loadDatabaseForm" method="post" action="/loaddatabase" onsubmit="return handleLoadDatabase(event)">
                        <button type="submit">Load Database</button>
                    </form>
                    <form method="get" action="/mainpage">
                        <button type="submit">Back to Main Page</button>
                    </form>
                </div>

                <script>
                    async function handleLoadDatabase(event) {
                    event.preventDefault(); // Prevent the form from submitting in the traditional way
                    const form = event.target;

                    try {
                    const response = await fetch(form.action, {
                    method: form.method,
                    headers: {
                    'Content-Type': 'application/x-www-form-urlencoded'
                    }
                    });

                    if (response.ok) {
                    alert('Database initialized!');
                    } else {
                    alert('Failed to initialize database.');
                    }
                    } catch (error) {
                    console.error('Error initializing database:', error);
                    alert('An error occurred while initializing the database.');
                    }

                    return false;
                    }
                </script>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
