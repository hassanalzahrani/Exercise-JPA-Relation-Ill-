package com.example.demo5.Service;

import com.example.demo5.Api_exception.ApiException;
import com.example.demo5.DTO.AddressDTO;
import com.example.demo5.Modell.Addreess;
import com.example.demo5.Modell.Teacher;
import com.example.demo5.Repositry.AdreessRepository;
import com.example.demo5.Repositry.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdreessService {

    private final AdreessRepository adreessRepository;

    private final TeacherRepository teacherRepository;
    public List<Addreess> getAllAddress() {
        return adreessRepository.findAll();
    }

    public void addAdreess(AddressDTO addressDTO) {
        Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacheer_id());
        if (teacher == null) {
            throw new ApiException("Teacher not found");
        }
        Addreess addreess=new Addreess(addressDTO.getTeacheer_id(),addressDTO.getArea(),addressDTO.getStreet(),addressDTO.getBuildingNumber(),teacher);

        adreessRepository.save(addreess);
    }

    public void updateAdreess(AddressDTO addressDTO) {
        Addreess addreess = adreessRepository.findAddreessById(addressDTO.getTeacheer_id());
        if (addreess == null) {
            throw new ApiException("Addreess not found");
        }
        addreess.setArea(addressDTO.getArea());
        addreess.setStreet(addressDTO.getStreet());
        addreess.setBuildingNumber(addressDTO.getBuildingNumber());
        adreessRepository.save(addreess);
    }

    public void deleteAdreess(Integer id) {

        if (adreessRepository.findAddreessById(id)==null){
            throw new ApiException("Addreess not found");

        }
        teacherRepository.deleteById(id);
    }


}