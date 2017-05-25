package mx.com.jrrs.test.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class TablaDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5904322308094063204L;
	
	private String nombreTabla;
	private List<Map<String, Object>> registros;

	public String getNombreTabla() {
		return nombreTabla;
	}

	public void setNombreTabla(String nombreTabla) {
		this.nombreTabla = nombreTabla;
	}

	public List<Map<String, Object>> getRegistros() {
		return registros;
	}

	public void setRegistros(List<Map<String, Object>> registros) {
		this.registros = registros;
	}

	public TablaDTO(String nombreTabla, List<Map<String, Object>> registros) {
		super();
		this.nombreTabla = nombreTabla;
		this.registros = registros;
	}

	public TablaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
