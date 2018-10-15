package dao;

import entity.User;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.sql.Statement;
import java.util.List;

@Service
public class UserDAO {
    public User getByLogin (String login){
        Session s = HibernateUtil.getSession();
        List<User> users= s.createCriteria(User.class).list();
        s.close();
        for(User user:users){
            if(user.getLogin().equals(login)){
                return user;
            }
        }
        return null;
    }
    public void addNewUser(@NotNull User user){
        Session s = HibernateUtil.getSession();
        s.beginTransaction();
        s.save(user);
        s.getTransaction().commit();
        s.close();
        System.out.println("added");
//        return true;
    }
    public void updateUser(User user){
        Session s = HibernateUtil.getSession();
        s.beginTransaction();
        s.update(user);
        s.getTransaction().commit();
        s.close();
    }
}
