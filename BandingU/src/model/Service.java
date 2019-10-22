package model;

public class Service extends Submission{
    String title;
    String description;
    
    public Service(String title, String description, String text){
    super(text);
    this.title = title;
    this.description = description;
    }
}
