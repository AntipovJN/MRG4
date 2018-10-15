package controller;

        import dao.ItemDAO;
        import dao.UserDAO;
        import entity.Item;
        import entity.User;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestParam;
        import org.springframework.web.servlet.ModelAndView;
        import service.AuthService;
        import service.UserService;
        import sun.plugin.util.UIUtil;

        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpSession;
        import java.util.UUID;

@Controller
public class MainController {
    private static final String INDEX_JSP="index";
    private final ItemDAO idao;
    private final UserService userv;
    private final UserDAO udao;
    @Autowired
    public MainController (ItemDAO idao, UserService userv,UserDAO udao){
        this.idao=idao;
        this.userv=userv;
        this.udao=udao;
    }
    @RequestMapping("/")
    public  ModelAndView main (@RequestParam(required = false) String exit,
                               @RequestParam(required = false) String cat,
                                       @RequestParam(required = false) String search,
                                       HttpServletRequest request){
        userv.userExit(request.getSession(),exit);
        User user = userv.getUserFromSession(request.getSession());
        ModelAndView model = new ModelAndView(INDEX_JSP);
        if(cat!=null){
            model.addObject("items", idao.SearchByCategory(cat));
        }else
            if(search!=null&&search!=""){
            model.addObject("items", idao.SearchByText(search));
            }else{
          model.addObject("items", idao.get());}
          model.addObject("user", user);
        return model;
    }
}
