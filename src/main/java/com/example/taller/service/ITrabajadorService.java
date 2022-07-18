package com.example.taller.service;

import java.util.List;

import com.example.taller.entity.Trabajador;

public interface ITrabajadorService {
	/**
	 * Buscar todos los trabajadores
	 * @return
	 */
	public List<Trabajador> findAll();
	/**
	 * Buscar por id un trabajador
	 * @param id
	 * @return
	 */
	public Trabajador findById(Long id);
	/**
	 * Crear un trabajador
	 * @param cliente
	 * @return
	 */
	public Trabajador save(Trabajador trabajador);
	/**
	 * Borrar un trabajador por su id
	 * @param id
	 */
	public void delete (Long id);
}
