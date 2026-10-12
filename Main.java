public class Main {
    public static void main(String[] args) {

        System.out.println("Minhas Tarefas");
        System.out.println("Bem vindo a sua lista de Tarefas!");

        String nomeUsuario = IO.readln("Digite seu nome: ");
        int totalTarefas = Integer.parseInt(IO.readln("Quantas tarefas você tem atualmente?: "));

        if (totalTarefas < 0) {
            System.out.println("Tarefas não podem ser menor que zero!");
        } else if (totalTarefas == 0) {
            System.out.println("Você não tem tarefas!");
        } else {
            int tarefasConcluidas = Integer.parseInt(IO.readln("Quantas tarefas concluidas?: "));
            if (tarefasConcluidas < 0) {
                System.out.println("Tarefas concluídas não podem ser menor que zero!");
            } else if (tarefasConcluidas > totalTarefas) {
                System.out.println("Tarefas concluídas não podem ser maior que o numero total de tarefas!");
            } else {
                int pendentes = totalTarefas - tarefasConcluidas;
                double percentual = (double) tarefasConcluidas / totalTarefas * 100;

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
        }
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
        System.out.println("Tarefas concluidas: " + concluidas);
        System.out.println("Pendentes de Tarefas: " + pendentes);
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
        System.out.println(String.format("Progresso: %.2f%%", percentual));
    }
}
