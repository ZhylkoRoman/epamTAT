package model;

import exception.TriangleException;

public class TriangleValidator {
    public static boolean isTriangle(double a, double b, double c) throws TriangleException {
        if (a < 0 || b < 0 || c < 0)
            throw new TriangleException("Sides can't be negative.");
        else if (a == 0 || b == 0 || c == 0)
            throw new TriangleException("Sides can't be zero.");
        return a + b > c && b + c > a && a + c > b;
    }

    public static TriangleType getType(double a, double b, double c) throws TriangleException {
        if (TriangleValidator.isTriangle(a, b, c)) {
            if (a == b && a == c)
                return TriangleType.EQUILATERAL;
            else if (a == b || b == c || c == a)
                return TriangleType.ISOSCELES;
            else if (a * a + b * b == c * c ||
                     a * a + c * c == b * b ||
                     b * b + c * c == a * a)
                return TriangleType.RIGHT;
            return TriangleType.VERSATILE;
        } else
            throw new TriangleException("Not a triangle.");
    }
}
