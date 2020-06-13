package com.jcalzado.demo.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jcalzado.demo.model.Carrito;


@Repository("carritodao")
public interface Carritodao extends JpaRepository<Carrito, Integer>{
	List<Carrito>findByNombre(String nombre);
}
