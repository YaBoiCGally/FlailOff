/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.galjcam.flailoff;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import io.galjcam.flailoff.entities.*;

/**
 *
 * @author Adam Li
 */
public class GameScreen extends ScreenAdapter {

    FlailOff game;
    World world;
    Entity ground; 

    public GameScreen(FlailOff game) {
        this.game = game;
        this.world = new World(new Vector2(0, -10), true);
        
        this.ground = new GroundEntity(world, game.camera);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int keyCode) {
                if (keyCode == Input.Keys.W) {
                    game.player1.decrementHealth(3);
                }
                if (keyCode == Input.Keys.UP) {
                    game.player2.decrementHealth(3);
                }
                return true;
            }
        });
    }

    @Override
    public void render(float delta) {
        if(game.player1.getHealth() <= 0) {
            game.setScreen(new EndScreen(game, "One"));
        } else if(game.player2.getHealth() <= 0) {
            game.setScreen(new EndScreen(game, "Two"));
        }
        Gdx.gl.glClearColor(0, .25f, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.background.render(delta);
        /*
        game.batch.begin();
        game.font.draw(game.batch, "Game Screen!", Gdx.graphics.getWidth() * .25f, Gdx.graphics.getHeight() * .75f);
        game.font.draw(game.batch, "Click the circle to win.", Gdx.graphics.getWidth() * .25f, Gdx.graphics.getHeight() * .5f);
        game.font.draw(game.batch, "Press space to play.", Gdx.graphics.getWidth() * .25f, Gdx.graphics.getHeight() * .25f);
        game.batch.end();
        */
        ground.render();
        game.status.render();
        world.step(1 / 60f, 6, 2);
        
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }
}
