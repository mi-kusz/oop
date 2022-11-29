package agh.ics.oop;

import java.util.Comparator;

public class MapElementXComparator implements Comparator<Vector2d>
{
    @Override
    public int compare(Vector2d o1, Vector2d o2)
    {
        int x1 = o1.x();
        int x2 = o2.x();
        int y1 = o1.y();
        int y2 = o2.y();

        if (x1 < x2)
        {
            return -1;
        }
        else if (x1 == x2)
        {
            if (y1 < y2)
            {
                return -1;
            }
            else if (y2 < y1)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
        else
        {
            return 1;
        }
    }
}
