package com.example.taller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.taller.entity.Trabajador;
import com.example.taller.service.ITrabajadorService;
import com.example.taller.service.TrabajadorService;

@RestController
@RequestMapping("/api")
public class Controller {

	@Autowired
	private TrabajadorService trabajadorService;
	
	@GetMapping("/trabajadores")
	public List<Trabajador> getTrabajadores(){
		return trabajadorService.findAll();
	}
	
	@GetMapping("/trabajadores/{id}")
	public Trabajador show (@PathVariable Long id) {
		return trabajadorService.findById(id);
		
	}
	@PostMapping("/trabajadores")
	@ResponseStatus(HttpStatus.CREATED)
	public Trabajador create(@RequestBody Trabajador trabajador) {
		return trabajadorService.save(trabajador);
	}
	/**
	 * Actualizar el trabajador update
	 * @param trabajador
	 * @param id
	 * @return
	 */
	@PutMapping("/trabajadores/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Trabajador update(@RequestBody Trabajador trabajador, @PathVariable Long id) {
		Trabajador trabajadorActual = trabajadorService.findById(id);
		trabajadorActual.setNombre(trabajador.getNombre());
		trabajadorActual.setApellido(trabajador.getApellido());
		trabajadorActual.setTelefono(trabajador.getTelefono());
		trabajadorActual.setEmail(trabajador.getEmail());

		return trabajadorService.save(trabajadorActual);
	}
	@DeleteMapping("/trabajadores/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		trabajadorService.delete(id);
	}
}
