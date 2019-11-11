package model;

import java.io.Serializable;

public class User implements Serializable{

    private String nome;
    private String nomeCompleto;
    private String email;
    private String telefone;
    private String endereco;
    private String password;
    private int ID;
    private double credits;
    private boolean valid;
    private boolean partner;
    private boolean provider;
    protected int rank;
    
    public User(String nome, String password, String nomeCompleto, String email, String telefone, String endereco, boolean provider, int ID) {
        this.nome = nome;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.password = password;
        this.ID = ID;
        this.provider = provider;
        this.credits = 0;
        this.valid = true;
        this.partner = false;
        this.rank = 0;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public boolean isProvider() {
        return provider;
    }

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
        return new Submission(text, this);
        }else{
        return null;
        }
    
    }
}
