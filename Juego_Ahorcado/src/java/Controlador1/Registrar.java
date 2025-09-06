package Controlador1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuarios;
import modelo.UsuariosDAO;

@WebServlet(name = "Registrar", urlPatterns = {"/Registrar"})
public class Registrar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtener datos del formulario
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String correo = request.getParameter("correo");
        String contrasena = request.getParameter("contrasena");

        // Crear objeto usuario
        Usuarios nuevoUsuario = new Usuarios();
        nuevoUsuario.setNombre(nombre);
        nuevoUsuario.setApellido(apellido);
        nuevoUsuario.setCorreo(correo);
        nuevoUsuario.setPass(contrasena);

        // Registrar usuario usando el DAO
        UsuariosDAO dao = new UsuariosDAO();
        boolean registrado = dao.registrarUsuario(nuevoUsuario);

        if (registrado) {
            // Registro exitoso, redirigir al login
            response.sendRedirect("index.jsp?registro=exito");
        } else {
            // Fallo en registro (correo duplicado, error, etc.)
            response.sendRedirect("registro.jsp?registro=error");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Redirigir a la página de registro si acceden por GET
        response.sendRedirect("registro.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Servlet para registrar usuarios";
    }
}
