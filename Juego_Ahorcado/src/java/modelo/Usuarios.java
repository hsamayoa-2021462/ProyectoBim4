package modelo;

public class Usuarios {
    private int codigoUsuario;
    private String nombre;
    private String apellido;
    private String correo;
    private String pass;

    public Usuarios() {}

    public Usuarios(int codigoUsuario, String nombre, String apellido, String correo, String pass) {
        this.codigoUsuario = codigoUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.pass = pass;
    }

    public int getCodigoUsuario() { return codigoUsuario; }
    public void setCodigoUsuario(int codigoUsuario) { this.codigoUsuario = codigoUsuario; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public String getPass() { return pass; }
    public void setPass(String pass) { this.pass = pass; }
}
