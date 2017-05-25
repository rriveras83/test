package mx.com.jrrs.test.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import mx.com.jrrs.test.dto.EstructuraDTO;
import mx.com.jrrs.test.service.EstructuraService;

@Controller
@RequestMapping("/baseService")
public class EstructuraServiceController {

	@Autowired
	EstructuraService estructuraService;
	
	@RequestMapping(value="/{instruccion}", method = RequestMethod.GET)
	public @ResponseBody EstructuraDTO mostrarEstructuraBD(@PathVariable("instruccion") String instruccion){
		EstructuraDTO estructuraDto = null;
		estructuraDto = estructuraService.obtenerEstructura(instruccion, null, null);
		return estructuraDto;
	}
	
	@RequestMapping(value="/porFecha/{instruccion}/{fecha}", method = RequestMethod.GET)
	public @ResponseBody EstructuraDTO mostrarEstructuraBDPorFecha(@PathVariable("instruccion") String instruccion, @PathVariable("fecha") String fecha){
		EstructuraDTO estructuraDto = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date date;
		try {
			date = sdf.parse(fecha);
		} catch (ParseException e) {
			return null;
		}
		estructuraDto = estructuraService.obtenerEstructura(instruccion, date , null);
		return estructuraDto;
	}
	
	@RequestMapping(value="/entreFechas/{instruccion}/{fechaInicio}/{fechaFin}", method = RequestMethod.GET)
	public @ResponseBody EstructuraDTO mostrarEstructuraBDPorFecha(@PathVariable("instruccion") String instruccion, @PathVariable("fechaInicio") String fechaInicio, @PathVariable("fechaFin") String fechaFin){
		EstructuraDTO estructuraDto = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date date1, date2;
		try {
			date1 = sdf.parse(fechaInicio);
			date2 = sdf.parse(fechaFin);
		} catch (ParseException e) {
			return null;
		}
		estructuraDto = estructuraService.obtenerEstructura(instruccion, date1, date2);
		return estructuraDto;
	}
}
