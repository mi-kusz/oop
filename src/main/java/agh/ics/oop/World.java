package agh.ics.oop;

public class World
{
    public static void main(String[] args)
    {
        MoveDirection[] moves = new OptionsParser().parse(args);

        Animal animal = new Animal();
        System.out.println(animal);

        for (MoveDirection direction : moves)
        {
            animal.move(direction);
        }

        System.out.println(animal);
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
