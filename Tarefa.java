public class Tarefa {
    private String titulo;
    private boolean concluida;

    Tarefa(String titulo) {
        this.setTitulo(titulo);
        this.concluida = false; // toda tarefa nova nasce pendente
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("O título não pode ser vazio!");
        }
        this.titulo = titulo;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }
}
