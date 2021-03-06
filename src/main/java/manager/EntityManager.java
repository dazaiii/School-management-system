package manager;
import entity.HibernateFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EntityManager {
    public boolean add(Object object){
        HibernateFactory hibernateFactory = new HibernateFactory();
        Session session = hibernateFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        boolean isAdded = false;
        try {
            session.save(object);
            session.getTransaction().commit();
            isAdded = true;
        } catch(Exception e){
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            hibernateFactory.getSessionFactory().close();
        }
        return isAdded;
    }

    public boolean delete(Object object){
        HibernateFactory hibernateFactory = new HibernateFactory();
        Session session = hibernateFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        boolean isDeleted = false;
        try {
            session.delete(object);
            session.getTransaction().commit();
            isDeleted = true;
        } catch(Exception e){
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            hibernateFactory.getSessionFactory().close();
        }
        return isDeleted;
    }

    public Object update(Object object){
        HibernateFactory hibernateFactory = new HibernateFactory();
        Session session = hibernateFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(object);
            session.getTransaction().commit();
        } catch(Exception e){
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            hibernateFactory.getSessionFactory().close();
        }
        return object;
    }

}
