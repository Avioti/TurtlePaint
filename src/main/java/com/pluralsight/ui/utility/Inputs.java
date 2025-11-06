package com.pluralsight.ui.utility;

import java.awt.*;

import static com.pluralsight.ui.TurtlePainterApp.scanner;

public class Inputs {

    public static int promptForInt() {
        System.out.println();
        System.out.print("Enter #: ");
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

    public static String promptForString() {
        System.out.println();
        System.out.print("Enter text: ");
        return scanner.nextLine();
    }

    public static Point promptForPoint() {
        System.out.println();
        System.out.print("Enter X coordinate: ");
        int x = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Y coordinate: ");
        int y = scanner.nextInt();
        scanner.nextLine();
        System.out.println();
        return new Point(x, y);
    }

    public static String promptForColor() {
        System.out.println();
        System.out.print("Enter color: ");
        return scanner.nextLine();
    }

    public static void promptForShapeType() {
        System.out.println();
        System.out.println("Which Shape");
        System.out.println("1. Circle");
        System.out.println("2. Square");
        System.out.println("3. Triangle");
        System.out.println("4. Exit to Main Menu");
    }

    public static int promptForBorderWidth() {
        System.out.println();
        System.out.print("Enter border width: ");
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

    public static Color parseColor(String colorStr) {
        colorStr = colorStr.trim().toUpperCase();
        return switch (colorStr) {
            case "RED" -> Color.RED;
            case "BLUE" -> Color.BLUE;
            case "GREEN" -> Color.GREEN;
            case "BLACK" -> Color.BLACK;
            case "YELLOW" -> Color.YELLOW;
            case "CYAN" -> Color.CYAN;
            case "MAGENTA" -> Color.MAGENTA;
            case "WHITE" -> Color.WHITE;
            case "ORANGE" -> Color.ORANGE;
            case "PINK" -> Color.PINK;
            case "GRAY", "GREY" -> Color.GRAY;
            case "DARK_GRAY", "DARK_GREY" -> Color.DARK_GRAY;
            case "LIGHT_GRAY", "LIGHT_GREY" -> Color.LIGHT_GRAY;
            default -> {
                System.out.println("Color not recognized. Using BLACK.");
                yield Color.BLACK;
            }
        };
    }
}
