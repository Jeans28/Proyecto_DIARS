package com.jcalzado.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.jcalzado.demo.dao.Productodao;
import com.jcalzado.demo.model.Producto;
import com.jcalzado.demo.service.ProductoService;

@Service("productoservice")
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	@Qualifier("productodao")
	private Productodao productodao;

	@Override
	public int save(Producto p) {
		int res=0;
		Producto producto=productodao.save(p);
		if(!producto.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void deletepro(int id) {
		productodao.deleteById(id); 
	}

	@Override
	public List<Producto> listarpro() {
		// TODO Auto-generated method stub
		return productodao.findAll();
	}

	@Override
	public Optional<Producto> listarId(int id) {
		// TODO Auto-generated method stub
		return productodao.findById(id);
	}


	
}
