@echo off
rem Runs the JAR outside VS Code, supplying the JavaFX VM arguments (lab page 27)
cd /d "%~dp0"
java --module-path "%~dp0javafx-sdk-17.0.2\lib" --add-modules javafx.controls,javafx.fxml -jar votingapplication.jar
