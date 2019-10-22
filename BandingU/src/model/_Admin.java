package model;

public interface _Admin {
    
    /**
     *
     * @param user
     * @return succeeded / failed
     */
    public boolean banUser(User user);
    
    public User promoteUser(User user);
}
