package com.brainacad.oop.testshapes;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by R2-D2 on 28.02.2016.
 */
public abstract class Shape implements Drawable {
    private String shapeColor;

    public Shape(String shapeColor) {
        this.shapeColor = shapeColor.toUpperCase();
    }

    //Lab 2.10.4
    public static Shape parseShape(String shapeInput) throws InvalidShapeStringException {
        String regex = "(Rectangle|Triangle|Circle):[A-Z]+:([1-9]\\d*,)*[1-9]\\d*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(shapeInput);
        if (!matcher.matches()) throw new InvalidShapeStringException();
        StringTokenizer stringTokenizer = new StringTokenizer(shapeInput, " ,:");
        String shape = stringTokenizer.nextToken();
        if (shape.equals("Rectangle")) {
            String color = stringTokenizer.nextToken();
            double width = Double.parseDouble(stringTokenizer.nextToken()); // concatenated lines
            double height = Double.parseDouble(stringTokenizer.nextToken()); // concatenated lines
            // Проверяем нет ли лишних параметров
            if (stringTokenizer.hasMoreTokens()) throw new InvalidShapeStringException();
            return new Rectangle(color, width, height);
        }
        if (shape.equals("Triangle")) {
            String color = stringTokenizer.nextToken();
            double a = Double.parseDouble(stringTokenizer.nextToken()); // concatenated lines
            double b = Double.parseDouble(stringTokenizer.nextToken()); // concatenated lines
            double c = Double.parseDouble(stringTokenizer.nextToken()); // concatenated lines
            // Проверяем нет ли лишних параметров
            if (stringTokenizer.hasMoreTokens()) throw new InvalidShapeStringException();
            return new Triangle(color, a, b, c);
        } else {
            String color = stringTokenizer.nextToken();
            double radius = Double.parseDouble(stringTokenizer.nextToken()); // concatenated lines
            // Проверяем нет ли лишних параметров
            if (stringTokenizer.hasMoreTokens()){ 
                throw new InvalidShapeStringException();
            }
            return new Circle(color, radius);
        }
    }

    @Override
    public String toString() {
        return "Shape, color is: " + shapeColor;
    }

    public abstract double calcArea();

    public String getShapeColor() {
        return shapeColor;
    }
}
