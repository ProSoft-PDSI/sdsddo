create or replace 
trigger TR_IN_DE_AC_PEDIDO 
AFTER INSERT OR DELETE OR UPDATE ON PEDIDO 
FOR EACH ROW
DECLARE
v_msg VARCHAR2(100);
BEGIN
  if updating then --Cuando se Actualiza
    if :NEW.usuario IS NULL then
        RAISE_APPLICATION_ERROR(-20000,'No se puede insertar usuario nulo en tabla PEDIDO');
    end if;
    if updating('nropedido') then
      RAISE_APPLICATION_ERROR(-20001, 'No se puede modificar atributo NROPEDIDO');
    end if;
    if updating('dni') then
      insert into AUDITORIA(cambio,valor_inicio,valor_modif,usuario,fecha) values('upd_PEDIDO campo: dni',
        :OLD.dni,:NEW.dni,:NEW.usuario,sysdate);
    end if;
    if updating('fecha') then
      insert into AUDITORIA(cambio,valor_inicio,valor_modif,usuario,fecha) values('upd_PEDIDO campo: fecha',
        :OLD.fecha,:NEW.fecha,:NEW.usuario,sysdate);
    end if;
    if updating('subtotalpedido') then
      insert into AUDITORIA(cambio,valor_inicio,valor_modif,usuario,fecha) values('upd_PEDIDO campo: subtotalpedido',
        :OLD.subtotalpedido,:NEW.subtotalpedido,:NEW.usuario,sysdate);
    end if;
    if updating('igv') then
      insert into AUDITORIA(cambio,valor_inicio,valor_modif,usuario,fecha) values('upd_PEDIDO campo: igv',
        :OLD.igv,:NEW.igv,:NEW.usuario,sysdate);
    end if;
    if updating('totalpedido') then
      insert into AUDITORIA(cambio,valor_inicio,valor_modif,usuario,fecha) values('upd_PEDIDO campo: totalpedido',
        :OLD.totalpedido,:NEW.totalpedido,:NEW.usuario,sysdate);
    end if;
    if updating('estado') then
      insert into AUDITORIA(cambio,valor_inicio,valor_modif,usuario,fecha) values('upd_PEDIDO campo: estado',
        :OLD.estado,:NEW.estado,:NEW.usuario,sysdate);
    end if;
  elsif inserting then
    if :NEW.usuario IS NULL THEN
        RAISE_APPLICATION_ERROR(-20002,'No se puede insertar usuario nulo Tabla PEDIDO');
    End if;
    insert into AUDITORIA(cambio,valor_inicio,valor_modif,usuario,fecha) values('ins_PEDIDO',
      :OLD.nropedido,:NEW.nropedido,:NEW.usuario,sysdate);
  elsif deleting then
    if :OLD.usuario IS NULL THEN
        RAISE_APPLICATION_ERROR(-20003,'No se puede eliminar registro con usuario nulo Tabla PEDIDO');
    End if;
    insert into AUDITORIA(cambio,valor_inicio,valor_modif,usuario,fecha) values('del_PEDIDO',
      :OLD.nropedido,:NEW.nropedido,:OLD.usuario,sysdate);
  End if;
  exception
    when others then
      v_msg:=sqlerrm;
      raise_application_error(-20000,v_msg);
    
END;
/