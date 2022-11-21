package agh.ics.oop;

import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver
{
    protected Map<Vector2d, Animal> animals;

    protected Vector2d topRight;
    protected Vector2d bottomLeft;

    protected MapVisualiser visualiser;

    @Override
    public boolean canMoveTo(Vector2d position)
    {
        return position.follows(bottomLeft) && position.precedes(topRight) && !isOccupied(position);
    }

    @Override
    public void place(Animal animal)
    {
        if (isOccupied(animal.position()))
        {
            throw new IllegalArgumentException(animal.position() + " is already taken");
        }
        else
        {
            animals.put(animal.position(), animal);
        }
    }

    @Override
    public boolean isOccupied(Vector2d position)
    {
        return animalOccupies(position);
    }

    @Override
    public Object objectAt(Vector2d position)
    {
        return animals.get(position);
    }

    abstract protected Vector2d calculateTopRight();
    abstract protected Vector2d calculateBottomLeft();

    @Override
    public String toString()
    {
        return visualiser.draw(calculateBottomLeft(), calculateTopRight());
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition)
    {
        Animal animal = animals.get(oldPosition);
        animals.remove(oldPosition);
        animals.put(newPosition, animal);
    }

    protected boolean animalOccupies(Vector2d position)
    {
        Animal animal = animals.get(position);

        return animal != null;
    }
}
