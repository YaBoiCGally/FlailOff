/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.galjcam.flailoff.elements;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 *
 * @author Adam Li
 */
public class InfiniteBackground {
    private final Camera camera;
    private final SpriteBatch batch;
    private final Vector2 speed = new Vector2();
    private final Texture backgroundTexture;
    
    
    public InfiniteBackground(String file, float width, float height, Vector2 speed){
        this.speed.set(speed);
        camera = new OrthographicCamera(width, height);
        batch = new SpriteBatch();
        backgroundTexture = new Texture(Gdx.files.internal(file));
    }

    public void render(float delta){
        this.camera.position.add(speed.x*delta,speed.y*delta, 0);
        batch.setProjectionMatrix(camera.projection);
        batch.begin();
        
        // Get the current location along the tiled background we would be at,
        // and subtract if moving the opposite direction, because modulo returns positive.
        // This gets updated as we draw along the x until off camera
        float currentX = -(camera.position.x % backgroundTexture.getWidth());
        if(speed.x < 0) currentX -= backgroundTexture.getWidth();

        while(currentX < camera.viewportWidth){
            // Likewise for Y
            float currentY = -(camera.position.y % backgroundTexture.getHeight());
            if(speed.y < 0)currentY -= backgroundTexture.getHeight();

            while(currentY < camera.viewportHeight){
                // Draw based on offsets
                batch.draw(backgroundTexture,
                        (-this.camera.viewportWidth/2) + currentX,
                        (-this.camera.viewportHeight/2) + currentY);
                // Update location
                currentY += backgroundTexture.getHeight();
            }

            currentX += backgroundTexture.getWidth();
        }
        batch.end();
    }
}
