document.addEventListener("DOMContentLoaded", function () {
    // Variables del juego 
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

    // Lista de palabras con al menos 8 caracteres, pista e imagen asociada
    const palabras = [
        {
            palabra: "Computadora",
            pistas: [
                "Dispositivo para procesar información",
                "Tiene teclado y pantalla",
                "Se usa para programar"
            ],
            imagen: "Images/computadora.png"
        },
        {
            palabra: "Television",
            pistas: [
                "Aparato para ver programas y películas",
                "Tiene pantalla grande",
                "Requiere control remoto"
            ],
            imagen: "Images/television.png"
        },
        {
            palabra: "Biblioteca",
            pistas: [
                "Lugar donde se guardan libros",
                "Es un lugar silencioso",
                "Ideal para estudiar"
            ],
            imagen: "Images/biblioteca.png"
        },
        {
            palabra: "Telescopio",
            pistas: [
                "Instrumento para observar estrellas",
                "Usado por astrónomos",
                "Permite ver objetos lejanos"
            ],
            imagen: "Images/telescopio.png"
        },
        {
            palabra: "Avioneta",
            pistas: [
                "Vehículo aéreo pequeño",
                "Puede aterrizar en pistas cortas",
                "Usada para vuelos privados"
            ],
            imagen: "Images/avioneta.png"
        }
    ];


    let palabraSecreta = "";
    let palabraOculta = [];
    let errores = 0;
    const maxErrores = 6;
    let juegoPausado = false;
    let imagenPalabra = "";
    let tiempoRestante = 600; // 10 minutos pasadi a segundos 
    let temporizador = null;

    // Formatea el tiempo en este formato MM:SS
    function formatearTiempo(segundos) {
        const minutos = Math.floor(segundos / 60);
        const segundosRestantes = segundos % 60;
        return `${minutos.toString().padStart(2, "0")}:${segundosRestantes.toString().padStart(2, "0")}`;
    }

    // Actualiza el temporizador cada segundo
    function actualizarTemporizador() {
        if (tiempoRestante <= 0) {
            clearInterval(temporizador);
            messageBox.textContent = `¡Tiempo Agotado XD! La palabra era ${palabraSecreta}.`;
            deshabilitarBotonesJuego();
            return;
        }
        timerDisplay.textContent = formatearTiempo(tiempoRestante);
        tiempoRestante--;
    }

    // Inicia el conteo de tiempo
    function iniciarTemporizador() {
        tiempoRestante = 600; // Reinicia a 10 minutos que fue lo estipulado
        timerDisplay.textContent = formatearTiempo(tiempoRestante);
        if (temporizador)
            clearInterval(temporizador);
        temporizador = setInterval(actualizarTemporizador, 1000);
    }

    // Detiene el conteo de tiempo 
    function detenerTemporizador() {
        if (temporizador) {
            clearInterval(temporizador);
            temporizador = null;
        }
    }

    // Muestra una ventana donde dice que has ganado el juego 
    function mostrarModalGanador() {
        modalMessage.textContent = `¡Has Ganado, Eres muy Bueno! La palabra es ${palabraSecreta}`;
        modalImage.src = imagenPalabra;
        winModal.style.display = "flex";
    }

    // Cierra la ventana emergente que se muestra al ganar
    function cerrarModal() {
        winModal.style.display = "none";
    }

    function inicializarJuego() {
        letterButtons.forEach(button => {
            button.disabled = false;
        });
        restartButton.disabled = false;
        pauseButton.disabled = false;
        juegoPausado = false;
        const seleccion = palabras[Math.floor(Math.random() * palabras.length)];
        palabraSecreta = seleccion.palabra;
        palabraOculta = Array(palabraSecreta.length).fill("_");
        errores = 0;
        imagenPalabra = seleccion.imagen;
        actualizarImagenAhorcado();
        actualizarPantalla();
        messageBox.textContent = "Descubre la palabra";
        mostrarPistas(seleccion.pistas);
        iniciarTemporizador();
        winModal.style.display = "none";
    }

    function actualizarPantalla() {
        wordDisplay.textContent = palabraOculta.join(" ");
    }

    function actualizarImagenAhorcado() {
        hangmanImage.src = `Images/imagen${errores}.png`;
    }

    function mostrarPistas(pistas) {
        cluesList.innerHTML = "";
        pistas.forEach(pista => {
            const li = document.createElement("li");
            li.textContent = pista;
            cluesList.appendChild(li);
        });
    }

    function verificarLetra(letra) {
        if (juegoPausado)
            return;

        let letraCorrecta = false;
        const letraMayuscula = letra.toUpperCase();

        for (let i = 0; i < palabraSecreta.length; i++) {
            if (palabraSecreta[i].toUpperCase() === letraMayuscula) {
                palabraOculta[i] = palabraSecreta[i];
                letraCorrecta = true;
            }
        }

        if (letraCorrecta) {
            actualizarPantalla();
        } else {
            errores++;
            actualizarImagenAhorcado();
        }

        comprobarEstadoJuego();
    }

    function comprobarEstadoJuego() {
        if (palabraOculta.join("") === palabraSecreta) {
            mostrarModalGanador();
            deshabilitarBotonesJuego();
            detenerTemporizador();
        } else if (errores >= maxErrores) {
            messageBox.textContent = `Has Perdido, eres muy MALO. La palabra era ${palabraSecreta}.`;
            deshabilitarBotonesJuego();
            detenerTemporizador();
        }
    }

    function deshabilitarBotonesJuego() {
        letterButtons.forEach(button => {
            button.disabled = true;
        });
        restartButton.disabled = false;
        pauseButton.disabled = true;
    }

    function reiniciarJuego() {
        inicializarJuego();
    }

    function pausarJuego() {
        juegoPausado = !juegoPausado;
        if (juegoPausado) {
            messageBox.textContent = "Juego pausado";
            letterButtons.forEach(button => button.disabled = true);
            pauseButton.textContent = "Reanudar juego";
            detenerTemporizador();
        } else {
            messageBox.textContent = "¡Adivina la palabra solicitada!";
            letterButtons.forEach(button => button.disabled = false);
            pauseButton.textContent = "Pausar el juego";
            iniciarTemporizador();
        }
    }

    function salirJuego() {
        if (confirm("¿Te quedo grande?¿Estas seguro de salir el juego?")) {
            messageBox.textContent = "¡Gracias por jugar, No te esperamos pronto JAJA!";
            deshabilitarBotonesJuego();
            startButton.disabled = false;
            restartButton.disabled = true;
            pauseButton.disabled = true;
            detenerTemporizador();
            winModal.style.display = "none";
        }
    }

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

    inicializarJuego();
});