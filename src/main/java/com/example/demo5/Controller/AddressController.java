package com.example.demo5.Controller;

import com.example.demo5.DTO.AddressDTO;
import com.example.demo5.Service.AdreessService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/address")
@RequiredArgsConstructor
public class AddressController {
    private final AdreessService adreessService;


    @GetMapping("/get")
    public ResponseEntity getAllAddress(){
        return ResponseEntity.status(200).body(adreessService.getAllAddress());

    }
    @PostMapping("/add")
    public ResponseEntity addAddress(@Valid @RequestBody AddressDTO addressDTO){
        adreessService.addAdreess(addressDTO);
        return ResponseEntity.status(200).body("address added");
    }
    @PutMapping("/update")

    public ResponseEntity updateAddress(@Valid @RequestBody AddressDTO addressDTO){
        adreessService.updateAdreess(addressDTO);
        return ResponseEntity.status(200).body("address updated");
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAddress(@PathVariable int id){
        adreessService.deleteAdreess(id);
        return ResponseEntity.status(200).body("address deleted");
    }


}