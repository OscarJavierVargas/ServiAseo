package com.facturadorServiAseo.serviaseo.detallefactura.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.facturadorServiAseo.serviaseo.detallefactura.entities.DetalleFacturaEntity;
import com.facturadorServiAseo.serviaseo.detallefactura.repository.DetalleFacturaRepository;
import com.facturadorServiAseo.serviaseo.factura.repository.FacturaRepository;
import com.facturadorServiAseo.serviaseo.facturas.entities.FacturaEntity;
@Service
public class DetalleFacturaService {

	@Autowired
	DetalleFacturaRepository detalleFacturaRepository;
	
	@Autowired
	FacturaRepository facturaRepository;
	
	
	
	 public List<DetalleFacturaEntity> obtenerDetallesPorFacturaId(long idFactura) {
	        return detalleFacturaRepository.findByFacturaId(idFactura);
	    }
	
	
	public ResponseEntity<?> listaFacturas(){
		return ResponseEntity.ok(facturaRepository.findAll());	
	}
	
	
	
	
	
	
	

	public void crearFactura(DetalleFacturaEntity detalle) {

		detalleFacturaRepository.crearFactura(
				detalle.getFactura().getCliente().getCedula(),
				detalle.getTipolimpieza().getId_tipo_limpieza(),
				detalle.getProducto().getNombre_producto(),
				detalle.getCantidad(),
				detalle.getFactura().getId_factura()
				);

	}

//	public String consultaCliente(String cedula) {
//		return clienteRepository.consultaCliente(cedula);
//	}
//
//	public 	 ResponseEntity<?> saveUsuarioPr(ClienteEntity usuario){
//		try {
//	String cedula=usuario.getCedula();
//	String nombre=usuario.getNombre();
//	String apellido=usuario.getApellido();
//	String email=usuario.getEmail();
//	String telefono=usuario.getTelefono();
//	String direccion=usuario.getDireccion();
//	clienteRepository.insertarUsuarion(cedula, nombre, apellido, email, telefono, direccion);
//		
//		return new ResponseEntity<>("cliente proced creado con exito",HttpStatus.OK);
//		}catch(Exception e) {
//			return new ResponseEntity<>(e.getMessage()+": verificar datos ingresados", HttpStatus.ALREADY_REPORTED);
//		}
//	}
//	
//	
//	// listar clietes
//	public ResponseEntity<?> getUsuario(){
//		try {
//			return  ResponseEntity.ok(clienteRepository.findAll());	
//		}catch(Exception e) {
//			return new ResponseEntity<>(e.getMessage()+": verificar datos ingresados", HttpStatus.OK);
//		}
//	}
//	
//	public ResponseEntity<?> getUsuarioId(String id){
//		try {
//			return  ResponseEntity.ok(clienteRepository.findById(id));	
//		}catch(Exception e) {
//			return new ResponseEntity<>(e.getMessage()+": verificar datos ingresados", HttpStatus.OK);
//		}
//	}
//	
//	// ingresar tickets
//	
//	public ResponseEntity<?> saveUsuario(ClienteEntity usuario){
//		LocalDateTime ahora = LocalDateTime.now();
//		try {
//			clienteRepository.save(usuario);
//			return new ResponseEntity<>("cliente creado con exito", HttpStatus.OK);
//		}catch(Exception e) {
//			return new ResponseEntity<>(e.getMessage()+": verificar datos ingresados", HttpStatus.OK);
//		}
//	}
//	
//	public ResponseEntity<?> updateUsuario(String id, ClienteEntity usuario){
//		LocalDateTime ahora = LocalDateTime.now();
//		try {
//			
//			if(clienteRepository.findById(id) != null) {
//				ClienteEntity actualiuzar=clienteRepository.findById(id).get();
//				actualiuzar.setNombre(usuario.getNombre());
//				actualiuzar.setApellido(usuario.getApellido());
//				actualiuzar.setDireccion(usuario.getDireccion());
//				actualiuzar.setEmail(usuario.getEmail());
//				actualiuzar.setTelefono(usuario.getTelefono());
//				clienteRepository.save(actualiuzar);
//			}
//			return new ResponseEntity<>("usuario modificado con exito", HttpStatus.OK);
//		}catch(Exception e) {
//			return new ResponseEntity<>(e.getMessage()+": verificar datos ingresados", HttpStatus.OK);
//		}
//	}
//	
//	public ResponseEntity<?> deleteUsuario(String id ){
//		try {
//			
//			if(clienteRepository.findById(id) != null) {;	
//			clienteRepository.deleteById(id);;
//			}
//			return new ResponseEntity<>("uusario eliminado con exito", HttpStatus.OK);
//		}catch(Exception e) {
//			return new ResponseEntity<>(e.getMessage()+": verificar datos ingresados", HttpStatus.OK);
//		}
//	}
//

}
