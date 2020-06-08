package com.example.demo.zabud.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class Item {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
	@Column(name = "cantidad")
	private Double cantidad;
	@Column(name = "valorTotal")
	private Double valorTotal;
	@JoinColumn(name = "producto_id", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Productos productoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemId")
    private List<Factura> listFactura;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getCantidad() {
		return cantidad;
	}
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Productos getProductoId() {
		return productoId;
	}
	public void setProductoId(Productos productoId) {
		this.productoId = productoId;
	}
	public List<Factura> getListFactura() {
		return listFactura;
	}
	public void setListFactura(List<Factura> listFactura) {
		this.listFactura = listFactura;
	}
	
	
	
}
