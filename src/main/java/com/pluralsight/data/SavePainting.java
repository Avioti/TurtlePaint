package com.pluralsight.data;

import com.pluralsight.shapes.Circle;
import com.pluralsight.shapes.Shape;
import com.pluralsight.shapes.Square;
import com.pluralsight.shapes.Triangle;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;

import static com.pluralsight.data.Painting.shapes;
import static com.pluralsight.ui.TurtlePainterApp.world;

public class SavePainting extends Painting {
    private static final String filePath = "src/main/resources/painting.csv";

    public static void saveToCsv() {
        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
            for (Shape shape : Painting.getShapes()) {
                String firstLine = world.getWidth() + "|" + world.getHeight() + "|" + world.getBackground();
                writer.write(firstLine);
                writer.newLine();

                if (shape instanceof Circle circle) {
                    String line = "Circle|" + circle.location.x + "|" + circle.location.y + "|" + circle.color + "|" + circle.border + "|" + circle.radius;
                    writer.write(line);
                    writer.newLine();
                }

                if (shape instanceof Square square) {
                    String line = "Square|" + square.location.x + "|" + square.location.y + "|" + square.color + "|" + square.border + "|" + square.sideLength;
                    writer.write(line);
                    writer.newLine();
                }

                if (shape instanceof Triangle triangle) {
                    String line = "Triangle|" + triangle.location.x + "|" + triangle.location.y + "|" + triangle.color + "|" + triangle.border;
                    writer.write(line);
                    writer.newLine();
                }


            }
            writer.close();
        } catch (Exception e) {
        e.printStackTrace();
        }

    }

    public Painting loadFromCsv() {
        return null;
    }
}
