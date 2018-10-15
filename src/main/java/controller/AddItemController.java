package controller;

import com.sun.deploy.net.HttpResponse;
import dao.ItemDAO;
import dao.UserDAO;
import entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Controller
public class AddItemController {
    private static final String ADD="addItem";
    private static UserService userv;
    private final ItemDAO IDAO;
    @Autowired
    public AddItemController (ItemDAO IDAO, UserService userv){
        this.IDAO=IDAO;
        this.userv=userv;
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public static ModelAndView viev(HttpServletResponse response, HttpServletRequest request) throws IOException {

        if(!userv.getUserFromSession(request.getSession()).getAcessLevel().equals("admin")){
            response.sendRedirect("/");
            return null;
        }else{
            return new ModelAndView(ADD);
        }
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void add(@RequestParam(required = false) String name,
                    @RequestParam(required = false) String about,
                    @RequestParam(required = false) int price,
                    @RequestParam(required = false) String pic,
                    @RequestParam(required = false) String category,
                    @RequestParam(required = false) String model, HttpServletResponse response) throws IOException {
     if((name!=null&&name!="")&(about!=null&about!="")&&(price>0)&&(pic!=null&&pic!="")&&(category!=null&category!="")&(model!=null&&model!="")){
         Item item = new Item((UUID.randomUUID().toString().toLowerCase()),name,about,price,pic,UUID.randomUUID().toString().toUpperCase().substring(0,5),category,model);
         IDAO.add(item);
         response.sendRedirect("/");
     }else {response.sendRedirect("/add");    }
}}
