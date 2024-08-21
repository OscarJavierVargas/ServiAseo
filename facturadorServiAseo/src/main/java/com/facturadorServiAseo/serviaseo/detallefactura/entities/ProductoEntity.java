package com.facturadorServiAseo.serviaseo.detallefactura.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Producto")
public class ProductoEntity {
	
	@Id
	@Column(name="id_producto")
	private long id_producto;
	@Column(name="nombre_producto")
	private String nombre_producto;
	@Column(name="precio_unitario")
	private double precio_unitario;
	
	@OneToMany(mappedBy = "Producto")
	List<DetalleFacturaEntity> DetalleFactura;
	
	
	public long getId_producto() {
		return id_producto;
	}
	public void setId_producto(long id_producto) {
		this.id_producto = id_producto;
	}
	public String getNombre_producto() {
		return nombre_producto;
	}
	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}
	public double getPrecio_unitario() {
		return precio_unitario;
	}
	public void setPrecio_unitario(double precio_unitario) {
		this.precio_unitario = precio_unitario;
	}
	
	

}
