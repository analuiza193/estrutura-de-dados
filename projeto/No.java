package projeto;

public class No {
    private Paciente paciente;
    private No proximo;

    // Construtor do nó
    public No(Paciente paciente) {
        this.paciente = paciente;
        this.proximo = null;
    }

    // Retorna o paciente armazenado
    public Paciente getPaciente() {
        return paciente;
    }

    // Define o paciente armazenado
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    // Retorna o próximo nó
    public No getProximo() {
        return proximo;
    }

    // Define o próximo nó
    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
}
