package agh.ics.oop;

public class World
{
    public static void main(String[] args)
    {
        try
        {
            MoveDirection[] directions = new OptionsParser().parse(args);
            AbstractWorldMap map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void run(Direction[] args)
    {
        for (Direction arg : args)
        {
            switch (arg)
            {
                case FORWARD -> System.out.println("Zwierzak idzie do przodu");
                case BACKWARD -> System.out.println("Zwierzak idzie do tyłu");
                case RIGHT -> System.out.println("Zwierzak skręca w prawo");
                case LEFT -> System.out.println("Zwierzak skręca w lewo");
            }
        }
    }
}
