package com.example.tarea1;
import java.io.*;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;

import java.util.ArrayList;
import java.util.List;

import java.util.ResourceBundle;

public class HelloController implements Initializable {
    // elementos de la interfaz
    @FXML
    private Button btn_add;
    @FXML
    private AnchorPane table;
    @FXML
    private TableView<Student> Table; // Lo que se le dice a la tabla es que contenga los datos que estan en la clase estudiantes.

    // columnas de la tabla que se carga por el archivo CSV
    @FXML
    private TableColumn<Student, String> Carne;
    @FXML
    private TableColumn<Student, String> Nombre;
    @FXML
    private TableColumn<Student, String> Correo;
    @FXML
    private TableColumn<Student, String> Telefono;
    @FXML
    private TableColumn<Student, String> Nickname;
    @FXML
    private TableColumn<Student, String> Tipo;
    @FXML
    private TableColumn<Student, String> PromedioExamenes;
    @FXML
    private TableColumn<Student, String> PromedioQuices;
    @FXML
    private TableColumn<Student, String> PromedioTareas;
    @FXML
    private TableColumn<Student, String> Proyecto1;
    @FXML
    private TableColumn<Student, String> Proyecto2;
    @FXML
    private TableColumn<Student, String> Proyecto3;

    // columnas adicionales
    @FXML
    private TableColumn<Student, String> PromedioProyectos;
    @FXML
    private TableColumn<Student, String> PromedioExQT;
    @FXML
    private TableColumn<Student, String> NotaFinal;

    ObservableList<Student> List = FXCollections.observableArrayList();
    @FXML
// formato de upload csv tomado de internet.
    public void SelectFile(MouseEvent event) throws IOException {
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        List<String> CSVfile = new ArrayList<>();

        if (selectedFile != null) {
            String direccionCSV = selectedFile.getAbsolutePath();
            String fila = "";

            BufferedReader br = new BufferedReader(new FileReader(direccionCSV));
            while((fila = br.readLine()) != null) {
                String[] values = fila.split(",");

                for(int i = 0; i < 12; i++){
                    CSVfile.add(values[i]);
                }
            }
            int ListSize = CSVfile.size();
// me gustaria tirar otro boton aqui, que actualice el archivo csv
            for(int i = 0; i < ListSize/12; i++){
                List.add(new Student(CSVfile.get(12 * i), // las 12 son las 12 columnas (es decir las 12 casillas 1ue hay por cada fila (estudiante))
                        CSVfile.get(12 * i + 1),
                        CSVfile.get(12 * i + 2),
                        CSVfile.get(12 * i + 3),
                        CSVfile.get(12 * i + 4),
                        CSVfile.get(12 * i + 5),
                        CSVfile.get(12 * i + 6),
                        CSVfile.get(12 * i + 7),
                        CSVfile.get(12 * i + 8),
                        CSVfile.get(12 * i + 9),
                        CSVfile.get(12 * i + 10) ,
                        CSVfile.get(12 * i + 11),
                        "NONE", // vacias por que aun no se como hacer la programacion de estas: son calculadas dependiendo del tipo de datos
                        "NONE",
                        "NONE"));
            }

            Table.refresh(); // refresca el contenido

        }
    }

    // asi es como se le ubica a cada valor del CSV en una celda, segun los valores que representan. cada linea representa un estudiante.
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        Carne.setCellValueFactory(new PropertyValueFactory<>("Carne"));
        Nombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        Correo.setCellValueFactory(new PropertyValueFactory<>("Correo"));
        Telefono.setCellValueFactory(new PropertyValueFactory<>("Telefono"));
        Nickname.setCellValueFactory(new PropertyValueFactory<>("Nickname"));
        Tipo.setCellValueFactory(new PropertyValueFactory<>("Tipo"));
        PromedioExamenes.setCellValueFactory(new PropertyValueFactory<>("PromedioExamenes"));
        PromedioQuices.setCellValueFactory(new PropertyValueFactory<>("PromedioQuices"));
        PromedioTareas.setCellValueFactory(new PropertyValueFactory<>("PromedioTareas"));
        Proyecto1.setCellValueFactory(new PropertyValueFactory<>("Proyecto1"));
        Proyecto2.setCellValueFactory(new PropertyValueFactory<>("Proyecto2"));
        Proyecto3.setCellValueFactory(new PropertyValueFactory<>("Proyecto3"));
        PromedioProyectos.setCellValueFactory(new PropertyValueFactory<>("PromedioProyectos"));
        PromedioExQT.setCellValueFactory(new PropertyValueFactory<>("PromedioExQT"));
        NotaFinal.setCellValueFactory(new PropertyValueFactory<>("NotaFinal"));

        Table.setItems(List);
    }
}
// todo se importa en formato string porque no me dejaba importar algunos en string y otros en interger. por esto cuando tenga que hacer los calculos voy a tener que cambiar
// el tipo de dato de los que se necesiten.