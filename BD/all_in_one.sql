/**
 *
 * DBMS           :  ORACLE
 * Base de Datos  :  RESTAURANTE
 * Descripcion    :  Base de Datos de Restaurante
 * Script         :  Todo en Uno(All_in_one)
 * Creado por     :  Prosoft
 * Email          :  yoshitomimaehara@gmail.com
 *
**/
-- ==========================================================
-- Inicio de Proceso
-- ==========================================================
SET TERMOUT ON
SET ECHO OFF
SET SERVEROUTPUT ON
BEGIN
	DBMS_OUTPUT.PUT_LINE('Inicio de la Creacion de Esquema...');
END;
/
SET TERMOUT OFF

-- ================================
-- Creando el Esquema
-- ================================

-- Verificar Cuenta

declare
  n number(3);
begin
  select count(*) into n from dba_users where username = 'restaurante';
  if(n = 1) then
    execute immediate 'drop user restaurante cascade';
  end if;
  execute immediate 'create user restaurante identified by admin';  
end;
/

-- Asignar Privilegios
grant connect,resource to restaurante;

-- Desconectar el usuario sysdba

disconnect 

-- Conexion con la base de datos
connect restaurante/admin

-- ====================================
-- Crear la Tabla de Usuarios:usuario
-- ====================================
create table usuario(
usuario varchar2(30) not null,
contrasenia varchar2(20) not null,
tipo char not null,
constraint pk_usuario
primary key(usuario)
);

-- =====================================
-- Crear la Tabla de Productos:producto
-- =====================================
create table producto(
codproducto char(4) not null,
nombreproducto varchar2(100) not null,
descrproducto varchar2(400)not null,
categoria varchar2(30) not null, 
imagen varchar2(200) not null,
preciounitario number(5,2) not null,
stock number(3,0) not null,
usuario varchar2(30) not null,
constraint pk_producto
	primary key (codproducto),
constraint fk_usuario_producto
	foreign key (usuario)
	references usuario,
constraint u_descr_producto
	unique(descrproducto),
constraint chk_producto_codproducto
	check( REGEXP_LIKE(codproducto,'[PE][INS][0-9][0-9]')),
constraint chk_producto_preciounitario
  check(preciounitario>0),
constraint chk_producto_stock
	check(stock>=0)		
);

-- ===================================
-- Crear la Tabla de Clientes:cliente
-- ===================================
create table cliente(
dni char(8) not null,
nomcliente varchar2(100) not null,
direccioncliente varchar2(100) not null,
email varchar2(100) not null,
fechanac date not null,
telefono char(7) not null,
usuario varchar2(30) not null,
constraint pk_cliente
	primary key(dni),
constraint fk_usuario_cliente
	foreign key (usuario)
	references usuario,
constraint u_nomcliente
	unique(nomcliente)
);


-- ===================================
-- Crear la Tabla de Pedidos:pedido
-- ===================================
create table pedido(
nropedido char(7) not null,
dni char(8) not null,
fecha date not null,
subtotalpedido number(5,2) not null,
igv    number(5,2) not null,
totalpedido  number(5,2) not null,
estado char(1) not null,
usuario varchar2(30) not null,
constraint pk_pedido
	primary key(nropedido),
constraint fk_dni
	foreign key(dni)
	references cliente,
constraint fk_usuario_pedido
	foreign key (usuario)
	references usuario,
constraint chk_subtotal
	check(subtotalpedido>=0.0),
constraint chk_igv
	check(igv>=0.0),	
constraint chk_totalpedido
	check(totalpedido>=0.0)	
);


-- ====================================================
-- Crear la Tabla de Detalle de Pedido:detallepedido
-- ====================================================

create table detallepedido(
nropedido	char(7) not null,
codproducto char(4) not null,
preciounitario number(5,2) not null,
cant int not null,
preciototal number(5,2) not null,
usuario varchar2(30) not null,
constraint fk_nropedido
	foreign key (nropedido)
	references pedido,
constraint fk_codproducto
	foreign key (codproducto)
	references producto,
constraint fk_usuario_detalle
	foreign key (usuario)
	references usuario,
constraint chk_detpedido_preuni
	check(preciounitario>0),
constraint chk_detpedido_cant
	check(cant>=0),
constraint chk_detpedido_pretot
	check(preciounitario>0)
);


