package com.pluralsight.shapes;

import com.pluralsight.data.Turtle;
import com.pluralsight.ui.utility.Inputs;

import java.awt.*;
import java.util.stream.IntStream;

import static com.pluralsight.ui.TurtlePainterApp.*;

public class Triangle extends Shape{

    public Triangle(Turtle turtle, Point location, String color, int border) {
        super(turtle, location, color, border);
    }

    @Override
   public void paint() {
        turtle = new Turtle(world,-100, -100);
        int width = world.getWidth() / 5;
        int height = world.getHeight() / 5;

        // calculate the hypotenuse (diagonal)
        // a2 + b2 = c2
        double widthSquared = Math.pow(width, 2);
        double heightSquared = Math.pow(height, 2);
        double hypotenuse = Math.sqrt(widthSquared + heightSquared);


        turtle.setPenWidth(border);
        turtle.setColor(Inputs.parseColor(color));
        turtle.penUp();
        turtle.goTo(location);
        turtle.penDown();

        int sides = 3;
        for (int i = 0; i < sides; i++) {
            turtle.turnRight(-120);
            turtle.forward(hypotenuse);
        }
//        IntStream.range(0,sides).forEach(i -> {
//            turtle.turnRight(-120);
//            turtle.forward(hypotenuse);
//        });
        homeScreen();
        handleChoice();

    }
}
