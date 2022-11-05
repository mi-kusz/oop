package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapDirectionTest {

    @Test
    void next()
    {
        //given:
        MapDirection north = MapDirection.NORTH;
        MapDirection south = MapDirection.SOUTH;
        MapDirection east = MapDirection.EAST;
        MapDirection west = MapDirection.WEST;

        //when:
        MapDirection northNext = north.next();
        MapDirection southNext = south.next();
        MapDirection eastNext = east.next();
        MapDirection westNext = west.next();

        //then:
        assertEquals(MapDirection.EAST, northNext);
        assertEquals(MapDirection.WEST, southNext);
        assertEquals(MapDirection.SOUTH, eastNext);
        assertEquals(MapDirection.NORTH, westNext);
    }

    @Test
    void previous()
    {
        //given:
        MapDirection north = MapDirection.NORTH;
        MapDirection south = MapDirection.SOUTH;
        MapDirection east = MapDirection.EAST;
        MapDirection west = MapDirection.WEST;

        //when:
        MapDirection northPrevious = north.previous();
        MapDirection southPrevious = south.previous();
        MapDirection eastPrevious = east.previous();
        MapDirection westPrevious = west.previous();

        //then:
        assertEquals(MapDirection.WEST, northPrevious);
        assertEquals(MapDirection.EAST, southPrevious);
        assertEquals(MapDirection.NORTH, eastPrevious);
        assertEquals(MapDirection.SOUTH, westPrevious);
    }
}