package com.hugosamayoa.Juego_Ahorcado.Controller;

import com.hugosamayoa.Juego_Ahorcado.Model.Palabra;
import com.hugosamayoa.Juego_Ahorcado.Service.PalabraService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/palabras")
public class PalabraController {

    private final PalabraService palabraService;

    public PalabraController(PalabraService palabraService) {
        this.palabraService = palabraService;
    }

    @GetMapping
    public List<Palabra> getAllPalabras() {
        return palabraService.getAllPalabras();
    }

    @GetMapping("/{id}")
    public Object getPalabraById(@PathVariable Integer id) {
        Palabra palabra = palabraService.getPalabraById(id);
        if (palabra == null) {
            return "No se encontró una palabra con el ID: " + id;
        }
        return palabra;
    }

    @PostMapping
    public String createPalabra(@RequestBody Palabra palabra) {
        Palabra result = palabraService.savePalabra(palabra);
        if (result == null) {
            return "Error al registrar la palabra. Verifica los datos ingresados.";
        }
        return "Palabra agregada exitosamente al juego.";
    }

    @PutMapping("/{id}")
    public String updatePalabra(@PathVariable Integer id, @RequestBody Palabra palabra) {
        Palabra result = palabraService.updatePalabra(id, palabra);
        if (result == null) {
            return "No se pudo actualizar. La palabra con el ID " + id + " no existe.";
        }
        return "Palabra actualizada correctamente.";
    }

    @DeleteMapping("/{id}")
    public String deletePalabra(@PathVariable Integer id) {
        Palabra palabra = palabraService.getPalabraById(id);
        if (palabra == null) {
            return "No se encontró una palabra con el ID " + id + " para eliminar.";
        }

        palabraService.deletePalabra(id);
        return "Palabra eliminada correctamente.";
    }
}
