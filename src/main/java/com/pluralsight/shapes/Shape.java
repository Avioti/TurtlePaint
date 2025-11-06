package com.pluralsight.shapes;

import com.pluralsight.data.Turtle;

import java.awt.*;

public abstract class Shape {
    Turtle turtle;
    Point location;
    String color;
    int border;

    abstract void paint();
}
