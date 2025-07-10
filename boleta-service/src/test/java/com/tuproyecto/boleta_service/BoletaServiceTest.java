package com.tuproyecto.boleta_service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.tuproyecto.boleta_service.entidades.Boleta;
import com.tuproyecto.boleta_service.repositorio.BoletaRepository;
import com.tuproyecto.boleta_service.servicio.BoletaServicio;

public class BoletaServiceTest {

    @Mock
    private BoletaRepository boletaRepository;

    @InjectMocks
    private BoletaServicio boletaServicio;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCrearBoleta() {
        Boleta boleta = new Boleta();
        boleta.setUsuarioId(1);
        boleta.setNombreProducto("Laptop");

        when(boletaRepository.save(boleta)).thenReturn(boleta);

        Boleta resultado = boletaServicio.create(boleta);

        assertNotNull(resultado);
        assertEquals("Laptop", resultado.getNombreProducto());
    }

    @Test
    void testGetAllBoletas() {
        Boleta boleta1 = new Boleta();
        boleta1.setNombreProducto("Teclado");

        Boleta boleta2 = new Boleta();
        boleta2.setNombreProducto("Mouse");

        when(boletaRepository.findAll()).thenReturn(List.of(boleta1, boleta2));

        List<Boleta> boletas = boletaServicio.getAll();

        assertEquals(2, boletas.size());
        assertEquals("Teclado", boletas.get(0).getNombreProducto());
    }

    @Test
    void testEliminarBoleta() {
        doNothing().when(boletaRepository).deleteById(1);
        boletaServicio.delete(1);
        verify(boletaRepository, times(1)).deleteById(1);
    }

    @Test
    void testGetBoletasByUsuarioId() {
        Boleta boleta = new Boleta();
        boleta.setUsuarioId(3);

        when(boletaRepository.findByUsuarioId(3)).thenReturn(List.of(boleta));

        List<Boleta> resultado = boletaServicio.getBoletasByUsuarioId(3);

        assertEquals(1, resultado.size());
        assertEquals(3, resultado.get(0).getUsuarioId());
    }

    @Test
    void testBoletaNombreUsuario() {
        Boleta boleta = new Boleta();
        boleta.setNombreUsuario("Juan Pérez");
        when(boletaRepository.findAll()).thenReturn(List.of(boleta));

        Boleta resultado = boletaServicio.getAll().get(0);
        assertEquals("Juan Pérez", resultado.getNombreUsuario());
    }

    @Test
    void testBoletaPrecioProducto() {
        Boleta boleta = new Boleta();
        boleta.setPrecioProducto(9990);
        when(boletaRepository.findAll()).thenReturn(List.of(boleta));

        Boleta resultado = boletaServicio.getAll().get(0);
        assertEquals(9990, resultado.getPrecioProducto());
    }
}