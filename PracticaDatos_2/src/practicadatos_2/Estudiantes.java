package practicadatos_2;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author Mateo Marulanda
 * @author Yeshua Narvaez
 */
public class Estudiantes {

    String nombre;
    String years;
    LinkedList<String> notas;
    LinkedList<String> materias;

    /**
     * Constructor de estudiantes
     */
    public Estudiantes() {
    }

    /**
     *
     * @param nombre alumno
     * @param years
     * @param notas linked list con las notas
     * @param materias linked list con las materias
     */
    public Estudiantes(String nombre, String years, LinkedList<String> notas, LinkedList<String> materias) {
        this.nombre = nombre;
        this.years = years;
        this.notas = notas;
        this.materias = materias;
    }

    /**
     * metodo para obtener las notas
     *
     * @return lista con las notas
     */
    public LinkedList<String> getNotas() {
        return notas;
    }

    /**
     * metodo para setear las notas
     *
     */
    public void setNotas(LinkedList<String> notas) {
        this.notas = notas;
    }

    /**
     * metodo para obtener las materias
     *
     * @return lista con las materias
     */
    public LinkedList<String> getMaterias() {
        return materias;
    }

    /**
     * metodo para setear las materias
     */
    public void setMaterias(LinkedList<String> materias) {
        this.materias = materias;
    }

    /**
     * metodo para obtener el año
     *
     * @return año
     */
    public String getYears() {
        return years;
    }

    /**
     * metodo para setear el año
     */
    public void setYears(String years) {
        this.years = years;
    }

    /**
     * metodo para obtener el nombre
     *
     * @return nombre del alumno
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * metodo para setear el nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @param estudiantes hasmap de los estudiantes
     * @param año el año a buscar
     * @param code2 el nombre a buscar
     */
    public void busqueda1(HashMap<String, HashMap<String, Estudiantes>> estudiantes, String año, String code2) {
        if (getNombre() == null && getYears() == null) {
            System.out.println("el año o el codigo no existe");

        } else if (estudiantes.containsKey(año) && estudiantes.get(año).containsKey(code2)) {
            System.out.println(estudiantes.get(año).get(code2).getNombre());
            MostrarMateriasNotas(getMaterias(), getNotas());
        }

    }

    /**
     *
     * @param materias Materias
     * @param notas Notas
     */
    public void MostrarMateriasNotas(LinkedList<String> materias, LinkedList<String> notas) {
        for (int i = 0; i < materias.size(); i++) {

            System.out.println(materias.get(i) + " | " + notas.get(i));

        }
        System.out.println("------------------");

    }

}
