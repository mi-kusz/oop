package agh.ics.oop;

import java.util.Objects;

public class Grass implements IMapElement
{
    private Vector2d position;

    public Grass(Vector2d pos)
    {
        position = pos;
    }

    public Vector2d getPosition()
    {
        return position;
    }

    @Override
    public String toString()
    {
        return "*";
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grass grass = (Grass) o;
        return position.equals(grass.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
