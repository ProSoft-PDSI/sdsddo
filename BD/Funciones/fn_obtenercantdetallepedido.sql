create or replace function fn_obtenercantdetallepedido(
  p_nropedido PEDIDO.NROPEDIDO%TYPE,
  p_codproducto varchar2
)
return number
is
v_cant number;
msg_error varchar2(500);
begin
  select cant into v_cant from detallepedido where codproducto = p_codproducto and nropedido = p_nropedido;
  return(v_cant);
exception
when others then
  msg_error := SQLERRM;
  RAISE_APPLICATION_ERROR(-20003, msg_error);
end;
/