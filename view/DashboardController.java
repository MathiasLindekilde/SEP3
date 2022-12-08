package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import model.Country;

import java.util.ArrayList;

public class DashboardController {
    @FXML
    Label nameLabel, countryRank1, countryRank2, countryRank3;
    @FXML
    Button loadButton, country1Button, country2Button, country3Button;
    @FXML
    BubbleChart<Double, Double> macsChart;
    @FXML
    NumberAxis xAxis, yAxis;
    @FXML
    ImageView myImageViewHome, myImageViewCriteria, myImageViewCountry1, myImageViewCountry2, myImageViewCountry3;

    private ArrayList<Country> model;
    private ViewController viewController;

    // Initialises the model and viewController
    public void init(ViewController viewController, ArrayList<Country> model) {
        this.model = model;
        this.viewController = viewController;
    }

    // Gets the login username and sets the nameLabel text to it
    public void displayName(String username) {
        nameLabel.setText(username);
    }

    // Loads the macChart when handleRanking button is clicked (called through handleRanking method).
    // Creates a XYChart series of each country in our model
    public void loadMacsChart() {
        macsChart.getData().clear();

        for (Country country : model) {
            String name = country.getCountry();
            double marketAttractiveness = country.getTotalMarketAttractiveness();
            double competitiveStrength = country.getTotalCompetitiveStrength();

            XYChart.Series<Double, Double> series = new XYChart.Series<>();
            series.setName(name);
            series.getData().add(new XYChart.Data<>(competitiveStrength, marketAttractiveness, .5));
            macsChart.getData().addAll(series);
        }
    }

    // Handles the ranking on dashboard and loads the macChart on button clicked
    public void handleRanking() {
        // If the countries names are NOT equal to the ones we instantiated them with, set the country rankings and load macsChart
        if (!(model.get(0).getCountry().equals("Country1") && model.get(1).getCountry().equals("Country2") && model.get(2).getCountry().equals("Country3"))) {
            loadMacsChart();
            // Setting up variables for the ranking
            double country1 = model.get(0).getTotalMarketAttractiveness() + model.get(0).getTotalCompetitiveStrength();
            double country2 = model.get(1).getTotalMarketAttractiveness() + model.get(1).getTotalCompetitiveStrength();
            double country3 = model.get(2).getTotalMarketAttractiveness() + model.get(2).getTotalCompetitiveStrength();
                // Setting country rank and color
                if (country1 >= country2) {
                    if (country1 >= country3) {
                        if (country2 >= country3) {
                            countryRank1.setText(model.get(0).getCountry());
                            countryRank1.setTextFill(Color.GREEN);
                            countryRank2.setText(model.get(1).getCountry());
                            countryRank2.setTextFill(Color.BLUE);
                            countryRank3.setText(model.get(2).getCountry());
                            countryRank2.setTextFill(Color.RED);
                        } else {
                            countryRank1.setText(model.get(0).getCountry());
                            countryRank1.setTextFill(Color.GREEN);
                            countryRank2.setText(model.get(2).getCountry());
                            countryRank2.setTextFill(Color.RED);
                            countryRank3.setText(model.get(1).getCountry());
                            countryRank2.setTextFill(Color.BLUE);
                        }
                    } else {
                        if (country2 >= country3) {
                            countryRank1.setText(model.get(1).getCountry());
                            countryRank1.setTextFill(Color.BLUE);
                            countryRank2.setText(model.get(2).getCountry());
                            countryRank2.setTextFill(Color.RED);
                            countryRank3.setText(model.get(0).getCountry());
                            countryRank3.setTextFill(Color.GREEN);
                        } else {
                            countryRank1.setText(model.get(2).getCountry());
                            countryRank1.setTextFill(Color.RED);
                            countryRank2.setText(model.get(0).getCountry());
                            countryRank2.setTextFill(Color.GREEN);
                            countryRank3.setText(model.get(1).getCountry());
                            countryRank3.setTextFill(Color.BLUE);
                        }
                    }
                } else {
                    if (country1 >= country3) {
                        if (country2 >= country3) {
                            countryRank1.setText(model.get(1).getCountry());
                            countryRank1.setTextFill(Color.BLUE);
                            countryRank2.setText(model.get(0).getCountry());
                            countryRank2.setTextFill(Color.GREEN);
                            countryRank3.setText(model.get(2).getCountry());
                            countryRank3.setTextFill(Color.RED);
                        } else {
                            countryRank1.setText(model.get(2).getCountry());
                            countryRank1.setTextFill(Color.RED);
                            countryRank2.setText(model.get(1).getCountry());
                            countryRank2.setTextFill(Color.BLUE);
                            countryRank3.setText(model.get(0).getCountry());
                            countryRank3.setTextFill(Color.GREEN);
                        }
                    } else {
                        if (country2 >= country3) {
                            countryRank1.setText(model.get(1).getCountry());
                            countryRank1.setTextFill(Color.BLUE);
                            countryRank2.setText(model.get(2).getCountry());
                            countryRank2.setTextFill(Color.RED);
                            countryRank3.setText(model.get(0).getCountry());
                            countryRank3.setTextFill(Color.GREEN);
                        } else {
                            countryRank1.setText(model.get(2).getCountry());
                            countryRank1.setTextFill(Color.RED);
                            countryRank2.setText(model.get(1).getCountry());
                            countryRank2.setTextFill(Color.BLUE);
                            countryRank3.setText(model.get(0).getCountry());
                            countryRank3.setTextFill(Color.GREEN);
                        }
                    }
                }
            }
    }

    // Switches scenes
    public void handleMacsFrameworkButton() {
        viewController.switchScene(ViewController.MACS_FRAMEWORK_SCENE);
    }

    public void handleCountry1() {
        viewController.switchScene(ViewController.COUNTRY_1_SCENE);
    }

    public void handleCountry2() {
        viewController.switchScene(ViewController.COUNTRY_2_SCENE);
    }

    public void handleCountry3() {
        viewController.switchScene(ViewController.COUNTRY_3_SCENE);
    }

    public void handleLogoff() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to logout!");
        alert.setContentText("Are you sure you want to logout? Information could be lost. ");

        if (alert.showAndWait().get() == ButtonType.OK) {
            viewController.switchScene(ViewController.LOGIN_SCENE);
        }
    }
}
