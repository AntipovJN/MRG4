package service;

import dao.UserDAO;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@Service
public class AuthService {
    private final UserDAO udao;

    @Autowired
    public AuthService (UserDAO udao){
        this.udao=udao;
    }

    public void loginUser(User user, String password, HttpSession session){
        if(user.getPassword().equals(password)){
            session.setAttribute("user",user);
        }
    }
    public void registerNewUser(String login,String password1,String password2, String name, String phone, String email) {
        if (!login.isEmpty() && udao.getByLogin(login) == null) {
            if (!password1.isEmpty() && password1.equals(password2) && !name.isEmpty() && !phone.isEmpty() && !email.isEmpty()) {
                udao.addNewUser(new User((UUID.randomUUID().toString()), login, password1, name, email, phone, "user", ""));
            }
        }
    }
}
