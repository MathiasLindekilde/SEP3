package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import model.Country;

import java.net.URL;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class Country3Controller implements Initializable {
    @FXML
    Label nameLabel, weightedPointsLabelMarket1, weightedPointsLabelMarket2, weightedPointsLabelMarket3, weightedPointsLabelComp1, weightedPointsLabelComp2, weightedPointsLabelComp3, totWeightedMarketPointsCountry3, totWeightedCompPointsCountry3;
    @FXML
    TextArea criteriaAreaMarket1, criteriaAreaMarket2, criteriaAreaMarket3, criteriaAreaComp1, criteriaAreaComp2, criteriaAreaComp3;
    @FXML
    TextField countryNameField, weightFieldMarket1, weightFieldMarket2, weightFieldMarket3, weightFieldComp1, weightFieldComp2, weightFieldComp3;
    @FXML
    TextField factFieldMarket1, factFieldMarket2, factFieldMarket3, factFieldComp1, factFieldComp2, factFieldComp3;
    @FXML
    ChoiceBox<Integer> pointsBoxMarket1, pointsBoxMarket2, pointsBoxMarket3, pointsBoxComp1, pointsBoxComp2, pointsBoxComp3;
    @FXML
    Button country1Button, country2Button, country3Button, saveAllButton;
    @FXML
    ImageView myImageViewHome, myImageViewCriteria, myImageViewCountry1, myImageViewCountry2, myImageViewCountry3;

    private ArrayList<Country> model;
    private ViewController viewController;

    DecimalFormat df = new DecimalFormat("0.00", new DecimalFormatSymbols(Locale.US));

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Sets the items in the 6 ChoiceBoxes
        pointsBoxMarket1.getItems().addAll(1, 2, 3, 4, 5);
        pointsBoxMarket2.getItems().addAll(1, 2, 3, 4, 5);
        pointsBoxMarket3.getItems().addAll(1, 2, 3, 4, 5);
        pointsBoxComp1.getItems().addAll(1, 2, 3, 4, 5);
        pointsBoxComp2.getItems().addAll(1, 2, 3, 4, 5);
        pointsBoxComp3.getItems().addAll(1, 2, 3, 4, 5);

        // onAction method reference to the updateWeight method
        pointsBoxMarket1.setOnAction(this::updateWeight);
        pointsBoxMarket2.setOnAction(this::updateWeight);
        pointsBoxMarket3.setOnAction(this::updateWeight);
        pointsBoxComp1.setOnAction(this::updateWeight);
        pointsBoxComp2.setOnAction(this::updateWeight);
        pointsBoxComp3.setOnAction(this::updateWeight);

    }

    // Initialises the model and viewController
    public void init(ViewController viewController, ArrayList<Country> model) {
        this.model = model;
        this.viewController = viewController;
    }

    // Gets the login username and sets the nameLabel text to it
    public void displayName(String username) {
        nameLabel.setText(username);
    }

    // Updates the weightLabels and totalWeight as its being typed in
    public void updateWeight(ActionEvent event) {
        double sumMarket = 0;
        double sumComp = 0;
        if (pointsBoxMarket1.getValue() != null) {
            weightedPointsLabelMarket1.setText(String.valueOf(df.format((((double)model.get(0).getCriteria(0).getWeight() / 100) * pointsBoxMarket1.getValue()))));
            sumMarket += Double.parseDouble(weightedPointsLabelMarket1.getText());
        }

        if (pointsBoxMarket2.getValue() != null) {
            weightedPointsLabelMarket2.setText(String.valueOf(df.format((((double)model.get(0).getCriteria(1).getWeight() / 100) * pointsBoxMarket2.getValue()))));
            sumMarket += Double.parseDouble(weightedPointsLabelMarket2.getText());
        }

        if (pointsBoxMarket3.getValue() != null) {
            weightedPointsLabelMarket3.setText(String.valueOf(df.format((((double)model.get(0).getCriteria(2).getWeight() / 100) * pointsBoxMarket3.getValue()))));
            sumMarket += Double.parseDouble(weightedPointsLabelMarket3.getText());
        }

        if (pointsBoxComp1.getValue() != null) {
            weightedPointsLabelComp1.setText(String.valueOf(df.format((((double)model.get(0).getCriteria(3).getWeight() / 100) * pointsBoxComp1.getValue()))));
            sumComp += Double.parseDouble(weightedPointsLabelComp1.getText());
        }

        if (pointsBoxComp2.getValue() != null) {
            weightedPointsLabelComp2.setText(String.valueOf(df.format((((double)model.get(0).getCriteria(4).getWeight() / 100) * pointsBoxComp2.getValue()))));
            sumComp += Double.parseDouble(weightedPointsLabelComp2.getText());
        }

        if (pointsBoxComp3.getValue() != null) {
            weightedPointsLabelComp3.setText(String.valueOf(df.format((((double)model.get(0).getCriteria(5).getWeight() / 100) * pointsBoxComp3.getValue()))));
            sumComp += Double.parseDouble(weightedPointsLabelComp3.getText());
        }

        totWeightedMarketPointsCountry3.setText(String.valueOf(df.format(sumMarket)));
        totWeightedCompPointsCountry3.setText(String.valueOf(df.format(sumComp)));

    }
    // Sets the criteria and weight entered from the criteria "page".
    public void setCriteria() {
            criteriaAreaMarket1.setText(model.get(2).getCriteria(0).getCriteria());
            weightFieldMarket1.setText(String.valueOf(model.get(2).getCriteria(0).getWeight()));

            criteriaAreaMarket2.setText(model.get(2).getCriteria(1).getCriteria());
            weightFieldMarket2.setText(String.valueOf(model.get(2).getCriteria(1).getWeight()));

            criteriaAreaMarket3.setText(model.get(2).getCriteria(2).getCriteria());
            weightFieldMarket3.setText(String.valueOf(model.get(2).getCriteria(2).getWeight()));

            criteriaAreaComp1.setText(model.get(2).getCriteria(3).getCriteria());
            weightFieldComp1.setText(String.valueOf(model.get(2).getCriteria(3).getWeight()));

            criteriaAreaComp2.setText(model.get(2).getCriteria(4).getCriteria());
            weightFieldComp2.setText(String.valueOf(model.get(2).getCriteria(4).getWeight()));

            criteriaAreaComp3.setText(model.get(2).getCriteria(5).getCriteria());
            weightFieldComp3.setText(String.valueOf(model.get(2).getCriteria(5).getWeight()));
    }

    // Sets/saves the criteria entered into our model (button on action)
    public void handleSaveFactors() {
        try {
            model.get(2).getCriteria(0).setFactors(pointsBoxMarket1.getValue(), Integer.parseInt(factFieldMarket1.getText()));
            weightedPointsLabelMarket1.setText(String.valueOf(df.format(model.get(2).getCriteria(0).getWeightedPoints())));

            model.get(2).getCriteria(1).setFactors(pointsBoxMarket2.getValue(), Integer.parseInt(factFieldMarket2.getText()));
            weightedPointsLabelMarket2.setText(String.valueOf(df.format(model.get(2).getCriteria(1).getWeightedPoints())));

            model.get(2).getCriteria(2).setFactors(pointsBoxMarket3.getValue(), Integer.parseInt(factFieldMarket3.getText()));
            weightedPointsLabelMarket3.setText(String.valueOf(df.format(model.get(2).getCriteria(2).getWeightedPoints())));

            totWeightedMarketPointsCountry3.setText(String.valueOf(df.format(model.get(2).getTotalMarketAttractiveness())));

            model.get(2).getCriteria(3).setFactors(pointsBoxComp1.getValue(), Integer.parseInt(factFieldComp1.getText()));
            weightedPointsLabelComp1.setText(String.valueOf(df.format(model.get(2).getCriteria(3).getWeightedPoints())));

            model.get(2).getCriteria(4).setFactors(pointsBoxComp2.getValue(), Integer.parseInt(factFieldComp2.getText()));
            weightedPointsLabelComp2.setText(String.valueOf(df.format(model.get(2).getCriteria(4).getWeightedPoints())));

            model.get(2).getCriteria(5).setFactors(pointsBoxComp3.getValue(), Integer.parseInt(factFieldComp3.getText()));
            weightedPointsLabelComp3.setText(String.valueOf(df.format(model.get(2).getCriteria(5).getWeightedPoints())));

            totWeightedCompPointsCountry3.setText(String.valueOf(df.format(model.get(2).getTotalCompetitiveStrength())));

            // If no country name has been entered don't change name to "blank"
            if (!countryNameField.getText().equals("")) {
                model.get(2).setCountry(countryNameField.getText());
                country3Button.setText(model.get(2).getCountry());
                viewController.getCountry1Controller().country3Button.setText(model.get(2).getCountry());
                viewController.getCountry2Controller().country3Button.setText(model.get(2).getCountry());
                viewController.getMacsFrameworkController().country3Button.setText(model.get(2).getCountry());
                viewController.getDashboardController().country3Button.setText(model.get(2).getCountry());
            }
        }
        catch (RuntimeException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Empty fields!");
            alert.setContentText("Please fill out all the fields before saving.");
            alert.showAndWait();
        }
    }

    // Switching scenes
    public void handleCountry2() {
        viewController.switchScene(ViewController.COUNTRY_2_SCENE);
    }

    public void handleCountry1() {
        viewController.switchScene(ViewController.COUNTRY_1_SCENE);
    }

    public void handleHomeButton() {
        viewController.switchScene(ViewController.DASHBOARD_SCENE);
    }

    public void handleSetCriteria() {
        viewController.switchScene(ViewController.MACS_FRAMEWORK_SCENE);
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
