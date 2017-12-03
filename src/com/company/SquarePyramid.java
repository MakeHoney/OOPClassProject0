package com.company;
import java.lang.Math.*;

class SquarePyramid extends Shapes2D.Square
        implements Shapes3DPyramid, Shapes3DPrism {
    private double x1, y1, x2, y2;
    private double normalHeight;
    private double slantHeight;

    public SquarePyramid(double x1, double y1, double x2, double y2,
                       double slantHeight) {
        super(x1, y1, x2, y2);
        this.x1 = x1; this.y1 = y1; this.x2 = x2; this.y2 = y2;
        this.slantHeight = slantHeight;
        this.normalHeight = Math.round(
                Math.sqrt(
                Math.pow(slantHeight, 2.0) - Math.pow(getDistance(x2, y2, x1, y2) / 2.0, 2.0))
        * 1000.0) / 1000.0;
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
                        + 1.0/2.0 * getDistance(x2, y2, x1, y2) * 4.0 * slantHeight)
                        * 1000.0) / 1000.0;
    }

    public double getVolume(){
        return Math.round(
                (1.0 / 3.0 * super.getArea() * normalHeight)
                        * 1000.0) / 1000.0;
    }

    @Override
    public String toString(){
        return "Upper left vertex of its rectangular base : UL(" + x1 + ", " + y1 + ")\n"
                + "Lower right vertex of its rectangular base : LR(" + x2 + ", " + y2 + ")\n"
                + "length / width  of its rectangular base = " + getDistance(x2, y2, x1, y2) +
                " / " + getDistance(x1, y1, x1, y2) + "\n" // ??????
                + "SquareBaseArea = " + super.getArea() + "\n"
                + "Slant Height = " + getSHeight() + "\n"
                + "Normal Height = " + getNHeight() + "\n"
                + "Surface Area = " + getArea() + "\n"
                + "Volume = " + getVolume();
    }
}
