package Twitter;

import java.util.Date;
import java.io.Serializable;

public class Usuario implements Serializable{
    private String username;
    private String password;
    private char gender;
    private long loginDate;
    private int age;
    private boolean active;
    
    
    public Usuario(String username, String password, char gender, long login, int age){
        this.username=username;
        this.password=password;
        this.gender=gender;
        login=loginDate;
        this.age=age;
        this.active=true;
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
        return loginDate;
    }

    public void setLoginDate(long loginDate) {
        this.loginDate = loginDate;
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
        return "Usuario{" + "username=" + username + ", password=" + password + ", gender=" + gender + ", loginDate=" + loginDate + ", age=" + age + ", active=" + active + '}';
    }
    
    
    
}
