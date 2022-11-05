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
        MoveDirection[] result = new OptionsParser().parse(charactersArray);

        //then:
        MoveDirection[] answer = {MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.RIGHT,
                MoveDirection.LEFT, MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.BACKWARD};

        assertArrayEquals(answer, result);
    }
}