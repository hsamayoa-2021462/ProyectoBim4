<%-- 
    Document   : index
    Created on : 2 sept 2025, 08:37:53
    Author     : informatica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Juego Del Ahorcado</title>

        <link rel="stylesheet" href="css/styles.css"/>
    </head>
    <body>
        <div class="game-container">
            <div class="header">
                <h1>Juego Del Ahorcado</h1>
                <img class="logo-placeholder" src="" alt="Logo de AORCADO" />
            </div>

            <div class="main-game-area">
                <div class="game-status-and-clues">
                    <div class="hangman-area">
                        <canvas id="hangman-canvas" class="hangman-canvas" width="200" height="250"></canvas>
                        <div id="timer-display" class="timer-display">00:00</div>
                    </div>

                    <div id="clues-section" class="clues-section">
                        <h2>Pistas de la Palabra</h2>
                        <ul id="clues-list">
                            <li>Primera pista</li>
                            <li>Segunda Pista</li>
                            <li>Tercera Pista</li>
                        </ul>
                    </div>
                </div>

                <div id="word-display" class="word-display"></div>
                <div id="message-box" class="message-box">Presiona "Iniciar" para comenzar.</div>
                <div id="keyboard" class="keyboard"></div>

                <div class="control-buttons">
                    <button id="start-btn" class="start-btn">Iniciar</button>
                    <button id="restart-btn" class="restart-btn" disabled>Reiniciar</button>
                    <button id="pause-btn" class="pause-btn" disabled>Pausar</button>
                    <button id="exit-btn" class="exit-btn">Salir</button>
                </div>
            </div>
        </div>

        <script src="js/script.js"></script>
    </body>
</html>
