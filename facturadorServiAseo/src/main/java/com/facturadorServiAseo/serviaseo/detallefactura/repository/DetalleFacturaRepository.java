package com.facturadorServiAseo.serviaseo.detallefactura.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.facturadorServiAseo.serviaseo.detallefactura.entities.DetalleFacturaEntity;

@Repository
public interface DetalleFacturaRepository extends JpaRepository<DetalleFacturaEntity, Long>{

	
	@Query("SELECT d FROM DetalleFacturaEntity d JOIN d.factura f WHERE f.id_factura = :idFactura")
    List<DetalleFacturaEntity> findByFacturaId(@Param("idFactura") long idFactura);
	
	
	
	// procedumiento cerar una factura y sus detalles
	@Procedure(procedureName = "pr_crear_facturas")
	void crearFactura(
			@Param ("p_cliente_id ")String cedula,
			@Param ("p_id_tipo_limpieza ") int tipoLimpieza,
			@Param ("p_nombre_producto ") String nombreProducto,
			@Param ("p_cantidad ") int cantidad,
			@Param ("p_id_factura_existente ") long idFacura

		
	);
}
