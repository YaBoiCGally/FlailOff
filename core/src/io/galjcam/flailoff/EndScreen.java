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

/**
 *
 * @author Adam Li
 */
public class EndScreen extends ScreenAdapter {
    FlailOff game;
    String winner;
    
    public EndScreen(FlailOff game, String winner) {
        game.player1.health = 100;
        game.player2.health = 100;
        this.game = game;
        this.winner = winner;
    }
    
    @Override
    public void show(){
        Gdx.input.setInputProcessor(new InputAdapter() {
            @Override
            public boolean keyDown(int keyCode) {
                if (keyCode == Input.Keys.SPACE) {
                    game.setScreen(new GameScreen(game));
                }
                return true;
            }
        });
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, .25f, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.background.render(delta);
        game.batch.begin();
        game.font.draw(game.batch, "Player " + winner + " wins!", Gdx.graphics.getWidth() * .25f, Gdx.graphics.getHeight() * .75f);

        game.font.draw(game.batch, "Press space to reset.", Gdx.graphics.getWidth() * .25f, Gdx.graphics.getHeight() * .25f);
        game.batch.end();
    }

    @Override
    public void hide(){
        Gdx.input.setInputProcessor(null);
    }
}
