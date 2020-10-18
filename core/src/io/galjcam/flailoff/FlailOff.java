package io.galjcam.flailoff;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import io.galjcam.flailoff.elements.InfiniteBackground;
import io.galjcam.flailoff.elements.Status;
import io.galjcam.flailoff.entities.Player;

public class FlailOff extends Game {

    SpriteBatch batch;
    ShapeRenderer shapeRenderer;
    BitmapFont font;
    
    OrthographicCamera camera;
    
    InfiniteBackground background;
    Status status;

    @Override
    public void create () {
        batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        font = new BitmapFont();
        
        float width = Gdx.graphics.getWidth();
        float height = Gdx.graphics.getHeight();
        
        this.camera = new OrthographicCamera(width, height);
        
        background = new InfiniteBackground("background-clouds.png", width, height, new Vector2(5, 100));
        status = new Status(new Player(), new Player(), width, height, new Vector2(width/2, height-50));
        setScreen(new MainScreen(this));
    }
    
    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose () {
        batch.dispose();
        shapeRenderer.dispose();
        font.dispose();
    }
}
