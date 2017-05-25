package mx.com.jrrs.test.dao;

import java.util.Date;
import java.util.List;

public interface EstructuraDAO {
	List<String> findTables();
	<T> List<T> buscarRegistros(final Class<T> tabla);
	<T> List<T> buscarRegistrosPorFecha(final Class<T> tabla, Date date);
	<T> List<T> buscarRegistrosPorFechas(final Class<T> tabla, Date fechaInicial, Date fechaFinal);
}
