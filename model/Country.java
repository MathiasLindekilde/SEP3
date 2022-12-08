package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Country implements Serializable {
    private String country;
    public ArrayList<Criteria> criteria;
    private double totalMarketAttractiveness;
    private double totalCompetitiveStrength;


    public Country(String country) {
        this.country = country;
        criteria = new ArrayList<>();
    }

    public Country(String country, ArrayList<Criteria> criteria) {
        this.country = country;
        this.criteria = criteria;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Criteria getCriteria(int index) {
        if (index >= 0 && index < criteria.size()) {
            return criteria.get(index);
        }
        return null;
    }

    public void addCriteria(String criteria, int weight) {
        if (criteria != null) {
            this.criteria.add(new Criteria(criteria, weight));
        }
    }

    public double getTotalMarketAttractiveness() {
        totalMarketAttractiveness = 0;
        // Setting the loop to go from criteria 0-2 as the first 3 criteria always are for the market attractiveness
        for (int i = 0; i <= 2; i++) {
            totalMarketAttractiveness += criteria.get(i).getWeightedPoints();
        }
        return totalMarketAttractiveness;
    }

    public double getTotalCompetitiveStrength() {
        totalCompetitiveStrength = 0;
        // Setting the loop to go from criteria 3-5 as the last 3 criteria always are for the competitive strength
        for (int i = 3; i <= 5; i++) {
            totalCompetitiveStrength += criteria.get(i).getWeightedPoints();
        }
        return totalCompetitiveStrength;
    }

    public void changeCriteria(int index, String newCriteria, int weight) {
        //check range of index values
        if(index>= 0 && index< criteria.size()) {
            criteria.get(index).setCriteria(newCriteria);
            criteria.get(index).setWeight(weight);
        }
    }

}
