package com.example.demo5.Modell;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor

public class Addreess {



   @Id
    private Integer Id;


    private String area;
    private String street;
    private String buildingNumber;






    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;
}
