create or replace procedure sp_agregardetallepedido(
  p_nropedido PEDIDO.NROPEDIDO%TYPE,
  p_codproducto varchar2,
  p_cant number,
  p_usuario varchar2
)
as
v_preciouni number(5,2);
v_preciototal number(5,2);
v_subtotal number(5,2);
v_igv number(5,2);
v_total number(5,2);
msg_error varchar2(500);
begin
  v_preciouni := fn_obtenerpreunitproducto(p_codproducto);
  v_preciototal := v_preciouni * p_cant;
  insert into detallepedido values (p_nropedido,p_codproducto,v_preciouni,p_cant,v_preciototal,p_usuario);
  
  v_subtotal:= fn_obtenersubtotalpedido(p_nropedido);
  v_igv := v_subtotal * 0.18;
  v_total := v_subtotal + v_igv;
  update pedido set subtotalpedido=v_subtotal,igv=v_igv,totalpedido=v_total where nropedido = p_nropedido;
  commit;
exception
when others then
  msg_error := SQLERRM;
  RAISE_APPLICATION_ERROR(-20003, msg_error);
  rollback;
end;
/