package com.tuproyecto.boleta_service.servicio;


import java.util.List;

import org.springframework.stereotype.Service;

import com.tuproyecto.boleta_service.entidades.Boleta;
import com.tuproyecto.boleta_service.repositorio.BoletaRepository;

@Service
public class BoletaServicio {

    private final BoletaRepository boletaRepository;

    public BoletaServicio(BoletaRepository boletaRepository) {
        this.boletaRepository = boletaRepository;
    }

    public List<Boleta> getAll() {
        return boletaRepository.findAll();
    }

    public Boleta create(Boleta boleta) {
        return boletaRepository.save(boleta);
    }

    public void delete(int id) {
        boletaRepository.deleteById(id);
    }

    public List<Boleta> getBoletasByUsuarioId(int usuarioId) {
        return boletaRepository.findByUsuarioId(usuarioId);
    }
}
