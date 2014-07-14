create or replace 
trigger TR_IN_DE_AC_CLIENTE 
AFTER INSERT OR DELETE OR UPDATE ON CLIENTE 
FOR EACH ROW
DECLARE
v_msg varchar2(100);
BEGIN
  If updating then
    if :NEW.usuario IS NULL then
        RAISE_APPLICATION_ERROR(-20000,'No se puede insertar usuario nulo');
    End if;
    if updating('dni') then
      RAISE_APPLICATION_ERROR(-20001,'No se puede modificar atributo DNI');
    End if;
    if updating('nomcliente') then
      insert into AUDITORIA(cambio,valor_inicio,valor_modif,usuario,fecha) values('upd_CLIENTE campo: nomcliente',
      :OLD.nomcliente,:NEW.nomcliente,:NEW.usuario,sysdate);
    end if;
    if updating('direccioncliente') then
      insert into AUDITORIA(cambio,valor_inicio,valor_modif,usuario,fecha) values('upd_CLIENTE campo: direccioncliente',
      :OLD.direccioncliente,:NEW.direccioncliente,:NEW.usuario,sysdate);
    end if;
    if updating('email') then
      insert into AUDITORIA(cambio,valor_inicio,valor_modif,usuario,fecha) values('upd_CLIENTE campo: email',
      :OLD.email, :NEW.email,:NEW.usuario,sysdate);
    end if;
    if updating('fechanac') then
      insert into AUDITORIA(cambio,valor_inicio,valor_modif,usuario,fecha) values('upd_CLIENTE campo: fechanac',
      :OLD.fechanac, :NEW.fechanac,:NEW.usuario,sysdate);
    end if;
    if updating('telefono') then
      insert into AUDITORIA(cambio,valor_inicio,valor_modif,usuario,fecha) values('upd_CLIENTE campo: telefono',
      :OLD.telefono, :NEW.telefono,:NEW.usuario,sysdate);
    end if;
  Elsif inserting then
    If :NEW.usuario IS NULL then
    RAISE_APPLICATION_ERROR(-20002,'No se puede eliminar registro con usuario nulo tabla CLIENTE');
    End if;
    insert into AUDITORIA(cambio,valor_inicio,valor_modif,usuario,fecha) values('ins_CLIENTE',
    :OLD.dni,:NEW.dni,:NEW.usuario,sysdate);
  Elsif deleting then
    If :OLD.usuario IS NULL then
      RAISE_APPLICATION_ERROR(-20003,'No se puede eliminar registro con usuario nulo Tabla CLIENTE');
    End if;
     insert into AUDITORIA(cambio,valor_inicio,valor_modif,usuario,fecha) values('del_PRODUCTO',
      :OLD.dni,:NEW.dni,:OLD.usuario,sysdate);
  End if;
  
  exception
    when others then
    v_msg:=sqlerrm;
    raise_application_error(-20000,v_msg);
END TR_IN_DE_AC_CLIENTE;
/