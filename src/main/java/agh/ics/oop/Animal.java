package agh.ics.oop;

import agh.ics.oop.gui.GuiElementBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Animal implements IMapElement
{
    private MapDirection orientation;
    private Vector2d position;
    private IWorldMap map;

    private GuiElementBox gui;

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

        gui = new GuiElementBox(this);
    }

    public Vector2d getPosition()
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
            case RIGHT ->
            {
                this.orientation = this.orientation.next();
                guiDirectionChanged();
            }
            case LEFT ->
            {
                this.orientation = this.orientation.previous();
                guiDirectionChanged();
            }
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
                    positionChanged(oldPosition, newPosition);
                    this.position = newPosition;
                    guiPositionChanged();
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

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return orientation == animal.orientation && position.equals(animal.position) && map.equals(animal.map) && observers.equals(animal.observers);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(map, observers);
    }

    @Override
    public String getResourceName()
    {
        return switch(orientation)
                {
                    case NORTH -> "src/main/resources/up.png";
                    case SOUTH -> "src/main/resources/down.png";
                    case WEST -> "src/main/resources/left.png";
                    case EAST -> "src/main/resources/right.png";
                };
    }

    private void guiPositionChanged()
    {
        gui.positionChanged();
    }

    private void guiDirectionChanged()
    {
        gui.directionChanged();
    }

    @Override
    public GuiElementBox getGui()
    {
        return gui;
    }
}
