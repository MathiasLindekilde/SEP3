package model;

import java.io.Serializable;

public class Criteria implements Serializable {
    private String criteria;
    private int weight;
    private Factors factors;

    public Criteria(String criteria, int weight) {
        this.criteria = criteria;
        this.weight = weight;
        this.factors = null;
    }

    public String getCriteria() {
        return criteria;
    }
    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


    public Factors getFactors() {
        return factors;
    }

    public void setFactors(int points, int fact) {
        factors = new Factors(points, fact);
    }

    public double getWeightedPoints() {
        factors.calculateWeightedPoints(weight, factors.getPoints());

        return factors.getWeightedPoints();
    }

    @Override
    public String toString() {
        return "Criteria{" +
                "criteria='" + criteria + '\'' +
                ", weight=" + weight +
                ", factors=" + factors +
                '}';
    }
}
