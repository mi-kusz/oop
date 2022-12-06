package agh.ics.oop;

import agh.ics.oop.gui.GuiElementBox;

public interface IMapElement
{
    Vector2d getPosition();

    String getResourceName();

    GuiElementBox getGui();
}