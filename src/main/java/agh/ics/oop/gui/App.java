package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application
{
    private AbstractWorldMap map;
    private Stage primaryStage;
    private SimulationEngine simulationEngine;
    private OptionsParser parser;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        this.primaryStage = primaryStage;
        primaryStage.setScene(visualiseMap());

        primaryStage.show();
    }

    @Override
    public void init() throws Exception
    {
        super.init();
        try
        {
            AbstractWorldMap map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
            parser = new OptionsParser();
            SimulationEngine simulationEngine = new SimulationEngine(map, positions);
            simulationEngine.setGui(this);
            this.simulationEngine = simulationEngine;

            this.map = map;
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    private void go(String input)
    {
        MoveDirection[] moves = parser.parse(input.split(" "));
        simulationEngine.setMoves(moves);

        Thread visualise = new Thread(simulationEngine);
        visualise.start();
    }

    private Scene visualiseMap()
    {
        MapBoundary mapBoundary = map.getBoundary();
        int lowestX = mapBoundary.getBottomLeft().x();
        int lowestY = mapBoundary.getBottomLeft().y();
        int greatestX = mapBoundary.getTopRight().x();
        int greatestY = mapBoundary.getTopRight().y();

        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);

        drawMapElements(gridPane, lowestX, greatestX, lowestY, greatestY);
        drawMapCoordinates(gridPane, lowestX, greatestX, lowestY, greatestY);
        drawTextFieldAndButton(gridPane, lowestX, greatestX, lowestY, greatestY);

        return new Scene(gridPane, 500, 500);
    }

    private void drawMapElements(GridPane gridPane, int lowestX, int greatestX, int lowestY, int greatestY)
    {
        for (int x = lowestX; x <= greatestX; ++x)
        {
            for (int y = lowestY; y <= greatestY; ++y)
            {
                IMapElement mapElement = (IMapElement) map.objectAt(new Vector2d(x, y));

                if (mapElement != null)
                {
                    VBox vBox = mapElement.getGui().getVBox();
                    GridPane.setHalignment(vBox, HPos.CENTER);
                    gridPane.add(vBox, x - lowestX,  greatestY - y);
                }
            }
        }
    }

    private void drawMapCoordinates(GridPane gridPane, int lowestX, int greatestX, int lowestY, int greatestY)
    {
        gridPane.getColumnConstraints().add(new ColumnConstraints(35));
        gridPane.getRowConstraints().add(new RowConstraints(35));

        for (int x = lowestX; x <= greatestX; ++x)
        {
            gridPane.getColumnConstraints().add(new ColumnConstraints(35));

            Label label = new Label(Integer.toString(x));
            GridPane.setHalignment(label, HPos.CENTER);
            gridPane.add(label, x - lowestX, greatestY + 1 - lowestY);
        }

        for (int y = lowestY; y <= greatestY; ++y)
        {
            gridPane.getRowConstraints().add(new RowConstraints(35));

            Label label = new Label(Integer.toString(y));
            GridPane.setHalignment(label, HPos.CENTER);
            gridPane.add(label, greatestX + 1 - lowestX, greatestY - y);
        }
    }

    private void drawTextFieldAndButton(GridPane gridPane, int lowestX, int greatestX, int lowestY, int greatestY)
    {
        TextField textField = new TextField();
        Button button = new Button("Start");
        button.setOnAction(
                new EventHandler<ActionEvent>()
                {
                    @Override
                    public void handle(ActionEvent event)
                    {
                        String text = textField.getText();
                        go(text);
                    }
                }
        );

        gridPane.add(textField, 0, greatestY + 2 - lowestY, greatestX - lowestX, 1);
        gridPane.add(button, greatestX - lowestX, greatestY + 2 - lowestY, 2, 1);
    }
    public void guiChanged()
    {
        Platform.runLater(new Runnable()
                          {
                              @Override
                              public void run()
                              {
                                  Scene scene = visualiseMap();
                                  primaryStage.setScene(scene);
                                  primaryStage.show();
                              }
                          }
        );
    }
}
