/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class ServiceBank implements java.io.Serializable{

    private final ArrayList<Service> services;

    public ServiceBank() {
        services = new ArrayList<>();
    }

    public void addService(Service service) {
        services.add(service);
    }

    public Service[] returnServices() {
        Service[] e = new Service[this.services.size()];
        return services.toArray(e);
    }

    public boolean editService(int index, String title, String desc) {
        services.add(new Service(title, desc, services.get(index).getText(), services.get(index).owner));
        services.remove(index);
        return true;
    }

    public ArrayList<Service> getServices() {
        return services;
    }
    
    public void emitRefresh(){
        
    }
}
