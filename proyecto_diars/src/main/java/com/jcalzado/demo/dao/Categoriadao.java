package com.jcalzado.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jcalzado.demo.model.Categoria;

@Repository("categoriadao")
public interface Categoriadao extends JpaRepository<Categoria, Integer> {

}
