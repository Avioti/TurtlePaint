package com.pluralsight.data;

import com.pluralsight.shapes.Circle;
import com.pluralsight.shapes.Shape;
import com.pluralsight.shapes.Square;
import com.pluralsight.shapes.Triangle;

import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import static com.pluralsight.data.Painting.shapes;
import static com.pluralsight.ui.TurtlePainterApp.turtle;
import static com.pluralsight.ui.TurtlePainterApp.world;

public class SavePainting extends Painting {
    private static final String filePath = "src/main/resources/painting.csv";

    public static void saveToCsv() {
        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
            for (Shape shape : Painting.getShapes()) {
                String firstLine = world.getWidth() + "|" + world.getHeight() + "|" + Color.WHITE;
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
            Painting.clear();
        } catch (Exception e) {
        e.printStackTrace();
        }

    }

    public static Shape loadFromCsv() {
        try{
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            String input;

            while((input = reader.readLine()) != null){
                String[] parts = input.split("\\|");
                if(!parts[0].equals("Circle") && !parts[0].equals("Square") && !parts[0].equals("Triangle")){
                    int width = Integer.parseInt(parts[0]);
                    int height = Integer.parseInt(parts[1]);
                    String background = parts[2];
                    world = new World(width, height);
                }
                switch (parts[0]) {
                    case "Circle" -> {
                        return new Circle(turtle, new Point(Integer.parseInt(parts[1]), Integer.parseInt(parts[2])), parts[3], Integer.parseInt(parts[4]), Integer.parseInt(parts[5]));
                    }
                    case "Square" -> {
                        return new Square(turtle, new Point(Integer.parseInt(parts[1]), Integer.parseInt(parts[2])), parts[3], Integer.parseInt(parts[4]), Integer.parseInt(parts[5]));
                    }
                    case "Triangle" -> {
                        return new Triangle(turtle, new Point(Integer.parseInt(parts[1]), Integer.parseInt(parts[2])), parts[3], Integer.parseInt(parts[4]));
                    }
                }

            }
            reader.close();
            Painting.clear();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
