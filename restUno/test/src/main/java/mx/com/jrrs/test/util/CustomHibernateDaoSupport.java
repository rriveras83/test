package mx.com.jrrs.test.util;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class CustomHibernateDaoSupport extends HibernateDaoSupport{

	@Autowired
	public void anyMetodName(SessionFactory sessionFactory){
		setSessionFactory(sessionFactory);
	}
	
}
