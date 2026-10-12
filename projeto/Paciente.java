package projeto;

public class Paciente {
    private String nome;
    private String cpf;
    private int idade;
    private String telefone;
    private String prontuario;

    // Construtor da classe
    public Paciente(String nome, String cpf, int idade,
                    String telefone, String prontuario) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.telefone = telefone;
        this.prontuario = prontuario;
    }

    // Métodos getters
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getProntuario() {
        return prontuario;
    }

    // Exibe os dados do paciente
    @Override
    public String toString() {
        return "Nome: " + nome
                + "\nCPF: " + cpf
                + "\nIdade: " + idade
                + "\nTelefone: " + telefone
                + "\nProntuário: " + prontuario;
    }
}
