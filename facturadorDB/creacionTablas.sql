create database ServiAseo;
use serviaseo;

CREATE TABLE Cliente (
    cedula VARCHAR(20) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    telefono VARCHAR(15),
    direccion VARCHAR(255)
);

CREATE TABLE Producto (
    id_producto INT PRIMARY KEY AUTO_INCREMENT,
    nombre_producto VARCHAR(100) NOT NULL,
    precio_unitario DECIMAL(10, 2) NOT NULL
);

INSERT INTO Producto (nombre_producto, precio_unitario) 
VALUES 
('Detergente', 5.99),
('Escoba', 3.50),
('Jabón Líquido', 2.75),
('Desinfectante', 4.50),
('Limpiador Multiusos', 6.30);




CREATE TABLE TipoLimpieza (
    id_tipo_limpieza INT PRIMARY KEY AUTO_INCREMENT,
    descripcion VARCHAR(255) NOT NULL,
    precio_base DECIMAL(10, 2) NOT NULL
);

INSERT INTO TipoLimpieza (descripcion, precio_base) 
VALUES 
('Limpieza Básica', 25.00),
('Limpieza Profunda', 50.00),
('Limpieza de Oficinas', 40.00),
('Limpieza de Alfombras', 30.00),
('Limpieza de Vidrios', 20.00);



CREATE TABLE Factura (
    id_factura INT PRIMARY KEY AUTO_INCREMENT,
    fecha_emision DATE NOT NULL,
    total DECIMAL(10, 2) NOT NULL,
    cedula VARCHAR(20),
     id_detalle INT,
    FOREIGN KEY (cedula) REFERENCES Cliente(cedula),
    FOREIGN KEY (id_detalle) REFERENCES DetalleFactura(id_detalle)
   
);
CREATE TABLE DetalleFactura (
    id_detalle INT PRIMARY KEY AUTO_INCREMENT,
    cantidad INT NOT NULL,
    subtotal DECIMAL(10, 2) NOT NULL,
    id_producto INT,
    id_tipo_limpieza INT,
    FOREIGN KEY (id_producto) REFERENCES Producto(id_producto),
    FOREIGN KEY (id_tipo_limpieza) REFERENCES TipoLimpieza(id_tipo_limpieza)
);









