package edu.pragmatic.movies.db.hibernate.config;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Iterator;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.util.ConfigHelper;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.service.ServiceRegistry;


public final class HibernateUtils {
	
	private static SessionFactory sessionFactory;
	private static Configuration conf;
	
	static {
		File configurationXML = getConfigurationXML();
		conf = new Configuration().configure(configurationXML);
		StandardServiceRegistryBuilder serviceRegistryBuilder = 
				new StandardServiceRegistryBuilder().applySettings( conf.getProperties() );
		ServiceRegistry serviceRegistry =  serviceRegistryBuilder.build();
		
		sessionFactory = conf.buildSessionFactory(serviceRegistry);
	}

	private static File getConfigurationXML() {
		URL url = ConfigHelper.findAsResource("db/hibernate.cfg.xml");
		File xmlFile = null;
		try {
			xmlFile = Paths.get(url.toURI()).toFile();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return xmlFile;
	}
	
	public static Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public static Session openSession(){
		return sessionFactory.openSession();
	}
	
	public static void closeCurrentSession(){
		getCurrentSession().close();
	} 
	
	public static PersistentClass getMappings(Class<?> clazz) {
		return conf.getClassMapping(clazz.getCanonicalName());
	}
	
	public static Transaction beginTransaction(){
		return getCurrentSession().beginTransaction();
	} 
	
	public static Iterator<PersistentClass> getMappings(){
		return conf.getClassMappings();
	}
	
	public static SQLQuery createSqlQuery(String sql){
		Session currentSession = getCurrentSession();
		beginTransaction();
		return currentSession.createSQLQuery(sql);
	}
	
	public static Query createHQlQuery(String hql){
		Session currentSession = getCurrentSession();
		beginTransaction();
		return currentSession.createQuery(hql);
	}
	
	public static Query createHQlQuery(String hql, Session currentSession){
		beginTransaction();
		return currentSession.createQuery(hql);
	}
	
	public static Criteria createCriteria(Class<?> claz){
		Session currentSession = getCurrentSession();
		beginTransaction();
		return currentSession.createCriteria(claz);
	}

	public static void evictQueries() {
		sessionFactory.getCache().evictQueryRegions();
	}

}
