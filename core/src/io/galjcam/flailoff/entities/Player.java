/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.galjcam.flailoff.entities;

import io.galjcam.flailoff.character.AbstractCharacter;

/**
 *
 * @author Cam
 */
public class Player extends AbstractCharacter implements Entity {

    @Override
    public void move(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void bind(Entity e1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getHealth() {
        return 69;
    }

    @Override
    public void render() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
