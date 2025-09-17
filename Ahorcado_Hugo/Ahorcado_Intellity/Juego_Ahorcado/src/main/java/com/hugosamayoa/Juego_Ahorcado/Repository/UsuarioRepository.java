package com.hugosamayoa.Juego_Ahorcado.Repository;

import com.hugosamayoa.Juego_Ahorcado.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
