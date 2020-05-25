package com.jcalzado.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jcalzado.demo.model.Usuario;

@Repository("usuariodao")
public interface UsuarioDao extends JpaRepository<Usuario, Integer>{

}
