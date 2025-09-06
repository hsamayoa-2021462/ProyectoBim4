<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Juego Ahorcado - Registro</title>
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
                    <h2>¡Únete a la diversión!</h2>
                    <p>Crea tu cuenta y comienza a descubrir palabras ocultas</p>
                </div>
            </div>

            <div class="login-section">
                <div class="form-box login">

                    <%-- Mostrar mensajes de registro --%>
                    <%
                        String registro = request.getParameter("registro");
                        if ("exito".equals(registro)) {
                    %>
                    <div class="alert success">¡Registro exitoso! Ahora puedes iniciar sesión.</div>
                    <%
                    } else if ("error".equals(registro)) {
                    %>
                    <div class="alert error">Ocurrió un error. El correo ya está registrado o hubo un problema.</div>
                    <%
                        }
                    %>

                    <%-- Formulario para registro --%>
                    <form action="Registrar" method="post">
                        <h2>Crear Cuenta</h2>

                        <div class="input-box">
                            <input type="text" name="nombre" placeholder="Nombre" required>
                        </div>
                        <div class="input-box">
                            <input type="text" name="apellido" placeholder="Apellido" required>
                        </div>
                        <div class="input-box">
                            <input type="email" name="correo" placeholder="Correo Electrónico" required>
                        </div>
                        <div class="input-box">
                            <input type="password" name="contrasena" id="contrasena" placeholder="Contraseña" required>
                        </div>

                        <div class="remember-password">
                            <label>
                                <input type="checkbox" id="showPass"> Ver contraseña
                            </label>
                        </div>

                        <button class="btn" type="submit">Registrarse</button>
                    </form>
                </div>
            </div>
        </div>

        <script>
            // Mostrar / ocultar contraseña
            document.getElementById('showPass').addEventListener('change', function () {
                const pass = document.getElementById('contrasena');
                pass.type = this.checked ? 'text' : 'password';
            });
        </script>
    </body>
</html>
