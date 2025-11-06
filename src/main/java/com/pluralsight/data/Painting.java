package com.pluralsight.data;

import com.pluralsight.shapes.Shape;

import java.util.ArrayList;
import java.util.List;

public class Painting {
    protected static List<Shape> shapes = new ArrayList<>();

    public static void addShape(Shape shape) {
        shapes.add(shape);
    }

    public static List<Shape> getShapes() {
        return shapes;
    }

    public static void clear() {
        shapes.clear();
    }
}
