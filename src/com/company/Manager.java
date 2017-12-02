package com.company;
import java.lang.Math.*;

import java.util.Scanner;

class Manager {

    static void chooseShape() {
        Scanner inputNum = new Scanner(System.in);
        int inp;

        System.out.println("Choose between 2D and 3D shapes\n");
        System.out.println("1. 2D Shapes\t|\t2. 3D Shapes");

        while (!inputNum.hasNextInt()) {
            inputNum.next();
            System.out.println("\nEnter only a number.\n");
        }

        inp = inputNum.nextInt();

        if (!(inp == 1 || inp == 2)) {
            System.out.println("\n\nEnter the number between 1 and 2.\n\n");
            chooseShape();
            //return;
        }

        if (inp == 1) {
            choose2DShape();
        } else if (inp == 2) {
            choose3DShape();

        }

    }


    private static void choose2DShape() {
        Scanner inputNum = new Scanner(System.in);
        double[] parameter = new double[6];
        int inp;

        System.out.println("1. Circle\t|\t2. Equilateral Triangle\t|\t3. Square");

        while (!inputNum.hasNextInt()) {
            inputNum.next();
            System.out.println("\nEnter only a number.\n");
            System.out.println("1. Circle\t|\t2. Equilateral Triangle\t|\t3. Square");
        }

        inp = inputNum.nextInt();
        if (!(inp == 1 || inp == 2 || inp == 3)) {
            System.out.println("\n\nEnter the number among 1, 2 and 3.\n\n");
            choose2DShape();
            //return;
        } else {
            if (inp == 1 || inp == 3) {
                while (true) {
                    boolean flag = false;
                    String inputString[] = {null, null, null, null};

                    if (inp == 1) {
                        inputString[0] = "C(x1, y1):\tx1 = ";
                        inputString[1] = "C(x1, y1):\ty1 = ";
                        inputString[2] = "B(x1, y1):\tx2 = ";
                        inputString[3] = "B(x1, y1):\ty2 = ";
                    } else {
                        inputString[0] = "UL(x1, y1):\tx1 = ";
                        inputString[1] = "UL(x1, y1):\ty1 = ";
                        inputString[2] = "LR(x2, y2):\tx2 = ";
                        inputString[3] = "LR(x2, y2):\ty2 = ";
                    }

                    for (int i = 0; i < 4; i++) {
                        System.out.print(inputString[i]);

                        while (!inputNum.hasNextDouble()) {
                            inputNum.next();
                            System.out.println("Enter only a number.");

                        }

                        parameter[i] = inputNum.nextDouble();

                        if (i == 3)
                            flag = true;
                    }
                    System.out.println("\n");
                    if (flag && inp == 1) {
                        if (parameter[0] == parameter[2] && parameter[1] == parameter[3]) {
                            System.out.println("Error1 : Enter valid points.");
                        } else
                            break;
                    } else if (flag && inp == 3) {
                        if (parameter[0] > parameter[2] || parameter[1] < parameter[3]
                                || (parameter[0] == parameter[2] && parameter[1] == parameter[3])) {
                            System.out.println("Error1 : Enter valid points.");
                        } else {
                            if (parameter[2] - parameter[0] != parameter[1] - parameter[3])
                                System.out.println("Error2 : It is not a square.");
                            else
                                break;
                        }
                    }
                    System.out.println("\n");
                }

                if (inp == 1) {
                    Shapes2D circle = new Shapes2D.Circle(parameter[0], parameter[1],
                            parameter[2], parameter[3]);
                    System.out.println("\n\n" + circle.toString());
                } else {
                    Shapes2D square = new Shapes2D.Square(parameter[0], parameter[1],
                            parameter[2], parameter[3]);
                    System.out.println("\n\n" + square.toString());
                }
            } else {

                while (true) {
                    double recX1 = 0;
                    double recX2 = 0;
                    double recY1 = 0;
                    double recY2 = 0;
                    boolean flag = false;
                    boolean flag2 = false;
                    String inputString[] = {"V1(x1, y1):\tx1 = ",
                            "V1(x1, y1):\ty1 = ",
                            "V2(x2, y2):\tx2 = ",
                            "V2(x2, y2):\ty2 = ",
                            "V3(x3, y3):\tx3 = ",
                            "V3(x3, y3):\ty3 = ",};

                    for (int i = 0; i < 6; i++) {

                        if (i == 4) {
                            System.out.println("\n\nV3(x3, y3) recommended\n");
                            System.out.println("(" + recX1 + ", " + recY1 + ") or (" + recX2 + ", " + recY2 + ")\n");
                        }
                        System.out.print(inputString[i]);

                        while (!inputNum.hasNextDouble()) {
                            inputNum.next();
                            System.out.println("Enter only a number.");

                        }

                        parameter[i] = inputNum.nextDouble();
                        if (i == 3) {
                            recX1 = Math.round((
                                    (parameter[0] + parameter[2]) / 2.0
                                            + (parameter[3] - parameter[1]) * 1.7315 / 2.0) * 10000.0) / 10000.0;
                            recX2 = Math.round((
                                    (parameter[0] + parameter[2]) / 2.0
                                            - (parameter[3] - parameter[1]) * 1.7315 / 2.0) * 10000.0) / 10000.0;
                            recY1 = Math.round((
                                    (parameter[1] + parameter[3]) / 2.0
                                            - (parameter[2] - parameter[0]) * 1.7315 / 2.0) * 10000.0) / 10000.0;
                            recY2 = Math.round((
                                    (parameter[1] + parameter[3]) / 2.0
                                            + (parameter[2] - parameter[0]) * 1.7315 / 2.0) * 10000.0) / 10000.0;
                        }

                        if (i == 5) {
                            flag = true;
                            if ((parameter[4] == recX1 && parameter[5] == recY1)
                                    || (parameter[4] == recX2 && parameter[5] == recY2))
                                flag2 = true;
                        }
                    }
                    System.out.println("\n");

                    if (flag && !flag2) {
                        System.out.println("Error2 : Triangle is not equilateral.");
                    }
                    if (flag) {
                        if (parameter[2] - parameter[0] == 0 || parameter[4] - parameter[2] == 0) {
                            if (parameter[4] - parameter[0] == 0)
                                System.out.println("Error4 : Three points cannot be on the same line.");
                            else if (flag2)
                                break;
                        } else if ((parameter[3] - parameter[1]) / (parameter[2] - parameter[0]) ==
                                (parameter[5] - parameter[3]) / (parameter[4] - parameter[2])) {
                            System.out.println("Error4 : Three points cannot be on the same line.");
                        } else if (flag2)
                            break;
                    }
                    System.out.println("\n");
                }

                Shapes2D triangle = new Shapes2D.EquilateralTriangle(parameter[0], parameter[1],
                        parameter[2], parameter[3], parameter[4], parameter[5]);
                System.out.println("\n\n" + triangle.toString());

            }
        }
    }

