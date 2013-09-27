package com.mkyong.util;
 
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.type.StandardBasicTypes;
 
public class HibernateUtil {
 
	private static final SessionFactory sessionFactory = buildSessionFactory();
 
	private static SessionFactory buildSessionFactory() {
		try {
			// Create the SessionFactory from hibernate.cfg.xml
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
 
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
 
	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}

	public static Integer getNextStockSequenceNumber(Session session){
	    Query query = 
	        session.createSQLQuery("select STOCK_SEQ.nextval as num from dual")
	        .addScalar("num", StandardBasicTypes.INTEGER);

	    return ((Integer) query.uniqueResult()).intValue();
	}
	
	public static Integer getNextCategorySequenceNumber(Session session){
	    Query query = 
	        session.createSQLQuery("select CATEGORY_SEQ.nextval as num from dual")
	        .addScalar("num", StandardBasicTypes.INTEGER);

	    return ((Integer) query.uniqueResult()).intValue();
	}
}