package dao;

import entity.Item;
import hibernate.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ItemDAO {
    public  List<Item> get(){
        Session s = HibernateUtil.getSession();
        Criteria c = s.createCriteria(Item.class);
        List<Item> out = c.list();
        return out;
    }
    public  Item getById (String id){
        Session s = HibernateUtil.getSession();
        Item item = (Item) s.createQuery("FROM Item WHERE id ='"+id+"'").uniqueResult();
                s.close();
        return item;
    }
    public static void add (Item i){
        Session s = HibernateUtil.getSession();
        s.beginTransaction();
        s.save(i);
        s.getTransaction().commit();
        s.close();
    }
    public  void delete (Item i){
        Session s = HibernateUtil.getSession();
        s.beginTransaction();
        s.delete(i);
        s.getTransaction().commit();
        s.close();
    }
    public List<Item> SearchByText(String search){
    List<Item> allItems = get();
        LinkedList items = new LinkedList<>();
    for(Item i: allItems){
        if(i.getName().toLowerCase().contains(search.toLowerCase()) || i.getAbout().contains(search.toLowerCase())){
items.add(i);
        }
    }
return items;
    }
    public  List<Item> SearchByCategory(String category){
        List <Item> allItems = get();
        LinkedList categoryItem = new LinkedList();
        for(Item i: allItems){
        if(i.getCategory().equals(category)) categoryItem.add(i);
        }
            return categoryItem;
    }
}
