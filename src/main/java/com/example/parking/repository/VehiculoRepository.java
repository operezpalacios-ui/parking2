
package com.example.parking.repository;

import com.example.parking.entity.VehiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehiculoRepository extends JpaRepository<VehiculoEntity, String> {

    boolean existsByMatriculaAndEstadoTrue(String matricula);
    boolean existsByMatriculaAndEstadoFalse(String matricula);
    Optional<VehiculoEntity> findByMatriculaAndEstadoTrue(String matricula);

}

