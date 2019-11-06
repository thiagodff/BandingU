package model;

public class Service extends Submission implements java.io.Serializable{
    String title;
    String description;
    
    public Service(String title, String description, String text, User owner){
    super(text, owner);
    this.title = title;
    this.description = description;
    }
    
    public Service(){
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
    
    public String getText(){
        return this.subText; 
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
