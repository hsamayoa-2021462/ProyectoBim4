package com.hugosamayoa.Juego_Ahorcado.Repository;


import com.hugosamayoa.Juego_Ahorcado.Model.Palabra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PalabraRepository extends JpaRepository<Palabra, Integer> {
    Optional<Palabra> findByPalabraIgnoreCase(String palabra);
}
