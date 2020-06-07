package com.example.demo.zabud.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "factura")
public class Factura {
  @Column(name = "cliente")
  private String cliente;
  @Column(name = "item")
  private List<Item> item;
  @Column(name = "valorTotal")
  private Double valorTotal;

public String getCliente() {
	return cliente;
}
public void setCliente(String cliente) {
	this.cliente = cliente;
}
public List<Item> getItem() {
	return item;
}
public void setItem(List<Item> item) {
	this.item = item;
}
public Double getValorTotal() {
	return valorTotal;
}
public void setValorTotal(Double valorTotal) {
	this.valorTotal = valorTotal;
}
}
