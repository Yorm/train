package com.train;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class BodyWorld {
    public World world;
    private Body floor;
    private BodyFactory bodyFactory;

    public BodyWorld(){
        world = new World(new Vector2(0,-10f), true);
        createFloor();

        bodyFactory = BodyFactory.getInstance(world);

        bodyFactory.makeCirclePolyBody(1, 1, 2, BodyFactory.RUBBER, BodyDef.BodyType.DynamicBody,false);
        bodyFactory.makeCirclePolyBody(4, 1, 2, BodyFactory.STEEL, BodyDef.BodyType.DynamicBody,false);
        bodyFactory.makeCirclePolyBody(-4, 1, 2, BodyFactory.STONE, BodyDef.BodyType.DynamicBody,false);
        bodyFactory.makeBoxPolyBody(1, 1, 2,5, BodyFactory.RUBBER, BodyDef.BodyType.StaticBody,false);

    }


    private void createFloor() {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(0, -10);

        floor = world.createBody(bodyDef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(50, 1);
        floor.createFixture(shape, 0.0f);

        shape.dispose();
    }



    public void logicStep(float delta){
        world.step(delta , 3, 3);
    }
}