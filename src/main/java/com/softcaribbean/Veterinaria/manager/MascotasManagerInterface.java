package com.softcaribbean.Veterinaria.manager;

import com.softcaribbean.Veterinaria.dto.MascotasDTO;

import java.util.List;
import java.util.Map;

public interface MascotasManagerInterface {
    public void saveOrUpdate(MascotasDTO mascotasDTO);
    public MascotasDTO findById(MascotasDTO mascotasDTO);
    public  void delete(MascotasDTO mascotasDTO);
    public List<Map<String, Object>> selectAll2();
}
