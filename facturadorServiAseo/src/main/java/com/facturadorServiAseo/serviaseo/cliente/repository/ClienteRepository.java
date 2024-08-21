package com.facturadorServiAseo.serviaseo.cliente.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.facturadorServiAseo.serviaseo.cliente.entities.ClienteEntity;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, String>{
	// funcion consuta si un ccliete ya existe
	@Query(value = "SELECT fn_consulta_cliente(:cedula)", nativeQuery = true)
    String consultaCliente(String cedula);
	
	
	// procedimiento insertar un cliente nuevo en la base e datos
	@Procedure(procedureName = "pr_insertat_cliente")
	void insertarUsuarion(
        @Param("_cedula") String cedula,
        @Param("_nombre") String nombre,
        @Param("_apellido") String apellido,
        @Param("_email") String email,
        @Param("_telefono") String telefono,
        @Param("_direccion") String direccion
        
    );
	
}
