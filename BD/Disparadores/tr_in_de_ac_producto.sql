create or replace 
trigger TR_IN_DE_AC_PRODUCTO 
AFTER INSERT OR DELETE OR UPDATE ON PRODUCTO 
FOR EACH ROW
DECLARE
v_msg varchar2(100);
BEGIN
    
  if updating then
    if :NEW.usuario IS NULL THEN
      RAISE_APPLICATION_ERROR(-20000,'No se puede insertar usuario nulo');
    End if;
    if updating('codproducto') then
      RAISE_APPLICATION_ERROR(-20001,'No se puede modificar atributo CODPRODUCTO');
    end if;  
    if updating('descrproducto') then
      insert into AUDITORIA(cambio,valor_inicio,valor_modif,usuario,fecha) values('upd_PRODUCTO campo: descrproducto',
      :OLD.descrproducto,:NEW.descrproducto,:NEW.usuario,sysdate);
    end if;
    if updating('preciounitario') then
      insert into AUDITORIA(cambio,valor_inicio,valor_modif,usuario,fecha) values('upd_PRODUCTO campo: preciounitario',
      :OLD.preciounitario,:NEW.preciounitario,:NEW.usuario,sysdate);
    end if;
    if updating('stock') then
      insert into AUDITORIA(cambio,valor_inicio,valor_modif,usuario,fecha) values('upd_PRODUCTO campo: stock',
      :OLD.stock,:NEW.stock,:NEW.usuario,sysdate);
    end if;
  Elsif inserting then
      if :NEW.usuario IS NULL THEN
        RAISE_APPLICATION_ERROR(-20002,'No se puede insertar usuario nulo Tabla PRODUCTO');
      End if;
      insert into AUDITORIA(cambio,valor_inicio,valor_modif,usuario,fecha) values('ins_PRODUCTO',
      :OLD.codproducto,:NEW.codproducto,:NEW.usuario,sysdate);
  Elsif deleting then
      if :OLD.usuario IS NULL THEN
        RAISE_APPLICATION_ERROR(-20003,'No se puede eliminar registro con usuario nulo Tabla PRODUCTO');
      End if;
      insert into AUDITORIA(cambio,valor_inicio,valor_modif,usuario,fecha) values('del_PRODUCTO',
      :OLD.codproducto,:NEW.codproducto,:OLD.usuario,sysdate);
  end if;
exception
	when others then
		v_msg:=sqlerrm;
		raise_application_error(-20000, v_msg); 
END TR_IN_DE_AC_PRODUCTO;
/