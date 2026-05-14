package pruebaia;

public class App1 {

    public static void main(String[] args) {

        // Matriz 3x3
        String[][] matriz = {
                {"Java", "Python", "Java"},
                {"C++", "Java", "Go"},
                {"Java", "Rust", "Java"}
        };

        // Palabra a buscar
        String palabra = "Java";

        // Arreglo de hilos
        Tarea[] hilos = new Tarea[matriz.length];

        // Crear y ejecutar hilos
        for (int i = 0; i < matriz.length; i++) {

            hilos[i] = new Tarea(
                    matriz[i],
                    palabra,
                    i
            );

            hilos[i].start();
        }

        int total = 0;

        // Esperar hilos
        for (int i = 0; i < hilos.length; i++) {

            try {

                hilos[i].join();

                total += hilos[i].getConteo();

            } catch (InterruptedException e) {

                System.out.println(
                        "Error al esperar hilos."
                );

                e.printStackTrace();
            }
        }

        System.out.println(
                "\nResultado total: " + total
        );
    }
}