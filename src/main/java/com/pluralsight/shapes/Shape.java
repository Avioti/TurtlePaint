package com.pluralsight.shapes;

import com.pluralsight.data.Turtle;

import java.awt.*;

public abstract class Shape {
    public Turtle turtle;
    public Point location;
    public String color;
    public int border;

    public Shape(Turtle turtle, Point location, String color, int border) {
        this.turtle = turtle;
        this.location = location;
        this.color = color;
        this.border = border;
    }

    abstract void paint();

    @Override
    public String toString() {
        return "Shape{" +
                "turtle=" + turtle +
                ", location=" + location +
                ", color='" + color + '\'' +
                ", border=" + border +
                '}';
    }
}
