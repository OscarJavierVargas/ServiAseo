select * FROM detallefactura d
inner join factura f
on d.id_factura=f.id_factura
WHERE f.id_factura= 3;