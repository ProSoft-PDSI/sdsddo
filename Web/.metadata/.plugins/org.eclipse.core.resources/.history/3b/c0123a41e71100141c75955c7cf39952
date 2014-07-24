function ver_tipo_pago(){
	var cboTipo=document.querySelector("#tipo_pago");
	alert(cboTipo.options[cboTipo.selectedIndex].value);
}

function hacerClic(){
	var elemento=document.querySelector("#btn_Grabar");
	elemento.addEventListener("click", calculaCambio, false);
}
function habilitaCtls(){
	var cboTipo=document.querySelector("#tipo_pago");
	var inpEfectivo=document.querySelector("#imp_efec");
	var imp_camb=document.querySelector("#td_imp_camb");
	
	//Actualiza hid_tipo_pago
	var tipo=document.querySelector("#hid_tipo_pago");
	//var usuario=document.querySelector("#hid_usuario");
    tipo.value=cboTipo.options[cboTipo.selectedIndex].value;
    
    //alert(usuario.value);
	
	if (cboTipo.options[cboTipo.selectedIndex].value=='E') {
		inpEfectivo.removeAttribute("disabled");
		//inpEfectivo.value=0.0;
		//imp_camb.removeAttribute("disabled");
	}else{
		inpEfectivo.setAttribute("disabled", "disabled");
		imp_camb.innerHTML="";
		inpEfectivo.value="";
	}
}//fin habilitaCtls

function eve_Ctipo_p(){
	var cboTipo=document.querySelector("#tipo_pago");
	cboTipo.addEventListener("change", habilitaCtls, false);
}
function init(){
	//hacerClic();
	eve_Ctipo_p();
	eve_UPMon();
	eve_CPro();
}

function seleccion(objInput){
	var valor_input = objInput.value; 
    var longitud = valor_input.length; 

    if (objInput.setSelectionRange) { 
    	objInput.focus(); 
    	objInput.setSelectionRange (0, longitud); 
    } 
    else if (objInput.createTextRange) { 
        var range = objInput.createTextRange() ; 
        range.collapse(true); 
        range.moveEnd('character', longitud); 
        range.moveStart('character', 0); 
        range.select(); 
    } 
}

function calculaCambio(){
        var td_total_pedido=document.querySelector("#td_total_pedido").innerHTML;
        var imp_efec=document.querySelector("#imp_efec");
        var val_imp_efec=imp_efec.value;
        var hid_cambio=document.querySelector("#hid_cambio");
        //alert(val_imp_efec);
        //val_imp_efec=(parseInt(val_imp_efec)).toFixed(2);
        //imp_efec.value=val_imp_efec.toFixed(2);
        //alert(val_imp_efec);
        //document.querySelector("#td_imp_camb").innerHTML=(td_total_pedido-val_imp_efec).toFixed(2);
        document.querySelector("#td_imp_camb").innerHTML=(td_total_pedido-val_imp_efec);
        hid_cambio.value=(td_total_pedido-val_imp_efec);
        //alert(hid_cambio.value);
	
}
function eve_UPMon(){
	var imp_efec=document.querySelector("#imp_efec");
	imp_efec.addEventListener("keyup",checkKey, false);
}

function checkKey(key){
	var imp_efec=document.querySelector("#imp_efec");
	var val_imp_efec=imp_efec.value;
	
	if(isNaN(val_imp_efec)){
		//alert('no valido'+val_imp_efec);
		alert('Ingrese un monto valido');
		seleccion(imp_efec);
	}else{
		//alert('valido'+val_imp_efec);
		calculaCambio();
		}
}
function eve_CPro(){
	var btn_Procesar=document.querySelector("#btn_Procesar");
	btn_Procesar.addEventListener("click", fnProcesar, false);
}
function fnProcesar(){
	var data=$("#formulario").serialize();
	$.post("Pago",data,function(rpta){
		alert(rpta);
	});
}

window.onload=init;