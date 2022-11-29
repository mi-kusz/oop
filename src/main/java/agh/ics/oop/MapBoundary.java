package agh.ics.oop;

import java.util.HashSet;
import java.util.TreeMap;

public class MapBoundary implements IMapBoundaryListener
{
    private Vector2d topRight;
    private Vector2d bottomLeft;
    private final AbstractWorldMap map;
    private final TreeMap<Vector2d, HashSet<IMapElement>> elementsXSorted;
    private final TreeMap<Vector2d, HashSet<IMapElement>> elementsYSorted;

    MapBoundary(AbstractWorldMap map)
    {
        this.map = map;
        topRight = map.calculateTopRight();
        bottomLeft = map.calculateBottomLeft();
        elementsXSorted = new TreeMap<>(new MapElementXComparator());
        elementsYSorted = new TreeMap<>(new MapElementYComparator());
    }

    @Override
    public void notifyMapBoundary (Vector2d oldPosition, Vector2d newPosition, IMapElement element)
    {
        if (oldPosition != null)
        {
            deleteElement(oldPosition, element);
        }

        addElement(newPosition, element);

        int lowestX = elementsXSorted.firstKey().x();
        int lowestY = elementsYSorted.firstKey().y();
        int greatestX = elementsXSorted.lastKey().x();
        int greatestY = elementsYSorted.lastKey().y();

        topRight = new Vector2d(greatestX, greatestY);
        bottomLeft = new Vector2d(lowestX, lowestY);
    }

    public Vector2d getTopRight()
    {
        return topRight;
    }

    public Vector2d getBottomLeft()
    {
        return bottomLeft;
    }

    private void addElement(Vector2d position, IMapElement element)
    {
        if (!elementsXSorted.containsKey(position))
        {
            elementsXSorted.put(position, new HashSet<>());
            elementsYSorted.put(position, new HashSet<>());
        }

        elementsXSorted.get(position).add(element);
        elementsYSorted.get(position).add(element);
    }

    private void deleteElement(Vector2d position, IMapElement element)
    {
        elementsXSorted.get(position).remove(element);
        elementsYSorted.get(position).remove(element);

        if (elementsXSorted.get(position).size() == 0)
        {
            elementsXSorted.remove(position);
            elementsYSorted.remove(position);
        }
    }
}