package com.softcaribbean.Veterinaria.dao;

import com.softcaribbean.Veterinaria.dto.MascotasDTO;

import java.util.List;
import java.util.Map;

public interface MascotasDaoInterface {

    void insert(MascotasDTO mascotasDTO);
    List<MascotasDTO> selectAll();
    public List<Map<String,Object>> selectAll2();
    MascotasDTO findById(MascotasDTO mascotasDTO);
    void update(MascotasDTO mascotasDTO);
    void delete(MascotasDTO mascotasDTO);

}
