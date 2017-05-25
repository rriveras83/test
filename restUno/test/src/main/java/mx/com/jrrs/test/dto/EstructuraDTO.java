package mx.com.jrrs.test.dto;

import java.io.Serializable;
import java.util.List;

public class EstructuraDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9130217019992587461L;
	
	public List<TablaDTO> tablas;

	public List<TablaDTO> getTablas() {
		return tablas;
	}

	public void setTablas(List<TablaDTO> tablas) {
		this.tablas = tablas;
	}

	public EstructuraDTO(List<TablaDTO> tablas) {
		this.tablas = tablas;
	}

	public EstructuraDTO() {
		super();
	}
	
}
