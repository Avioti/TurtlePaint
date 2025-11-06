package com.pluralsight.shapes;

import com.pluralsight.data.Turtle;
import com.pluralsight.ui.utility.Inputs;

import java.awt.*;
import java.util.stream.IntStream;

import static com.pluralsight.ui.TurtlePainterApp.*;

public class Circle extends Shape{
    public int radius;

    public Circle(Turtle turtle, Point location, String color, int border, int radius) {
        super(turtle, location, color, border);
        this.radius = radius;
    }

    @Override
    public void paint() {
        turtle = new Turtle(world,-100, -100);
        turtle.setPenWidth(border);
        turtle.setColor(Inputs.parseColor(color));
        turtle.penUp();
        turtle.goTo(location);
        turtle.penDown();
        int sides = 60;
        double sideLength = (2 * Math.PI * radius) / sides;
        for(int i = 0; i < sides; i++) {
            turtle.forward(sideLength);
            turtle.turnRight(6);
        }
//        IntStream.range(0, sides).forEach(i -> {
//            turtle.forward(sideLength);
//            turtle.turnRight(6);
//        });
        homeScreen();
        handleChoice();
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", turtle=" + turtle +
                ", location=" + location +
                ", color='" + color + '\'' +
                ", border=" + border +
                '}';
    }
}
