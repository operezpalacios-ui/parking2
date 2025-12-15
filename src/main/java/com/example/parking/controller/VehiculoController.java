
package com.example.parking.controller;


import com.example.parking.dto.FacturaDTO;
import com.example.parking.dto.SalidaDTO;
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
    public ResponseEntity<VehiculoDTO>registrarVehiculo(@RequestBody VehiculoDTO dto) throws Exception {
        VehiculoDTO vehiculoRegistrado = service.registrarVehiculo(dto);
        return ResponseEntity.ok(vehiculoRegistrado);
    }

    @DeleteMapping("/{matricula}")
    public ResponseEntity<SalidaDTO> eliminarVehiculo(@PathVariable String matricula) {

        service.eliminarVehiculo(matricula);
        SalidaDTO salidaDTO = new SalidaDTO("Se ha eliminado correctamente");
        return ResponseEntity.ok(salidaDTO);

    }


    @GetMapping("/{matricula}") // buscar Vehiculo
    public ResponseEntity<VehiculoDTO> buscarMatricula(@PathVariable String matricula) {
        VehiculoDTO vehiculo = service.buscarPorMatricula(matricula);
        return ResponseEntity.ok(vehiculo);
    }

    @PutMapping("/{matricula}")
    public ResponseEntity<FacturaDTO> darSalida(@PathVariable String matricula) throws Exception{
        FacturaDTO factura = service.darSalida (matricula);
        return ResponseEntity.ok(factura);
    }

}
