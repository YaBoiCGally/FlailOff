/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.galjcam.flailoff.entities;

/**
 *
 * @author Adam Li
 */
public interface Entity {
    
    public void move(int x, int y);
    
    public void bind(Entity e1);
    
    public int getHealth();
    
    public void render();
}
