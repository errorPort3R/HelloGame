package com.theironyard.javawithclojure.porter;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	float x, y, xv, yv;
	static final float MAX_VELOCITY = 100;
	static final float DECLERATION_RATE = 0.95f;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		move();

		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, x, y);
		batch.end();
	}

	public void move()
	{
		if (Gdx.input.isKeyPressed(Input.Keys.UP))
		{
			yv = MAX_VELOCITY;
		}
		else if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
		{
			yv = -MAX_VELOCITY;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
		{
			xv = MAX_VELOCITY;
		}

		if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
		{
			xv = -MAX_VELOCITY;
		}

		float delta = Gdx.graphics.getDeltaTime();
		y+= yv * delta;
		x+= xv * delta;
		yv = decelerate(yv);
		xv = decelerate(xv);

	}

	public float decelerate(float velocity)
	{
		velocity *= DECLERATION_RATE;
		if (Math.abs(velocity) < 1)
		{
			velocity = 0;
		}
		return velocity;
	}
}
