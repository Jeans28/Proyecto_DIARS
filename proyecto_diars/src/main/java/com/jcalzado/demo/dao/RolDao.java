package com.jcalzado.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jcalzado.demo.model.Rol;

@Repository("roldao")
public interface RolDao extends JpaRepository<Rol, Integer>{

}
