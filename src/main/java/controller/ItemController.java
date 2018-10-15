package controller;

import dao.ItemDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ItemController {
    private static final String ITEM="item";

 private static ItemDAO IDAO;
    @Autowired
    public ItemController (ItemDAO IDAO){
        this.IDAO=IDAO;
    }

    @RequestMapping("/item")
    public static ModelAndView viev (@RequestParam String id){
        ModelAndView model = new ModelAndView(ITEM);
        model.addObject(ITEM, IDAO.getById(id));
        return model;
    }
}
