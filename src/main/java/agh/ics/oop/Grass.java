package agh.ics.oop;

import agh.ics.oop.gui.GuiElementBox;

import java.util.Objects;

public class Grass implements IMapElement
{
    private Vector2d position;
    private GuiElementBox gui;

    public Grass(Vector2d pos)
    {
        position = pos;
        gui = new GuiElementBox(this);
    }

    public Vector2d getPosition()
    {
        return position;
    }

    @Override
    public String toString()
    {
        return "*";
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grass grass = (Grass) o;
        return position.equals(grass.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public String getResourceName()
    {
        return "src/main/resources/grass.png";
    }
    @Override
    public GuiElementBox getGui()
    {
        return gui;
    }
}