-- ====================================
-- Crear la Tabla de Control:control
-- ====================================
create table control(
  parametro varchar2(20) not null,
  valor varchar2(6) not null
);

-- ====================================
-- Crear la tabla de Auditoria
-- ====================================
create table auditoria(
 codseguimiento number not null,
 cambio varchar2(500) not null,
 valor_inicio varchar2(50) ,
 valor_modif varchar2(50) ,
 fecha date,
 usuario varchar2(30)not null,
 constraint pk_auditoria
 primary key(codseguimiento),
 constraint fk_usuario
 foreign key(usuario)
 references usuario
);

-- ========================================
-- Crear la tabla de Mensaje
-- ========================================
create table mensaje(
	codmensaje char(6) not null,
	mensaje varchar2(100) not null,
	constraint pk_mensaje 
		primary key(codmensaje)
  );

--===================================================
--Crear tabla Tipo_Pago
--===================================================
create table tipo_pago(
codtipo_pago char(1) not null,
descrtipo_pago varchar2(50) not null,
constraint pk_tipo_pago
  primary key(codtipo_pago),
constraint u_descrtipo_pago
  unique(descrtipo_pago)
);


--===================================================
--Crear la Tabla Pagos
--===================================================
create table pagos(
nropedido char(7) not null,
codtipo_pago char(1) not null,
totalpedido  number(5,2) not null,
efectivo number(5,2),
cambio number(5,2),
estado char(1) not null,
usuario varchar2(30) not null,
constraint pk_pagos
  primary key(nropedido),
constraint fk_nropedidos
  foreign key(nropedido)
  references pedido,
constraint fk_codtipo_pago
  foreign key(codtipo_pago)
  references tipo_pago,
constraint fk_usuario_pagos
	foreign key (usuario)
	references usuario,
constraint chk_totalpedidos  
 check(totalpedido > 0)
 );

SET TERMOUT ON
SET ECHO OFF
SET SERVEROUTPUT ON
BEGIN
	DBMS_OUTPUT.PUT_LINE('Fin de la Creacion de Esquema...');
END;
/
SET TERMOUT OFF
-----------------------------------------------------------------
SET TERMOUT ON
SET ECHO OFF
SET SERVEROUTPUT ON
BEGIN
	DBMS_OUTPUT.PUT_LINE('Inicio de Carga de Datos...');
END;
/
SET TERMOUT OFF

