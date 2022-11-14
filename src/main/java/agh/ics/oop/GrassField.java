package agh.ics.oop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GrassField extends AbstractWorldMap
{
    private final List<Grass> grasses;

    public GrassField(int amount)
    {
        bottomLeft = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
        topRight = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);

        animals = new ArrayList<>();
        grasses = new ArrayList<>(amount);
        addGrass(amount);
    }

    private int[] shuffle(int amount, int size)
    {
        Random r = new Random();

        int[] positions = new int[size * size];

        for (int i = 0; i < positions.length; ++i)
        {
            positions[i] = i;
        }

        for (int i = 0; i < positions.length; ++i)
        {
            int newIndex = r.nextInt(positions.length);

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

            grasses.add(new Grass(new Vector2d(x, y)));
        }
    }

    private boolean grassOccupies(Vector2d position)
    {
        for (Grass g : grasses)
        {
            if (g.getPosition().equals(position))
            {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean canMoveTo(Vector2d position)
    {
        return !isOccupied(position) || !super.isOccupied(position);
    }

    @Override
    public boolean place(Animal animal)
    {
        Vector2d p = animal.position();

        if (isOccupied(p) && !grassOccupies(p))
        {
            return false;
        }

        animals.add(animal);
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position)
    {
        return super.isOccupied(position) || grassOccupies(position);
    }

    @Override
    public Object objectAt(Vector2d position)
    {
        Object animal = super.objectAt(position);

        if (animal != null)
        {
            return animal;
        }

        for (Grass g : grasses)
        {
            if (g.getPosition().equals(position))
            {
                return g;
            }
        }

        return null;
    }

    @Override
    protected Vector2d calculateTopRight()
    {
        int top = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;

        for (Animal a : animals)
        {
            Vector2d p = a.position();

            top = Math.max(top, p.y());
            right = Math.max(right, p.x());
        }

        for (Grass g : grasses)
        {
            Vector2d p = g.getPosition();

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

        for (Animal a : animals)
        {
            Vector2d p = a.position();

            bottom = Math.min(bottom, p.y());
            left = Math.min(left, p.x());
        }

        for (Grass g : grasses)
        {
            Vector2d p = g.getPosition();

            bottom = Math.min(bottom, p.y());
            left = Math.min(left, p.x());
        }

        return new Vector2d(left, bottom);
    }
}
