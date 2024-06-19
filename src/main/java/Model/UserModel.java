package Model;

public class UserModel {
    
    private int id;
    private String name;
    private String email;
    private String password;

    public UserModel(int id, String name, String email, String password){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }
    //getters
    public int getid(){
        return id;
    }
    public String getname(){
        return name;
    }
    public String getemail(){
        return email;
    }
    public String getpassword(){
        return password;
    }

    //setters
    public void setid(int id){
        this.id = id;
    }
    public void setname(String name){
        this.name = name;
    }
    public void setemail(String email){
        this.email = email;
    }
    public void setpassword(String password){
        this.password = password;
    }
}
