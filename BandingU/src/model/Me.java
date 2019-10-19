/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author xande
 */
public class Me {
    private User self;
    private boolean isOn;
    
    public Me(User self, boolean isOn){
    this.self = self;
    this.isOn = isOn;
    }
}
