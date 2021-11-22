package Entities;

public class User {
    
    //Atributos
    private int id;
    private String nom;
    private String pass;
    
    
    //Constructor
    public User(){
    
    }
    
    
    
    //Metodos Getter and Setter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    
    

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    
    
    
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
}
