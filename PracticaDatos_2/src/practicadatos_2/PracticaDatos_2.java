package practicadatos_2;

import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Mateo Marulanda
 * @author Yeshua Narvaez
 */
public class PracticaDatos_2 {

    static Estudiantes estudiante = new Estudiantes();
    static LinkedList<String> notas = new LinkedList<String>();
    static LinkedList<String> materias = new LinkedList<String>();

    /**
     * Clase main
     *
     * @param args
     */
    public static void main(String[] args) {

        Scanner lector = new Scanner(System.in);
        System.out.println("Inserte el tipo de busqueda: 1. Año y Nombre 2. Semestre y Materia");
        int n = lector.nextInt();

        while (n == 1 || n == 2) {
            long inicio = 0;
            if (n == 1) {
                System.out.println("inserte el año");
                String año = lector.next();
                System.out.println("inserte nombre");
                String nombre = lector.next();
                inicio = System.currentTimeMillis();
                System.out.println("---------------");
                Estudiantes estudiante = lectura(año, nombre);
                HashMap<String, HashMap<String, Estudiantes>> secundario = new HashMap();
                HashMap<String, Estudiantes> principal = new HashMap<String, Estudiantes>();
                principal.put(nombre, estudiante);
                secundario.put(año, principal);
                estudiante.busqueda1(secundario, año, nombre);

            } else if (n == 2) {
                System.out.println("inserte el año");
                String año = lector.next();
                System.out.println("inserte materia");
                lector.nextLine();
                String materia = lector.nextLine();
                Estudiantes estudiante = lectura2(año, materia);
                HashMap<String, HashMap<String, Estudiantes>> secundario = new HashMap();
                HashMap<String, Estudiantes> principal = new HashMap<String, Estudiantes>();
                principal.put(materia, estudiante);
                secundario.put(año, principal);
                estudiante.busqueda1(secundario, año, materia);
                estudiante = null;
            }
            System.out.println("Inserte el tipo de busqueda: 1. Año y Nombre 2. Semestre y Materia 3. Salir");
            float memory = usedMemory() / 8;
            memory = memory / 1024;
            memory = memory / 1024;
            System.out.println(memory);
            long finaliza = System.currentTimeMillis() - inicio;
            System.out.println(finaliza);
            n = lector.nextInt();
        }
    }

    /**
     *
     * @param año para filtrar por el año
     * @param code2 sera el nombre del alumno
     * @return objeto de tipo estudiantes con la informacion
     */
    public static Estudiantes lectura(String año, String code2) {

        String csvFile = "NOTAS ST0242.csv";
        String csvFile2 = "NOTAS ST0245.csv";
        String csvFile3 = "NOTAS ST0247.csv";

        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(csvFile));
            String[] line;
            while ((line = reader.readNext()) != null) {
                if (line[0].equals(code2) && line[3].equals(año)) {
                    notas.add(line[11]);
                    materias.add(line[8]);
                    estudiante = new Estudiantes(line[0], line[3], notas, materias);

                }
            }
            reader = new CSVReader(new FileReader(csvFile2));
            while ((line = reader.readNext()) != null) {
                if (line[0].equals(code2) && line[3].equals(año)) {
                    notas.add(line[11]);
                    materias.add(line[8]);
                    estudiante = new Estudiantes(line[0], line[3], notas, materias);

                }
            }
            reader = new CSVReader(new FileReader(csvFile3));
            while ((line = reader.readNext()) != null) {
                if (line[0].equals(code2) && line[3].equals(año)) {
                    notas.add(line[11]);
                    materias.add(line[8]);
                    estudiante = new Estudiantes(line[0], line[3], notas, materias);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return estudiante;
    }

    /**
     *
     * @param año para filtrar por el año
     * @param materia sera el nombre del alumno
     * @return objeto de tipo estudiantes con la informacion
     */
    public static Estudiantes lectura2(String año, String materia) {
        String csvFile = "NOTAS ST0242.csv";
        String csvFile2 = "NOTAS ST0245.csv";
        String csvFile3 = "NOTAS ST0247.csv";
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(csvFile));
            String[] line;
            while ((line = reader.readNext()) != null) {

                if (line[8].equals(materia) && line[3].equals(año)) {
                    notas.add(line[11]);
                    materias.add(line[0]);
                    estudiante = new Estudiantes(line[0], line[3], notas, materias);

                }
            }
            reader = new CSVReader(new FileReader(csvFile2));
            while ((line = reader.readNext()) != null) {
                if (line[8].equals(materia) && line[3].equals(año)) {
                    notas.add(line[11]);
                    materias.add(line[0]);
                    estudiante = new Estudiantes(line[0], line[3], notas, materias);

                }
            }
            reader = new CSVReader(new FileReader(csvFile3));
            while ((line = reader.readNext()) != null) {
                if (line[8].equals(materia) && line[3].equals(año)) {
                    notas.add(line[11]);
                    materias.add(line[0]);
                    estudiante = new Estudiantes(line[0], line[3], notas, materias);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return estudiante;
    }

    /**
     * Metodo para consultar el consumo de memoria
     *
     * @return consumo de memoria en Mb
     */
    public static float usedMemory() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }
}