-- ==========================================================
-- Cargar datos a la tabla: producto
-- ==========================================================
-- Pizza
insert into producto(codproducto,nombreproducto,descrproducto,categoria,imagen,preciounitario,stock,usuario) values ('PI01','Pizza Mediterranea Personal','Peperoni, tomate, champiñones, cebolla y aceitunas negras.','normal','images/clas_1.jpg',16.00,60,'admin');
insert into producto(codproducto,nombreproducto,descrproducto,categoria,imagen,preciounitario,stock,usuario) values ('PI02','Pizza Mediterranea Grande','Peperoni, tomate, champiñones, cebolla y aceitunas negras.','normal','images/clas_1.jpg',27.00,60,'admin');
insert into producto(codproducto,nombreproducto,descrproducto,categoria,imagen,preciounitario,stock,usuario) values ('PI03','Pizza Mediterranea Familiar','Peperoni, tomate, champiñones, cebolla y aceitunas negras.','normal','images/clas_1.jpg',34.50,60,'admin');
insert into producto(codproducto,nombreproducto,descrproducto,categoria,imagen,preciounitario,stock,usuario) values ('PI04','Pizza Hawaiana Personal','El paraiso de la mesa" Se completa con jamon, piña y queso mozzarella.','normal','images/clas_2.jpg',21.70,60,'admin');
insert into producto(codproducto,nombreproducto,descrproducto,categoria,imagen,preciounitario,stock,usuario) values ('PI05','Pizza Hawaiana Grande','El paraiso de la mesa" Se completa con jamon, piña y queso mozzarella.','normal','images/clas_2.jpg',36.60,60,'admin');
insert into producto(codproducto,nombreproducto,descrproducto,categoria,imagen,preciounitario,stock,usuario) values ('PI06','Pizza Hawaiana Familiar','El paraiso de la mesa" Se completa con jamon, piña y queso mozzarella.','normal','images/clas_2.jpg',44.10,60,'admin');
insert into producto(codproducto,nombreproducto,descrproducto,categoria,imagen,preciounitario,stock,usuario) values ('PI07','Pizza Americana Personal','La preferida de los chicos, jamon y queso mozzarella','normal','images/clas_3.jpg',21.00,60,'admin');
insert into producto(codproducto,nombreproducto,descrproducto,categoria,imagen,preciounitario,stock,usuario) values ('PI08','Pizza Americana Grande','La preferida de los chicos, jamon y queso mozzarella','normal','images/clas_3.jpg',34.50,60,'admin');
insert into producto(codproducto,nombreproducto,descrproducto,categoria,imagen,preciounitario,stock,usuario) values ('PI09','Pizza Americana Familiar','La preferida de los chicos, jamon y queso mozzarella','normal','images/clas_3.jpg',43.80,60,'admin');
insert into producto(codproducto,nombreproducto,descrproducto,categoria,imagen,preciounitario,stock,usuario) values ('PI10','Pizza Pepperoni Personal','Sabor incomparable de pepperoni<br> americano y queso mozzarella.','clasico','images/clas_4.jpg',21.50,60,'admin');
insert into producto(codproducto,nombreproducto,descrproducto,categoria,imagen,preciounitario,stock,usuario) values ('PI11','Pizza Pepperoni Grande','Sabor incomparable de pepperoni<br> americano y queso mozzarella.','clasico','images/clas_4.jpg',37.60,60,'admin');
insert into producto(codproducto,nombreproducto,descrproducto,categoria,imagen,preciounitario,stock,usuario) values ('PI12','Pizza Pepperoni Familiar','Sabor incomparable de pepperoni<br> americano y queso mozzarella.','clasico','images/clas_4.jpg',45.00,60,'admin');
insert into producto(codproducto,nombreproducto,descrproducto,categoria,imagen,preciounitario,stock,usuario) values ('PI13','Pizza Napolitana Personal','Una clasica combinacion de tomate,<br> salsa de oregano y queso mozzarella.','clasico','images/clas_5.jpg',22.00,60,'admin');
insert into producto(codproducto,nombreproducto,descrproducto,categoria,imagen,preciounitario,stock,usuario) values ('PI14','Pizza Napolitana Grande','Una clasica combinacion de tomate,<br> salsa de oregano y queso mozzarella.','clasico','images/clas_5.jpg',37.90,60,'admin');
insert into producto(codproducto,nombreproducto,descrproducto,categoria,imagen,preciounitario,stock,usuario) values ('PI15','Pizza Napolitana Familiar','Una clasica combinacion de tomate,<br> salsa de oregano y queso mozzarella.','clasico','images/clas_5.jpg',47.10,60,'admin');
insert into producto(codproducto,nombreproducto,descrproducto,categoria,imagen,preciounitario,stock,usuario) values ('PI16','Pizza Enrrollado de pollo Personal','Combinacion de carne molida,<br> rodajas de jalapeño, pimiento y cebolla.','clasico','images/clas_6.jpg',22.00,60,'admin');
insert into producto(codproducto,nombreproducto,descrproducto,categoria,imagen,preciounitario,stock,usuario) values ('PI17','Pizza Enrrollado de pollo Grande','Combinacion de carne molida,<br> rodajas de jalapeño, pimiento y cebolla.','clasico','images/clas_6.jpg',37.90,60,'admin');
insert into producto(codproducto,nombreproducto,descrproducto,categoria,imagen,preciounitario,stock,usuario) values ('PI18','Pizza Enrrollado de pollo Familiar','Combinacion de carne molida,<br> rodajas de jalapeño, pimiento y cebolla.','clasico','images/clas_6.jpg',47.30,60,'admin');
commit;

-- Entrada

