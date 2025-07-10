package com.tuproyecto.boleta_service.repositorio;

import com.tuproyecto.boleta_service.entidades.Boleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoletaRepository extends JpaRepository<Boleta, Integer> {
    List<Boleta> findByUsuarioId(int usuarioId);
    List<Boleta> findByIdPedido(int idPedido);

}
