create or replace function fn_obtenervalorcontrol(
  p_parametro varchar2
)
return varchar2
is
  v_valor varchar2(10);
  msg_error varchar2(500);
begin
  select valor into v_valor from control where parametro = p_parametro;
  return(v_valor);
exception
when others then
  msg_error:=SQLERRM;
  RAISE_APPLICATION_ERROR(-20003, msg_error);
end;
/