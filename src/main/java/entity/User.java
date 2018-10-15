package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "user_mrg")
public class User {
    @Id
    private String id;
    private String login;
    private String password;
    private String name;
    private String email;
    private String phone;
    private String basket;
    private String acclevel;

    public User() {
    }

    public User(String id, String login, String password, String name, String email, String phone, String acessLevel, String basket) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.acclevel = acessLevel;
        this.basket = basket;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAcessLevel() {
        return acclevel;
    }

    public void setAcessLevel(String acessLevel) {
        this.acclevel = acessLevel;
    }

    public String getBasket() {
        return basket;
    }

    public void setBasket(String basket) {
        this.basket = basket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(name, user.name) &&
                Objects.equals(email, user.email) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(acclevel, user.acclevel) &&
                Objects.equals(basket, user.basket);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, login, password, name, email, phone, acclevel, basket);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", acessLevel='" + acclevel + '\'' +
                ", basket='" + basket + '\'' +
                '}';
    }
}
