package budhioct.dev;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestConnctionDB {

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Test
    void testConnection(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        transaction.commit();

        entityManager.close();
        entityManagerFactory.close();
    }

}
