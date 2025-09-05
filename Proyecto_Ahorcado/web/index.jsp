<%-- 
    Document   : index
    Created on : 2 sept 2025, 08:37:53
    Author     : informatica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Juego Ahorcado</title>
        <link rel="stylesheet" href="css/Styles1.css">
        <link rel="icon" href="image/logo.png" type="image/png">
    </head>
    <body>
        <header class="header">
            <div class="logo-container">
                <div class="logo">Juego Ahorcado</div>
                <div class="logo_image">
                    <img src="image/logo1.png" alt="Logo" />
                </div>
            </div>
        </header>

        <div class="background"></div>
        <div class="container">
            <div class="item">
                <h2 class="titulo">Juego ahorcado</h2>
                <div class="text-item">
                    <h2>¡Bienvenido al juego!</h2>
                    <p>Utiliza tu mente y descubre las palabras ocultas</p>
                </div>
            </div>

            <div class="login-section">
                <div class="form-box login">
                    <!-- Redirige al juego al iniciar sesión -->
                    <form action="ahorcado.jsp" method="post">
                        <h2>Iniciar Sesión</h2>
                        <div class="input-box">
                            <span class="icon"><i class='bx bxs-envelope'></i></span>
                            <input type="email" name="email" placeholder="Correo" required>
                        </div>
                        <div class="input-box">
                            <span class="icon"><i class='bx bxs-lock-alt'></i></span>
                            <input type="password" name="password" placeholder="Contraseña" required>
                        </div>
                        <div class="remember-password">
                            <label><input type="checkbox"> Ver contraseña</label>
                        </div>
                        <button class="btn" type="submit">Iniciar sesión</button>

                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
