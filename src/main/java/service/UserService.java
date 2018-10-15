package service;

import dao.UserDAO;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserService {

    private static final String USER_ATTRIBUTE = "user";

    private final UserDAO udao;

    @Autowired
    public UserService(UserDAO udao){
        this.udao=udao;
    }

    public User getUserFromSession (HttpSession session){
        return (User) session.getAttribute(USER_ATTRIBUTE);
    }
    public void removeUserFromSession(HttpSession session){
        session.removeAttribute(USER_ATTRIBUTE);
    }
    public void userExit (HttpSession session,String exit){
        if (exit!=null){
            removeUserFromSession(session);
        }
    }
    public User getByLogin (String login){
        return udao.getByLogin(login);
    }
    public void updateUser(User user,String pass,String name, String phone, String email){
        user.setPassword(pass);
        user.setName(name);
        user.setPhone(phone);
        user.setEmail(email);
        udao.updateUser(user);
    }
}
