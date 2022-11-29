package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application
{
    private AbstractWorldMap map;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Scene scene = visualiseMap(this.map);

        primaryStage.setScene(scene);

        primaryStage.show();
    }

    @Override
    public void init() throws Exception
    {
        super.init();
        try
        {
            String[] args = getParameters().getRaw().toArray(String[]::new);
            MoveDirection[] directions = new OptionsParser().parse(args);
            AbstractWorldMap map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
            this.map = map;
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    private Scene visualiseMap(AbstractWorldMap map)
    {
        MapBoundary mapBoundary = map.getBoundary();
        int lowestX = mapBoundary.getBottomLeft().x();
        int lowestY = mapBoundary.getBottomLeft().y();
        int greatestX = mapBoundary.getTopRight().x();
        int greatestY = mapBoundary.getTopRight().y();

        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);

        for (int x = lowestX; x <= greatestX; ++x)
        {
            gridPane.getColumnConstraints().add(new ColumnConstraints(20));
            for (int y = lowestY; y <= greatestY; ++y)
            {
                IMapElement mapElement = (IMapElement) map.objectAt(new Vector2d(x, y));

                if (mapElement != null)
                {
                    Label label = new Label(mapElement.toString());
                    GridPane.setHalignment(label, HPos.CENTER);
                    gridPane.add(label, x - lowestX,  greatestY - y);
                }
            }
        }

        gridPane.getColumnConstraints().add(new ColumnConstraints(20));

        for (int x = lowestX; x <= greatestX; ++x)
        {
            Label label = new Label(Integer.toString(x));
            GridPane.setHalignment(label, HPos.CENTER);
            gridPane.add(label, x - lowestX, greatestY + 1 - lowestY);
        }

        for (int y = lowestY; y <= greatestY; ++y)
        {
            Label label = new Label(Integer.toString(y));
            GridPane.setHalignment(label, HPos.CENTER);
            gridPane.add(label, greatestX + 1 - lowestX, greatestY - y);
        }

        return new Scene(gridPane, 400, 400);
    }
}
