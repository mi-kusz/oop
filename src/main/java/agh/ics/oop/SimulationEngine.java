package agh.ics.oop;

public class SimulationEngine implements IEngine
{
    private MoveDirection[] moves;
    private IWorldMap map;
    private Animal[] animals;

    public SimulationEngine(MoveDirection[] moves, AbstractWorldMap map, Vector2d[] positions)
    {
        this.moves = moves;
        this.map = map;

        animals = new Animal[positions.length];

        for (int i = 0; i < positions.length; ++i)
        {
            animals[i] = new Animal(map, positions[i]);
            animals[i].addObserver(map);
            map.place(animals[i]);
        }
    }

    @Override
    public void run()
    {
        for (int i = 0; i < moves.length; ++i)
        {
            animals[i % animals.length].move(moves[i]);
        }
    }
}
