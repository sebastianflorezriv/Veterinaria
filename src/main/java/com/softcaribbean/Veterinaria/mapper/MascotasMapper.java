package com.softcaribbean.Veterinaria.mapper;

import com.softcaribbean.Veterinaria.dto.MascotasDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MascotasMapper implements RowMapper<MascotasDTO> {

    @Override
    public MascotasDTO mapRow(ResultSet resultSet, int i) throws SQLException {
        MascotasDTO masc=new MascotasDTO();
        masc.setId(resultSet.getString("id"));
        masc.setNombre(resultSet.getString("nombre"));
        masc.setEspecie(resultSet.getString("especie"));
        masc.setRaza(resultSet.getString("raza"));
        masc.setFecha_nacimiento(resultSet.getString("fecha_nacimiento"));
        masc.setTipo_identificacion(resultSet.getString("tipo_identificacion"));
        masc.setId_propietario(resultSet.getString("id_propietario"));
        masc.setNombre_propietario(resultSet.getString("nombre_propietario"));
        masc.setCiudad(resultSet.getString("ciudad"));
        masc.setDireccion(resultSet.getString("direccion"));
        masc.setTelefono(resultSet.getString("telefono"));
        masc.setFecha_registro(resultSet.getDate("fecha_registro"));
        return masc;
    }

}
