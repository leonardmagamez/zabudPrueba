package com.example.demo.zabud.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "factura")
public class Factura {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "cliente")
	private String cliente;
	@Column(name = "valorTotal")
	private Double valorTotal;
	@JoinColumn(name = "item_id", referencedColumnName = "id")
	@ManyToOne(targetEntity=Item.class)
	private List<Item> itemId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public List<Item> getItemId() {
		return itemId;
	}
	public void setItemId(List<Item> itemId) {
		this.itemId = itemId;
	}
	
	
	

	
}
