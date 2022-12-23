import com.mysql.cj.Session;
import entity.Group;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.imageio.spi.ServiceRegistry;
import javax.security.auth.login.Configuration;

public class TestProgram {
    public static void main(String[] args) {
        Session session = null;
        try{
            session = buildSessionFactory().openSession();
            Group group = new Group();
            group.setName("SQL");
            session.save(group);
            System.out.println("Create success");
        }finally {
            if(session != null){
                session.close();
            }
        }
    }
    private static SessionFactory buildSessionFactory(){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Group.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory(serviceRegistry);
    }
}
