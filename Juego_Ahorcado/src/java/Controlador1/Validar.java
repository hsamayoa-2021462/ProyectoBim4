package Controlador1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.UsuariosDAO;

@WebServlet(name = "Validar", urlPatterns = {"/Validar"})
public class Validar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtener datos del formulario
        String correo = request.getParameter("correo").trim();
        String pass = request.getParameter("pass").trim();

        // Instancia del DAO
        UsuariosDAO dao = new UsuariosDAO();

        try {
            boolean existe = dao.validarUsuario(correo, pass);

            if (existe) {
                // Usuario correcto: establece la sesión y redirige
                request.getSession().setAttribute("usuario", correo);
                System.out.println("Inicio de sesión exitoso para el usuario ingresado: " + correo);
                System.out.println("Inicio de sesión exitoso para la contraseña del usuario ingresado: " + pass);
                response.sendRedirect("Controlador?menu=Ahorcado");
            } else {
                // Usuario incorrecto: redirige de vuelta a la página principal con un parámetro
                System.out.println("Intento de inicio de sesión fallido con el correo: " + correo);
                System.out.println("Contraseña incorrecta, revisa los campos o tu contraseña: " + pass);
                response.sendRedirect("Controlador?menu=Principal&error=credenciales_invalidas");
            }
        } catch (Exception e) {
            System.err.println("ERROR: Se produjo una excepción durante la validación de credenciales.");
            e.printStackTrace();
        }
    }
}
