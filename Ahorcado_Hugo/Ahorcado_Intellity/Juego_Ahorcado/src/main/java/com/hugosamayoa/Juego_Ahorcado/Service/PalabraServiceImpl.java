package com.hugosamayoa.Juego_Ahorcado.Service;

import com.hugosamayoa.Juego_Ahorcado.Model.Palabra;
import com.hugosamayoa.Juego_Ahorcado.Repository.PalabraRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PalabraServiceImpl implements PalabraService {

    private final PalabraRepository palabraRepository;

    public PalabraServiceImpl(PalabraRepository palabraRepository) {
        this.palabraRepository = palabraRepository;
    }

    @Override
    public List<Palabra> getAllPalabras() {
        return palabraRepository.findAll();
    }

    @Override
    public Palabra getPalabraById(Integer id) {
        return palabraRepository.findById(id).orElse(null);
    }

    @Override
    public Palabra savePalabra(Palabra palabra) {
        // Validación 1: si la palabra es nula o vacía
        if (palabra.getPalabra() == null || palabra.getPalabra().trim().isEmpty()) {
            palabra.setPalabra("Vacio");
            return palabra;
        }

        // Validación 2: si la palabra ya existe
        Optional<Palabra> existingPalabra = palabraRepository.findByPalabraIgnoreCase(palabra.getPalabra());
        if (existingPalabra.isPresent()) {
            palabra.setPalabra("EnUso");
            return palabra;
        }

        return palabraRepository.save(palabra);
    }

    @Override
    public Palabra updatePalabra(Integer id, Palabra palabra) {
        Palabra existingPalabra = palabraRepository.findById(id).orElse(null);
        if (existingPalabra != null) {
            existingPalabra.setPalabra(palabra.getPalabra());
            existingPalabra.setPista1(palabra.getPista1());
            existingPalabra.setPista2(palabra.getPista2());
            existingPalabra.setPista3(palabra.getPista3());
            return palabraRepository.save(existingPalabra);
        }
        return null;
    }

    @Override
    public void deletePalabra(Integer id) {
        palabraRepository.deleteById(id);
    }
}