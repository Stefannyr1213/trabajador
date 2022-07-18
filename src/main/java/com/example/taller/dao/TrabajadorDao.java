package com.example.taller.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.taller.entity.Trabajador;

@Repository
public interface TrabajadorDao extends CrudRepository<Trabajador, Long>{

}
