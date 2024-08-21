package com.facturadorServiAseo.serviaseo.detallefactura.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
		try {
			
			return ResponseEntity.ok(facturaRepository.findAll());	
		}catch (Exception e) {
			return new ResponseEntity<>(e.getMessage()+"verificar datos", HttpStatus.BAD_REQUEST);	
		}
		}
	
	
	
	public ResponseEntity<?> crearFactura(DetalleFacturaEntity detalle) {
try{
		detalleFacturaRepository.crearFactura(
				detalle.getFactura().getCliente().getCedula(),
				detalle.getTipolimpieza().getId_tipo_limpieza(),
				detalle.getProducto().getNombre_producto(),
				detalle.getCantidad(),
				detalle.getFactura().getId_factura()
				);
		return new ResponseEntity<>("cliente creado con exito", HttpStatus.OK);	
}catch(Exception e) {
	return new ResponseEntity<>(e.getMessage()+"verificar datos", HttpStatus.BAD_REQUEST);	
}
	}

}
