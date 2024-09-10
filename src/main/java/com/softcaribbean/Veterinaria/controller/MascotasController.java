package com.softcaribbean.Veterinaria.controller;

import com.softcaribbean.Veterinaria.business.MascotasBusinessInterface;
import com.softcaribbean.Veterinaria.dto.MascotasDTO;
import com.softcaribbean.Veterinaria.mensajes.ResponseMessage;
import com.softcaribbean.Veterinaria.utils.Credenciales;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@Slf4j
@RequestMapping("/mascotas/")
public class MascotasController {
    private MascotasBusinessInterface mascotasBusinessInterface;

    public MascotasController(MascotasBusinessInterface mascotasBusinessInterface){
        this.mascotasBusinessInterface=mascotasBusinessInterface;
    }

    @PostMapping({"/saveOrUpdate"})
    public ResponseEntity<ResponseMessage<MascotasDTO>> saveOrUpdate(@RequestBody MascotasDTO request) {
        log.debug("REST request to saveOrUpdate Mascotas : {}", request);
        ResponseMessage message =null;
        try{
            mascotasBusinessInterface.saveOrUpdate(request);
            message = new ResponseMessage<>(200, "saveOrUpdate, process successful ", request);
        }catch (Exception ex){
            message = new ResponseMessage<>(406, ex.getMessage(), request);
        }

        return ResponseEntity.ok(message);
    }

    @PostMapping({"/findById"})
    public ResponseEntity<ResponseMessage<MascotasDTO>> findById(@RequestBody MascotasDTO request) {
        log.debug("REST request to saveOrUpdate Mascotas : {}", request);
        ResponseMessage message =null;
        try{
            MascotasDTO mascotasDTO= mascotasBusinessInterface.findById(request);

            message = new ResponseMessage<>(200, "findById, process successful ", mascotasDTO);
        }catch (Exception ex){
            message = new ResponseMessage<>(406, ex.getMessage(),null);
        }

        return ResponseEntity.ok(message);
    }

    @PostMapping({"/Delete"})
    public ResponseEntity<ResponseMessage<MascotasDTO>> delete(@RequestBody MascotasDTO request) {
        log.debug("REST request to Delete Mascotas : {}", request);
        ResponseMessage message =null;
        try{
            this.mascotasBusinessInterface.delete(request);

            message = new ResponseMessage<>(200, "Delete, process successful ", request);
        }catch (Exception ex){
            message = new ResponseMessage<>(406, ex.getMessage(),null);
        }

        return ResponseEntity.ok(message);
    }

    @GetMapping("/All")
    public ResponseEntity<ResponseMessage> selectAll() {
        List<Map<String, Object>> list = null;
        ResponseMessage message =null;

        try {
            list= this.mascotasBusinessInterface.selectAll2();
            message = new ResponseMessage<>(200, "All, process successful ", list );
        }catch (Exception exception){
            message = new ResponseMessage<>(406, exception.getMessage(),null );
        }
        return ResponseEntity.ok(message);
    }


    @PostMapping("/login")
    public ResponseEntity<ResponseMessage<String>> login(@RequestBody Credenciales credenciales) {
        ResponseMessage<String> responseMessage;

        if ("admin".equals(credenciales.getUsuario()) && "password".equals(credenciales.getContraseña())) {
            responseMessage = new ResponseMessage<>(200, "Inicio de sesión exitoso", null);
            return ResponseEntity.ok(responseMessage);
        } else {
            responseMessage = new ResponseMessage<>(401, "Credenciales incorrectas", null);
            return ResponseEntity.status(401).body(responseMessage);
        }
    }

}
