package com.company;
import java.lang.Math.*;

public class EquilateralTriangularPrism extends Shapes2D.EquilateralTriangle
        implements Shapes3DPrism {
    private double x1, y1, x2, y2, x3, y3;
    private double normalHeight;


    public EquilateralTriangularPrism(double x1, double y1, double x2, double y2,
                                      double x3, double y3, double normalHeight){
        super(x1, y1, x2, y2, x3, y3);
        this.x1 = x1; this.y1 = y1; this.x2 = x2; this.y2 = y2; this.x3 = x3 ; this.y3 = y3;
        this.normalHeight = normalHeight;
    }

    public double getNHeight(){
        return 0;
    }

    @Override
    public double getArea(){
        return Math.round(
                (2.0 * super.getArea()
                + (getDistance(x1, y1, x2, y2) + getDistance(x1, y1, x3, y3) +
                getDistance(x2, y2, x3, y3)) * normalHeight)
                        * 1000.0) / 1000.0;
    }

    public double getVolume(){
        return Math.round((super.getArea() * normalHeight) * 1000.0) / 1000.0;
    }

    @Override
    public String toString(){
        return "Three vertices of its triangular base : V1(" + x1 + ", " + y1 + "), "
                + "V2(" + x2 + ", " + y2 + ") and V3(" + x3 + ", " + y3 + ")\n"
                + "Length of three sides of its triangular base = " + getDistance(x1, y1, x2, y2) + ", " +
                getDistance(x1, y1, x3, y3) + ", " +
                getDistance(x2, y2, x3, y3) + "\n"
                + "TriangularBaseArea = " + super.getArea() + "\n"
                + "Normal Height = " + getNHeight() + "\n"
                + "Surface Area = " + getArea() + "\n"
                + "Volume = " + getVolume();
    }
}
