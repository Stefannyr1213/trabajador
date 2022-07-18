package com.example.taller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.taller.dao.TrabajadorDao;
import com.example.taller.entity.Trabajador;

@Service
public class TrabajadorService implements ITrabajadorService{
	@Autowired
	private TrabajadorDao trabajadorDao;
	@Transactional(readOnly = true)	
	public List<Trabajador> findAll() {//buscar todos los trabajadores
		return (List<Trabajador>) trabajadorDao.findAll();
	}
	@Transactional(readOnly = true)	
	public Trabajador findById(Long id) {//buscar por id un trabajador
		return trabajadorDao.findById(id).orElse(null);
	}
	@Transactional
	public Trabajador save(Trabajador cliente) {//crear un trabajador
		return trabajadorDao.save(cliente);
	}
	@Transactional
	public void delete(Long id) {//borrar un trabajador por id
		trabajadorDao.deleteById(id);
	}	
}
