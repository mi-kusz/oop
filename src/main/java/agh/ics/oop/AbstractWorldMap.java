package agh.ics.oop;

import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap
{
    protected List<Animal> animals;

    protected Vector2d topRight;
    protected Vector2d bottomLeft;

    @Override
    public boolean canMoveTo(Vector2d position)
    {
        return position.follows(bottomLeft) && position.precedes(topRight) && !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal)
    {
        if (isOccupied(animal.position()))
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

    abstract protected Vector2d calculateTopRight();
    abstract protected Vector2d calculateBottomLeft();

    @Override
    public String toString()
    {
        MapVisualiser mapVisualiser = new MapVisualiser(this);
        return mapVisualiser.draw(calculateBottomLeft(), calculateTopRight());
    }
}
