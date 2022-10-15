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
        assertEquals(northNext, MapDirection.EAST);
        assertEquals(southNext, MapDirection.WEST);
        assertEquals(eastNext, MapDirection.SOUTH);
        assertEquals(westNext, MapDirection.NORTH);
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
        assertEquals(northPrevious, MapDirection.WEST);
        assertEquals(southPrevious, MapDirection.EAST);
        assertEquals(eastPrevious, MapDirection.NORTH);
        assertEquals(westPrevious, MapDirection.SOUTH);
    }
}