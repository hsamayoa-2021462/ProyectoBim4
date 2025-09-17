package com.hugosamayoa.Juego_Ahorcado.Repository;


import com.hugosamayoa.Juego_Ahorcado.Model.Palabra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PalabraRepository extends JpaRepository<Palabra, Integer> {

}
