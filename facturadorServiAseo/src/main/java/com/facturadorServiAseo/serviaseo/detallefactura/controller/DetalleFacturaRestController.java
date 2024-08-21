package com.facturadorServiAseo.serviaseo.detallefactura.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facturadorServiAseo.serviaseo.detallefactura.entities.DetalleFacturaEntity;
import com.facturadorServiAseo.serviaseo.detallefactura.service.DetalleFacturaService;
import com.facturadorServiAseo.serviaseo.factura.repository.FacturaRepository;
import com.facturadorServiAseo.serviaseo.facturas.entities.FacturaEntity;

@RestController
@RequestMapping
public class DetalleFacturaRestController {
	
	
	@Autowired
	DetalleFacturaService detalleFacturaService;
	

	
	
    @GetMapping("/factura/{idFactura}/detalles")
    public List<DetalleFacturaEntity> obtenerDetallesFactura(@PathVariable long idFactura) {
        return detalleFacturaService.obtenerDetallesPorFacturaId(idFactura);
    }
	
	
	@GetMapping("/factura")
	public ResponseEntity<?> listaFacturas(){
		return detalleFacturaService.listaFacturas();
	}
	
	@PostMapping("/factura")
	public void crearFactura(@RequestBody DetalleFacturaEntity detalle) {
		detalleFacturaService.crearFactura(detalle);
	}
	
	
//	@GetMapping("/conusulta/{cedula}")
//	public String consultaCliente(@PathVariable String cedula) {
//		return clienteService.consultaCliente(cedula);
//	}
//	
//	
//	@PostMapping("/usuarioPr")
//	ResponseEntity<?> savaUsuarioPr(@RequestBody ClienteEntity usuario){
//		return clienteService.saveUsuarioPr(usuario);
//		}
//	
//
//	
//	@GetMapping("/usuario")
//	ResponseEntity<?> getUsuario(){
//		return clienteService.getUsuario();
//		}
//	
//	@GetMapping("/usuario/{id}")
//	ResponseEntity<?> getUsuario(@PathVariable String id){
//		return clienteService.getUsuarioId(id);
//		}
//	
//    @PostMapping("/usuario")
//    ResponseEntity<?> saveUsuario (@RequestBody ClienteEntity usuario){
//    	return clienteService.saveUsuario(usuario);
//    }
//    
//    @PutMapping("/usuario/{id}")
//    ResponseEntity<?> updateUsuario (@PathVariable String id, @RequestBody ClienteEntity usuario){
//    	try {
//    	return clienteService.updateUsuario(id, usuario);
//    	}catch (Exception e) {
//    		return new ResponseEntity<>(e.getMessage()+": verificar datos ingresados", HttpStatus.OK);
//    		
//		}
//    }
//	
//    @DeleteMapping("/usuario/{id}")
//	ResponseEntity<?> deleteUsuario(@PathVariable String id){
//		return clienteService.deleteUsuario(id);
//		}
//
//		
//
//	
}
