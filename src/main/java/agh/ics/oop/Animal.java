package agh.ics.oop;

public class Animal
{
    private MapDirection orientation;
    private Vector2d position;

    public Animal()
    {
        orientation = MapDirection.NORTH;
        position = new Vector2d(2, 2);
    }

    @Override
    public String toString()
    {
        return "Position: " + position + ", orientation: " + orientation;
    }

    public boolean isAt(Vector2d position)
    {
        return this.position.equals(position);
    }

    public void move(MoveDirection direction)
    {
        Vector2d topRight = new Vector2d(4, 4);
        Vector2d bottomLeft = new Vector2d(0, 0);

        switch(direction)
        {
            case RIGHT -> this.orientation = this.orientation.next();
            case LEFT -> this.orientation = this.orientation.previous();
            case FORWARD ->
            {
                Vector2d newPosition = this.position.add(orientation.toUnitVector());

                if (newPosition.follows(bottomLeft) && newPosition.precedes(topRight))
                {
                    this.position = newPosition;
                }
            }
            case BACKWARD ->
            {
                Vector2d newPosition = this.position.substract(orientation.toUnitVector());

                if (newPosition.follows(bottomLeft) && newPosition.precedes(topRight))
                {
                    this.position = newPosition;
                }
            }
        }
    }
}
