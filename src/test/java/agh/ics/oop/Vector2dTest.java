package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {

    @Test
    void testToString()
    {
        //given:
        Vector2d vector2d = new Vector2d(1, 2);

        //when:
        String name = vector2d.toString();

        //then:
        assertEquals("(1,2)", name);
    }

    @Test
    void testEquals()
    {
        //given:
        Vector2d a = new Vector2d(1, 2);
        Vector2d b = new Vector2d(1, 2);
        String s = "";

        //when:
        boolean selfResult = a.equals(a);
        boolean vectorResult = a.equals(b);
        boolean stringResult = a.equals(s);

        //then:
        assertEquals(true, selfResult);
        assertEquals(true, vectorResult);
        assertEquals(false, stringResult);
    }

    @Test
    void precedes()
    {
        //given:
        Vector2d a = new Vector2d(1, 1);
        Vector2d b = new Vector2d(2, 2);
        Vector2d c = new Vector2d(0, 1);

        //when:
        boolean selfResult = a.precedes(a);
        boolean higherResult = a.precedes(b);
        boolean lowerResult = a.precedes(c);

        //then:
        assertEquals(true, selfResult);
        assertEquals(true, higherResult);
        assertEquals(false, lowerResult);
    }

    @Test
    void follows()
    {
        //given:
        Vector2d a = new Vector2d(1, 1);
        Vector2d b = new Vector2d(2, 2);
        Vector2d c = new Vector2d(0, 1);

        //when:
        boolean selfResult = a.follows(a);
        boolean higherResult = a.follows(b);
        boolean lowerResult = a.follows(c);

        //then:
        assertEquals(true, selfResult);
        assertEquals(false, higherResult);
        assertEquals(true, lowerResult);

    }

    @Test
    void upperRight()
    {
        //given:
        Vector2d a = new Vector2d(1, 100);
        Vector2d b = new Vector2d(200, -50);

        //when:
        Vector2d result = a.upperRight(b);

        //then:
        Vector2d answer = new Vector2d(200, 100);
        assertEquals(answer, result);
    }

    @Test
    void lowerLeft()
    {
        //given:
        Vector2d a = new Vector2d(1, 100);
        Vector2d b = new Vector2d(200, -50);

        //when:
        Vector2d result = a.lowerLeft(b);

        //then:
        Vector2d answer = new Vector2d(1, -50);
        assertEquals(answer, result);
    }

    @Test
    void add()
    {
        //given:
        Vector2d a = new Vector2d(10, 20);
        Vector2d b = new Vector2d(100, 200);

        //when:
        Vector2d result = a.add(b);

        //then:
        Vector2d answer = new Vector2d(110, 220);
        assertEquals(answer, result);
    }

    @Test
    void subtract()
    {
        //given:
        Vector2d a = new Vector2d(10, 20);
        Vector2d b = new Vector2d(100, 200);

        //when:
        Vector2d result = a.subtract(b);

        //then:
        Vector2d answer = new Vector2d(-90, -180);
        assertEquals(answer, result);
    }

    @Test
    void opposite()
    {
        //given:
        Vector2d a = new Vector2d(1, 2);

        //when:
        Vector2d b = a.opposite();

        //then:
        Vector2d c = new Vector2d(-1, -2);
        assertEquals(c, b);
    }
}