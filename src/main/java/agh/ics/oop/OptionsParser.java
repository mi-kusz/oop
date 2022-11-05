package agh.ics.oop;

import java.util.Arrays;

public class OptionsParser
{
    public MoveDirection[] parse(String[] input)
    {
        MoveDirection[] result = new MoveDirection[input.length];
        int i = 0;

        for (String s : input)
        {
            result[i] = switch(s)
            {
                case "f", "forward" -> MoveDirection.FORWARD;
                case "b", "backward" -> MoveDirection.BACKWARD;
                case "r", "right" -> MoveDirection.RIGHT;
                case "l", "left" -> MoveDirection.LEFT;
                default -> null;
            };

            if (result[i] != null)
            {
                ++i;
            }
        }

        return Arrays.copyOfRange(result, 0, i);
    }
}
