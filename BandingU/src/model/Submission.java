package model;

public class Submission implements java.io.Serializable{
    
    protected String subText;
    protected User owner;
    
    public Submission(String text, User owner){
    this.subText = text;
    }
    
    public Submission(){}
}
