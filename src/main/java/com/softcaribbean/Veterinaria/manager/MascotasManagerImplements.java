package com.softcaribbean.Veterinaria.manager;

import com.softcaribbean.Veterinaria.dao.MascotasDaoInterface;
import com.softcaribbean.Veterinaria.dto.MascotasDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class MascotasManagerImplements implements MascotasManagerInterface {
    public MascotasDaoInterface mascotasDaoInterface;

    public MascotasManagerImplements(MascotasDaoInterface mascotasDaoInterface){
        this.mascotasDaoInterface=mascotasDaoInterface;
    }

    public void saveOrUpdate(MascotasDTO mascotasDTO) {
        MascotasDTO mascotasFound = this.mascotasDaoInterface.findById(mascotasDTO);
        if(mascotasFound==null){
            this.mascotasDaoInterface.insert(mascotasDTO);
        }else{
            this.mascotasDaoInterface.update(mascotasDTO);
        }
    }

    public MascotasDTO findById(MascotasDTO mascotasDTO) {
        MascotasDTO mascotasFound = this.mascotasDaoInterface.findById(mascotasDTO);
        return mascotasFound;
    }

    @Override
    public void delete(MascotasDTO mascotasDTO) {

        this.mascotasDaoInterface.delete(mascotasDTO);
    }

    @Override
    public List<Map<String, Object>> selectAll2() {

        return this.mascotasDaoInterface.selectAll2();
    }

}
