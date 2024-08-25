package com.example.demo5.Repositry;

import com.example.demo5.Modell.Addreess;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdreessRepository extends JpaRepository<Addreess, Integer> {

    Addreess findAddreessById(Integer id);
}
