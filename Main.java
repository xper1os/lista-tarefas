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

                System.out.println("1 - Ver resumo");
                System.out.println("2 - Ver situação das tarefas");
                System.out.println("3 - Ver progresso");
                System.out.println("4 - Ver status");
                System.out.println("0 - Sair");
                int opcao = Integer.parseInt(IO.readln("Escolha uma opção: "));

                switch (opcao) {
                    case 1 -> {
                        System.out.println("Usuário: " + nomeUsuario);
                        System.out.println("Total de Tarefas: " + totalTarefas);
                        System.out.println("Tarefas concluidas: " + tarefasConcluidas);
                        System.out.println("Pendentes de Tarefas: " + pendentes);
                    }
                    case 2 -> {
                        if (pendentes > 0) {
                            if (pendentes > 1) {
                                System.out.println("Existem " + pendentes + " tarefas pendentes!");
                            } else {
                                System.out.println("Existe " + pendentes + " tarefa pendente!");
                            }
                        } else {
                            if (totalTarefas > 1) {
                                System.out.println("Todas as tarefas foram concluídas!");
                            } else {
                                System.out.println("A tarefa foi concluída!");
                            }
                        }
                    }
                    case 3 -> {
                        System.out.println("Você concluiu " + tarefasConcluidas + " de " + totalTarefas + ".");
                        System.out.println("Progresso: " + percentual + "%");
                    }
                    case 4 -> {
                        if (percentual == 100) {
                            System.out.println("Parabéns! Tudo concluído!");
                        } else if (percentual >= 50) {
                            System.out.println("Mais da metade, continue assim!");
                        } else if (percentual > 0) {
                            System.out.println("Você já começou, bora!");
                        } else {
                            System.out.println("Ainda não começou.");
                        }
                        System.out.println("Progresso: " + percentual + "%");
                    }
                    case 0 -> System.out.println("Até logo!");
                    default -> System.out.println("Opção Inválida!");
                }
            }
        }
    }
}