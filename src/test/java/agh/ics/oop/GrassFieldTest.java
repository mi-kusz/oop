package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {

    @Test
    void canMoveTo()
    {
        //given:
        GrassField map = new GrassField(5);
        Vector2d position1 = new Vector2d(2, 2);
        Vector2d position2 = new Vector2d(5, 100);

        //when:
        boolean result1 = map.canMoveTo(position1);
        boolean result2 = map.canMoveTo(position2);

        //then:
        assertEquals(true, result1);
        assertEquals(true, result2);
    }

    @Test
    void place()
    {
        //given:
        GrassField map = new GrassField(5);
        Vector2d animalPosition1 = new Vector2d(1, 1);
        Animal animal1 = new Animal(map, animalPosition1);
        Vector2d animalPosition2 = new Vector2d(1, 1);
        Animal animal2 = new Animal(map, animalPosition2);

        //when:
        boolean exception1Happened = false;
        boolean exception2Happened = false;
        try
        {
            map.place(animal1);
        }
        catch (IllegalArgumentException e)
        {
            exception1Happened = true;
        }

        try
        {
            map.place(animal2);
        }
        catch (IllegalArgumentException e)
        {
            exception2Happened = true;
        }

        //then:
        assertEquals(false, exception1Happened);
        assertEquals(true, exception2Happened);
    }

    @Test
    void isOccupied()
    {
        //given:
        Vector2d position1 = new Vector2d(1, 1);
        Vector2d position2 = new Vector2d(50, 50);

        //when:
        GrassField map = new GrassField(5);
        Vector2d animalPosition = new Vector2d(1, 1);
        Animal animal = new Animal(map, animalPosition);
        map.place(animal);

        //then:
        assertEquals(true, map.isOccupied(position1));
        assertEquals(false, map.isOccupied(position2));
    }

    @Test
    void objectAt()
    {
        //given:
        Vector2d position1 = new Vector2d(1, 1);
        Vector2d position2 = new Vector2d(100, 500);

        //when:
        GrassField map = new GrassField(10);
        Vector2d animalPosition = new Vector2d(1, 1);
        Animal animal = new Animal(map, animalPosition);
        map.place(animal);

        //then:
        assertEquals(animal, map.objectAt(position1));
        assertEquals(null, map.objectAt(position2));
    }

    @Test
    void calculateTopRight()
    {
        //given:
        GrassField map = new GrassField(10);

        //when:
        Vector2d animalPosition1 = new Vector2d(50, 30);
        Animal animal1 = new Animal(map, animalPosition1);
        map.place(animal1);

        Vector2d animalPosition2 = new Vector2d(30, 50);
        Animal animal2 = new Animal(map, animalPosition2);
        map.place(animal2);

        Vector2d result = map.calculateTopRight();

        //then:
        assertEquals(new Vector2d(50, 50), result);
    }

    @Test
    void calculateBottomLeft()
    {
        //given:
        GrassField map = new GrassField(50);

        //when:
        Vector2d animalPosition1 = new Vector2d(50, 30);
        Animal animal1 = new Animal(map, animalPosition1);
        map.place(animal1);

        Vector2d animalPosition2 = new Vector2d(-30, -50);
        Animal animal2 = new Animal(map, animalPosition2);
        map.place(animal2);

        Vector2d result = map.calculateBottomLeft();

        //then:
        assertEquals(new Vector2d(-30, -50), result);
    }
}