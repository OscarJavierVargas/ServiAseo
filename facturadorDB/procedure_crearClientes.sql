-- drop procedure pr_insertat_cliente;
DELIMITER //
create  procedure pr_insertat_cliente (

in	_cedula VARCHAR(20),
in  _nombre VARCHAR(100),
in  _apellido VARCHAR(100),
in  _email VARCHAR(100),
in  _telefono VARCHAR(15),
in  _direccion VARCHAR(255))

BEGIN
declare
cliente_existente int ; 
 DECLARE EXIT HANDLER FOR SQLEXCEPTION
      BEGIN
       SET @codigo_error = 'INS_CLI_ERR001';
        SET @mensaje_error = 'Error: no se pudo insertar el cliente debido a una excepción SQL en: pr_insertat_cliente.';
        ROLLBACK;
        SELECT @codigo_error AS codigo, @mensaje_error AS mensaje;
    
    END;

select count(*) into cliente_existente
from cliente
where cedula =_cedula;
if(cliente_existente>0) then
 SELECT CONCAT('Error: Ya existe un cliente con la cédula ', _cedula) AS Mensaje;
else
INSERT INTO Cliente (cedula, nombre, apellido, email, telefono, direccion)
value(_cedula, _nombre, _apellido, _email, _telefono, _direccion);
end if;
 SET @codigo_exito = 'SUC001';
    SET @mensaje_exito = 'Cliente insertado exitosamente.';
    SELECT @codigo_exito AS codigo, @mensaje_exito AS mensaje;
END  //
DELIMITER ;



