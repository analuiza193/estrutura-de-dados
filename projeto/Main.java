package projeto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListarPacientes lista = new ListarPacientes();

        int opcao;

        do {
            System.out.println("\n===== CADASTRO DE PACIENTES =====");
            System.out.println("1 - Cadastrar paciente no início");
            System.out.println("2 - Cadastrar paciente no fim");
            System.out.println("3 - Cadastrar paciente em uma posição");
            System.out.println("4 - Remover paciente do início");
            System.out.println("5 - Remover paciente do fim");
            System.out.println("6 - Remover paciente de uma posição");
            System.out.println("7 - Verificar paciente por posição");
            System.out.println("8 - Listar todos os pacientes");
            System.out.println("9 - Pesquisar paciente por CPF");
            System.out.println("10 - Pesquisar paciente por prontuário");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            while (!sc.hasNextInt()) {
                System.out.println("Digite um número válido.");
                sc.nextLine();
                System.out.print("Escolha uma opção: ");
            }

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    lista.inserirInicio(cadastrarPaciente(sc));
                    System.out.println("Paciente cadastrado no início!");
                    break;

                case 2:
                    lista.inserirFim(cadastrarPaciente(sc));
                    System.out.println("Paciente cadastrado no fim!");
                    break;

                case 3: {
                    Paciente p = cadastrarPaciente(sc);
                    System.out.print("Informe a posição: ");
                    int posicao = lerInteiro(sc);

                    if (lista.inserirPosicao(p, posicao)) {
                        System.out.println("Paciente cadastrado com sucesso!");
                    } else {
                        System.out.println("Posição inválida.");
                    }
                    break;
                }

                case 4:
                    exibirRemovido(lista.removerInicio());
                    break;

                case 5:
                    exibirRemovido(lista.removerFim());
                    break;

                case 6: {
                    System.out.print("Informe a posição: ");
                    int posicao = lerInteiro(sc);
                    exibirRemovido(lista.removerPosicao(posicao));
                    break;
                }

                case 7: {
                    System.out.print("Informe a posição: ");
                    int posicao = lerInteiro(sc);
                    Paciente p = lista.verificarPosicao(posicao);

                    if (p != null) {
                        System.out.println(p);
                    } else {
                        System.out.println("Posição inválida ou lista vazia.");
                    }
                    break;
                }

                case 8:
                    lista.listarPacientes();
                    break;

                case 9:
                    System.out.print("Informe o CPF: ");
                    String cpf = sc.nextLine();
                    exibirPesquisa(lista.pesquisarCpf(cpf));
                    break;

                case 10:
                    System.out.print("Informe o prontuário: ");
                    String prontuario = sc.nextLine();
                    exibirPesquisa(lista.pesquisarProntuario(prontuario));
                    break;

                case 0:
                    System.out.println("Sistema encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        sc.close();
    }

    // Cadastra os dados de um paciente
    public static Paciente cadastrarPaciente(Scanner sc) {
        System.out.println("\n--- Dados do paciente ---");

        System.out.print("Nome completo: ");
        String nome = sc.nextLine();

        System.out.print("CPF: ");
        String cpf = sc.nextLine();

        System.out.print("Idade: ");
        int idade = lerInteiro(sc);

        System.out.print("Telefone: ");
        String telefone = sc.nextLine();

        System.out.print("Número do prontuário: ");
        String prontuario = sc.nextLine();

        return new Paciente(nome, cpf, idade, telefone, prontuario);
    }

    // Lê um número inteiro
    public static int lerInteiro(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Digite um número inteiro válido.");
            sc.nextLine();
        }

        int numero = sc.nextInt();
        sc.nextLine();
        return numero;
    }

    // Exibe o paciente removido
    public static void exibirRemovido(Paciente p) {
        if (p != null) {
            System.out.println("Paciente removido:");
            System.out.println(p);
        } else {
            System.out.println("Não foi possível remover. Lista vazia ou posição inválida.");
        }
    }

    // Exibe o resultado da pesquisa
    public static void exibirPesquisa(Paciente p) {
        if (p != null) {
            System.out.println("Paciente encontrado:");
            System.out.println(p);
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }
}
