package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.AuthService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class AutorisationController {
    private static final String LOGIN="login";
    private static final String REGISTER="register";

    private final AuthService authserv;
    private final UserService userv;


    @Autowired
    public AutorisationController(AuthService authserv, UserService userv){
     this.authserv=authserv;
     this.userv=userv;
        }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public static ModelAndView vievLoginPage(){
        return new ModelAndView(LOGIN);
    }
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public static  ModelAndView vievRegisterPage(){
        return new ModelAndView(REGISTER);
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(@RequestParam String login,
                      @RequestParam String password,
                      HttpServletResponse response, HttpServletRequest req) throws IOException {
        authserv.loginUser(userv.getByLogin(login),password,req.getSession());
        response.sendRedirect("/");
    }
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public void registerNewUser (@RequestParam String login,
                                 @RequestParam String password1,
                                 @RequestParam String password2,
                                 @RequestParam String name,
                                 @RequestParam String phone,
                                 @RequestParam String email, HttpServletResponse response) throws IOException {
        authserv.registerNewUser(login,password1,password2,name,phone,email);
        response.sendRedirect("/");

    }
}
