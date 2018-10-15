package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Table(name ="items_mrg")
@Entity
public class Item {
   @Id
   private String id;
   private String name;
   private String about;
   private int price;
   private String pic;
   private String article;
   private String category;
   private String model;

   public Item() {
    }

    public Item(String id, String name, String about, int price, String pic, String article, String category, String model) {
        this.id = id;
        this.name = name;
        this.about = about;
        this.price = price;
        this.pic = pic;
        this.article = article;
        this.category = category;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", about='" + about + '\'' +
                ", price=" + price +
                ", pic='" + pic + '\'' +
                ", article='" + article + '\'' +
                ", category='" + category + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return price == item.price &&
                Objects.equals(id, item.id) &&
                Objects.equals(name, item.name) &&
                Objects.equals(about, item.about) &&
                Objects.equals(pic, item.pic) &&
                Objects.equals(article, item.article) &&
                Objects.equals(category, item.category) &&
                Objects.equals(model, item.model);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, about, price, pic, article, category, model);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
