package com.example.demo.zabud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.zabud.entity.Productos;

public interface ProductDao extends JpaRepository<Productos, Long>{
	Productos findByCodigo(String productoId);
}
