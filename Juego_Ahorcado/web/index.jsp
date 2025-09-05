<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Juego Ahorcado</title>
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
                <h2 class="titulo">Juego ahorcado</h2>
                <div class="text-item">
                    <h2>¡Bienvenido al juego!</h2>
                    <p>Utiliza tu mente y descubre las palabras ocultas</p>
                </div>
            </div>

            <div class="login-section">
                <div class="form-box login">
                    <!-- Formulario para registro o inicio con más campos -->
                    <form action="ahorcado.jsp" method="post">
                        <h2>Registro / Iniciar Sesión</h2>

                        <div class="input-box">
                            <input type="text" name="nombre" placeholder="Nombre" required>
                        </div>

                        <div class="input-box">
                            <input type="text" name="apellido" placeholder="Apellido" required>
                        </div>

                        <div class="input-box">
                            <input type="email" name="correo" placeholder="Correo" required>
                        </div>

                        <div class="input-box">
                            <input type="password" name="pass" placeholder="Contraseña" required>
                        </div>

                        <div class="remember-password">
                            <label><input type="checkbox"> Ver contraseña</label>
                        </div>

                        <button class="btn" type="submit">Iniciar sesion</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
