package com.hugosamayoa.Juego_Ahorcado.Service;

import com.hugosamayoa.Juego_Ahorcado.Model.Usuario;
import java.util.List;

public interface UsuarioService {
    List<Usuario> getAllUsuarios();
    Usuario getUsuarioById(Integer id);
    Usuario saveUsuario(Usuario usuario);
    Usuario updateUsuario(Integer id, Usuario usuario);
    void deleteUsuario(Integer id);
}
