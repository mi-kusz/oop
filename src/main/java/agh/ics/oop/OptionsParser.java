package agh.ics.oop;

public class OptionsParser
{
    public MoveDirection[] parse(String[] input)
    {
        MoveDirection[] result = new MoveDirection[input.length];

        for (int i = 0; i < input.length; ++i)
        {
            result[i] = switch(input[i])
            {
                case "f", "forward" -> MoveDirection.FORWARD;
                case "b", "backward" -> MoveDirection.BACKWARD;
                case "r", "right" -> MoveDirection.RIGHT;
                case "l", "left" -> MoveDirection.LEFT;
                default -> throw new IllegalArgumentException(input[i] + " is not legal move specification");
            };
        }

        return result;
    }
}
