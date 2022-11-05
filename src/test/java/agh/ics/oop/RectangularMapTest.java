package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangularMapTest {

    @Test
    void canMoveTo()
    {
        //given:
        RectangularMap map = new RectangularMap(5, 5);
        Vector2d position1 = new Vector2d(2, 2);
        Vector2d position2 = new Vector2d(5, 100);

        //when:
        boolean result1 = map.canMoveTo(position1);
        boolean result2 = map.canMoveTo(position2);

        //then:
        assertEquals(true, result1);
        assertEquals(false, result2);
    }

    @Test
    void place()
    {
        //given:
        RectangularMap map = new RectangularMap(5, 5);
        Vector2d animalPosition1 = new Vector2d(1, 1);
        Animal animal1 = new Animal(map, animalPosition1);
        Vector2d animalPosition2 = new Vector2d(1, 1);
        Animal animal2 = new Animal(map, animalPosition2);

        //when:
        boolean result1 = map.place(animal1);
        boolean result2 = map.place(animal2);

        //then:
        assertEquals(true, result1);
        assertEquals(false, result2);
    }

    @Test
    void isOccupied()
    {
        //given:
        Vector2d position1 = new Vector2d(1, 1);
        Vector2d position2 = new Vector2d(3, 3);

        //when:
        RectangularMap map = new RectangularMap(5, 5);
        Vector2d animalPosition = new Vector2d(1, 1);
        Animal animal = new Animal(map, animalPosition);
        map.place(animal);

        //then:
        assertEquals(true, map.isOccupied(position1));
        assertEquals(false, map.isOccupied(position2));
    }

    @Test
    void objectAt() {
        //given:
        Vector2d position1 = new Vector2d(1, 1);
        Vector2d position2 = new Vector2d(2, 2);

        //when:
        RectangularMap map = new RectangularMap(5, 5);
        Vector2d animalPosition = new Vector2d(1, 1);
        Animal animal = new Animal(map, animalPosition);
        map.place(animal);

        //then:
        assertEquals(animal, map.objectAt(position1));
        assertEquals(null, map.objectAt(position2));
    }
}