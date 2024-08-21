DELIMITER //

CREATE PROCEDURE pr_enviar_factura_por_correo (
    IN p_id_factura INT,
    OUT p_asunto VARCHAR(255),
    OUT p_cuerpo TEXT,
    OUT p_email_cliente VARCHAR(255)
)
BEGIN
    DECLARE v_cliente_nombre VARCHAR(100);
    DECLARE v_total DECIMAL(10, 2);
    DECLARE v_fecha DATE;

    -- Obtener los detalles del cliente y la factura
    SELECT c.email, c.nombre, f.total, f.fecha_emision 
    INTO p_email_cliente, v_cliente_nombre, v_total, v_fecha
    FROM factura f
    INNER JOIN cliente c ON f.cedula = c.cedula
    WHERE f.id_factura = p_id_factura;

    -- Preparar el asunto del correo
    SET p_asunto = CONCAT('Factura #', p_id_factura, ' - ', v_cliente_nombre);

    -- Preparar el cuerpo del correo
    SET p_cuerpo = CONCAT(
        'Estimado/a ', v_cliente_nombre, ',\n\n',
        'Gracias por su compra. A continuación, encontrará los detalles de su factura.\n\n',
        'Fecha de Emisión: ', v_fecha, '\n',
        'Total: $', v_total, '\n\n',
        'Saludos cordiales,\n',
        'Su Empresa'
    );
END //

DELIMITER ;
