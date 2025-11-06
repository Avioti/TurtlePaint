package com.pluralsight.data;

import com.pluralsight.shapes.Shape;

import java.util.List;

public class Painting {
    List<Shape> shapes;

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    public void clear() {
        shapes.clear();
    }
}
