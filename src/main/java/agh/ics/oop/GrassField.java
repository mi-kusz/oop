package agh.ics.oop;

import java.util.*;

public class GrassField extends AbstractWorldMap
{
    private final Map<Vector2d, Grass> grasses;

    public GrassField(int amount)
    {
        bottomLeft = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
        topRight = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);

        animals = new HashMap<>();
        grasses = new HashMap<>();
        addGrass(amount);

        visualiser = new MapVisualiser(this);
    }

    private int[] shuffle(int amount, int size)
    {
        Random random = new Random();

        int[] positions = new int[size * size];

        for (int i = 0; i < positions.length; ++i)
        {
            positions[i] = i;
        }

        for (int i = 0; i < positions.length; ++i)
        {
            int newIndex = random.nextInt(positions.length);

            int tmp = positions[newIndex];
            positions[newIndex] = positions[i];
            positions[i] = tmp;
        }

        return Arrays.copyOfRange(positions, 0, amount);
    }

    private void addGrass(int n)
    {
        int size = (int) Math.ceil(Math.sqrt(n * 10));

        int[] results = shuffle(n, size);

        for (int a : results)
        {
            int x = a / size;
            int y = a % size;

            Vector2d pos = new Vector2d(x, y);
            Grass grass = new Grass(pos);

            grasses.put(pos, grass);
        }
    }

    private boolean grassOccupies(Vector2d position)
    {
        Grass grass = grasses.get(position);

        return grass != null;
    }

    @Override
    public boolean canMoveTo(Vector2d position)
    {
        return !animalOccupies(position);
    }

    @Override
    public void place(Animal animal)
    {
        if (animalOccupies(animal.position()))
        {
            throw new IllegalArgumentException(animal.position() + " is already taken");
        }
        else
        {
            animals.put(animal.position(), animal);
        }
    }

    @Override
    public boolean isOccupied(Vector2d position)
    {
        return animalOccupies(position) || grassOccupies(position);
    }

    @Override
    public Object objectAt(Vector2d position)
    {
        Object animal = super.objectAt(position);

        if (animal != null)
        {
            return animal;
        }
        else
        {
            return grasses.get(position);
        }
    }

    @Override
    protected Vector2d calculateTopRight()
    {
        int top = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;

        for (Vector2d p : animals.keySet())
        {
            top = Math.max(top, p.y());
            right = Math.max(right, p.x());
        }

        for (Vector2d p : grasses.keySet())
        {
            top = Math.max(top, p.y());
            right = Math.max(right, p.x());
        }

        return new Vector2d(right, top);
    }

    @Override
    protected Vector2d calculateBottomLeft()
    {
        int bottom = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;

        for (Vector2d p : animals.keySet())
        {
            bottom = Math.min(bottom, p.y());
            left = Math.min(left, p.x());
        }

        for (Vector2d p : grasses.keySet())
        {
            bottom = Math.min(bottom, p.y());
            left = Math.min(left, p.x());
        }

        return new Vector2d(left, bottom);
    }
}
