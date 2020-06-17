package com.jcalzado.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jcalzado.demo.dao.CarritoDao;
import com.jcalzado.demo.model.Carrito;
import com.jcalzado.demo.service.CarritoService;


@Service("carritoservice")
public class CarritoServiceImpl implements CarritoService{

	@Autowired
	@Qualifier("carritodao")
	private CarritoDao carritodao;

	@Override
	public int save(Carrito p) {
		int res=0;
		Carrito carrito=carritodao.save(p);
		if(!carrito.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void deletecar(int id) {
		carritodao.deleteById(id); 
	}

	@Override
	public List<Carrito> listarcar() {
		// TODO Auto-generated method stub
		return carritodao.findAll();
	}

	@Override
	public Optional<Carrito> listarId(int id) {
		// TODO Auto-generated method stub
		return carritodao.findById(id);
	}

}
