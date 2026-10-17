public class Tarefa {
    private String titulo;
    private boolean concluida;
    private Prioridade prioridade;

    Tarefa(String titulo, Prioridade prioridade) {
        this.setTitulo(titulo);
        this.concluida = false; // toda tarefa nova nasce pendente
        this.setPrioridade(prioridade);
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        if (prioridade == null) {
            throw new IllegalArgumentException("Prioridade não pode ser nula!");
        }
        this.prioridade = prioridade;
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

    public void concluir() {
        this.concluida = true;
    }

    public void reabrir() {
        this.concluida = false;
    }

    @Override
    public String toString() {
        String marcador;
        if (concluida) {
            marcador = "[x] ";
        } else {
            marcador = "[ ] ";
        }
        return marcador + titulo + " - " + prioridade;
    }
}
