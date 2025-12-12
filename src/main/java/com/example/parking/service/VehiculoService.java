package com.example.parking.service;

import com.example.parking.dto.FacturaDTO;
import com.example.parking.dto.VehiculoDTO;
import com.example.parking.entity.VehiculoEntity;
import com.example.parking.exception.VehiculoNoEncontradoException;
import com.example.parking.mapper.VehiculoMapper;
import com.example.parking.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.parking.exception.VehiculoNoEncontradoException;



import java.util.Optional;

@Service
public class VehiculoService {
    @Autowired
    private VehiculoRepository repo;

    public VehiculoDTO registrarVehiculo(VehiculoDTO dto) {
        VehiculoEntity vehiculoEntity = VehiculoMapper.toEntity(dto);
        vehiculoEntity.setEstado(true);
        repo.save(vehiculoEntity);

        return dto;
    }

<<<<<<< HEAD
    public VehiculoDTO eliminarVehiculo(String matricula) {
        VehiculoEntity vehiculoEntity = repo.findById(matricula)
                .orElseThrow(() -> new VehiculoNoEncontradoException("Vehículo no encontrado: " + matricula));
=======
    public VehiculoDTO eliminarVehiculo(VehiculoDTO dto) {
        VehiculoEntity vehiculoEntity = VehiculoMapper.toEntity(dto);
        vehiculoEntity.setEstado(true);
>>>>>>> 5e35cfb44b26c6a54eef665d5661ab8fa2345f86
        repo.delete(vehiculoEntity);
        return VehiculoMapper.toDTO(vehiculoEntity);
    }
<<<<<<< HEAD
    public VehiculoDTO buscarPorMatricula(String matricula) {
        VehiculoEntity vehiculoEntity = repo.findById(matricula)
                .orElseThrow(() -> new VehiculoNoEncontradoException("Vehículo no encontrado: " + matricula));
        return VehiculoMapper.toDTO(vehiculoEntity);

    }


=======


    public FacturaDTO darSalida(String matricula) throws Exception {

        Optional<VehiculoEntity> vehiculoOpt = repo.findById(matricula);

        if (vehiculoOpt.isPresent()) {

            VehiculoEntity vehiculoEntity = vehiculoOpt.get();
            // Aquí actualizas los datos de salida, horaSalida, estado, etc.
            vehiculoEntity.setHoraSalida(System.currentTimeMillis());
            vehiculoEntity.setEstado(false); // ya no está aparcado

            // Guardar los cambios en la base de datos
            repo.save(vehiculoEntity);

            FacturaDTO factura = new FacturaDTO();
            factura.setMatricula(vehiculoEntity.getMatricula());
            factura.setTarifa(vehiculoEntity.getTarifa());
            factura.setHoraEntrada(vehiculoEntity.getHoraEntrada());
            factura.setHoraSalida(vehiculoEntity.getHoraSalida());

            long duracionMillis = vehiculoEntity.getHoraSalida() - vehiculoEntity.getHoraEntrada();
            double duracionHoras = duracionMillis / 3600000.0; // convertir a horas

            double costeTotal = duracionHoras * vehiculoEntity.getTarifa();

            factura.setCosteTotal(costeTotal);

            return factura;
        }
        return null;
    }
>>>>>>> 5e35cfb44b26c6a54eef665d5661ab8fa2345f86
}