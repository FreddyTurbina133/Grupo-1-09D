package com.tuproyecto.boleta_service.controlador;

import com.tuproyecto.boleta_service.entidades.Boleta;
import com.tuproyecto.boleta_service.servicio.BoletaServicio;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boletas")
public class BoletaController {

    private final BoletaServicio service;

    public BoletaController(BoletaServicio service) {
        this.service = service;
    }

    @GetMapping
    public List<Boleta> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Boleta create(@RequestBody Boleta boleta) {
        return service.create(boleta);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Boleta> getBoletasByUsuario(@PathVariable int usuarioId) {
    return service.getBoletasByUsuarioId(usuarioId);
    }
}
