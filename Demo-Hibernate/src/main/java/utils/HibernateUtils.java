package utils;

import entity.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.imageio.spi.ServiceRegistry;

public class HibernateUtils {
    public static HibernateUtils getInstance() {
    }

    private void configure() {
        configuration = new Configuration();
        configuration.configure("hibbernate.cfg.xml");
        configuration.addAnnotatedClass(Department.class);
    }

}
    private SessionFactory buildSessionFactory(){
        if(null == sessionFactory || sessionFactory.isclose()) {
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();
            sessionFactiory = configuration.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
        }
        public void closeFactory(){
    if(null != sessionFactory && sessionFactory.isOpen()){
        sessionFactory.close();
    }
        }

