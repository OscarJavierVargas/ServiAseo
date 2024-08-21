drop procedure pr_consulta_cliente;
DELIMITER //
create  procedure pr_consulta_cliente (

in	_cedula VARCHAR(20))

BEGIN
declare
cliente_existente int ; 
 DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
       SET @codigo_error = 'CONS_CLI_ERR002';
        SET @mensaje_error = 'Error: no se pudo insertar el cliente debido a una excepción SQL en: pr_consulta_cliente.';
        ROLLBACK;
        SELECT @codigo_error AS codigo, @mensaje_error AS mensaje;
    END;

select count(*) into cliente_existente
from cliente
where cedula =_cedula;
if(cliente_existente>0) then
 SELECT CONCAT('mensaje: Ya existe un cliente con la cédula ', _cedula) AS Mensaje;
else
select concat('mensaje: no existe un cliente con cedula', _cedula ) as Mensaje;
end if;
END  //
DELIMITER ;
