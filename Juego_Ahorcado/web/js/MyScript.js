document.addEventListener("DOMContentLoaded", function () {
    const hangmanImage = document.getElementById("imagen");
    const wordDisplay = document.getElementById("palabraAdivinar");
    const messageBox = document.getElementById("message-box");
    const startButton = document.getElementById("jugar");
    const restartButton = document.getElementById("restart-btn");
    const pauseButton = document.getElementById("pause-btn");
    const exitButton = document.getElementById("exit-btn");
    const letterButtons = document.querySelectorAll(".letra");
    const cluesList = document.getElementById("clues-list");
    const timerDisplay = document.getElementById("timer-display");
    const winModal = document.getElementById("win-modal");
    const modalMessage = document.getElementById("modal-message");
    const modalImage = document.getElementById("modal-image");
    const closeModalButton = document.getElementById("close-modal");

    let palabras = [];
    let palabraSecreta = "";
    let palabraOculta = [];
    let errores = 0;
    const maxErrores = 6;
    let juegoPausado = false;
    let imagenPalabra = "";
    let tiempoRestante = 600; // 10 minutos
    let temporizador = null;

    // Cargar palabras desde el servlet PalabraMP
    async function cargarPalabras() {
        const res = await fetch('PalabraMP');
        palabras = await res.json();
    }

    // Formatear tiempo mm:ss
    function formatearTiempo(segundos) {
        const minutos = Math.floor(segundos / 60);
        const segundosRestantes = segundos % 60;
        return `${minutos.toString().padStart(2, "0")}:${segundosRestantes.toString().padStart(2, "0")}`;
    }

    // Actualizar el temporizador cada segundo
    function actualizarTemporizador() {
        if (tiempoRestante <= 0) {
            clearInterval(temporizador);
            temporizador = null;
            messageBox.textContent = `¡Tiempo Agotado! La palabra era ${palabraSecreta}.`;
            deshabilitarBotonesJuego();
            return;
        }
        timerDisplay.textContent = formatearTiempo(tiempoRestante);
        tiempoRestante--;
    }

    // Iniciar el temporizador (solo si no hay uno corriendo)
    function iniciarTemporizador() {
        if (!temporizador) {
            temporizador = setInterval(actualizarTemporizador, 1000);
        }
    }

    // Detener el temporizador
    function detenerTemporizador() {
        if (temporizador) {
            clearInterval(temporizador);
            temporizador = null;
        }
    }

    // Mostrar modal ganador
    function mostrarModalGanador() {
        modalMessage.textContent = `¡Has Ganado! La palabra es ${palabraSecreta}`;
        modalImage.src = imagenPalabra;
        winModal.style.display = "flex";
    }

    function cerrarModal() {
        winModal.style.display = "none";
    }

    // Mostrar pistas
    function mostrarPistas(pistas) {
        cluesList.innerHTML = "";
        pistas.forEach(pista => {
            const li = document.createElement("li");
            li.textContent = pista;
            cluesList.appendChild(li);
        });
    }

    // Actualizar pantalla
    function actualizarPantalla() { 
        wordDisplay.textContent = palabraOculta.join(" "); 
    }

    function actualizarImagenAhorcado() { 
        hangmanImage.src = `Images/imagen${errores}.png`; 
    }

    // Inicializar juego
    function inicializarJuego() {
        const seleccion = palabras[Math.floor(Math.random() * palabras.length)];
        palabraSecreta = seleccion.palabra;
        palabraOculta = Array(palabraSecreta.length).fill("_");
        errores = 0;
        juegoPausado = false;
        imagenPalabra = "Images/" + palabraSecreta.toLowerCase() + ".png"; // opcional
        actualizarImagenAhorcado();
        actualizarPantalla();
        mostrarPistas(seleccion.pistas);
        tiempoRestante = 600; // reiniciar tiempo al iniciar juego
        timerDisplay.textContent = formatearTiempo(tiempoRestante);
        iniciarTemporizador();
        winModal.style.display = "none";
        letterButtons.forEach(b => b.disabled = false);
        restartButton.disabled = false;
        pauseButton.disabled = false;
    }

    // Verificar letra
    function verificarLetra(letra) {
        if (juegoPausado) return;
        let letraCorrecta = false;
        letra = letra.toUpperCase();
        for (let i = 0; i < palabraSecreta.length; i++) {
            if (palabraSecreta[i].toUpperCase() === letra) {
                palabraOculta[i] = palabraSecreta[i];
                letraCorrecta = true;
            }
        }
        if (!letraCorrecta) errores++;
        actualizarPantalla();
        actualizarImagenAhorcado();
        comprobarEstadoJuego();
    }

    // Comprobar estado del juego
    function comprobarEstadoJuego() {
        if (palabraOculta.join("") === palabraSecreta) {
            mostrarModalGanador();
            deshabilitarBotonesJuego();
            detenerTemporizador();
        } else if (errores >= maxErrores) {
            messageBox.textContent = `Has Perdido. La palabra era ${palabraSecreta}.`;
            deshabilitarBotonesJuego();
            detenerTemporizador();
        }
    }

    // Deshabilitar botones del juego
    function deshabilitarBotonesJuego() {
        letterButtons.forEach(b => b.disabled = true);
        restartButton.disabled = false;
        pauseButton.disabled = true;
    }

    // Funciones principales
    function reiniciarJuego() { 
        inicializarJuego(); 
    }

    function pausarJuego() {
        juegoPausado = !juegoPausado;
        if (juegoPausado) {
            messageBox.textContent = "Juego pausado";
            letterButtons.forEach(b => b.disabled = true);
            pauseButton.textContent = "Reanudar";
            detenerTemporizador();
        } else {
            messageBox.textContent = "¡Adivina la palabra!";
            letterButtons.forEach(b => b.disabled = false);
            pauseButton.textContent = "Pausar";
            iniciarTemporizador(); // continúa desde donde quedó
        }
    }

    function salirJuego() {
        if (confirm("¿Seguro que deseas salir?")) {
            messageBox.textContent = "¡Gracias por jugar!";
            deshabilitarBotonesJuego();
            startButton.disabled = false;
            restartButton.disabled = true;
            pauseButton.disabled = true;
            detenerTemporizador();
            winModal.style.display = "none";
            window.location.href = "Controlador?menu=Principal"; // redirige al index
        }
    }

    // Eventos
    startButton.addEventListener("click", inicializarJuego);
    restartButton.addEventListener("click", reiniciarJuego);
    pauseButton.addEventListener("click", pausarJuego);
    exitButton.addEventListener("click", salirJuego);
    closeModalButton.addEventListener("click", cerrarModal);

    letterButtons.forEach(button => {
        button.addEventListener("click", function () {
            const letra = button.textContent;
            button.disabled = true;
            verificarLetra(letra);
        });
    });

    // Cargar palabras y empezar juego
    cargarPalabras().then(() => inicializarJuego());
});

    // Funcion para mostrar una imagen predeterminada al agregar nuevas palabras.. 