insert into producto(codproducto,nombreproducto,descrproducto,categoria,imagen,preciounitario,stock,usuario) values ('EN01','Trio','Disfrute de las alas de pollo al horno, trozos de papa y 4 piezas de pollo con un nuevo manjar de salsa barbacoa..','normal','images/ent_1.png',10.50,60,'admin');
insert into producto(codproducto,nombreproducto,descrproducto,categoria,imagen,preciounitario,stock,usuario) values ('EN02','Palitos de Queso','Deliciosos palitos de queso mozzarella, acompañda de salsa de tomate..','normal','images/ent_2.png',5.50,60,'admin');
insert into producto(codproducto,nombreproducto,descrproducto,categoria,imagen,preciounitario,stock,usuario) values ('EN03','Pan al Ajo','El favorito de todos, nuestro crujiente pan al ajo bañado con queso mozzarella..','normal','images/ent_3.png',10.50,60,'admin');
insert into producto(codproducto,nombreproducto,descrproducto,categoria,imagen,preciounitario,stock,usuario) values ('EN04','Palitos a la Toscana','Exquisito palitos rellenos de queso mozzarella, jamon y tocino','clasico','images/ent_4.jpg',10.50,60,'admin');
insert into producto(codproducto,nombreproducto,descrproducto,categoria,imagen,preciounitario,stock,usuario) values ('EN05','Alitas de pollo','Alitas de pollo marinado y horneado con nuestra exclusiva receta de salsa picante.','clasico','images/ent_5.png',10.50,60,'admin');
insert into producto(codproducto,nombreproducto,descrproducto,categoria,imagen,preciounitario,stock,usuario) values ('EN06','Enrrollado de pollo','Deliciosa masa recubierta con queso parmesano lleno de pollo y su salsa de barbacoa, horneados a la perfección.','clasico','images/ent_6.jpg',10.50,60,'admin');
commit;

-- ====================================
-- Cargar datos a la tabla usuario
-- ====================================
insert into usuario(usuario,contrasenia,tipo) values ('admin','superusuario','S');
commit;

-- ====================================
-- Cargar datos a la tabla mensaje
-- ====================================
insert into mensaje(codmensaje,mensaje) values ('MEN001','El Usuario no Existe');
insert into mensaje(codmensaje,mensaje) values ('MEN002','La Contraseña es Incorrecta');
insert into mensaje(codmensaje,mensaje) values ('MEN003','Existen Campos Vacios');
insert into mensaje(codmensaje,mensaje) values ('MEN004','Email Erroneo o Inexistente');
commit;

-- ====================================
-- Cargar datos a la tabla control
-- ====================================
 insert into control(parametro,valor) values ('pedido','PED001');
 insert into control(parametro,valor) values ('pagos','PAG001');
commit;

SET TERMOUT ON
SET ECHO OFF
SET SERVEROUTPUT ON
BEGIN
	DBMS_OUTPUT.PUT_LINE('Fin de Carga de Datos...');
END;
/
SET TERMOUT OFF
------------------------------------------------------------------
SET TERMOUT ON
SET ECHO OFF
SET SERVEROUTPUT ON
BEGIN
	DBMS_OUTPUT.PUT_LINE('Inicio de Carga de Funciones...');
END;
/
SET TERMOUT OFF


-- =================================
--   Funciones
-- =================================

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

create or replace function fn_isduplicadoproducto(
  p_nropedido PEDIDO.NROPEDIDO%TYPE,
  p_codproducto varchar2
)
return number
is
v_cant number;
msg_error varchar2(500);
begin
  select count(*) into v_cant from detallepedido where codproducto = p_codproducto and nropedido = p_nropedido;
  if v_cant > 0 then
    return 1;
  else
    return 0;
  end if;
exception
when others then
  msg_error := SQLERRM;
  RAISE_APPLICATION_ERROR(-20003, msg_error);
end;
/

SET TERMOUT ON
SET ECHO OFF
SET SERVEROUTPUT ON
BEGIN
	DBMS_OUTPUT.PUT_LINE('Fin de Carga de Funciones...');
END;
/
SET TERMOUT OFF
-------------------------------------------------------
SET TERMOUT ON
SET ECHO OFF
SET SERVEROUTPUT ON
BEGIN
	DBMS_OUTPUT.PUT_LINE('Inicio de Procesos Almacenados...');
