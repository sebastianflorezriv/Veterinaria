package com.softcaribbean.Veterinaria.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class MascotasDTO {
    private String id;
    private String nombre;
    private String especie;
    private String raza;
    private String fecha_nacimiento;
    private String tipo_identificacion;
    private String id_propietario;
    private String nombre_propietario;
    private String ciudad;
    private String direccion;
    private String telefono;
    private Date fecha_registro;
}
