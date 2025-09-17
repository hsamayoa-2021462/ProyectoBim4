package com.hugosamayoa.Juego_Ahorcado.Service;

import com.hugosamayoa.Juego_Ahorcado.Model.Palabra;
import java.util.List;

public interface PalabraService {
    List<Palabra> getAllPalabras();
    Palabra getPalabraById(Integer id);
    Palabra savePalabra(Palabra palabra);
    Palabra updatePalabra(Integer id, Palabra palabra);
    void deletePalabra(Integer id);
}
