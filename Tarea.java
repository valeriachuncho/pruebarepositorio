package pruebaia;

public class Tarea extends Thread {

    private String[] fila;
    private String palabra;
    private int numeroFila;
    private int conteo;

    public Tarea(
            String[] fila,
            String palabra,
            int numeroFila
    ) {

        this.fila = fila;
        this.palabra = palabra;
        this.numeroFila = numeroFila;
    }

    @Override
    public void run() {

        for (int i = 0; i < fila.length; i++) {

            if (fila[i].equalsIgnoreCase(palabra)) {
                conteo++;
            }
        }

        System.out.println(
                "Hilo-" + numeroFila
                        + " encontró "
                        + conteo
        );
    }

    public int getConteo() {
        return conteo;
    }
}
