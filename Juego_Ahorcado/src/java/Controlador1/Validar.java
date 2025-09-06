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

        // Habilitar salida para debug
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            out.println("<h3>Debug de login</h3>");
            out.println("<p>Correo recibido: " + correo + "</p>");
            out.println("<p>Contraseña recibida: " + pass + "</p>");

            boolean existe = dao.validarUsuario(correo, pass);

            if (existe) {
                // Usuario correcto
                request.getSession().setAttribute("usuario", correo);
                out.println("<p style='color:green;'>Usuario válido, redirigiendo...</p>");
                response.sendRedirect("Controlador?menu=Ahorcado");
            } else {
                response.sendRedirect("Controlador?menu=Principal");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
