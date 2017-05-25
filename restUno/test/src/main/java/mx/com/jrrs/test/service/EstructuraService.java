package mx.com.jrrs.test.service;

import java.util.Date;

import mx.com.jrrs.test.dto.EstructuraDTO;

public interface EstructuraService {
	EstructuraDTO obtenerEstructura(String instruccion, Date fechaInicio, Date fechaFin);
}
