package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimulationEngineTest {

    @Test
    void run()
    {
        //given:
        IWorldMap map1 = new RectangularMap(5, 5);
        IWorldMap map2 = new RectangularMap(5, 5);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        MoveDirection[] directions1 = {MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.LEFT};
        MoveDirection[] directions2 = {MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT, MoveDirection.LEFT, MoveDirection.FORWARD, MoveDirection.FORWARD,
        MoveDirection.RIGHT, MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD,
        MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.FORWARD};

        SimulationEngine engine1 = new SimulationEngine(directions1, map1, positions);
        SimulationEngine engine2 = new SimulationEngine(directions2, map2, positions);

        //when:
        engine1.run();
        engine2.run();

        //then:
        Vector2d map1Position1 = new Vector2d(2, 3);
        String map1Orientation1 = "E";
        Vector2d map1Position2 = new Vector2d(3, 3);
        String map1Orientation2 = "W";

        Vector2d map2Position1 = new Vector2d(2, 0);
        String map2Orientation1 = "S";
        Vector2d map2Position2 = new Vector2d(3, 4);
        String map2Orientation2 = "N";

        assertEquals(true, map1.isOccupied(map1Position1));
        assertEquals(true, map1Orientation1.equals(map1.objectAt(map1Position1).toString()));

        assertEquals(true, map1.isOccupied(map1Position2));
        assertEquals(true, map1Orientation2.equals(map1.objectAt(map1Position2).toString()));

        assertEquals(true, map2.isOccupied(map2Position1));
        assertEquals(true, map2Orientation1.equals(map2.objectAt(map2Position1).toString()));

        assertEquals(true, map2.isOccupied(map2Position2));
        assertEquals(true, map2Orientation2.equals(map2.objectAt(map2Position2).toString()));
    }
}