package lab3;

import java.util.*;

interface Shapee {
    public void draw();

    public double getArea();

    public String getName();

    public String getHexFillColor();

    public int getBorderWidth();

}

class HexColorValidator {

    public boolean validate(String colorHex) {

        return colorHex.length() == 7 && colorHex.matches("#[0-9[A-F]]+");

    }

}

class Dreptunghi implements Shapee {

    private String fillColor;
    private int borderWidth;
    private int height, width;

    private HexColorValidator hex = new HexColorValidator();


    Dreptunghi(String fillColor, int borderWidth, int height, int width) {

        setBorderWidth(borderWidth);
        setFillColor(fillColor);
        setHeight(height);
        setWidth(width);
    }

    public void setBorderWidth(int borderWidth) {

        if (borderWidth > 0)
            this.borderWidth = borderWidth;
        else
            throw new IllegalArgumentException("Latimea bordurii este negativa!");
    }

    public void setFillColor(String fillColor) {

        if (hex.validate(fillColor)) {

            this.fillColor = fillColor;
        } else
            throw new IllegalArgumentException("Codul in hexa este incorect!");
    }

    public void setWidth(int width) {

        if (width > 0)
            this.width = width;
        else
            throw new IllegalArgumentException("Latimea este negativa!");

    }

    public void setHeight(int height) {
        if (height > 0)
            this.height = height;
        else
            throw new IllegalArgumentException("Inaltimea este negativa!");
    }

    @Override
    public void draw() {
        int i, j;

        for (i = 0; i < width; i++) {

            for (j = 0; j < height; j++) {

                if (i == 0 || i == width - 1 || j == 0 || j == height - 1)

                    System.out.print("* ");
                else
                    System.out.print("  ");

            }

            System.out.println();
        }

    }


    @Override
    public double getArea() {
        return height * width;
    }

    @Override
    public String getName() {
        String nume = "Dreptunghi";
        return nume;
    }

    @Override
    public String getHexFillColor() {
        return fillColor;
    }

    @Override
    public int getBorderWidth() {
        return borderWidth;
    }
}

class Patrat implements Shapee {

    private String fillColor;
    private int borderWidth;
    private int size;

    private HexColorValidator hex = new HexColorValidator();


    Patrat(String fillColor, int borderWidth, int size) {

        setBorderWidth(borderWidth);
        setFillColor(fillColor);
        setSize(size);
    }

    public void setBorderWidth(int borderWidth) {

        if (borderWidth > 0)
            this.borderWidth = borderWidth;
        else
            throw new IllegalArgumentException("Latimea bordurii este negativa!");
    }

    public void setFillColor(String fillColor) {

        if (hex.validate(fillColor)) {

            this.fillColor = fillColor;
        } else
            throw new IllegalArgumentException("Codul in hexa este incorect!");
    }


    public void setSize(int size) {
        if (size > 0)
            this.size = size;
        else
            throw new IllegalArgumentException("Dimensiunea este negativa!");
    }

    @Override
    public void draw() {
        int i, j;
        for (i = 0; i < size; i++) {

            for (j = 0; j < size; j++) {

                if (i == 0 || i == size - 1 || j == 0 || j == size - 1)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }

            System.out.println();
        }
    }

    @Override
    public double getArea() {
        return size * size;
    }

    @Override
    public String getName() {
        String nume = "Patrat";
        return nume;
    }

    @Override
    public String getHexFillColor() {
        return fillColor;
    }

    @Override
    public int getBorderWidth() {
        return borderWidth;
    }
}

class Cerc implements Shapee {

    private String fillColor;
    private int borderWidth;
    private int radius;

    private HexColorValidator hex = new HexColorValidator();

    Cerc(String fillColor, int borderWidth, int radius) {

        setBorderWidth(borderWidth);
        setFillColor(fillColor);
        setRadius(radius);
    }

    public void setBorderWidth(int borderWidth) {

        if (borderWidth > 0)
            this.borderWidth = borderWidth;
        else
            throw new IllegalArgumentException("Latimea bordurii este negativa!");
    }

    public void setFillColor(String fillColor) {

        if (hex.validate(fillColor)) {

            this.fillColor = fillColor;
        } else
            throw new IllegalArgumentException("Codul in hexa este incorect!");
    }

    public void setRadius(int radius) {

        if (radius > 0)
            this.radius = radius;
        else
            throw new IllegalArgumentException("Raza este negativa!");
    }

