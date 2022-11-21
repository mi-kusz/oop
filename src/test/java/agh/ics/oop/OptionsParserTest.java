package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptionsParserTest {

    @Test
    void parse()
    {
        //given:
        String[] charactersArray = {"f", "backward", "r", "left", "sasda", "aasd", "right", "f", "fasdas", "b"};

        //when:
        boolean exceptionHappened = false;
        try
        {
            MoveDirection[] result = new OptionsParser().parse(charactersArray);
        }
        catch(IllegalArgumentException e)
        {
            exceptionHappened = true;
        }

        //then:
        assertEquals(true, exceptionHappened);
    }
}