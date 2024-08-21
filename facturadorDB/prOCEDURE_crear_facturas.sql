DROP PROCEDURE IF EXISTS pr_crear_facturas;
DELIMITER //

CREATE PROCEDURE pr_crear_facturas (
    IN p_cliente_id VARCHAR(20),
    IN p_id_tipo_limpieza INT,
    IN p_nombre_producto VARCHAR(100),
    IN p_cantidad INT,
    IN p_id_factura_existente INT
)
BEGIN
    DECLARE _sub_total_producto DECIMAL(10, 2);
    DECLARE _sub_total_base DECIMAL(10, 2);
    DECLARE _sub_total DECIMAL(10, 2);
    DECLARE _id_producto INT;
    DECLARE v_factura_id INT;
    DECLARE factura_existente INT;
    DECLARE _valor DECIMAL(10, 2);

    -- Manejo de excepciones
 --   DECLARE EXIT HANDLER FOR SQLEXCEPTION
 --   BEGIN
        -- Si ocurre un error, se asegura de que la transacción sea revertida y se envíe un mensaje de error
 --       ROLLBACK;
--        SELECT 'CRE_FACT_ERR003' AS codigo, 'Error: no se pudo crear la factura debido a una excepción SQL.' AS mensaje;
--    END;

    -- Iniciar una transacción
    START TRANSACTION;
    SELECT COUNT(*) INTO factura_existente
    FROM Factura
    WHERE id_factura = p_id_factura_existente;
    IF factura_existente = 0 THEN
     INSERT INTO Factura (fecha_emision, total, cedula) 
        VALUES (NOW(), 0, p_cliente_id );  
     set v_factura_id= LAST_INSERT_ID();
	ELSE
	set v_factura_id=p_id_factura_existente;
    END IF;
    -- Obtener el subtotal del producto
    SELECT precio_unitario * p_cantidad INTO _sub_total_producto
    FROM Producto
    WHERE nombre_producto = p_nombre_producto;

    -- Obtener el subtotal base del tipo de limpieza
    SELECT precio_base INTO _sub_total_base
    FROM TipoLimpieza
    WHERE id_tipo_limpieza = p_id_tipo_limpieza;

    -- Calcular el subtotal total
    SET _sub_total = _sub_total_producto + _sub_total_base;

    -- Obtener el ID del producto
    SELECT id_producto INTO _id_producto
    FROM Producto
    WHERE nombre_producto = p_nombre_producto;

    -- Insertar en DetalleFactura
    INSERT INTO 
    DetalleFactura (cantidad, subtotal, id_producto, id_tipo_limpieza, id_factura)
		    VALUES (p_cantidad, _sub_total,_id_producto, p_id_tipo_limpieza,  v_factura_id);
            
     select sum(subtotal) into _valor
     from DetalleFactura
     where id_factura=v_factura_id;
     
	UPDATE Factura
    SET total = _valor
    WHERE id_factura = v_factura_id;

    
    -- Confirmar la transacción
    COMMIT;

    -- Mensaje de éxito
    SELECT 'SUC001' AS codigo, 'FACTURA CREADA exitosamente.' AS mensaje;

END //

DELIMITER ;
