package com.example.demo.zabud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.zabud.entity.Factura;

public interface FacturaDao extends JpaRepository<Factura, Long> {

}
