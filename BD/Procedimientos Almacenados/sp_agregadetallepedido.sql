create or replace procedure sp_agregardetalledepedido(
  p_codproducto varchar2,
  p_cant number
)
as
v_nro varchar2(10);
v_preciouni number;
v_preciototal number;
msg_error varchar2(500);
begin
  v_nro := fn_obtenervalorcontrol('pedido');
  v_preciouni := fn_obtenerpreuniproducto(p_codproducto);
  v_preciototal := v_preciouni * p_cant;
  insert into detallepedido values (v_nro,p_codproducto,v_preciouni,p_cant,v_preciototal);
  commit;
exception
when others then
  msg_error := SQLERRM;
  RAISE_APPLICATION_ERROR(-20003, msg_error);
  rollback;
end;