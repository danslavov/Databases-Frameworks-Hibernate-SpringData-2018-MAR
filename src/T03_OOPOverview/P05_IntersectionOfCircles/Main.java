package T03_OOPOverview.P05_IntersectionOfCircles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double[] firstCircleParams = Arrays.stream(reader.readLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();
        double[] secondCircleParams = Arrays.stream(reader.readLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();
        Circle firstCircle = new Circle(
                new Point(firstCircleParams[0], firstCircleParams[1]),
                firstCircleParams[2]);
        Circle secondCircle = new Circle(
                new Point(secondCircleParams[0], secondCircleParams[1]),
                secondCircleParams[2]);

        System.out.println(
                intersect(firstCircle, secondCircle) ? "Yes" : "No");
    }

    private static boolean intersect(Circle c1, Circle c2) {
        double squareA = Math.pow((
                        c1.getCenter().getXAxis() -
                        c2.getCenter().getXAxis()), 2);
        double squareB = Math.pow((
                        c1.getCenter().getYAxis() -
                        c2.getCenter().getYAxis()), 2);
        double distanceBetweenCenters = Math.sqrt(squareA + squareB);
        return distanceBetweenCenters <= c1.getRadius() + c2.getRadius();
    }
}