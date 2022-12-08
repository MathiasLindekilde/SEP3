package model;

public class Factors {

    private int points, fact;
    private double weightedPoints;

    public Factors(int points, int fact) {
        this.points = points;
        this.fact = fact;
        weightedPoints = 0;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getFact() {
        return fact;
    }

    public void setFact(int fact) {
        this.fact = fact;
    }

    public double getWeightedPoints() {
        return weightedPoints;
    }

    public void calculateWeightedPoints(int weight, int points) {
        double decimalWeight = weight / 100.0;
        weightedPoints = points * decimalWeight;
    }



}
