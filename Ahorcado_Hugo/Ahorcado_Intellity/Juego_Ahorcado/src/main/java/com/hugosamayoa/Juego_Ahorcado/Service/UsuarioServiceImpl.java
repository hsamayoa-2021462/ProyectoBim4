package com.hugosamayoa.Juego_Ahorcado.Service;

import com.hugosamayoa.Juego_Ahorcado.Model.Usuario;
import com.hugosamayoa.Juego_Ahorcado.Repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario getUsuarioById(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        List<Usuario> lista = usuarioRepository.findAll();
        for (Usuario u : lista) {
            if (u.getCorreo().equalsIgnoreCase(usuario.getCorreo())) {
                usuario.setCorreo("ERROR_CORREO_REPETIDO");
                return usuario;
            }
        }
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario updateUsuario(Integer id, Usuario usuario) {
        Usuario existingUsuario = usuarioRepository.findById(id).orElse(null);
        if (existingUsuario != null) {
            List<Usuario> lista = usuarioRepository.findAll();
            for (Usuario u : lista) {
                if (!u.getCodigoUsuario().equals(id)) {
                    if (u.getCorreo().equalsIgnoreCase(usuario.getCorreo())) {
                        usuario.setCorreo("ERROR_CORREO_REPETIDO");
                        return usuario;
                    }
                }
            }

            // Actualizar campos del usuario existente
            existingUsuario.setNombre(usuario.getNombre());
            existingUsuario.setApellido(usuario.getApellido());
            existingUsuario.setCorreo(usuario.getCorreo());
            existingUsuario.setPass(usuario.getPass());

            // Guardar los cambios en la base de datos
            return usuarioRepository.save(existingUsuario);
        }
        return null;  // Usuario no encontrado
    }

    @Override
    public void deleteUsuario(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
