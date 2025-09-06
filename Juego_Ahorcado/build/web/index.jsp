<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Juego Ahorcado - Login</title>
        <link rel="stylesheet" href="Styles/Styles1.css">
        <link rel="icon" href="Images/logo.png" type="image/png">
    </head>
    <body>
        <header class="header">
            <div class="logo-container">
                <div class="logo">Juego Ahorcado</div>
                <div class="logo_image">
                    <img src="Images/logo1.png" alt="Logo" />
                </div>
            </div>
        </header>
        <div class="background"></div>
        <div class="container">
            <div class="item">
                <h2 class="titulo">Juego Ahorcado</h2>
                <div class="text-item">
                    <h2>¡Bienvenido al juego!</h2>
                    <p>Utiliza tu mente y descubre las palabras ocultas</p>
                </div>
            </div>
            <div class="login-section">
                <!-- Formulario solo para login -->
                <div class="form-box login">
                    <form id="loginForm" action="Validar" method="post">
                        <h2>Iniciar Sesión</h2>
                        <div class="input-box">
                            <input type="email" name="correo" id="correo" placeholder="Correo" required>
                        </div>
                        <div class="input-box">
                            <input type="password" name="pass" id="pass" placeholder="Contraseña" required>
                        </div>
                        <div class="remember-password">
                            <label>
                                <input type="checkbox" id="showPass"> Ver contraseña
                            </label>
                        </div>
                        <button class="btn" type="submit" id="loginBtn">Iniciar sesión</button>
                    </form>
                    <button class="btn" type="button" id="registroBtn" onclick="window.location.href = 'Controlador?menu=Registro'" style="margin-top: 15px;">Registrarse</button>
                </div>
            </div>
        </div>
        <script>
            // Mostrar / ocultar contraseña
            document.getElementById('showPass').addEventListener('change', function () {
                const pass = document.getElementById('pass');
                pass.type = this.checked ? 'text' : 'password';
            });
        </script>
    </body>
</html>