package com.pluralsight.shapes;

import com.pluralsight.data.Turtle;
import com.pluralsight.ui.utility.Inputs;

import java.awt.*;

import static com.pluralsight.ui.TurtlePainterApp.*;

public class Square extends Shape {
    public int sideLength;

    public Square(Turtle turtle, Point location, String color, int border, int sideLength) {
        super(turtle, location, color, border);
        this.sideLength = sideLength;
    }

    @Override
    public void paint() {
        turtle = new Turtle(world, -100, -100);
        turtle.setPenWidth(border);
        turtle.setColor(Inputs.parseColor(color));
        turtle.penUp();
        turtle.goTo(location);
        turtle.penDown();
        int sides = 4;
        for (int i = 0; i < sides; i++) {
            turtle.forward(sideLength);
            turtle.turnRight(90);
        }
        homeScreen();
        handleChoice();

    }

    @Override
    public String toString() {
        return "Square{" +
                "sideLength=" + sideLength +
                ", turtle=" + turtle +
                ", location=" + location +
                ", color='" + color + '\'' +
                ", border=" + border +
                '}';
    }
}
