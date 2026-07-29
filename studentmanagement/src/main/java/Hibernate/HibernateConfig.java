package Hibernate;

import java.io.InputStream;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Model.Student;

public class HibernateConfig {

	private  static SessionFactory sf;
	static {
		
		try {
			Properties props = new Properties();
			
			InputStream is = HibernateConfig.class.getClassLoader().getResourceAsStream("application.properties");
			props.load(is);
			
			Configuration config = new Configuration();
			config.setProperties(props);
			config.addAnnotatedClass(Student.class);
			
			 sf = config.buildSessionFactory();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public  static SessionFactory getSessionFactory() {
		return sf;
	}
}
