package com.pluralsight.ui;

import com.pluralsight.data.Painting;
import com.pluralsight.data.SavePainting;
import com.pluralsight.data.Turtle;
import com.pluralsight.data.World;
import com.pluralsight.shapes.Circle;
import com.pluralsight.shapes.Shape;
import com.pluralsight.shapes.Square;
import com.pluralsight.shapes.Triangle;
import com.pluralsight.ui.utility.Inputs;

import java.awt.*;
import java.util.Scanner;



public class TurtlePainterApp extends Painting{
    public static Turtle turtle;
    public static World world;
    public static final Scanner scanner = new Scanner(System.in);

    public static void run() {
        welcomeScreen();
        homeScreen();
        handleChoice();
    }

    public static void welcomeScreen() {
        System.out.println("Welcome to Turtle Painter!");
        promptCanvasSize();
    }

    public static void homeScreen() {
        System.out.println();
        System.out.println("1. Add Shape");
        System.out.println("2. Save Image");
        System.out.println("3. Load Saved Images");
        System.out.println("4. Exit");
    }


    public static void promptCanvasSize() {
        System.out.println();
        System.out.println("Canvas width");
        int width = Inputs.promptForInt();
        System.out.println();
        System.out.println("Canvas height");
        int height = Inputs.promptForInt();
        world = new World(width, height);

    }


    public static void handleChoice() {
        int choice = Inputs.promptForInt();
        switch (choice){
            case 1 -> addShapeFlow();
            case 2 -> saveImage();
            case 3 -> loadImage();
            case 4 -> exit();
            default -> {
                System.out.println("Invalid choice. Please try again.");
                homeScreen();
                handleChoice();
            }
        }
    }

    public static void addShapeFlow() {
        Inputs.promptForShapeType();
        int choice = Inputs.promptForInt();
        switch (choice){
            case 1 -> {
               circleImage();
            }
            case 2 -> {
              squareImage();
            }
            case 3 -> {
                triangleImage();

            }
            case 4 -> {
                homeScreen();
                handleChoice();
            }
            default -> {
                System.out.println("Invalid choice. Please try again.");
                addShapeFlow();
            }
        }

    }




    public static void circleImage() {
        System.out.println("What is Radius?");
        int radius = Inputs.promptForInt();
        int border = Inputs.promptForBorderWidth();
        String color = Inputs.promptForColor();
        Point location = Inputs.promptForPoint();
        Circle circle = new Circle(turtle, location, color, border, radius);
        Painting.addShape(circle);
        circle.paint();
    }


    public static void squareImage() {
        int border = Inputs.promptForBorderWidth();
        String color = Inputs.promptForColor();
        Point location = Inputs.promptForPoint();
        System.out.println("What is Side Length?");
        int sideLength = Inputs.promptForInt();
        Square square = new Square(turtle, location, color, border,sideLength);
        Painting.addShape(square);
        square.paint();
    }

    public static void triangleImage() {
        int border = Inputs.promptForBorderWidth();
        String color = Inputs.promptForColor();
        Point location = Inputs.promptForPoint();
        Triangle triangle = new Triangle(turtle, location, color, border);
        Painting.addShape(triangle);
        triangle.paint();
    }

    public static void saveImage() {
        if(Painting.shapes.isEmpty()) {
            System.out.println("No shapes to save. Please add shapes before saving.");
            homeScreen();
            handleChoice();
            return;
        }
        SavePainting.saveToCsv();
        System.out.println("Image saved successfully!");
        homeScreen();
        handleChoice();
    }



    public static void loadImage() {
        SavePainting.loadFromCsv();
        Shape c = savedCircle;
        Shape s = savedSquare;
        Shape t = savedTriangle;
        if(c instanceof Circle circle){
            circle.paint();
            turtle.setDelay(25);
        } if (s instanceof Square square) {
            square.paint();
            turtle.setDelay(25);
        }if (t instanceof Triangle triangle) {
            triangle.paint();
        }
    }

    public static void exit() {
        System.out.println("Thank you for using Turtle Painter!");
        System.exit(0);

    }

}
