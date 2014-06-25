create or replace function fn_obtenerpreunitproducto(
  p_codproducto varchar2
)
return number
is
v_preunit number;
msg_error varchar2(500);
begin
  select preciounitario into v_preunit from producto where codproducto = p_codproducto;
  return(v_preunit);
exception
when others then
  msg_error := SQLERRM;
  RAISE_APPLICATION_ERROR(-20003, msg_error);
end;
/