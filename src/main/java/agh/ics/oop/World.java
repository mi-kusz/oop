package agh.ics.oop;

public class World
{
    public static void main(String[] args)
    {
        Direction[] moves = new Direction[args.length];

        for (int i = 0; i < args.length; ++i)
        {
            switch (args[i])
            {
                case "f":
                {
                    moves[i] = Direction.FORWARD;
                }
                break;
                case "b":
                {
                    moves[i] = Direction.BACKWARD;
                }
                break;
                case "r":
                {
                    moves[i] = Direction.RIGHT;
                }
                break;
                case "l":
                {
                    moves[i] = Direction.LEFT;
                }
                break;
            }
        }

        System.out.println("Start");
        run(moves);
        System.out.println("Stop");
    }

    public static void run(Direction[] args)
    {
        for (int i = 0; i < args.length; ++i)
        {
            switch (args[i])
            {
                case FORWARD:
                {
                    System.out.println("Zwierzak idzie do przodu");
                }
                break;
                case BACKWARD:
                {
                    System.out.println("Zwierzak idzie do tyłu");
                }
                break;
                case RIGHT:
                {
                    System.out.println("Zwierzak skręca w prawo");
                }
                break;
                case LEFT:
                {
                    System.out.println("Zwierzak skręca w lewo");
                }
                break;
            }
        }
    }
}
