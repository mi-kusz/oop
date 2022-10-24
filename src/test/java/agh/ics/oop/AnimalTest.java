package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {

    @Test
    void move()
    {
        //given:
        Animal orientationTest = new Animal();
        Animal movingTest = new Animal();
        Animal boundsTest = new Animal();

        //when:
        orientationTest.move(MoveDirection.RIGHT);

        movingTest.move(MoveDirection.FORWARD);
        movingTest.move(MoveDirection.FORWARD);

        boundsTest.move(MoveDirection.FORWARD);
        boundsTest.move(MoveDirection.FORWARD);
        boundsTest.move(MoveDirection.FORWARD);

        //then:
        assertEquals(orientationTest.toString(), "Position: (2,2), orientation: Wschód");
        assertEquals(movingTest.isAt(new Vector2d(2, 4)), true);
        assertEquals(boundsTest.isAt(new Vector2d(2, 4)), true);
    }
}