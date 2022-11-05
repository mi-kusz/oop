package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap
{
    private List<Animal> animals;

    private Vector2d topRight;
    private Vector2d bottomLeft;

    public RectangularMap(int width, int height)
    {
        animals = new ArrayList<>();
        topRight = new Vector2d(width - 1, height - 1);
        bottomLeft = new Vector2d(0, 0);
    }

    @Override
    public boolean canMoveTo(Vector2d position)
    {
        return position.follows(bottomLeft) && position.precedes(topRight) && !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal)
    {
        Vector2d p = animal.position();

        if (isOccupied(p))
        {
            return false;
        }

        animals.add(animal);
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position)
    {
        for (Animal a : animals)
        {
            if (a.isAt(position))
            {
                return true;
            }
        }

        return false;
    }

    @Override
    public Object objectAt(Vector2d position)
    {
        for (Animal a : animals)
        {
            if (a.isAt(position))
            {
                return a;
            }
        }

        return null;
    }

    @Override
    public String toString()
    {
        MapVisualiser mapVisualiser = new MapVisualiser(this);
        return mapVisualiser.draw(bottomLeft, topRight);
    }
}
