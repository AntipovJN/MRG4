package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


public class HibernateUtil {
    private static final SessionFactory ourSessionFactory;

    static {
        try{
            ourSessionFactory   = new AnnotationConfiguration().configure().buildSessionFactory();
        }catch (Throwable ex){
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static Session getSession(){
        return ourSessionFactory.openSession();
    }
}
