package com.company;

import java.lang.Math.*;

interface Shapes2D {
    double getDistance(double x1, double y1, double x2, double y2);
    double getArea();



    class Circle implements Shapes2D{
        private double x1, y1, x2, y2;

        Circle(double x1, double y1, double x2, double y2){
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        public double getDistance(double x1, double y1, double x2, double y2){
            return Math.round(Math.sqrt(Math.pow(x1 - x2, 2.0) + Math.pow(y1 - y2, 2.0)) * 1000.0) / 1000.0;
        }
        public double getArea(){
            return Math.round(Math.PI * Math.pow(getDistance(x1, y1, x2, y2), 2) * 1000.0) / 1000.0;
        }

        @Override
        public String toString(){
            return "Center: C(" + x1 + ", " + y1 + ")\n"
                    + "Point on boundary: B(" + x2 + ", " + y2 + ")\n"
                    + "radius = " + getDistance(x1, y1, x2, y2) + "\n"
                    + "CircularBaseArea = " + getArea() + "\n";
        }

    }

    class EquilateralTriangle implements Shapes2D{
        private double x1, y1, x2, y2, x3, y3;
        private double a, b, c, d;

        EquilateralTriangle(double x1, double y1, double x2,
                                   double y2, double x3, double y3){
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.x3 = x3;
            this.y3 = y3;
            a = x1 - x2;
            b = y1 - y2;
            c = x3 - x2;
            d = y3 - y2;
        }

        public double getDistance(double x1, double y1, double x2, double y2){
            return Math.round(Math.sqrt(Math.pow(x1 - x2, 2.0) + Math.pow(y1 - y2, 2.0)) * 100.0) / 100.0;
        }

        public double getArea(){
            return Math.round((Math.abs(a*d - b*c) * 1/2) * 1000.0) / 1000.0;
        }

        @Override
        public String toString(){
            return "Three vertices: V1(" + x1 + ", " + y1 + "), "
                    + "V2(" + x2 + ", " + y2 + ") and V3(" + x3 + ", " + y3 + ")\n"
                    + "Length of three sides = " + getDistance(x1, y1, x2, y2) + ", " +
                    getDistance(x1, y1, x3, y3) + ", " +
                    getDistance(x2, y2, x3, y3) + "\n"
                    + "TriangularBaseArea = " + getArea() + "\n";
        }
    }

    class Square implements Shapes2D{
        private double x1, y1, x2, y2;
        private double a, b;

        Square(double x1, double y1, double x2, double y2){
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            a = x2 - x1;
            b = y1 - y2;
        }

        public double getDistance(double x1, double y1, double x2, double y2){
            return Math.round(Math.sqrt(Math.pow(x1 - x2, 2.0) + Math.pow(y1 - y2, 2.0)) * 1000.0) / 1000.0;
        }
        public double getArea(){
            return Math.round(Math.abs(a * b) * 1000.0) / 1000.0;
        }

        @Override
        public String toString(){
            return "Upper left vertex: UL(" + x1 + ", " + y1 + ")\n"
                    + "Lower right vertex: LR(" + x2 + ", " + y2 + ")\n"
                    + "length / width = " + getDistance(x2, y2, x1, y2) +
                    " / " + getDistance(x1, y1, x1, y2) + "\n"
                    + "SquareBaseArea = " + getArea() + "\n";
        }

    }

}
