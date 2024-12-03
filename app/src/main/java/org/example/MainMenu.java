package org.example;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
public class MainMenu extends VBox {

    MainMenuButton exitButton;
    public MainMenu() {
        Image backIcon = new Image(getClass().getResourceAsStream("/images/backarrow.png"));
        ImageView backIconView = new ImageView(backIcon);
        backIconView.setFitWidth(20);
        backIconView.setFitHeight(20);

        //Main Menu buttons
        MainMenuButton AIButton = new MainMenuButton("AI");
        MainMenuButton twoPlayerButton = new MainMenuButton("Local");
        exitButton = new MainMenuButton("Exit");
        exitButton.setGraphic(backIconView);

        this.getChildren().addAll(AIButton, twoPlayerButton, exitButton);

        this.setSpacing(20); // Space between buttons
        this.setStyle("-fx-alignment: center;"); // Center the buttons in the VBox

        AIButton.setOnAction(e -> {
            //delete current scene & create 5 new buttons
            this.getChildren().clear();
            MainMenuButton easyButton = new MainMenuButton("Easy");
            MainMenuButton mediumButton = new MainMenuButton("Medium");
            MainMenuButton hardButton = new MainMenuButton("Hard");
            MainMenuButton impossibleButton = new MainMenuButton("Impossible");
            MainMenuButton backButton = new MainMenuButton("Back");
            backButton.setGraphic(backIconView);

            this.getChildren().addAll(easyButton, mediumButton, hardButton, impossibleButton, backButton);
            backButton.setOnAction(e2 -> {
                //delete current scene & create 3 main menu buttons
                this.getChildren().clear();
                //fix to a weird bug where the button loses its graphic but JavaFX still thinks it has one
                exitButton = new MainMenuButton("Exit");
                exitButton.setGraphic(backIconView);
                this.getChildren().addAll(AIButton, twoPlayerButton, exitButton);
            });
        });
        twoPlayerButton.setOnAction(e -> {
            TTTUI tttui = new TTTUI();
            App.scene.setRoot(tttui);
        });
        exitButton.setOnAction(e -> System.exit(0));
    }
}
