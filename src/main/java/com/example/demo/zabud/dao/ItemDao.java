package com.example.demo.zabud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.zabud.entity.Item;

public interface ItemDao extends JpaRepository<Item, Long>{

}
