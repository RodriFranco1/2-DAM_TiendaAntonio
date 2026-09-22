import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // creo la lista de tareas para ir almacenandolas
    private static ArrayList<Tarea> listaTareas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion = 0;

        // bucle do while para que el programa siga corriendo hasta que la opcion sea 5
        do {
            mostrarMenu();
            // try catch para evitar que el programa falle si se mete una letra en vez de numero
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            // condicion switch para que en funcion de la opcion elegida por el usuario ejecute un metodo u otro
            switch (opcion) {
                case 1:
                    anadirTarea();
                    break;
                case 2:
                    listarTareas();
                    break;
                case 3:
                    marcarCompletada();
                    break;
                case 4:
                    eliminarTarea();
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.\n");
            }
        } while (opcion != 5);
    }

    // metodo auxiliar para imprimir las opciones del menu
    private static void mostrarMenu() {
        System.out.println("--- Gestor tareas ---");
        System.out.println("1. Añadir tarea");
        System.out.println("2. Ver lista de tareas");
        System.out.println("3. Marcar tarea como completada");
        System.out.println("4. Eliminar tarea");
        System.out.println("5. Salir");
        System.out.print("Selecciona una opción: ");
    }

    // metodo para pedir texto y prioridad, y guardar una nueva tarea
    private static void anadirTarea() {
        System.out.print("\nIntroduce la descripción de la tarea: ");
        String descripcion = scanner.nextLine();

        if (descripcion.trim().isEmpty()) { // si no hay descripcion eliminamos espacios
            System.out.println("-> La descripción no puede estar vacía.\n");
            return;
        }

        int prioridad = pedirPrioridad(); // pedimos la prioridad al usuario con validacion
        if (prioridad == -1) {
            System.out.println("-> Operación cancelada, prioridad no válida.\n");
            return;
        }

        listaTareas.add(new Tarea(descripcion, prioridad)); // añadimos una nueva tarea a la lista con su descripcion y prioridad
        System.out.println("-> Tarea añadida con éxito.\n");
    }

    // metodo nuevo para pedir la prioridad (1 baja, 2 media, 3 alta) validando la entrada
    private static int pedirPrioridad() {
        System.out.print("Introduce la prioridad (1 = Baja, 2 = Media, 3 = Alta): ");
        try {
            int prioridad = Integer.parseInt(scanner.nextLine());
            if (prioridad >= 1 && prioridad <= 3) {
                return prioridad;
            } else {
                return -1; // fuera de rango
            }
        } catch (NumberFormatException e) {
            return -1; // entrada no numerica
        }
    }

    // metodo para mostrar por pantalla todas las tareas que tenemos guardadas
    private static void listarTareas() {
        System.out.println("\n--- Lista de tareas ---");
        if (listaTareas.isEmpty()) { // si no hay tareas se avisa
            System.out.println("No hay tareas registradas.");
        } else {
            for (int i = 0; i < listaTareas.size(); i++) { // en caso de haber se hace bucle for para listarlas
                System.out.println((i + 1) + ". " + listaTareas.get(i)); // se añade +1 por el indice 0
            }
        }
        System.out.println();
    }

    // metodo para seleccionar una tarea de la lista y cambiar su estado
    private static void marcarCompletada() {
        listarTareas();
        if (listaTareas.isEmpty()) return; // no ejecuta nada si no hay tareas

        System.out.print("Introduce el número de la tarea a marcar como completada: ");
        try {
            // le restamos 1 a la posicion introducida para cuadrar con el indice de la lista
            int indice = Integer.parseInt(scanner.nextLine()) - 1;
            if (indice >= 0 && indice < listaTareas.size()) {
                listaTareas.get(indice).marcarComoCompletada();
                System.out.println("-> Tarea marcada como completada.\n");
            } else {
                System.out.println("-> Número de tarea inválido.\n");
            }
        } catch (NumberFormatException e) {
            System.out.println("-> Entrada no válida.\n");
        }
    }

    // metodo para eliminar una tarea seleccionandola por su número
    private static void eliminarTarea() {
        listarTareas();
        if (listaTareas.isEmpty()) return;

        System.out.print("Introduce el número de la tarea a eliminar: ");
        try {
            // se vuelve a restar 1 para borrar la posicion exacta de la lista
            int indice = Integer.parseInt(scanner.nextLine()) - 1;
            if (indice >= 0 && indice < listaTareas.size()) {
                listaTareas.remove(indice);
                System.out.println("-> Tarea eliminada correctamente.\n");
            } else {
                System.out.println("-> Número de tarea inválido.\n");
            }
        } catch (NumberFormatException e) {
            System.out.println("-> Entrada no válida.\n");
        }
    }
}