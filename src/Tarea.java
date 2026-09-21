public class Tarea { // creamos la clase y luego se declaran sus atributos
    private String descripcion;
    private boolean completada;

    // constructor para inicializar la tarea con su texto y marcada como no completada por defecto
    public Tarea(String descripcion) {
        this.descripcion = descripcion;
        this.completada = false;
    }

    // getter para obtener el texto de la tarea
    public String getDescripcion() {
        return descripcion;
    }

    // getter para comprobar si esta hecha o no
    public boolean isCompletada() {
        return completada;
    }

    // metodo para cambiar el estado de la tarea a completada
    public void marcarComoCompletada() {
        this.completada = true;
    }

    // metodo para mostrar la tarea formateada con su corchete segun si esta hecha o no
    @Override
    public String toString() {
        String estado = completada ? "[X]" : "[ ]";
        return estado + " " + descripcion;
    }
}