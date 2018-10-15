package controller;

import com.google.gson.Gson;
import dao.ItemDAO;
import dao.UserDAO;
import entity.Basket;
import entity.Item;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Controller
public class BasketController {
    private static final String BASKET="basket";
private static ItemDAO idao;
private static UserService userv;
private static UserDAO udao;
    @Autowired
public BasketController (ItemDAO idao, UserService userv,UserDAO udao){
    this.idao=idao;
    this.udao=udao;
    this.userv=userv;}

    @RequestMapping("/basket")
    public static ModelAndView viev (HttpServletResponse response, HttpServletRequest request) throws IOException {
        ModelAndView model= new ModelAndView(BASKET);
        User u =  userv.getUserFromSession(request.getSession());
        if(u==null){response.sendRedirect("/");}
        String id = request.getParameter("id");
        Gson gson = new Gson();
        Basket basket = gson.fromJson(u.getBasket(),Basket.class);
        if(id!=null){
            if(id.equals("0")) {
                basket.items.clear();
            }else
                if(id.startsWith("-")){ 
                basket.items.remove(id.substring(1));
                }else{
                basket.items.add(id);
                }
        u.setBasket(gson.toJson(basket));
            udao.updateUser(u);
        response.sendRedirect("/basket");}else{
 List<Item> items = new LinkedList<>();
 for(String idString:basket.items){
      items.add(idao.getById(idString));

 } model.addObject("items",items);
        }
        return model;
    }
}
