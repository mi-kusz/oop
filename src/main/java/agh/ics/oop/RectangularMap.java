package agh.ics.oop;

import java.util.HashMap;

public class RectangularMap extends AbstractWorldMap
{
    public RectangularMap(int width, int height)
    {
        animals = new HashMap<>();
        topRight = new Vector2d(width - 1, height - 1);
        bottomLeft = new Vector2d(0, 0);
        visualiser = new MapVisualiser(this);
    }

    @Override
    protected Vector2d calculateTopRight()
    {
        return topRight;
    }

    @Override
    protected Vector2d calculateBottomLeft()
    {
        return bottomLeft;
    }
}
