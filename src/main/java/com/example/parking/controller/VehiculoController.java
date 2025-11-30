
package com.example.parking.controller;


import com.example.parking.dto.VehiculoDTO;
import com.example.parking.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {
    @Autowired
    private VehiculoService service;


    @PostMapping//registrar vehiculo
    public ResponseEntity<VehiculoDTO>registrarVehiculo(@RequestBody VehiculoDTO dto) {
        VehiculoDTO vehiculoRegistrado = service.registrarVehiculo(dto);
        return ResponseEntity.ok(vehiculoRegistrado);
    }


}
