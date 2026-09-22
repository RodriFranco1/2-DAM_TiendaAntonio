public class Tarea { // creamos la clase y luego se declaran sus atributos
    private String descripcion;
    private boolean completada;
    private int prioridad; // 1 = baja, 2 = media, 3 = alta

    // constructor para inicializar la tarea con su texto, prioridad y marcada como no completada por defecto
    public Tarea(String descripcion, int prioridad) {
        this.descripcion = descripcion;
        this.completada = false;
        this.prioridad = prioridad;
    }

    // getter para obtener el texto de la tarea
    public String getDescripcion() {
        return descripcion;
    }

    // getter para comprobar si esta hecha o no
    public boolean isCompletada() {
        return completada;
    }

    // getter para obtener la prioridad de la tarea
    public int getPrioridad() {
        return prioridad;
    }

    // metodo para cambiar el estado de la tarea a completada
    public void marcarComoCompletada() {
        this.completada = true;
    }

    // metodo auxiliar para convertir el numero de prioridad en texto legible
    private String getPrioridadTexto() {
        switch (prioridad) {
            case 1:
                return "Baja";
            case 2:
                return "Media";
            case 3:
                return "Alta";
            default:
                return "Sin definir";
        }
    }

    // metodo para mostrar la tarea formateada con su corchete segun si esta hecha o no, y su prioridad
    @Override
    public String toString() {
        String estado = completada ? "[X]" : "[ ]";
        return estado + " " + descripcion + " (Prioridad: " + getPrioridadTexto() + ")";
    }
}