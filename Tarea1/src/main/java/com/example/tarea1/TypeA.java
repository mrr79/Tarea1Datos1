package com.example.tarea1;
// necesito: hacer calculos con strings===> hacerlos floats (x si hubieran decimales)
// mostrar en la tabla otra vez: la tabla solo muestra strings.

public class TypeA extends Student {
    public TypeA(String carne, String nombre, String correo, String telefono, String nickname, String tipo, String promedioExamenes, String promedioQuices, String promedioTareas, String proyecto1, String proyecto2, String proyecto3, String promedioProyectos, String promedioExQT, String notaFinal) {
        super(carne, nombre, correo, telefono, nickname, tipo, promedioExamenes, promedioQuices, promedioTareas, proyecto1, proyecto2, proyecto3, promedioProyectos, promedioExQT, notaFinal);
        // como yo defini los valores de proyectos, examenes, quices y tareas como strings, ahora que los necesito como int debo de combertir el tipo de dato que son.
        int promExamenes = Integer.parseInt(promedioExamenes);
        int promQuices = Integer.parseInt(promedioQuices);
        int promTareas = Integer.parseInt(promedioTareas);
        int Proyecto1 = Integer.parseInt(proyecto1);
        int Proyecto2 = Integer.parseInt(proyecto2);
        int Proyecto3 = Integer.parseInt(proyecto3);
        // con int tambien tengo que trabajar los valores que debo calcular , para en este caso, las condiciones que establece el tipo de estudiante A.
        //se debe dejar vacío el campo Nota promedio (proyectos) y se debe completar el campo Nota promedio (exámenes, quices, tareas)
        //calculándolo con la información de las notas promedios de cada uno de estos
        int promExQT;
        promExQT = (promExamenes + promQuices + promTareas) / 3;
        // lo convierto string para poder mostrarlo en la tabla.
        String str_promExQT = String.valueOf(promExQT);

        int promFinal;
        promFinal = (promExamenes + promQuices + promTareas + Proyecto1 + Proyecto2 + Proyecto3) / 6;
        // lo convierto string para poder mostrarlo en la tabla.
        String str_promFinal = String.valueOf(promFinal);

        PromedioExQT = str_promExQT;
        PromedioProyectos = ""; //para que quede vacia
        NotaFinal = str_promFinal;
    }
}