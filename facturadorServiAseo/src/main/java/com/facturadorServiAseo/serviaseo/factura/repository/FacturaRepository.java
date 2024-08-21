package com.facturadorServiAseo.serviaseo.factura.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.facturadorServiAseo.serviaseo.detallefactura.entities.DetalleFacturaEntity;
import com.facturadorServiAseo.serviaseo.facturas.entities.FacturaEntity;

@Repository
public interface FacturaRepository extends JpaRepository<FacturaEntity, Long>{

	

}
