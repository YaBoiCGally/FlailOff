/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.galjcam.flailoff.entities;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

/**
 *
 * @author Adam Li
 */
public class GroundEntity implements Entity {

    private BodyDef groundBodyDef;
    private Body groundBody;
    private PolygonShape groundBox;
    private ShapeRenderer shapeRenderer;
    private World world;
    private Camera camera;
    private Box2DDebugRenderer debugger;

    public GroundEntity(World world, Camera camera) {
        // Create our body definition
        this.groundBodyDef = new BodyDef();
        // Set its world position
        int x = 0, y = (int) (-(camera.viewportHeight / 2) + 40);  
        groundBodyDef.position.set(new Vector2(x, y));

        // Create a body from the definition and add it to the world
        this.groundBody = world.createBody(groundBodyDef);
        groundBodyDef.type = BodyType.StaticBody;
        // Create a polygon shape
        this.groundBox = new PolygonShape();
        // Set the polygon shape as a box which is twice the size of our view port and 20 high
        // (setAsBox takes half-width and half-height as arguments)
        groundBox.setAsBox(camera.viewportWidth / 2 - 100, 40.0f);
        // Create a fixture from our polygon shape and add it to our ground body  
        groundBody.createFixture(groundBox, 0.0f);
        // Clean up after ourselves
        groundBox.dispose();
        
        this.shapeRenderer = new ShapeRenderer();
        this.world = world;
        this.camera = camera;
        this.debugger = new Box2DDebugRenderer();
    }

    @Override
    public void move(int x, int y) {
        System.out.println("Cannot move stage entity");
    }

    @Override
    public void bind(Entity e1) {
        System.out.println("Cannot bind stage to entities");
    }
    
    @Override
    public int getHealth() {
        return -1;
    }
    @Override
    public void render() {
        shapeRenderer.setProjectionMatrix(camera.combined);
        int x = (int)(-camera.viewportWidth / 2 + 100);
        int y = (int)(-camera.viewportHeight / 2);
        int width = 854 - 200, height = 80;
        
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.OLIVE);
        shapeRenderer.rect(x, y, width, height);
        shapeRenderer.end();
        
        debugger.render(world, camera.combined);
    }
}
