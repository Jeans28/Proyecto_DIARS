package com.jcalzado.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jcalzado.demo.dao.RolDao;
import com.jcalzado.demo.model.Rol;
import com.jcalzado.demo.service.RolService;

@Service("rolservice")
public class RolServiceImpl implements RolService{

	@Autowired
	@Qualifier("roldao")
	private RolDao roldao;

	@Override
	public List<Rol> lsitarrol() {
		// TODO Auto-generated method stub
		return roldao.findAll();
	}
}
