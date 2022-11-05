package agh.ics.oop;

public class Animal
{
    private MapDirection orientation;
    private Vector2d position;
    private IWorldMap map;

    public Animal(IWorldMap map)
    {
        orientation = MapDirection.NORTH;
        this.map = map;
        this.position = new Vector2d(0, 0);
    }

    public Animal(IWorldMap map, Vector2d initialPosition)
    {
        orientation = MapDirection.NORTH;
        this.map = map;
        this.position = initialPosition;
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
                Vector2d newPosition = null;

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
                }
            }
        }
    }
}
