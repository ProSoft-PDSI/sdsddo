create or replace PROCEDURE SP_AGREGARUSUARIO(
p_dni varchar2,
p_nombrecliente varchar2,
p_direccioncliente varchar2,
P_email varchar2,
p_fechanac date,
p_telefono varchar2,
p_usuario varchar2,
p_contraseña varchar2
)
AS
v_msg_error varchar2(500);
v_msg varchar2(500);
n int;
val int;
err_cli exception;
err_usu exception;  
BEGIN
  /*comprobar si existe el usuario*/
  select count(*) into  n from usuario where usuario=p_usuario;
  if n = 0 then
    insert into usuario values (p_usuario,p_contraseña,'C');
  else
    raise err_usu;
  end if;

 /*comprobar si existe el cliente*/
  select count(*) into  n from cliente where dni=p_dni;
  if n = 0 then
    insert into cliente values (p_dni,p_nombrecliente,p_direccioncliente,P_email,p_fechanac,p_telefono,p_usuario);   
  else
    raise err_cli;
  end if;
  

  
  /*auditoria*/
  /*
  v_msg:='se inserto los datos  de un nuevo cliente ' || p_dni;
  select to_number(valor,99) into val from control where parametro='auditoria';
  insert into auditoria values(val,v_msg,0,0,'admin');
  val:=val+1;
  update control
  set valor=val
  where parametro='auditoria';
  */ 
  commit;
  EXCEPTION
  WHEN err_cli THEN
    v_msg_error:='error de insercion cliente';
    raise_application_error(-20001,v_msg_error);
  WHEN err_usu THEN
    v_msg_error:='error de insercion usuario';
    raise_application_error(-20002,v_msg_error);
  WHEN OTHERS THEN
    v_msg_error:=SQLERRM;
    raise_application_error(-20003,v_msg_error);
  rollback;
END;
/