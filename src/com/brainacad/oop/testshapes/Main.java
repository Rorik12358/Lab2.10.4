package com.brainacad.oop.testshapes;

import java.util.Arrays;

/**
 * Created by R2-D2 on 28.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle("Green",10);
        System.out.println(circle);
        System.out.println("Shape area is: "+circle.calcArea());
        Rectangle rectangle = new Rectangle("red", 11, 22);
        System.out.println(rectangle);
        System.out.println("Shape area is: "+rectangle.calcArea());
        Triangle triangle = new Triangle("BlacK", 5, 5, 5);
        System.out.println(triangle);
        System.out.println("Shape area is: " + triangle.calcArea());

        Shape[] arr = {rectangle, new Rectangle("yellow", 11, 7), new Rectangle("yellow", 8, 7), new Rectangle("pink", 112, 7), new Rectangle("brown", 11, 7), circle, new Circle("blue", 5),
                triangle, new Triangle("grey", 11, 5, 7)};
        double sumArea = 0;
        double sumRectArea = 0;
        double sumTriangleArea = 0;
        double sumCircleArea = 0;
        for (Shape shapeElem : arr) {
            double area = shapeElem.calcArea();
            System.out.println(shapeElem.toString() + ", area is: " + area);
            sumArea += area;
            if (shapeElem instanceof Rectangle) sumRectArea += area;
            if (shapeElem instanceof Triangle) sumTriangleArea += area;
            if (shapeElem instanceof Circle) sumCircleArea += area;
        }
//        Rectangles total area: 234.54
//        Circle total area: 547.231
//        Triangle total area: 356.56
        System.out.println("Rectangles total area: " + sumRectArea);
        System.out.println("Circle total area: " + sumCircleArea);
        System.out.println("Triangle  total area: " + sumTriangleArea);
        System.out.println("total area of shapes: " + sumArea);
        for(Drawable drawable:arr){
            drawable.draw();
        }

        Rectangle rectangle1 = new Rectangle("black" ,12.15, 445.11);
        Rectangle rectangle2 = new Rectangle("black" ,119.15, 800.11);
        System.out.println(rectangle1.compareTo(rectangle2));

        Rectangle arr2[] = {rectangle, rectangle1, rectangle2, new Rectangle("brown", 144.1, 908), new Rectangle("pink", 1024.22, 10), new Rectangle("indigo", 0.5, 1000233.15)};
        Arrays.sort(arr2);
        for (Drawable draw:arr2){
            draw.draw();
        }
        System.out.println();
        System.out.println("Lab 2.10.4:");
        //Lab 2.10.4
        try {
            Rectangle rectangle2_10_4 = (Rectangle) Shape.parseShape("Rectangle:RED:10,20");
            System.out.println(rectangle2_10_4);
        } catch (InvalidShapeStringException e) {
            e.printStackTrace();
        }
        try {
            Triangle triangle2_10_4 = (Triangle) Shape.parseShape("Triangle:YELLOW:12,55,12");
            System.out.println(triangle2_10_4);
        } catch (InvalidShapeStringException e) {
            e.printStackTrace();
        }
        try {
            Circle circle2_10_4 = (Circle) Shape.parseShape("Circle:BLACK:29");
            System.out.println(circle2_10_4);
        } catch (InvalidShapeStringException e) {
            e.printStackTrace();
        }
    }
}
