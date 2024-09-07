package com.softcaribbean.Veterinaria.business;

import com.softcaribbean.Veterinaria.dto.MascotasDTO;

import java.util.List;
import java.util.Map;

public interface MascotasBusinessInterface {
    public void saveOrUpdate(MascotasDTO mascotasDTO) throws Exception;
    public MascotasDTO findById(MascotasDTO mascotasDTO) throws Exception;
    public  void delete(MascotasDTO mascotasDTO) throws Exception;
    public List<Map<String, Object>> selectAll2() throws Exception;
}
