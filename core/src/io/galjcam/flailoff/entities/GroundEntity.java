/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.galjcam.flailoff.entities;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

/**
 *
 * @author Adam Li
 */
public class GroundEntity implements Entity {

    BodyDef groundBodyDef;
    Body groundBody;
    PolygonShape groundBox;
    ShapeRenderer renderer;

    public GroundEntity(World world, OrthographicCamera camera) {
        // Create our body definition
        this.groundBodyDef = new BodyDef();
        // Set its world position
        groundBodyDef.position.set(new Vector2(0, 10));

        // Create a body from the definition and add it to the world
        this.groundBody = world.createBody(groundBodyDef);

        // Create a polygon shape
        this.groundBox = new PolygonShape();
        // Set the polygon shape as a box which is twice the size of our view port and 20 high
        // (setAsBox takes half-width and half-height as arguments)
        groundBox.setAsBox(camera.viewportWidth, 40.0f);
        // Create a fixture from our polygon shape and add it to our ground body  
        groundBody.createFixture(groundBox, 0.0f);
        // Clean up after ourselves
        groundBox.dispose();
    }

    @Override
    public void move(int x, int y) {
        System.out.println("Cannot move stage entity");
    }

    @Override
    public void bind(Entity e1) {
        System.out.println("Cannot bind stage to entities");
    }
}
