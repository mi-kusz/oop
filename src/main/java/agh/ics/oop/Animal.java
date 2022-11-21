package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class Animal
{
    private MapDirection orientation;
    private Vector2d position;
    private IWorldMap map;

    private List<IPositionChangeObserver> observers;

    public Animal(IWorldMap map)
    {
        this(map, new Vector2d(0, 0));
    }

    public Animal(IWorldMap map, Vector2d initialPosition)
    {
        orientation = MapDirection.NORTH;
        this.map = map;
        this.position = initialPosition;
        this.observers = new ArrayList<>();
    }

    public Vector2d position()
    {
        return position;
    }

    @Override
    public String toString()
    {
        return switch(orientation)
                {
                    case NORTH -> "N";
                    case SOUTH -> "S";
                    case EAST -> "E";
                    case WEST -> "W";
                };
    }

    public boolean isAt(Vector2d position)
    {
        return this.position.equals(position);
    }

    public void move(MoveDirection direction)
    {
        switch(direction)
        {
            case RIGHT -> this.orientation = this.orientation.next();
            case LEFT -> this.orientation = this.orientation.previous();
            case FORWARD, BACKWARD ->
            {
                Vector2d oldPosition = this.position;
                Vector2d newPosition;

                if (direction == MoveDirection.FORWARD)
                {
                    newPosition = this.position.add(orientation.toUnitVector());
                }
                else
                {
                    newPosition = this.position.subtract(orientation.toUnitVector());
                }

                if (map.canMoveTo(newPosition))
                {
                    this.position = newPosition;
                    positionChanged(oldPosition, newPosition);
                }
            }
        }
    }

    public void addObserver(IPositionChangeObserver observer)
    {
        this.observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer)
    {
        this.observers.remove(observer);
    }

    private void positionChanged(Vector2d oldPosition, Vector2d newPosition)
    {
        for (IPositionChangeObserver observer : observers)
        {
            observer.positionChanged(oldPosition, newPosition);
        }
    }
}
