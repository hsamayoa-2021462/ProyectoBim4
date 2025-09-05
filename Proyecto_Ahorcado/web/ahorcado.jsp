<%-- 
    Document   : ahorcado
    Created on : 4 sept 2025, 17:11:07
    Author     : VictorHugo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Juego Del Ahorcado</title>

        <link rel="stylesheet" href="css/styles.css" />
        <link rel="icon" href="image/logo1.png" type="image/png">
        <script src="js/MyScript.js" defer></script>
    </head>
    <body>
        <div class="game-container">
            <div class="header">
                <h1>Juego Del Ahorcado</h1>
            </div>

            <div class="main-game-area">
                <div class="game-status-and-clues">
                    <div class="hangman-area">
                        <img id="imagen" src="image/imagen0.png" alt="Hangman" width="200" height="250" />
                        <div id="timer-display" class="timer-display">10:00</div>
                    </div>

                    <div id="clues-section" class="clues-section">
                        <h2>Pistas de la Palabra</h2>
                        <!-- ✅ Aquí dejamos la lista vacía para que el JS inserte las pistas dinámicamente -->
                        <ul id="clues-list"></ul>
                    </div>
                </div>

                <p id="palabraAdivinar"></p>
                <div id="word-display" class="word-display"></div>
                <div id="message-box" class="message-box">Presiona "Iniciar" para comenzar.</div>

                <div class="control-buttons">
                    <button id="jugar" class="start-btn">Iniciar</button>
                    <button id="restart-btn" class="restart-btn" disabled>Reiniciar</button>
                    <button id="pause-btn" class="pause-btn" disabled>Pausar</button>
                    <button id="exit-btn" class="exit-btn">Salir</button>
                </div>

                <div id="letras">
                    <button class="letra">A</button>
                    <button class="letra">B</button>
                    <button class="letra">C</button>
                    <button class="letra">D</button>
                    <button class="letra">E</button>
                    <button class="letra">F</button>
                    <button class="letra">G</button>
                    <button class="letra">H</button>
                    <button class="letra">I</button>
                    <button class="letra">J</button>
                    <button class="letra">K</button>
                    <button class="letra">L</button>
                    <button class="letra">M</button>
                    <button class="letra">N</button>
                    <button class="letra">Ñ</button>
                    <button class="letra">O</button>
                    <button class="letra">P</button>
                    <button class="letra">Q</button>
                    <button class="letra">R</button>
                    <button class="letra">S</button>
                    <button class="letra">T</button>
                    <button class="letra">U</button>
                    <button class="letra">V</button>
                    <button class="letra">W</button>
                    <button class="letra">X</button>
                    <button class="letra">Y</button>
                    <button class="letra">Z</button>
                </div>
            </div>
        </div>

        <!-- Modal para mostrar una vista extra cuando se gana el juego
        y rebela la imagen de la palabra descubierta-->
        <div id="win-modal" class="modal">
            <div class="modal-content">
                <h2 id="modal-message"></h2>
                <img id="modal-image" src="" alt="La palabra descubierta es correcta" />
                <button id="close-modal">Cerrar</button>
            </div>
        </div>
    </body>
</html>
