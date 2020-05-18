package com.jcalzado.demo.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jcalzado.demo.model.Producto;

@Repository("productodao")
public interface Productodao extends JpaRepository<Producto, Serializable> {

}
