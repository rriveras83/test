package mx.com.jrrs.test.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.jrrs.test.dao.EstructuraDAO;
import mx.com.jrrs.test.dto.AlumnoDTO;
import mx.com.jrrs.test.dto.CarreraDTO;
import mx.com.jrrs.test.dto.EstructuraDTO;
import mx.com.jrrs.test.dto.MateriaDTO;
import mx.com.jrrs.test.dto.ProfesorDTO;
import mx.com.jrrs.test.dto.TablaDTO;

@Service("estructuraService")
public class EstructuraServiceImpl implements EstructuraService{

	@Autowired
	EstructuraDAO estructuraDAO;
	
	
	/**
	 * Metodo el cual genera el objecto EstructuraDTO el cual sera presentado como resultado
	 * de la ejecucion del servicio rest
	 */
	@Override
	public EstructuraDTO obtenerEstructura(String instruccion, Date fechaInicio, Date fechaFin) {
		List<String> tablasBD = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		if(instruccion.equals("all")) {
			tablasBD = estructuraDAO.findTables();
		} else if(instruccion.equals("alumnos")){
			tablasBD.add("alumnos");
		} else if(instruccion.equals("profesores")){
			tablasBD.add("profesores");
		} else if(instruccion.equals("carreras")){
			tablasBD.add("carreras");
		} else if(instruccion.equals("materias")){
			tablasBD.add("materias");
		}
			
		TablaDTO tablaDto;
		List<TablaDTO> tablas = new ArrayList<TablaDTO>();
		for(String tabla: tablasBD){
			tablaDto = new TablaDTO();
			tablaDto.setNombreTabla(tabla);
			List<Map<String, Object>> registros = new ArrayList<Map<String,Object>>();
			if(tabla.equals("alumnos")){
				List<AlumnoDTO> datosAlumnos = new ArrayList<AlumnoDTO>();
				if(fechaInicio == null && fechaFin == null){
					datosAlumnos = estructuraDAO.buscarRegistros(AlumnoDTO.class);
				} else if(fechaInicio != null && fechaFin == null){
					datosAlumnos = estructuraDAO.buscarRegistrosPorFecha(AlumnoDTO.class, fechaInicio);
				} else if(fechaInicio != null && fechaFin != null){
					datosAlumnos = estructuraDAO.buscarRegistrosPorFechas(AlumnoDTO.class, fechaInicio, fechaFin);
				}
				Map<String, Object> fila;
				for(AlumnoDTO alumnoDto: datosAlumnos){
					fila = new HashMap<String, Object>();
					fila.put("id", alumnoDto.getId());
					fila.put("nombre", alumnoDto.getNombre());
					fila.put("paterno", alumnoDto.getPaterno());
					fila.put("materno", alumnoDto.getMaterno());
					fila.put("matricula", alumnoDto.getMatricula());
					fila.put("updateDate", sdf.format(alumnoDto.getUpdateDate()));
					registros.add(fila);
				}
			}
			if(tabla.equals("profesores")){		
				List<ProfesorDTO> datosProfesores = new ArrayList<ProfesorDTO>();
				if(fechaInicio == null && fechaFin == null){
					datosProfesores = estructuraDAO.buscarRegistros(ProfesorDTO.class);
				} else if(fechaInicio != null && fechaFin == null){
					datosProfesores = estructuraDAO.buscarRegistrosPorFecha(ProfesorDTO.class, fechaInicio);
				} else if(fechaInicio != null && fechaFin != null){
					datosProfesores = estructuraDAO.buscarRegistrosPorFechas(ProfesorDTO.class, fechaInicio, fechaFin);
				}
				Map<String, Object> fila;
				for(ProfesorDTO profesorDto: datosProfesores){
					fila = new HashMap<String, Object>();
					fila.put("id", profesorDto.getId());
					fila.put("nombre", profesorDto.getNombre());
					fila.put("paterno", profesorDto.getPaterno());
					fila.put("materno", profesorDto.getMaterno());
					fila.put("updateDate", profesorDto.getUpdateDate());
					registros.add(fila);
				}
			}
			if(tabla.equals("carreras")){				
				List<CarreraDTO> datosCarreras = new ArrayList<CarreraDTO>();
				if(fechaInicio == null && fechaFin == null){
					datosCarreras = estructuraDAO.buscarRegistros(CarreraDTO.class);
				} else if(fechaInicio != null && fechaFin == null){
					datosCarreras = estructuraDAO.buscarRegistrosPorFecha(CarreraDTO.class, fechaInicio);
				} else if(fechaInicio != null && fechaFin != null){
					datosCarreras = estructuraDAO.buscarRegistrosPorFechas(CarreraDTO.class, fechaInicio, fechaFin);
				}		
				Map<String, Object> fila;
				for(CarreraDTO carreraDTO: datosCarreras){
					fila = new HashMap<String, Object>();
					fila.put("id", carreraDTO.getId());
					fila.put("nombre", carreraDTO.getNombre());
					fila.put("descripcion", carreraDTO.getDescripcion());
					fila.put("updateDate", carreraDTO.getUpdateDate());
					registros.add(fila);
				}
			}
			if(tabla.equals("materias")){
				List<MateriaDTO> datosMaterias = new ArrayList<MateriaDTO>();
				if(fechaInicio == null && fechaFin == null){
					datosMaterias = estructuraDAO.buscarRegistros(MateriaDTO.class);
				} else if(fechaInicio != null && fechaFin == null){
					datosMaterias = estructuraDAO.buscarRegistrosPorFecha(MateriaDTO.class, fechaInicio);
				} else if(fechaInicio != null && fechaFin != null){
					datosMaterias = estructuraDAO.buscarRegistrosPorFechas(MateriaDTO.class, fechaInicio, fechaFin);
				}		
				Map<String, Object> fila;
				for(MateriaDTO materiaDTO: datosMaterias){
					fila = new HashMap<String, Object>();
					fila.put("id", materiaDTO.getId());
					fila.put("nombre", materiaDTO.getNombre());
					fila.put("descripcion", materiaDTO.getDescripcion());
					fila.put("creditos", materiaDTO.getCreditos());
					fila.put("updateDate", materiaDTO.getUpdateDate());
					registros.add(fila);
				}
			}
			tablaDto.setRegistros(registros);
			tablas.add(tablaDto);
		}
		EstructuraDTO estructuraDto = new EstructuraDTO(tablas);
		return estructuraDto;
	}

}
