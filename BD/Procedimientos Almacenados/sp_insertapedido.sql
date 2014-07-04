CREATE OR REPLACE PROCEDURE sp_insertapedidos(
  p_dni varchar2,
  p_fecha date
)
as
  v_nro varchar2(10);
  v_inicio varchar2(7);
  v_temporal varchar2(10);
  n number;
  msg_error varchar2(100);
begin
  v_nro := fn_obtenervalorcontrol('pedido');
  insert into pedido values (v_nro,P_dni,p_fecha,null,null,null);
  
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