package com.hugosamayoa.Juego_Ahorcado.Controller;

import com.hugosamayoa.Juego_Ahorcado.Model.Usuario;
import com.hugosamayoa.Juego_Ahorcado.Service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario getUsuarioById(@PathVariable Integer id) {
        return usuarioService.getUsuarioById(id);
    }

    @PostMapping
    public String createUsuario(@RequestBody Usuario usuario) {
        Usuario result = usuarioService.saveUsuario(usuario);
        if ("ERROR_CORREO_REPETIDO".equals(result.getCorreo())) {
            return "El correo ingresado ya está registrado. Intenta con otro.";
        }
        return "Usuario registrado correctamente.";
    }

    @PutMapping("/{id}")
    public String updateUsuario(@PathVariable Integer id, @RequestBody Usuario usuario) {
        Usuario result = usuarioService.updateUsuario(id, usuario);
        if (result == null) {
            return "Usuario no encontrado con el ID que usaste.";
        }
        if ("ERROR_CORREO_REPETIDO".equals(result.getCorreo())) {
            return "El correo ingresado ya está registrado. Intenta con otro.";
        }
        return "Usuario actualizado correctamente.";
    }

    @DeleteMapping("/{id}")
    public String deleteUsuario(@PathVariable Integer id) {
        usuarioService.deleteUsuario(id);
        return "Usuario eliminado correctamente.";
    }
}