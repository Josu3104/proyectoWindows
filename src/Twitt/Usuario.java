package Twitt;

import java.util.Date;
import java.io.Serializable;

public class Usuario implements Serializable{
    private String NombreCompleto;
    private String username;
    private String password;
    private char gender;
    private long date;
    private int age;
    private boolean active;
    
    
    public Usuario(String name,String username, String password, char gender, long date, int age, boolean state){
        this.NombreCompleto = name;
        this.username=username;
        this.password=password;
        this.gender=gender;
        this.date=date;
        this.age=age;
        this.active=state;
    }

   

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public long getLoginDate() {
        return date;
    }

    public void setLoginDate(long loginDate) {
        this.date = loginDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Usuario{" + "username=" + username + ", password=" + password + ", gender=" + gender + ", loginDate=" + date + ", age=" + age + ", active=" + active + '}';
    }

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public void setNombreCompleto(String NombreCompleto) {
        this.NombreCompleto = NombreCompleto;
    }
    
    
    
}
