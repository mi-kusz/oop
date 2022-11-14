package agh.ics.oop;

import java.util.ArrayList;

public class RectangularMap extends AbstractWorldMap
{
    public RectangularMap(int width, int height)
    {
        animals = new ArrayList<>();
        topRight = new Vector2d(width - 1, height - 1);
        bottomLeft = new Vector2d(0, 0);
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
