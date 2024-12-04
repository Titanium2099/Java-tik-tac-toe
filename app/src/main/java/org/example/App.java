/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;

import java.awt.Taskbar;
import java.awt.Toolkit;
import java.net.URL;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class App extends Application {

    public static Scene scene; // static so it can be accessed from other classes
    public static MainMenu mainMenu; //static so it can be accessed from other classes
    @Override
    public void start(Stage primaryStage) {
        URL imageResource = App.class.getClassLoader().getResource("assets/icon-512.png");
        if (imageResource == null) {
            System.out.println("Icon resource not found!");
            return;
        }

        // Set the stage icon
        primaryStage.getIcons().add(new Image("file:src/main/resources/assets/512x512.png")); // Replace with your icon path


        // Configure the Taskbar icon (requires Java 9+)
        try {
            Taskbar taskbar = Taskbar.getTaskbar();
            java.awt.Image awtImage = Toolkit.getDefaultToolkit().getImage(imageResource);
            taskbar.setIconImage(awtImage);
        } catch (UnsupportedOperationException e) {
            System.out.println("The OS does not support Taskbar.setIconImage");
        } catch (SecurityException e) {
            System.out.println("There was a security exception for Taskbar.setIconImage");
        }
        /*
        mainMenu = new MainMenu();

        scene = new Scene(mainMenu, 1120, 630);
        scene.getStylesheets().add(getClass().getResource("/main.css").toExternalForm());
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.getIcons().add(new Image("file:src/main/resources/512x512.png")); // Replace with your icon path
        primaryStage.setScene(scene);
        primaryStage.show();
        */
        /*Connect4 connect4 = new Connect4(3);
        scene = new Scene(connect4, 1120, 630);
        scene.getStylesheets().add(getClass().getResource("/main.css").toExternalForm());
        primaryStage.setTitle("Connect 4");
        primaryStage.getIcons().add(new Image("file:src/main/resources/512x512.png")); // Replace with your icon path
        primaryStage.setScene(scene);
        primaryStage.show();
        */
        GameMenu MainGameMenu = new GameMenu();
        scene = new Scene(MainGameMenu, 1120, 630);
        scene.getStylesheets().add(getClass().getResource("/main.css").toExternalForm());
        primaryStage.setTitle("Connect 4");
        primaryStage.getIcons().add(new Image("file:src/main/resources/512x512.png")); // Replace with your icon path
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args); // Start JavaFX application
    }
}
