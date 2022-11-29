package agh.ics.oop;

import java.util.HashMap;

public class RectangularMap extends AbstractWorldMap
{
    public RectangularMap(int width, int height)
    {
        animals = new HashMap<>();
        topRight = new Vector2d(width - 1, height - 1);
        bottomLeft = new Vector2d(0, 0);

        boundary = new MapBoundary(this);
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

    @Override
    protected void notifyMapBoundary(Vector2d oldPosition, Vector2d newPosition, IMapElement element)
    {
        //Do not notify MapBoundary, size can't change
    }
}
