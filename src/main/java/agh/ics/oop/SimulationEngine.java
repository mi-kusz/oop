package agh.ics.oop;

import agh.ics.oop.gui.App;

public class SimulationEngine implements IEngine, Runnable
{
    private MoveDirection[] moves;
    private IWorldMap map;
    private Animal[] animals;
    private App gui;

    private int moveDelay;

    public SimulationEngine(AbstractWorldMap map, Vector2d[] positions)
    {
        moveDelay = 1000;
        this.map = map;

        animals = new Animal[positions.length];

        for (int i = 0; i < positions.length; ++i)
        {
            animals[i] = new Animal(map, positions[i]);
            animals[i].addObserver(map);
            map.place(animals[i]);
        }
    }

    public void setMoves(MoveDirection[] moves)
    {
        this.moves = moves;
    }

    @Override
    public void run()
    {
        for (int i = 0; i < moves.length; ++i)
        {
            try
            {
                Thread.sleep(moveDelay);
            }
            catch (InterruptedException e)
            {
                System.out.println("Przerywanie symulacji");
                System.exit(2);
            }

            animals[i % animals.length].move(moves[i]);
            notifyGui();
        }
    }

    public void setGui(App app)
    {
        this.gui = app;
    }

    private void notifyGui()
    {
        gui.guiChanged();
    }
}
