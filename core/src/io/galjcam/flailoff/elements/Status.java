/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.galjcam.flailoff.elements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import io.galjcam.flailoff.entities.Player;

/**
 *
 * @author Adam Li
 */
public class Status {
    private final Camera camera;
    private final int height;
    private final int length;
    private final int border;
    private final int gap;
    private final Vector2 center;
    
    private final ShapeRenderer shapeRenderer;
    
    private final Player player1;
    private final Player player2;
    
    public Status(Player player1, Player player2, float width, float height, Vector2 center){
        this.player1 = player1;
        this.player2 = player2;
        this.center = center;
        camera = new OrthographicCamera(width, height);
        
        // Considering the width of the screen is 852px, each bar is 300px long
        this.length = 300;
        // Considering the height of the screen is 480 px, each bar is 30 px tall
        this.height = 30;
        // Make the border 3px for visibility
        this.border = 3;
        // Gap is like 50px
        this.gap = 50;
        shapeRenderer = new ShapeRenderer();
    }
    
    private void renderBar(int health, boolean reverse, int center_x, int center_y){
        int leftPos = center_x - length/2;
        int botPos = center_y - height/2;
        int barLen = (int) ((health/100.0f)*length);
        int startPos = reverse ? leftPos+length-barLen : leftPos;
        //Rename for shortness
        ShapeRenderer s = shapeRenderer;
        //Draw solids
        s.begin(ShapeType.Filled);
        //Draw bar background
        s.setColor(Color.CLEAR);
        s.rect(leftPos, botPos, length, height);
        //Draw health
        s.setColor(Color.PURPLE);
        s.rect(startPos, botPos, barLen, height);
        //Draw knob
        s.setColor(Color.WHITE);
        if (reverse) s.rect(startPos-2, botPos, 5, height);
        else s.rect(leftPos+barLen-2, botPos, 5, height);
        //Finish solids, Draw outline
        s.end();
        s.begin(ShapeType.Line);
        Gdx.gl20.glLineWidth(border);
        s.setColor(Color.BLACK);
        s.rect(leftPos, botPos, length, height);
        s.end();
    }

    public void render(){
        this.camera.update();
        shapeRenderer.setProjectionMatrix(camera.combined);
        
        //Get offset
        int xoff = (int) (-this.camera.viewportWidth/2);
        int yoff = (int) (-this.camera.viewportHeight/2);
        int offset = gap/2 + length/2;
        
        //Render the bars
        renderBar(player1.getHealth(), true, xoff + (int)(center.x-offset), yoff + (int)center.y);
        renderBar(player2.getHealth(), false, xoff + (int)(center.x+offset), yoff + (int)center.y);
    }
}
