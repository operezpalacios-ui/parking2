package com.example.parking.service;

import com.example.parking.dto.VehiculoDTO;
import com.example.parking.entity.VehiculoEntity;
import com.example.parking.exception.VehiculoNoEncontradoException;
import com.example.parking.mapper.VehiculoMapper;
import com.example.parking.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.parking.exception.VehiculoNoEncontradoException;



@Service
public class VehiculoService {
    @Autowired
    private VehiculoRepository repo;

    public VehiculoDTO registrarVehiculo(VehiculoDTO dto) {
        VehiculoEntity vehiculoEntity= VehiculoMapper.toEntity(dto);
        vehiculoEntity.setEstado(true);
        repo.save(vehiculoEntity);

        return dto;
    }

    public VehiculoDTO eliminarVehiculo(String matricula) {
        VehiculoEntity vehiculoEntity = repo.findById(matricula)
                .orElseThrow(() -> new VehiculoNoEncontradoException("Vehículo no encontrado: " + matricula));
        repo.delete(vehiculoEntity);
        return VehiculoMapper.toDTO(vehiculoEntity);
    }
    public VehiculoDTO buscarPorMatricula(String matricula) {
        VehiculoEntity vehiculoEntity = repo.findById(matricula)
                .orElseThrow(() -> new VehiculoNoEncontradoException("Vehículo no encontrado: " + matricula));
        return VehiculoMapper.toDTO(vehiculoEntity);

    }


}