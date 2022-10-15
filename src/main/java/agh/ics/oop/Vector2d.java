package agh.ics.oop;

import java.util.Objects;

public class Vector2d
{
    public final int x;
    public final int y;

    public Vector2d(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString()
    {
        return "(" + x + "," + y + ")";
    }

    public boolean precedes(Vector2d other)
    {
        return (this.x <= other.x && this.y <= other.y);
    }

    public boolean follows(Vector2d other)
    {
        return (this.x >= other.x && this.y >= other.y);
    }

    public Vector2d upperRight(Vector2d other)
    {
        int biggerX = Math.max(this.x, other.x);
        int biggerY = Math.max(this.y, other.y);

        return new Vector2d(biggerX, biggerY);
    }

    public Vector2d lowerLeft(Vector2d other)
    {
        int lowerX = Math.min(this.x, other.x);
        int lowerY = Math.min(this.y, other.y);

        return new Vector2d(lowerX, lowerY);
    }

    public Vector2d add(Vector2d other)
    {
        int sumX = this.x + other.x;
        int sumY = this.y + other.y;

        return new Vector2d(sumX, sumY);
    }

    public Vector2d substract(Vector2d other)
    {
        int differenceX = this.x - other.x;
        int differenceY = this.y - other.y;

        return new Vector2d(differenceX, differenceY);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector2d vector2d = (Vector2d) o;
        return x == vector2d.x && y == vector2d.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public Vector2d opposite()
    {
        return new Vector2d(-this.x, -this.y);
    }

}