END;
/
SET TERMOUT OFF

-- ===================
--  Stored Procedures
-- ===================
create or replace procedure sp_insertadetallepedido(
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
v_cant number;
begin
  v_preciouni := fn_obtenerpreunitproducto(p_codproducto);
  v_preciototal := v_preciouni * p_cant;
  if fn_isduplicadoproducto(p_nropedido,p_codproducto) = 1 then
    v_cant := fn_obtenercantdetallepedido(p_nropedido,p_codproducto);
    v_cant := v_cant + p_cant;
    update detallepedido set cant = v_cant where nropedido = p_nropedido and codproducto = p_codproducto;
  else
    insert into detallepedido values (p_nropedido,p_codproducto,v_preciouni,p_cant,v_preciototal,p_usuario);
  end if;
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

create or replace PROCEDURE sp_insertacliente(
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

CREATE OR REPLACE PROCEDURE sp_eliminarpedido(
	p_nropedido PEDIDO.NROPEDIDO%TYPE,
	p_usuario varchar2
)
as
msg_error varchar2(500);
begin
	delete from detallepedido where nropedido = p_nropedido;
	delete from pedido where nropedido = p_nropedido;
	commit;
exception
when others then
  msg_error:=SQLERRM;
  RAISE_APPLICATION_ERROR(-20003, msg_error);
  rollback;
end;
/

CREATE OR REPLACE PROCEDURE sp_insertapedidos(
  p_dni varchar2,
  p_usuario varchar2
)
as
  v_nro varchar2(10);
  v_inicio varchar2(7);
  v_temporal varchar2(10);
  n number;
  msg_error varchar2(100);
begin
  v_nro := fn_obtenervalorcontrol('pedido');
  insert into pedido values (v_nro,P_dni,sysdate,0,0,0,'E',p_usuario);
  v_inicio:=substr(v_nro,4,3);
  n:=to_number(v_inicio);
  n:=n+1;
  v_temporal:='PED'||to_char(n,'FM009');
  
  update control
  set valor=v_temporal
  where parametro='pedido';
   
commit;
exception
when others then
  msg_error:=SQLERRM;
  RAISE_APPLICATION_ERROR(-20003, msg_error);
rollback;
end;
/

SET TERMOUT ON
SET ECHO OFF
SET SERVEROUTPUT ON
BEGIN
	DBMS_OUTPUT.PUT_LINE('Fin de Carga de Procesos Almacenados...');
END;
/
SET TERMOUT OFF
------------------------------------------------------------------
SET TERMOUT ON
SET ECHO OFF
SET SERVEROUTPUT ON
BEGIN
	DBMS_OUTPUT.PUT_LINE('Inicio de Carga de Disparadores...');
END;
/
SET TERMOUT OFF

-- ==================
-- Disparadores
-- ==================
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

SET TERMOUT ON
SET ECHO OFF
SET SERVEROUTPUT ON
BEGIN
	DBMS_OUTPUT.PUT_LINE('Fin de Carga de Disparadores...');
END;
/
SET TERMOUT OFF

------------------------------------------------------------------

SET TERMOUT ON
SET ECHO OFF
SET SERVEROUTPUT ON
BEGIN
	DBMS_OUTPUT.PUT_LINE('Inicio de Carga de Bloques Utiles...');
END;
/
SET TERMOUT OFF

-- ================
-- Bloques Utiles
-- ================

-- -----------
-- SECUENCIA
-- -----------
CREATE SEQUENCE AUDIT_SEQUENCE
START WITH 1
INCREMENT BY 1;

-- ----------
-- TRIGGER
-- ----------
create or replace 
trigger TR_SEQ_AUDITORIA 
BEFORE INSERT
ON AUDITORIA
REFERENCING NEW AS NEW
FOR EACH ROW
BEGIN
SELECT AUDIT_SEQUENCE.nextval INTO :NEW.CODSEGUIMIENTO FROM dual;
END;
/

SET TERMOUT ON
SET ECHO OFF
SET SERVEROUTPUT ON
BEGIN
	DBMS_OUTPUT.PUT_LINE('Fin de Carga de Bloques Utiles...');
END;
/
SET TERMOUT OFF