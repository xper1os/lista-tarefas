public class Main {
    public static void main(String[] args) {

        Tarefa t1 = new Tarefa("Estudar Java");
        Tarefa t2 = new Tarefa("Fazer o README");
        Tarefa t3 = new Tarefa("Aprender Orientação a Objetos");

        t1.concluir();
        t3.concluir();
        t3.reabrir();

        System.out.println(t1.getTitulo() + " - concluída? " + t1.isConcluida());
        System.out.println(t2.getTitulo() + " - concluída? " + t2.isConcluida());
        System.out.println(t3.getTitulo() + " - concluída? " + t3.isConcluida());
        // Fim do experimento

        System.out.println("Minhas Tarefas");
        System.out.println("Bem-vindo à sua lista de tarefas!");

        String nomeUsuario = IO.readln("Digite seu nome: ");

        int totalTarefas = lerTotal();
        int tarefasConcluidas = lerConcluidas(totalTarefas);
        int pendentes = calcularPendentes(totalTarefas, tarefasConcluidas);
        double percentual = calcularPercentual(tarefasConcluidas, totalTarefas);

        int opcao;
        do {
            mostrarMenu();
            opcao = Integer.parseInt(IO.readln("Escolha uma opção: "));
            switch (opcao) {
                case 1 -> mostrarResumo(nomeUsuario, totalTarefas, tarefasConcluidas, pendentes, percentual);
                case 2 -> mostrarSituacao(pendentes, totalTarefas);
                case 3 -> mostrarProgresso(tarefasConcluidas, totalTarefas, percentual);
                case 4 -> mostrarStatus(percentual);
                case 5 -> mostrarLista(totalTarefas, tarefasConcluidas);
                case 0 -> System.out.println("Até logo!");
                default -> System.out.println("Opção Inválida!");
            }
        } while (opcao != 0);

    }

    static void mostrarMenu() {
        System.out.println("Menu:");
        System.out.println("1 - Ver resumo");
        System.out.println("2 - Ver situação das tarefas");
        System.out.println("3 - Ver progresso");
        System.out.println("4 - Ver status");
        System.out.println("5 - Ver lista");
        System.out.println("0 - Sair");
    }

    static void mostrarLista(int total, int concluidas) {
        for (int i = 1; i <= total; i++) {
            if (concluidas >= i) {
                System.out.println("Tarefa " + i + " - [x] Concluída!");
            } else {
                System.out.println("Tarefa " + i + " - [ ] Pendente!");
            }
        }
    }

    static void mostrarResumo(String usuario, int total, int concluidas, int pendentes, double percentual) {
        System.out.println("Resumo:");
        System.out.println("Usuário: " + usuario);
        System.out.println("Total de Tarefas: " + total);
        System.out.println("Tarefas concluídas: " + concluidas);
        System.out.println("Tarefas pendentes: " + pendentes);
        mostrarPercentual(percentual);
    }

    static void mostrarSituacao(int pendentes, int total) {
        if (pendentes > 0) {
            if (pendentes > 1) {
                System.out.println("Existem " + pendentes + " tarefas pendentes!");
            } else {
                System.out.println("Existe " + pendentes + " tarefa pendente!");
            }
        } else {
            if (total > 1) {
                System.out.println("Todas as tarefas foram concluídas!");
            } else {
                System.out.println("A tarefa foi concluída!");
            }
        }
    }

    static void mostrarProgresso(int concluidas, int total, double percentual) {
        System.out.println("Você concluiu " + concluidas + " de " + total + ".");
        mostrarPercentual(percentual);
    }

    static void mostrarStatus(double percentual) {
        if (percentual == 100) {
            System.out.println("Parabéns! Tudo concluído!");
        } else if (percentual >= 50) {
            System.out.println("Mais da metade, continue assim!");
        } else if (percentual > 0) {
            System.out.println("Você já começou, bora!");
        } else {
            System.out.println("Ainda não começou.");
        }
        mostrarPercentual(percentual);
    }

    static void mostrarPercentual(double percentual) {
        System.out.printf("Progresso: %.2f%%%n", percentual);
    }

    static double calcularPercentual(int concluidas, int total) {
        return (double) concluidas / total * 100;
    }

    static int lerTotal() {
        int total;
        do {
            total = Integer.parseInt(IO.readln("Quantas tarefas você tem atualmente?: "));
            if (total < 0) {
                System.out.println("Total de tarefas não pode ser negativo!");
            } else if (total == 0) {
                System.out.println("Total de tarefas não pode ser zero!");
            }
        } while (total <= 0);

        return total;
    }

    static int lerConcluidas(int total) {
        int concluidas;
        do {
            concluidas = Integer.parseInt(IO.readln("Quantas tarefas concluídas?: "));
            if (concluidas < 0) {
                System.out.println("Total de concluídas não pode ser negativo!");
            } else if (concluidas > total) {
                System.out.println("Total de concluídas não pode ser maior que o total de tarefas!");
            }
        } while (concluidas < 0 || concluidas > total);

        return concluidas;
    }

    static int calcularPendentes(int total, int concluidas) {
        return total - concluidas;
    }
}
