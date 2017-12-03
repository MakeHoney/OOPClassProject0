package com.company;
import java.lang.Math.*;

class Cylinder extends Shapes2D.Circle
        implements Shapes3DPrism {
    private double x1, y1, x2, y2;
    private double normalHeight;

    public Cylinder(double x1, double y1, double x2, double y2, double normalHeight){
        super(x1, y1, x2, y2);
        this.x1 = x1; this.y1 = y1; this.x2 = x2; this.y2 = y2;
        this.normalHeight = normalHeight;
    }


    public double getNHeight(){
        return normalHeight;
    }

    @Override
    public double getArea(){
        return Math.round(
                (2.0 * super.getArea()
                        + 2.0 * Math.PI * getDistance(x1, y1, x2, y2) * normalHeight)
                        * 1000.0) / 1000.0;
    }

    public double getVolume(){
        return Math.round((super.getArea() * normalHeight) * 1000.0) / 1000.0;
    }

    @Override
    public String toString(){
        return "Center of its circular base : C(" + x1 + ", " + y1 + ")\n"
                + "Point on boundary of its circular base : B(" + x2 + ", " + y2 + ")\n"
                + "radius of its circular base = " + getDistance(x1, y1, x2, y2) + "\n"
                + "CircularBaseArea = " + super.getArea() + "\n"
                + "Normal Height = " + getNHeight() + "\n"
                + "Surface Area = " + getArea() + "\n"
                + "Volume = " + getVolume();
    }
}
