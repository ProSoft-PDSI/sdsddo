CREATE OR REPLACE PROCEDURE sp_agregarpago
(
p_nropedido in varchar2,
p_codtipo_pago in pagos.codtipo_pago%type,
p_totalpedido in number,
p_efectivo in number,
p_cambio in number,
p_estado pagos.estado%type,
p_usuario in pagos.usuario%type
)
AS
v_cont number;
v_msg varchar2(100);
BEGIN
--Verifica pago
select count(*) into v_cont
from pagos
where nropedido=p_nropedido;
if v_cont > 0 then
	raise_application_error(-20000, 'Pago ya existe');
end if;

insert into pagos(nropedido, codtipo_pago, totalpedido,
	efectivo, cambio, estado,usuario)
values(p_nropedido,p_codtipo_pago, p_totalpedido,
	p_efectivo, p_cambio, p_estado,p_usuario);

commit;
exception
	when others then
		v_msg:=sqlerrm;
		rollback;
		raise_application_error(-20000, v_msg);
END;
/