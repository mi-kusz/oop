package agh.ics.oop.gui;

import agh.ics.oop.IMapElement;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.IOException;

public class GuiElementBox implements IMapGuiStateChanged
{
    private IMapElement element;
    private ImageView imageView;
    private Label label;
    private VBox vBox;

    public GuiElementBox(IMapElement element)
    {
        this.element = element;

        readImage();
        readPosition();
        setVBox();
    }

    private void readImage()
    {
        try (FileInputStream stream = new FileInputStream(element.getResourceName()))
        {
            Image image = new Image(stream);

            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(20);
            imageView.setFitHeight(20);

            this.imageView = imageView;
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    private void readPosition()
    {
        Label label = new Label(element.getPosition().toString());
        this.label = label;
    }

    private void setVBox()
    {
        VBox vBox = new VBox();
        vBox.getChildren().addAll(imageView, label);
        vBox.setAlignment(Pos.CENTER);

        this.vBox = vBox;
    }

    public VBox getVBox()
    {
        setVBox();
        return vBox;
    }

    @Override
    public void positionChanged()
    {
        readPosition();
    }

    @Override
    public void directionChanged()
    {
        readImage();
    }
}
