package model;

import java.io.Serializable;

public class User implements Serializable{

    private String nome;
    private String password;
    private int ID;
    private double credits;
    private boolean valid;
    private boolean partner;
    protected int rank;

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getNome() {
        return nome;
    }

    public int getID() {
        return ID;
    }

    public String getPassword() {
        return password;
    }

    public double getCredits() {
        return credits;
    }

    public boolean isPartner() {
        return partner;
    }

    public void setPartner(boolean partner) {
        this.partner = partner;
    }

    public int getRank() {
        return rank;
    }
    
    

    public User(String nome, String password, int ID) {
        this.nome = nome;
        this.password = password;
        this.ID = ID;
        this.credits = 0;
        this.valid = true;
        this.partner = false;
        this.rank = 0;
    }

    public boolean login(String password) {
        return this.password.equals(password) && this.valid;
    }
    
    public boolean validate(String nome, String password){
        return this.nome.equals(nome) && this.password.equals(password) && this.valid;
    }
    
    public void deposit(double value){
    this.credits += value;
    }
    
    public boolean withdraw(double value){
    if(this.credits - value < 0)
        return false;
    
    this.credits += value;
    return true;
    }
    
    public Submission submit(String text){
    
        if(this.partner){
        return new Submission(text);
        }else{
        return null;
        }
    
    }
}
