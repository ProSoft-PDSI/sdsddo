CREATE OR REPLACE PROCEDURE sp_insertapedidos(
  p_dni varchar2,
  p_fecha date
)
as
v_subtotal number;
v_igv number;
v_total number;
v_nro varchar2(10);
v_temporal varchar(10);
begin
  v_subtotal:= fn_obtenersubtotalpedido();
  v_igv := v_subtotal * 0.18;
  v_total := v_subtotal + v_igv;
  v_nro := fn_obtnervalorcontrol('pedido'); 
  insert into pedidos values (v_nro,P_dni,p_fecha,v_subtotal,v_igv,v_total);
  
  v_inicio:=substr(v_nro,4,3);
  n:=to_number(v_inicio);
  n:=n+1;
  v_temporal:='PED'||to_char(n,'FM009');
  
  update control
  set valor=v_temporal
  where parametro='pedido';
   
commit;
exception
when others then
  msg_error:=SQLERRM;
  RAISE_APPLICATION_ERROR(-20003, msg_error);
rollback;
end;
/