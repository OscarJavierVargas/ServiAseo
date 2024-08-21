package com.facturadorServiAseo.serviaseo.facturas.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.facturadorServiAseo.serviaseo.cliente.entities.ClienteEntity;
import com.facturadorServiAseo.serviaseo.detallefactura.entities.DetalleFacturaEntity;

@Entity
@Table(name = "factura")
public class FacturaEntity {

	public FacturaEntity() {
		super();
	}

	@Id
	@Column(name="id_factura")
	private long id_factura;
	@Column(name="fecha_emision")
	private Date fecha_emision;
	@Column(name="total")
	private double total;
	
	@ManyToOne
	@JoinColumn(name = "cedula")
	ClienteEntity Cliente;
	
	@OneToMany (mappedBy ="factura")
	List<DetalleFacturaEntity> detallefactura;
	
	
	
	public long getId_factura() {
		return id_factura;
	}
	public void setId_factura(long id_factura) {
		this.id_factura = id_factura;
	}
	public Date getFecha_emision() {
		return fecha_emision;
	}
	public void setFecha_emision(Date fecha_emision) {
		this.fecha_emision = fecha_emision;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public ClienteEntity getCliente() {
		return Cliente;
	}
	public void setCliente(ClienteEntity cliente) {
		Cliente = cliente;
	}
	
	
}
