package model;

import dao.impl.ControlDaoImpl;
import dao.spec.ControlDao;

public class ControlModel {
	public String getValor(String parametro){
		ControlDao dao = new ControlDaoImpl();
		return dao.getValor(parametro);
	}
}
