package com.softcaribbean.Veterinaria.dao;

import com.softcaribbean.Veterinaria.dto.MascotasDTO;
import com.softcaribbean.Veterinaria.mapper.MascotasMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Repository
public class MascotasDaoImplements implements MascotasDaoInterface {
    private JdbcTemplate jdbcTemplate;

    public MascotasDaoImplements(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void insert(MascotasDTO mascotasDTO) {

        String INSERT = "INSERT INTO public.mascotas(nombre,especie,raza,fecha_nacimiento,tipo_identificacion,id_propietario,nombre_propietario,ciudad,direccion,telefono) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(INSERT,
                mascotasDTO.getNombre(),
                mascotasDTO.getEspecie(),
                mascotasDTO.getRaza(),
                mascotasDTO.getFecha_nacimiento(),
                mascotasDTO.getTipo_identificacion(),
                mascotasDTO.getId_propietario(),
                mascotasDTO.getNombre_propietario(),
                mascotasDTO.getCiudad(),
                mascotasDTO.getDireccion(),
                mascotasDTO.getTelefono());

        return;
    }

    @Override
    public List<MascotasDTO> selectAll() {
        String SQL = "SELECT id,nombre,especie,raza,fecha_nacimiento,tipo_identificacion,id_propietario,nombre_propietario,ciudad,direccion,telefono,fecha_registro FROM mascotas";
        return jdbcTemplate.query(SQL, new MascotasMapper());
    }

    @Override
    public List<Map<String, Object>> selectAll2() {
        String SQL = "SELECT id,nombre,especie,raza,fecha_nacimiento,tipo_identificacion,id_propietario,nombre_propietario,ciudad,direccion,telefono,fecha_registro FROM mascotas";
        return jdbcTemplate.queryForList(SQL);
    }

    @Override
    public MascotasDTO findById(MascotasDTO mascotasDTO) {
        try{
            String QUERY = "SELECT id,nombre,especie,raza,fecha_nacimiento,tipo_identificacion,id_propietario,nombre_propietario,ciudad,direccion,telefono,fecha_registro FROM mascotas WHERE id=?";
            return jdbcTemplate.queryForObject(QUERY, new MascotasMapper(),mascotasDTO.getId());
        }catch(EmptyResultDataAccessException ex){
            return null;
        }
    }

    @Override
    public void update(MascotasDTO mascotasDTO) {

        String UPDATE = "UPDATE mascotas SET nombre=?,especie=?,raza=?,fecha_nacimiento=?,tipo_identificacion=?,id_propietario=?,nombre_propietario=?,ciudad=?,direccion=?,telefono=?,fecha_registro=? WHERE id=?";

        jdbcTemplate.update(UPDATE,
                mascotasDTO.getNombre(),
                mascotasDTO.getEspecie(),
                mascotasDTO.getRaza(),
                mascotasDTO.getFecha_nacimiento(),
                mascotasDTO.getTipo_identificacion(),
                mascotasDTO.getId_propietario(),
                mascotasDTO.getNombre_propietario(),
                mascotasDTO.getCiudad(),
                mascotasDTO.getDireccion(),
                mascotasDTO.getTelefono(),
                mascotasDTO.getFecha_registro(),
                mascotasDTO.getId());

        return;

    }

    @Override
    public void delete(MascotasDTO mascotasDTO) {
        String DELETE = "DELETE FROM mascotas WHERE id=?";
        jdbcTemplate.update(DELETE, mascotasDTO.getId());

        return;
    }
}
