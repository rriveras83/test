package mx.com.jrrs.test.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import mx.com.jrrs.test.util.CustomHibernateDaoSupport;

@Repository("estructuraDao")
public class EstructuraDAOImpl extends CustomHibernateDaoSupport implements EstructuraDAO{

	/**
	 * Este metodo esta realizado de esta manera para demostrar como trabajar con los metadatos de la base de datos
	 */
	@Override
	public List<String> findTables() {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		List<String> list = (List<String>)session.createSQLQuery("SELECT table_name FROM information_schema.tables WHERE table_schema = 'public' and table_catalog = 'sample'").list();
		return list;
	}

	@Override
	public <T> List<T> buscarRegistros(final Class<T> tabla) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Criteria crit = session.createCriteria(tabla);
		return crit.list();
	}

	/**
	 * Metodo que usa como busqueda el criterio eq para buscar registros con una fecha
	 * en especifico
	 */
	@Override
	public <T> List<T> buscarRegistrosPorFecha(Class<T> tabla, Date date) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Criteria crit = session.createCriteria(tabla);
		crit.add(Restrictions.eq("updateDate", date));
		return crit.list();
	}

	/**
	 * Metodo que usa como busqueda el criterio between para buscar registros entre
	 * un rango de fechas en especifico
	 */
	@Override
	public <T> List<T> buscarRegistrosPorFechas(Class<T> tabla, Date fechaInicial, Date fechaFinal) {
		Session session = getHibernateTemplate().getSessionFactory().openSession();
		Criteria crit = session.createCriteria(tabla);
		crit.add(Restrictions.between("updateDate", fechaInicial, fechaFinal));
		return crit.list();
	}

	
}