    @Override
    public void draw() {
        double dist;

        for (int i = 0; i <= 2 * radius; i++) {
            for (int j = 0; j <= 2 * radius; j++) {
                dist = Math.sqrt(Math.pow(i - radius, 2) + Math.pow(j - radius, 2));

                if (dist > radius - 0.5 && dist < radius + 0.5)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    @Override
    public double getArea() {
        return radius * radius * 3.14;
    }

    @Override
    public String getName() {
        String nume = "Cerc";
        return nume;
    }

    @Override
    public String getHexFillColor() {
        return fillColor;
    }

    @Override
    public int getBorderWidth() {
        return borderWidth;
    }
}

public class Problema {

    private Scanner sc;
    private List<String> larray;

    Problema() {
        sc = new Scanner(System.in);
        polimorfisme();
    }

    private void polimorfisme() {

        System.out.println("Alegeti modul de desenare:");
        System.out.println("A - automat");
        System.out.println("M - manual");
        String option = sc.nextLine();

        if (option.toUpperCase().compareTo("A") == 0) {

            List<Shapee> shapes = new ArrayList<Shapee>();

            shapes.add(new Patrat("#000000", 1, 7));
            shapes.add(new Patrat("#FFFFFF", 1, 10));
            shapes.add(new Dreptunghi("#FFFFFF", 3, 10, 5)); // FD23FF
            shapes.add(new Dreptunghi("#002F3C", 1, 5, 10));
            shapes.add(new Cerc("#FFFFFF", 1, 5)); //#CCC908
            shapes.add(new Cerc("#FDAE00", 1, 10));

            for (Shapee s : shapes) {
                System.out.println("Shape Name : " + s.getName());
                System.out.println("Shape Area : " + s.getArea());
                System.out.println("Shape FillColor : " + s.getHexFillColor());
                System.out.println("Shape BorderWidth : " + s.getBorderWidth());
                System.out.println("Drawing . . . . ");

                s.draw();
                System.out.println();
            }

        } else if (option.toUpperCase().compareTo("M") == 0) {

            System.out.println("Ce doriti sa construiti?");
            System.out.println("P pentru patrat!");
            System.out.println("D pentru dreptungi!");
            System.out.println("C pentru cerc!");

            String opt = sc.nextLine();

            switch (opt.toUpperCase()) {
                case "P":
                    System.out.println("Introduceti o culoare de forma '#000000' !");
                    String squareColor = sc.nextLine();
                    System.out.println("Introduceti lungimea patratului (numar pozitiv) !");
                    int size = Integer.parseInt(sc.nextLine());
                    System.out.println("Introduceti grosimea conturului (numar pozitiv) !");
                    int squareBorder = Integer.parseInt(sc.nextLine());

                    Shapee s = new Patrat(squareColor, squareBorder, size);
                    System.out.println("Shape Name : " + s.getName());
                    System.out.println("Shape Area : " + s.getArea());
                    System.out.println("Shape FillColor : " + s.getHexFillColor());
                    System.out.println("Shape BorderWidth : " + s.getBorderWidth());
                    System.out.println("Drawing . . . . ");
                    s.draw();
                    break;

                case "C":
                    System.out.println("Introduceti o culoare de forma '#000000' !");
                    String circleColor = sc.nextLine();
                    System.out.println("Introduceti raza cercului (numar pozitiv) !");
                    int radius = Integer.parseInt(sc.nextLine());
                    System.out.println("Introduceti grosimea conturului (numar pozitiv) !");
                    int circleBorder = Integer.parseInt(sc.nextLine());

                    Shapee s1 = new Cerc(circleColor, circleBorder, radius);
                    System.out.println("Shape Name : " + s1.getName());
                    System.out.println("Shape Area : " + s1.getArea());
                    System.out.println("Shape FillColor : " + s1.getHexFillColor());
                    System.out.println("Shape BorderWidth : " + s1.getBorderWidth());
                    System.out.println("Drawing . . . . ");
                    s1.draw();
                    break;

                case "D":
                    System.out.println("Introduceti o culoare de forma '#000000' !");
                    String rectangleColor = sc.nextLine();
                    System.out.println("Introduceti lungimea dreptunghiului (numar pozitiv) !");
                    int rectangleHeight = Integer.parseInt(sc.nextLine());
                    System.out.println("Introduceti latimea dreptunghiului (numar pozitiv) !");
                    int rectangleWidth = Integer.parseInt(sc.nextLine());
                    System.out.println("Introduceti grosimea conturului (numar pozitiv) !");
                    int rectangleBorder = Integer.parseInt(sc.nextLine());

                    Shapee s2 = new Dreptunghi(rectangleColor, rectangleBorder, rectangleHeight, rectangleWidth);
                    System.out.println("Shape Name : " + s2.getName());
                    System.out.println("Shape Area : " + s2.getArea());
                    System.out.println("Shape FillColor : " + s2.getHexFillColor());
                    System.out.println("Shape BorderWidth : " + s2.getBorderWidth());
                    System.out.println("Drawing . . . . ");
                    s2.draw();
                    break;
            }

        }
        sc.close();
    }
}

