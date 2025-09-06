package modelo;

import config.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PalabrasDAO {

    public List<Palabras> listarParaJuego() {
        List<Palabras> lista = new ArrayList<>();
        String sql = "CALL sp_verpalabras()";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Palabras p = new Palabras();
                p.setCodigoPalabra(rs.getInt("codigoPalabra"));
                p.setPalabra(rs.getString("palabra"));
                p.setPista1(rs.getString("pista1"));
                p.setPista2(rs.getString("pista2"));
                p.setPista3(rs.getString("pista3"));
                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
  

}
