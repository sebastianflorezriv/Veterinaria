package com.softcaribbean.Veterinaria.business;

import com.softcaribbean.Veterinaria.dto.MascotasDTO;
import com.softcaribbean.Veterinaria.manager.MascotasManagerInterface;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Component
@Transactional
public class MascotasBusinessImplements implements MascotasBusinessInterface{
    private MascotasManagerInterface mascotasManagerInterface;

    public MascotasBusinessImplements(MascotasManagerInterface mascotasManagerInterface){
        this.mascotasManagerInterface=mascotasManagerInterface;
    }

    public void saveOrUpdate(MascotasDTO mascotasDTO) throws Exception{
        this.mascotasManagerInterface.saveOrUpdate(mascotasDTO);
    }

    public MascotasDTO findById(MascotasDTO mascotasDTO) throws Exception{
        return this.mascotasManagerInterface.findById(mascotasDTO);
    }

    @Override
    public void delete(MascotasDTO mascotasDTO) throws Exception{
        this.mascotasManagerInterface.delete(mascotasDTO);
    }

    @Override
    public List<Map<String, Object>> selectAll2() throws Exception{
        return this.mascotasManagerInterface.selectAll2();
    }

}
