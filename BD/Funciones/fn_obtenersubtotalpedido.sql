CREATE OR REPLACE FUNCTION fn_obtenersubtotalpedido(
  p_nropedido PEDIDO.NROPEDIDO%TYPE
)
return NUMBER
is
  subtotal number(5,2);
  v_msg_error varchar2(100);
  n number;
  err_ped exception;
begin
  select count(*)into n from detallepedido where nropedido = p_nropedido;
  if n>0 then
  select sum(preciototal) into subtotal from detallepedido where nropedido = p_nropedido;
  return(subtotal);
  else
    raise err_ped;
  end if;
  
exception
WHEN err_ped THEN
    v_msg_error:='error de busqueda de pedido';
    raise_application_error(-20001,v_msg_error);
when others then
  v_msg_error:=SQLERRM;
  RAISE_APPLICATION_ERROR(-20003, v_msg_error);
end;
/