    private static void choose3DShape() {
        Scanner inputNum = new Scanner(System.in);
        double[] parameter = new double[7];
        int inp;

        System.out.println("1. Cone\t|\t2. Equilateral Triangular Pyramid\t|\t3. Square Pyramid");
        System.out.println("4. Cylinder\t|\t5. Equilateral Triangular Prism\t|\t6. Square Prism");


        while (!inputNum.hasNextInt()) {
            inputNum.next();
            System.out.println("\nEnter only a number.\n");
            System.out.println("1. Cone\t|\t2. Equilateral Triangular Pyramid\t|\t3. Square Pyramid");
            System.out.println("4. Cylinder\t|\t5. Equilateral Triangular Prism\t|\t6. Square Prism");
        }

        inp = inputNum.nextInt();
        if (!(inp == 1 || inp == 2 || inp == 3
                || inp == 4 || inp == 5 || inp == 6)) {
            System.out.println("\n\nEnter the number among 1, 2, 3, 4, 5 and 6.\n\n");
            choose3DShape();
            //return;
        } else {
            if (inp == 2 || inp == 5) {

                while (true) {
                    double recX1 = 0;
                    double recX2 = 0;
                    double recY1 = 0;
                    double recY2 = 0;
                    boolean flag = false;
                    boolean flag2 = false;
                    String inputString[] = {"V1(x1, y1):\tx1 = ",
                            "V1(x1, y1):\ty1 = ",
                            "V2(x2, y2):\tx2 = ",
                            "V2(x2, y2):\ty2 = ",
                            "V3(x3, y3):\tx3 = ",
                            "V3(x3, y3):\ty3 = ",
                            null};

                    if (inp == 2) {
                        inputString[6] = "Slant Height : ";
                    } else {
                        inputString[6] = "Normal Height : ";
                    }


                    for (int i = 0; i < 7; i++) {

                        if (i == 4) {
                            System.out.println("\n\nV3(x3, y3) recommended\n");
                            System.out.println("(" + recX1 + ", " + recY1 + ") or (" + recX2 + ", " + recY2 + ")\n");
                        }

                        System.out.print(inputString[i]);

                        while (!inputNum.hasNextDouble()) {
                            inputNum.next();
                            System.out.println("Enter only a number.");
                        }

                        parameter[i] = inputNum.nextDouble();

                        if (i == 3) {
                            recX1 = Math.round((
                                    (parameter[0] + parameter[2]) / 2.0
                                            + (parameter[3] - parameter[1]) * 1.7315 / 2.0) * 10000.0) / 10000.0;
                            recX2 = Math.round((
                                    (parameter[0] + parameter[2]) / 2.0
                                            - (parameter[3] - parameter[1]) * 1.7315 / 2.0) * 10000.0) / 10000.0;
                            recY1 = Math.round((
                                    (parameter[1] + parameter[3]) / 2.0
                                            - (parameter[2] - parameter[0]) * 1.7315 / 2.0) * 10000.0) / 10000.0;
                            recY2 = Math.round((
                                    (parameter[1] + parameter[3]) / 2.0
                                            + (parameter[2] - parameter[0]) * 1.7315 / 2.0) * 10000.0) / 10000.0;
                        }

                        if (i == 6) {
                            flag = true;
                            if ((parameter[4] == recX1 && parameter[5] == recY1)
                                    || (parameter[4] == recX2 && parameter[5] == recY2))
                                flag2 = true;
                        }
                    }
                    System.out.println("\n");
                    if (flag && !flag2) {
                        System.out.println("Error2 : Base triangle is not equilateral.");
                    }
                    if (flag) {
                        if (parameter[6] > 0) {
                            if (parameter[2] - parameter[0] == 0 || parameter[4] - parameter[2] == 0) {
                                if (parameter[4] - parameter[0] == 0)
                                    System.out.println("Error4 : Three points of base triangle cannot be on the same line.");
                                else if (flag2)
                                    break;
                            } else if ((parameter[3] - parameter[1]) / (parameter[2] - parameter[0]) ==
                                    (parameter[5] - parameter[3]) / (parameter[4] - parameter[2])) {
                                System.out.println("Error4 : Three points of base triangle cannot be on the same line.");
                            } else if (flag2)
                                break;
                        } else {
                            System.out.println("Error3 : Height must be more than zero.");
                        }
                    }
                    System.out.println("\n");
                }

                if (inp == 2) {
                    Shapes3DPyramid triangularPyramid = new EquilateralTriangularPyramid(parameter[0], parameter[1],
                            parameter[2], parameter[3], parameter[4], parameter[5], parameter[6]);
                    System.out.println("\n\n" + triangularPyramid.toString());
                } else {
                    Shapes3DPrism triangularPrism = new EquilateralTriangularPrism(parameter[0], parameter[1],
                            parameter[2], parameter[3], parameter[4], parameter[5], parameter[6]);
                    System.out.println("\n\n" + triangularPrism.toString());
                }
            } else {

                while (true) {
                    boolean flag = false;
                    String inputString[] = {null, null, null, null, null};

                    if (inp == 1 || inp == 4) {
                        inputString[0] = "C(x1, y1):\tx1 = ";
                        inputString[1] = "C(x1, y1):\ty1 = ";
                        inputString[2] = "B(x1, y1):\tx2 = ";
                        inputString[3] = "B(x1, y1):\ty2 = ";
                        inputString[4] = "Slant Height : ";
                    } else {
                        inputString[0] = "UL(x1, y1):\tx1 = ";
                        inputString[1] = "UL(x1, y1):\ty1 = ";
                        inputString[2] = "LR(x2, y2):\tx2 = ";
                        inputString[3] = "LR(x2, y2):\ty2 = ";
                        inputString[4] = "Normal Height : ";
                    }

                    for (int i = 0; i < 5; i++) {
                        System.out.print(inputString[i]);

                        while (!inputNum.hasNextDouble()) {
                            inputNum.next();
                            System.out.println("Enter only a number.");

                        }

                        parameter[i] = inputNum.nextDouble();

                        if (i == 4)
                            flag = true;
                    }
                    System.out.println("\n");
                    if (flag && (inp == 1 || inp == 4)) {
                        if (parameter[4] != 0 && (parameter[0] == parameter[2] && parameter[1] == parameter[3])) {
                            System.out.println("Error1 : Enter valid points.");
                        } else {
                            if (parameter[4] <= 0)
                                System.out.println("Error3 : Height must be more than zero.");
                            else
                                break;
                        }
                    } else if (flag && (inp == 3 || inp == 6)) {
                        if (parameter[4] != 0 && (parameter[0] > parameter[2] || parameter[1] < parameter[3]
                                || (parameter[0] == parameter[2] && parameter[1] == parameter[3]))) {
                            System.out.println("Error1 : Enter valid points.");
                        } else {
                            if (parameter[4] <= 0)
                                System.out.println("Error3 : Height must be more than zero.");
                            else if (parameter[2] - parameter[0] != parameter[1] - parameter[3])
                                System.out.println("Error2 : Base is not a square.");
                            else
                                break;
                        }
                    }
                    System.out.println("\n");
                }

                if (inp == 1 || inp == 4) {
                    if (inp == 1) {
                        Shapes3DPyramid cone = new Cone(parameter[0], parameter[1],
                                parameter[2], parameter[3], parameter[4]);
                        System.out.println("\n\n" + cone.toString());
                    } else {
                        Shapes3DPrism cylinder = new Cylinder(parameter[0], parameter[1],
                                parameter[2], parameter[3], parameter[4]);
                        System.out.println("\n\n" + cylinder.toString());
                    }
                } else {
                    if (inp == 3) {
                        Shapes3DPyramid squarePyramid = new SquarePyramid(parameter[0], parameter[1],
                                parameter[2], parameter[3], parameter[4]);
                        System.out.println("\n\n" + squarePyramid.toString());
                    } else {
                        Shapes3DPrism squarePrism = new SquarePrism(parameter[0], parameter[1],
                                parameter[2], parameter[3], parameter[4]);
                        System.out.println("\n\n" + squarePrism.toString());
                    }
                }
            }
        }
    }
}
