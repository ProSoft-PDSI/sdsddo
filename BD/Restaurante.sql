/**
 *
 * DBMS           :  ORACLE
 * Base de Datos  :  RESTAURANTE
 * Descripcion    :  Base de Datos de Restaurante
 * Script         :  Crea la esquema
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
	DBMS_OUTPUT.PUT_LINE('Inicio del proceso...');
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
-- Crear la Tabla de Usuarios:usuario
-- ====================================
create table usuario(
usuario varchar2(30) not null,
contrasenia varchar2(20) not null,
tipo char not null,
constraint pk_usuario
primary key(usuario)
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
	DBMS_OUTPUT.PUT_LINE('Fin del proceso...');
END;
/
SET TERMOUT OFF

