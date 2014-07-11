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