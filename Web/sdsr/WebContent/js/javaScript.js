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
	var hid_imp_efec=document.querySelector("#hid_imp_efec");
	
	//Actualiza hid_tipo_pago
	var tipo=document.querySelector("#hid_tipo_pago");
	var hid_cambio=document.querySelector("#hid_cambio");
	//var usuario=document.querySelector("#hid_usuario");
    tipo.value=cboTipo.options[cboTipo.selectedIndex].value;
    
    //alert(usuario.value);
	
	if (cboTipo.options[cboTipo.selectedIndex].value=='E') {
		inpEfectivo.removeAttribute("disabled");
		//inpEfectivo.value=0.0;
		//imp_camb.removeAttribute("disabled");
	}else{
		inpEfectivo.setAttribute("disabled", "disabled");
		imp_camb.innerHTML=0.0;
		inpEfectivo.value=0.0;
		hid_imp_efec.value=0.0;
		hab_btn(false);
	
		hid_cambio.value=0.0;
		
	}
}//fin habilitaCtls

function eve_Ctipo_p(){
	var cboTipo=document.querySelector("#tipo_pago");
	cboTipo.addEventListener("change", habilitaCtls, false);
}
function init(){
	//hacerClic();
	//var hid_cambio=document.querySelector("#hid_cambio");
	var hid_tipo_pago=document.querySelector("#hid_tipo_pago");
	var inpEfectivo=document.querySelector("#imp_efec");
	var cboTipo=document.querySelector("#tipo_pago");
	//hid_cambio.value="0.0";
	//inpEfectivo.value="0.0";
	
	hid_tipo_pago.value=cboTipo.options[cboTipo.selectedIndex].value;
	//alert(hid_tipo_pago.value);
	focusNodo(inpEfectivo);
	hab_btn(true);
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
        var hid_imp_efec=document.querySelector("#hid_imp_efec");
        var val_imp_efec=imp_efec.value;
        var hid_cambio=document.querySelector("#hid_cambio");
        hid_imp_efec.value=imp_efec.value;
        //alert(val_imp_efec);
        //val_imp_efec=(parseInt(val_imp_efec)).toFixed(2);
        //imp_efec.value=val_imp_efec.toFixed(2);
        //alert(val_imp_efec);
        //document.querySelector("#td_imp_camb").innerHTML=(td_total_pedido-val_imp_efec).toFixed(2);
        document.querySelector("#td_imp_camb").innerHTML=(val_imp_efec-td_total_pedido).toFixed(2);
        hid_cambio.value=(val_imp_efec-td_total_pedido).toFixed(2);
        
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
		hab_btn(true);
		alert('Ingrese un monto valido');
		seleccion(imp_efec);
	}else{
		//alert('valido'+val_imp_efec);
			hab_btn(false);
			calculaCambio();
	}
}

function eve_CPro(){
	
	var btn_Procesar=document.querySelector("#btn_Procesar");
	
	btn_Procesar.addEventListener("click", fnProcesar, false);
	
}

function fnProcesar(){
	var cboTipo=document.querySelector("#tipo_pago");
	var data=$("#formulario").serialize();
	var sn=validaCtrls();
	if(sn==true){
		$.post("Pago",data,function(rpta){
			alert(rpta);
		});
	}else{focusNodo(cboTipo);}
	
	
}
function qHayDentro(){
	var imp_efec=document.querySelector("#imp_efec");
	var val_imp_efec=imp_efec.value;
	if(val_imp_efec=="" || (val_imp_efec.length ==0)){
	 alert(val_imp_efec);}
}



function hab_btn(sn){
	var btn_Procesar=document.querySelector("#btn_Procesar");
	if(sn==true){btn_Procesar.setAttribute("disabled", "disabled");}
	if(sn==false){btn_Procesar.removeAttribute("disabled");}
}

function validaCtrls(){
	
	var cboTipo=document.querySelector("#tipo_pago");
	var imp_efec=document.querySelector("#imp_efec").value;
	var td_total_pedido=parseFloat(document.querySelector("#td_total_pedido").innerHTML);
	//alert('hola');
	
	//var val_imp_efec=imp_efec.value();
	
	
	if(cboTipo.options[cboTipo.selectedIndex].value=='E'){
		if(imp_efec=="" || (imp_efec.length ==0)){
			alert('Debe ingresar monto efectivo');
			 return false;
		}else{
			if(imp_efec >= td_total_pedido){
				//hab_btn(false);
				//alert('OK');
				return true;
			}else{
				hab_btn(true);
				alert("Efectivo debe se mayor o igual a total pedido ");
				return false;
			}
			 
		}
	}else{return true;}
	
}// FIN validaCtrls
function focusNodo(objInput){
	objInput.focus();
}

window.onload=init;
