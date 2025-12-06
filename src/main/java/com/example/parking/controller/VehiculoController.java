
package com.example.parking.controller;


import com.example.parking.dto.FacturaDTO;
import com.example.parking.dto.VehiculoDTO;
import com.example.parking.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

    @DeleteMapping//eliminar vehiculo
    public ResponseEntity<VehiculoDTO>eliminarVehiculo(@RequestBody VehiculoDTO dto){
        VehiculoDTO vehiculoEliminado = service.eliminarVehiculo(dto);
        return ResponseEntity.ok(vehiculoEliminado);

    }

    @PutMapping
    public ResponseEntity<FacturaDTO> darSalida(@RequestBody String matricula) throws Exception{
        FacturaDTO factura = service.darSalida (matricula);
        return ResponseEntity.ok(factura);
    }

}
