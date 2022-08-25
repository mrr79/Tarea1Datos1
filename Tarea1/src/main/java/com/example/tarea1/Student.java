package com.example.tarea1;

public class Student {
    /** Herencia
     * Para los atributos de la clase student, se usa Protected porque cuando una variable o método está protegido, puede overriding a otra subclase utilizando solo un modificador
     * público o protegido. Los atributos de la clase Student estan protegidos y esto hace que sean accesibles solamente por las clases hijas , y la clase TypeA y TypeB se heredan de la clase Student,
     * luego se accede a este método protegido creando un objeto de la clase TypeA o TypeB.
     */
    protected String Carne;
    protected String Nombre;
    protected String Correo;
    protected String Telefono;
    protected String Nickname;
    protected String Tipo;
    protected String PromedioExamenes;
    protected String PromedioQuices;
    protected String PromedioTareas;
    protected String Proyecto1;
    protected String Proyecto2;
    protected String Proyecto3;

    // todos estos son los atributos del programa
    protected String NotaFinal;
    protected String PromedioExQT;
    protected String PromedioProyectos;

    // el protected es una aplicacion del encapsulamiento ya que solo se usa en clases hijas.

    public Student(String carne, String nombre, String correo, String telefono, String nickname, String tipo, String promedioExamenes, String promedioQuices, String promedioTareas, String proyecto1, String proyecto2, String proyecto3, String promedioProyectos, String promedioExQT, String notaFinal) {
        Carne = carne;
        Nombre = nombre;
        Correo = correo;
        Telefono = telefono;
        Nickname = nickname;
        Tipo = tipo;
        PromedioExamenes = promedioExamenes;
        PromedioQuices = promedioQuices;
        PromedioTareas = promedioTareas;
        Proyecto1 = proyecto1;
        Proyecto2 = proyecto2;
        Proyecto3 = proyecto3;
        PromedioProyectos = promedioProyectos;
        PromedioExQT = promedioExQT;
        NotaFinal = notaFinal;
    }
    public String getCarne() {return Carne;}
    public String getNombre() {return Nombre;}
    public String getCorreo() {return Correo;}
    public String getTelefono() {return Telefono;}
    public String getNickname() {return Nickname;}
    public String getTipo() {
        return Tipo;
    }
    public String getPromedioExamenes() {return PromedioExamenes;}
    public String getPromedioQuices() {return PromedioQuices;}
    public String getPromedioTareas() {
        return PromedioTareas;
    }
    public String getProyecto1() {
        return Proyecto1;
    }
    public String getProyecto2() {
        return Proyecto2;
    }
    public String getProyecto3() {
        return Proyecto3;
    }
    public String getPromedioProyectos() {
        return PromedioProyectos;
    }
    public String getPromedioExQT() {
        return PromedioExQT;
    }
    public String getNotaFinal() {
        return NotaFinal;
    }
}