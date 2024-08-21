package com.facturadorServiAseo.serviaseo.cliente.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.facturadorServiAseo.serviaseo.detallefactura.entities.DetalleFacturaEntity;
import com.facturadorServiAseo.serviaseo.facturas.entities.FacturaEntity;

@Entity
@Table(name = "Cliente")
public class ClienteEntity {

	public ClienteEntity() {
		super();
	}
	
	

	public ClienteEntity(String cedula, String nombre, String apellido, String email, String telefono,
			String direccion) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
		this.direccion = direccion;
	}



	@Id
	@Column(name="cedula")
	private String cedula;
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellido")
	private String apellido;
	@Column(name="email")
	private String email;
	@Column(name="telefono")
	private String telefono;
	@Column(name="direccion")
	private String direccion;
	
	
	
	@OneToMany(mappedBy = "Cliente")
    List<FacturaEntity> factura;
	
	
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	

}
