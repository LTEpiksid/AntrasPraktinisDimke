<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html xmlns:th="http://www.thymeleaf.org">
            <head>
                <meta charset="UTF-8">
                <title>VIKO Racing Database</title>
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
                    /* Modal styles */
                    .modal {
                    display: none;
                    position: fixed;
                    z-index: 1;
                    left: 0;
                    top: 0;
                    width: 100%;
                    height: 100%;
                    overflow: auto;
                    background-color: rgba(0,0,0,0.4);
                    padding-top: 60px;
                    }
                    .modal-content {
                    background-color: #fefefe;
                    margin: 5% auto;
                    padding: 20px;
                    border: 1px solid #888;
                    width: 80%;
                    }
                    .close {
                    color: #aaa;
                    float: right;
                    font-size: 28px;
                    font-weight: bold;
                    }
                    .close:hover,
                    .close:focus {
                    color: black;
                    text-decoration: none;
                    cursor: pointer;
                    }
                </style>
            </head>
            <body>
                <img src="/Image/Logo.png" alt="Logo" class="logo"/>
                <div class="container">
                    <h1>VIKO Racing Database</h1>
                    <button id="pdfButton">Racer Info</button>
                    <button id="raceInfoButton">Race Info</button>
                    <form method="get" action="/mainpage">
                        <button type="submit">Back to Main Page</button>
                    </form>
                </div>
                <!-- Racer Info Modal -->
                <div id="pdfModal" class="modal">
                    <div class="modal-content">
                        <span class="close">&amp;times;</span>
                        <form method="post" action="/generate-racer-pdf">
                            <label for="racerId">Racer ID:</label>
                            <input type="text" id="racerId" name="racerId" required="required"/>
                            <button type="submit">Generate PDF</button>
                        </form>
                    </div>
                </div>
                <!-- Race Info Modal -->
                <div id="raceInfoModal" class="modal">
                    <div class="modal-content">
                        <span class="close">&amp;times;</span>
                        <form method="post" action="/generate-raceinfo-pdf">
                            <label for="raceId">Race ID:</label>
                            <input type="text" id="raceId" name="raceId" required="required"/>
                            <button type="submit">Generate PDF</button>
                        </form>
                    </div>
                </div>
                <script>
                    // Racer Info Modal
                    var pdfModal = document.getElementById("pdfModal");
                    var pdfBtn = document.getElementById("pdfButton");
                    var pdfSpan = document.getElementsByClassName("close")[0];
                    pdfBtn.onclick = function() {
                    pdfModal.style.display = "block";
                    }
                    pdfSpan.onclick = function() {
                    pdfModal.style.display = "none";
                    }

                    // Race Info Modal
                    var raceInfoModal = document.getElementById("raceInfoModal");
                    var raceInfoBtn = document.getElementById("raceInfoButton");
                    var raceInfoSpan = document.getElementsByClassName("close")[1];
                    raceInfoBtn.onclick = function() {
                    raceInfoModal.style.display = "block";
                    }
                    raceInfoSpan.onclick = function() {
                    raceInfoModal.style.display = "none";
                    }

                    // Close modal when clicking outside of it
                    window.onclick = function(event) {
                    if (event.target == pdfModal) {
                    pdfModal.style.display = "none";
                    }
                    if (event.target == raceInfoModal) {
                    raceInfoModal.style.display = "none";
                    }
                    }
                </script>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
