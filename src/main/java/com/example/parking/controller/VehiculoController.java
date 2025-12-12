
package com.example.parking.controller;


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
    public ResponseEntity<VehiculoDTO>eliminarVehiculo(@PathVariable String matricula){
        VehiculoDTO vehiculoEliminado = service.eliminarVehiculo(matricula);
        return ResponseEntity.ok(vehiculoEliminado);

    }
    @GetMapping("/{matricula}") // buscar Vehiculo
    public ResponseEntity<VehiculoDTO> buscarMatricula(@PathVariable String matricula) {
        VehiculoDTO vehiculo = service.buscarPorMatricula(matricula);
        return ResponseEntity.ok(vehiculo);
    }

}
