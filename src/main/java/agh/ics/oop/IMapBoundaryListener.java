package agh.ics.oop;

public interface IMapBoundaryListener
{
    void notifyMapBoundary(Vector2d oldPosition, Vector2d newPosition, IMapElement element);
}
