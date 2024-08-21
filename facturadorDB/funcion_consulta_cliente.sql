DROP FUNCTION IF EXISTS fn_consulta_cliente;
DELIMITER //

CREATE FUNCTION fn_consulta_cliente (
    _cedula VARCHAR(20)
) RETURNS VARCHAR(255)
    READS SQL DATA
BEGIN
    DECLARE cliente_existente INT;
    DECLARE mensaje VARCHAR(255);

    -- Consulta para verificar si el cliente existe
    SELECT COUNT(*) INTO cliente_existente
    FROM cliente
    WHERE cedula = _cedula;

    -- Determina el mensaje basado en si el cliente existe o no
    IF cliente_existente > 0 THEN
        SET mensaje = CONCAT('mensaje: Ya existe un cliente con la cédula ', _cedula);
    ELSE
        SET mensaje = CONCAT('mensaje: no existe un cliente con cédula ', _cedula);
    END IF;

    RETURN mensaje;
END //

DELIMITER ;
