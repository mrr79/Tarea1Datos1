package com.example.tarea1;
import java.io.*;

import javafx.beans.Observable;
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
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
    /**
     Encapsulacion: la encapsulacion es ocultar los detalles de implementación a los usuarios. Si un miembro de datos es privado,
     significa que solo se puede acceder a él dentro de la misma clase. Ninguna clase externa puede acceder al miembro de datos privados (variable) de otra clase.
     El uso de private en las lineas 31-69 del controller son un ejemplo de encapsulacion donde solo puede establecer y obtener valores de estas variables a través
     de los métodos de la clase.
     tomado de: https://beginnersbook.com/2013/05/encapsulation-in-java/#:~:text=What%20is%20encapsulation%3F,(variable)%20of%20other%20class.
     */
    ObservableList<Student> List = FXCollections.observableArrayList();
    @FXML

    public void SelectFile(MouseEvent event) throws IOException {
        /**
         * Este es el primer metoodo que se crea en la programacion, que como se establece en clase, son operaciones que me permiten hacer cambios en los atributos de los objetos.
         * Este metodo es de tipo void: que es una palabra clave especifica para un método que no debe tener un valor de retorno
         * El metodo SelectFile se ve aplicado en la interfaz y consiste en primeramente elejir un archivo csv de la computadora, luego el programa toma cada una de las lineas(hasta el /n) del archivo
         * y procede a crearlo como tipo strings segun el index.
         * Posteriormente, analiza si el index 5, es decir, la posisicion 6 correspondiente al tipo de dato es a o b y lo anade a la clase segun ese tipo de dato. este es un ejemplo de instanciacion.
         * Tomado de:  Alex Lee https://youtu.be/-Aud0cDh-J8
         */
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        List<String> CSVfile = new ArrayList<>();

        if (selectedFile != null) {
            String direccionCSV = selectedFile.getAbsolutePath();
            String fila = "";

            BufferedReader br = new BufferedReader(new FileReader(direccionCSV));
            while((fila = br.readLine()) != null) {
                String[] values = fila.split(",");
                ///en esta parte, toma cada fila y segun su posicion/index se le da a una celda.
                String DCarne = values[0];
                String DNombre = values[1];
                String Dcorreo = values[2];
                String DTelefono = values[3];
                String DNickname = values[4];
                String DTipo = values[5];
                String DPromedioExamenes = (values[6]);
                String PromedioQuices =  (values[7]);
                String PromedioTareas = (values[8]);
                String Proyecto1 = (values[9]);
                String Proyecto2 = (values[10]);
                String Proyecto3 =  (values[11]);
                String DPromedioProyectos = "";
                String DPromedioExQT = "";
                String DNotaFinal = "";
                /**
                 *  En la determinacion del tipo de dato se observa un ejemplo de instanciacion, que se segun lo visto en clase es, crear un objeto usando el 'molde' de una clase definida por aparte.
                 *  En este caso, se crean Student dependiendo del tipo, siendo estos TypeA o TypeB, que tienen como aributos los creados anteriormente, que dependen del CSV y de los calculos.
                    Tambien, en la determinacion del tipo de dato, se muestra un ejemplo de polimorfismo, ya que estos se instancian de formas diferentes segun el tipo de dato.
                 */
                if (Objects.equals(values[5], "a")) {
                    List.add(new TypeA(DCarne, DNombre, Dcorreo, DTelefono, DNickname, DTipo, DPromedioExamenes, PromedioQuices, PromedioTareas, Proyecto1, Proyecto2,  Proyecto3, DPromedioProyectos, DPromedioExQT, DNotaFinal));

                }
                if (Objects.equals(values[5], "b")) {
                    List.add(new TypeB(DCarne, DNombre, Dcorreo, DTelefono, DNickname, DTipo, DPromedioExamenes, PromedioQuices, PromedioTareas, Proyecto1, Proyecto2,  Proyecto3, DPromedioProyectos, DPromedioExQT, DNotaFinal));

                }
// Objects.equals sirve para: a static method of the Objects class that accepts two objects and checks if the objects are equal.
// entonces con esta comparo si lo que esta en la columna 6 (index 5) es b o es a, y depende lo meto en esa clase de una vez.


                Table.refresh(); // refresca el contenido
            }
            /**
             Encapsulacion: El uso de una interfaz es tambien un ejemplo de encapsulacion porque perimete al usuario tener acceso mediante una interfaz para cambviar los atributos de un objeto.
             es decir, se opera en la interfaz, no con la memoria como tal.
             tomado de la presentacion de clase
             */
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