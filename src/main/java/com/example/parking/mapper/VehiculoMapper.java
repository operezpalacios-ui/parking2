package com.example.parking.mapper;

import com.example.parking.dto.VehiculoDTO;
import com.example.parking.entity.VehiculoEntity;

public class VehiculoMapper {

        // ============================
        //   DTO → ENTITY
        // ============================
        public static VehiculoEntity toEntity(VehiculoDTO dto) {
            if (dto == null) return null;

            VehiculoEntity entity = new VehiculoEntity();

            entity.setMatricula(dto.getMatricula());
            entity.setModelo(dto.getModelo());
            entity.setHoraEntrada(dto.getHoraEntrada());
            entity.setMarca(dto.getMarca());
            entity.setNumeroPuertas(dto.getNumeroPuertas());
            entity.setColor(dto.getColor());
            entity.setEstado(dto.isEstado());
            entity.setTipoVehiculo(dto.getTipoVehiculo());
            entity.setTarifa(dto.getTarifa());
            entity.setHoraSalida(dto.getHoraSalida());

            return entity;
        }

        // ============================
        //   ENTITY → DTO
        // ============================
        public static VehiculoDTO toDTO(VehiculoEntity entity) {
            if (entity == null) return null;

            VehiculoDTO dto = new VehiculoDTO();

            dto.setMatricula(entity.getMatricula());
            dto.setModelo(entity.getModelo());
            dto.setHoraEntrada(entity.getHoraEntrada());
            dto.setMarca(entity.getMarca());
            dto.setNumeroPuertas(entity.getNumeroPuertas());
            dto.setColor(entity.getColor());
            dto.setEstado(entity.isEstado());
            dto.setTipoVehiculo(entity.getTipoVehiculo());
            dto.setTarifa(entity.getTarifa());
            dto.setHoraSalida(entity.getHoraSalida());

            return dto;
        }
    }

