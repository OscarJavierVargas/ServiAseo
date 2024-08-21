package com.facturadorServiAseo.serviaseo.detallefactura.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.facturadorServiAseo.serviaseo.facturas.entities.FacturaEntity;

@Entity
@Table(name = "detallefactura")
public class DetalleFacturaEntity {

	public DetalleFacturaEntity() {
		super();
	}

	@Id
	@Column(name="id_detalle")
	private long id_detalle;
	@Column(name="cantidad")
	private int cantidad;
	@Column(name="subtotal")
	private double subtotal;

	@ManyToOne
	@JoinColumn(name = "id_producto")
	ProductoEntity Producto;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo_limpieza")
	TipoLimpiezaEntity tipolimpieza;
	
	@ManyToOne
	@JoinColumn(name = "id_factura")
	FacturaEntity factura;
	
	
	public FacturaEntity getFactura() {
		return factura;
	}
	public void setFactura(FacturaEntity factura) {
		this.factura = factura;
	}
	public long getId_detalle() {
		return id_detalle;
	}
	public void setId_detalle(long id_detalle) {
		this.id_detalle = id_detalle;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	
	public ProductoEntity getProducto() {
		return Producto;
	}
	public void setProducto(ProductoEntity producto) {
		Producto = producto;
	}
	public TipoLimpiezaEntity getTipolimpieza() {
		return tipolimpieza;
	}
	public void setTipolimpieza(TipoLimpiezaEntity tipolimpieza) {
		this.tipolimpieza = tipolimpieza;
	}
	

	
	
}
