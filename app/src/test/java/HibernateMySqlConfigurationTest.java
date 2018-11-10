import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import persistance.cofiguration.HibernateMySqlConfiguration;

public class HibernateMySqlConfigurationTest {
    @Test
    void Save() {
        HibernateMySqlConfiguration configuration = new HibernateMySqlConfiguration();
        configuration.configure();
        configuration.addClass(User.class);
        configuration.buildSessionFactory();
        User user = new User();
        user.setName("ndjaka");
        user.setSurname("Eugene");
        SessionFactory sessionFactory = configuration.sessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
        System.out.println("New user id: " + user.getId());
    }
}
