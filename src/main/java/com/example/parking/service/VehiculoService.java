package com.example.parking.service;

import com.example.parking.dto.FacturaDTO;
import com.example.parking.dto.VehiculoDTO;
import com.example.parking.entity.VehiculoEntity;
import com.example.parking.exception.VehiculoNoEncontradoException;
import com.example.parking.mapper.VehiculoMapper;
import com.example.parking.repository.VehiculoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.parking.exception.VehiculoNoEncontradoException;



import java.util.Optional;

@Service
public class VehiculoService {
    @Autowired
    private VehiculoRepository repo;

    public VehiculoDTO registrarVehiculo(VehiculoDTO dto) throws Exception {
        VehiculoEntity vehiculoEntity = VehiculoMapper.toEntity(dto);

        if (repo.findById(vehiculoEntity.getMatricula()).isEmpty()) {
            vehiculoEntity.setEstado(true);
            repo.save(vehiculoEntity);
            return VehiculoMapper.toDTO(vehiculoEntity);
        }

        if (!repo.existsByMatriculaAndEstadoTrue(vehiculoEntity.getMatricula())) {
            vehiculoEntity.setEstado(true);
            repo.save(vehiculoEntity);
        } else {
            throw new Exception("El vehiculo ya se encuentra en el parking");
        }

        dto =VehiculoMapper.toDTO(vehiculoEntity);
        return dto;
    }


    public void eliminarVehiculo(String matricula) {

        VehiculoEntity vehiculoEntity = new VehiculoEntity();
        vehiculoEntity.setMatricula(matricula);
        try{
            repo.delete(vehiculoEntity);
        } catch (Exception e) {
            throw new VehiculoNoEncontradoException("El vehiculo no se encuentra en la base de datos");
        }
    }

    public VehiculoDTO buscarPorMatricula(String matricula) {
        VehiculoEntity vehiculoEntity = repo.findById(matricula)
                .orElseThrow(() -> new VehiculoNoEncontradoException("Vehículo no encontrado: " + matricula));
        return VehiculoMapper.toDTO(vehiculoEntity);
    }

    public FacturaDTO darSalida(String matricula) throws Exception {

        // 1️⃣ Comprobar que el vehículo existe
        if (!repo.existsById(matricula)) {
            throw new Exception("Vehículo no existe en base de datos");
        }

        // 2️⃣ Comprobar que el vehículo está actualmente aparcado
        Optional<VehiculoEntity> vehiculoOpt =
                repo.findByMatriculaAndEstadoTrue(matricula);

        if (vehiculoOpt.isEmpty()) {
            throw new Exception("Vehículo no se encuentra en el parking en este momento");
        }

        // 3️⃣ Obtener entidad y actualizar salida
        VehiculoEntity vehiculo = vehiculoOpt.get();

        long horaSalida = System.currentTimeMillis();
        vehiculo.setHoraSalida(horaSalida);
        vehiculo.setEstado(false);

        repo.save(vehiculo);

        // 4️⃣ Calcular factura
        long duracionMillis = horaSalida - vehiculo.getHoraEntrada();
        double duracionHoras = duracionMillis / 3600000.0;
        double costeTotal = duracionHoras * vehiculo.getTarifa();

        // 5️⃣ Construir DTO
        FacturaDTO factura = new FacturaDTO();
        factura.setMatricula(vehiculo.getMatricula());
        factura.setTarifa(vehiculo.getTarifa());
        factura.setHoraEntrada(vehiculo.getHoraEntrada());
        factura.setHoraSalida(horaSalida);
        factura.setCosteTotal(costeTotal);

        return factura;
    }
}