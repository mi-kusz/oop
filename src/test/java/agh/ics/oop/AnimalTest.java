package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @Test
    void move()
    {
        //given:
        IWorldMap map = new RectangularMap(50, 50);
        Animal orientationTest = new Animal(map, new Vector2d(0, 0));
        Animal movingTest = new Animal(map, new Vector2d(10, 10));
        Animal boundsTest = new Animal(map, new Vector2d(0, 48));

        //when:
        orientationTest.move(MoveDirection.RIGHT);

        movingTest.move(MoveDirection.FORWARD);
        movingTest.move(MoveDirection.FORWARD);

        boundsTest.move(MoveDirection.FORWARD);
        boundsTest.move(MoveDirection.FORWARD);
        boundsTest.move(MoveDirection.FORWARD);

        //then:
        assertEquals("E", orientationTest.toString());
        assertEquals(true, movingTest.isAt(new Vector2d(10, 12)));
        assertEquals(true, boundsTest.isAt(new Vector2d(0, 49)));
    }
}