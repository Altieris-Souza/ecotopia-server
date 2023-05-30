import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GetInstance {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("postgres");
    }
}
