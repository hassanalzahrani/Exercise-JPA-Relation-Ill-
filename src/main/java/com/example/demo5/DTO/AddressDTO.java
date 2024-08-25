package com.example.demo5.DTO;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {

    private Integer teacheer_id;
    @NotEmpty(message = "area should not be empty")
    private String area;
    @NotEmpty(message = "Street should not be empty")

    private String street;
    @NotEmpty(message = "Building Number should not be empty")

    private String buildingNumber;



}