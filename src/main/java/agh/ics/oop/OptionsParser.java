package agh.ics.oop;

public class OptionsParser
{
    public MoveDirection[] parse(String[] input)
    {
        int counter = 0;

        for(String s : input)
        {
            if (s.equals("f") || s.equals("forward")
                    || s.equals("b") || s.equals("backward")
                    || s.equals("r") || s.equals("right")
                    || s.equals("l") || s.equals("left"))
            {
                ++counter;
            }
        }

        MoveDirection[] result = new MoveDirection[counter];
        int i = 0;

        for(String s : input)
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

        return result;
    }
}
