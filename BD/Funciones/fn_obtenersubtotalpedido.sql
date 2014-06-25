CREATE OR REPLACE FUNCTION fn_obtenersubtotalpedido(
  p_nropedido varchar2
)
return NUMBER
is
  subtotal number;
  msg_error varchar2(100);
begin
  select sum(preciototal) into subtotal from detallepedido where nropedido = p_nropedido;
  return(subtotal);
exception
when others then
  msg_error:=SQLERRM;
  RAISE_APPLICATION_ERROR(-20003, msg_error);
  return 0;
end;
/