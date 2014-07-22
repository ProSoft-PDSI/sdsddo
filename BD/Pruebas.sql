-- ======================
--    Pruebas Unitarias
-- ======================
exec sp_insertacliente('46370142','Yoshitomi Eduardo Maehara Aliaga','calle 1 Mz E lt 18 Urb Viv Villa Resd Santa Rosita','trombon2004@gmail.com',to_date('1980/01/09', 'yyyy/mm/dd'),'5756138','sakren','saadia');
exec sp_insertapedidos('46370142','sakren');
exec sp_insertadetallepedido('PED001','PI01',3,'sakren');
exec sp_eliminarpedido();