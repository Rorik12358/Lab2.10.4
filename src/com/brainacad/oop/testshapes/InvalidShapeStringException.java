package com.brainacad.oop.testshapes;

/**
 * Created by R2-D2 on 08.03.2016.
 */
public class InvalidShapeStringException extends Exception {
    public InvalidShapeStringException() {
        super("new ShapeException");     //very bad message. You can avoid of using any constructor
    }
}
