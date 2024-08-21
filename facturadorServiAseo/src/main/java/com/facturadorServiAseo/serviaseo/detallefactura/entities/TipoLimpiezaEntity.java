package com.facturadorServiAseo.serviaseo.detallefactura.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tipolimpieza")
public class TipoLimpiezaEntity {
	
	@Id
	@Column(name="id_tipo_limpieza")
	private int id_tipo_limpieza;
	@Column(name="descripcion")
	private String descripcion;
	@Column(name="precio_base")
	private double precio_base;
	
	@OneToMany(mappedBy = "tipolimpieza")
	List<DetalleFacturaEntity> DetalleFactura;
	
	public int getId_tipo_limpieza() {
		return id_tipo_limpieza;
	}
	public void setId_tipo_limpieza(int id_tipo_limpieza) {
		this.id_tipo_limpieza = id_tipo_limpieza;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio_base() {
		return precio_base;
	}
	public void setPrecio_base(double precio_base) {
		this.precio_base = precio_base;
	}
	
	
	
	
	
	
}
