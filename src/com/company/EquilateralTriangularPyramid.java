package com.company;
import java.lang.Math.*;

public class EquilateralTriangularPyramid extends Shapes2D.EquilateralTriangle
        implements Shapes3DPyramid, Shapes3DPrism {
    private double x1, y1, x2, y2, x3, y3;
    private double normalHeight;
    private double slantHeight;
    private double centerOfGravityX, centerOfGravityY;


    public EquilateralTriangularPyramid(double x1, double y1, double x2, double y2,
                                      double x3, double y3, double slantHeight){
        super(x1, y1, x2, y2, x3, y3);
        this.x1 = x1; this.y1 = y1; this.x2 = x2; this.y2 = y2; this.x3 = x3 ; this.y3 = y3;
        this.centerOfGravityX = (x1 + x2 + x3) / 3.0;
        this.centerOfGravityY = (y1 + y2 + y3) / 3.0;
        this.slantHeight = slantHeight;
        this.normalHeight = Math.round(
                Math.sqrt(
                Math.pow(slantHeight, 2.0) -
                        Math.pow(Math.sqrt(Math.pow(
                                getDistance(x1, y1, centerOfGravityX, centerOfGravityY), 2.0) -
                                Math.pow(getDistance(x1, y1, x2, y2) / 2.0, 2.0)), 2.0)) * 1000.0) / 1000.0;
    }


    public double getNHeight(){
        return normalHeight;
    }

    public double getSHeight(){
        return slantHeight;
    }

    @Override
    public double getArea(){
        return Math.round(
                (super.getArea()
                        + 1.0/2.0 * (getDistance(x1, y1, x2, y2) + getDistance(x1, y1, x3, y3) +
                        getDistance(x2, y2, x3, y3)) * slantHeight)
                        * 1000.0) / 1000.0;
    }

    public double getVolume(){
        return Math.round(
                (1.0 / 3.0 * super.getArea() * normalHeight)
                        * 1000.0) / 1000.0;
    }

    @Override
    public String toString(){
        return "Three vertices of its triangular base : V1(" + x1 + ", " + y1 + "), "
                + "V2(" + x2 + ", " + y2 + ") and V3(" + x3 + ", " + y3 + ")\n"
                + "Length of three sides of its triangular base = " + getDistance(x1, y1, x2, y2) + ", " +
                getDistance(x1, y1, x3, y3) + ", " +
                getDistance(x2, y2, x3, y3) + "\n"
                + "TriangularBaseArea = " + super.getArea() + "\n"
                + "Slant Height = " + getSHeight() + "\n"
                + "Normal Height = " + getNHeight() + "\n"
                + "Surface Area = " + getArea() + "\n"
                + "Volume = " + getVolume();
    }
}
