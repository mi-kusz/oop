package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Application;

public class World
{
    public static void main(String[] args)
    {
        Application.launch(App.class, args);
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
