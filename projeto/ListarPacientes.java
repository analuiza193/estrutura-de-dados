package projeto;

public class ListarPacientes {
    private No inicio;
    private int tamanho;

    // Construtor da lista
    public ListarPacientes() {
        this.inicio = null;
        this.tamanho = 0;
    }

    // Retorna a quantidade de pacientes cadastrados
    public int getTamanho() {
        return tamanho;
    }

    // Verifica se a lista está vazia
    public boolean estaVazia() {
        return inicio == null;
    }

    // 1. Inserir paciente no início
    public void inserirInicio(Paciente paciente) {
        No novo = new No(paciente);
        novo.setProximo(inicio);
        inicio = novo;
        tamanho++;
    }
    // 2. Inserir paciente no fim
    public void inserirFim(Paciente paciente) {
        No novo = new No(paciente);
        if (estaVazia()) {
            inicio = novo;
        } else {
            No atual = inicio;
            while (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
            atual.setProximo(novo);
        }
        tamanho++;
    }

    // 3. Inserir paciente em qualquer posição
    public boolean inserirPosicao(Paciente paciente, int posicao) {
        if (posicao < 0 || posicao > tamanho) {
            return false;
        }
        if (posicao == 0) {
            inserirInicio(paciente);
            return true;
        }
        if (posicao == tamanho) {
            inserirFim(paciente);
            return true;
        }
        No novo = new No(paciente);
        No atual = inicio;

        for (int i = 0; i < posicao - 1; i++) {
            atual = atual.getProximo();
        }
        novo.setProximo(atual.getProximo());
        atual.setProximo(novo);
        tamanho++;

        return true;
    }
    // 4. Remover paciente do início
    public Paciente removerInicio() {
        if (estaVazia()) {
            return null;
        }

        Paciente removido = inicio.getPaciente();
        inicio = inicio.getProximo();
        tamanho--;

        return removido;
    }

    // 5. Remover paciente do fim
    public Paciente removerFim() {
        if (estaVazia()) {
            return null;
        }

        if (tamanho == 1) {
            return removerInicio();
        }

        No atual = inicio;

        while (atual.getProximo().getProximo() != null) {
            atual = atual.getProximo();
        }

        Paciente removido = atual.getProximo().getPaciente();
        atual.setProximo(null);
        tamanho--;

        return removido;
    }

    // 6. Remover paciente de qualquer posição
    public Paciente removerPosicao(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            return null;
        }

        if (posicao == 0) {
            return removerInicio();
        }

        if (posicao == tamanho - 1) {
            return removerFim();
        }

        No atual = inicio;

        for (int i = 0; i < posicao - 1; i++) {
            atual = atual.getProximo();
        }

        No removido = atual.getProximo();
        atual.setProximo(removido.getProximo());
        tamanho--;

        return removido.getPaciente();
    }
    
    // 7. Verificar paciente em determinada posição
    public Paciente verificarPosicao(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            return null;
        }
        No atual = inicio;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }
        return atual.getPaciente();
    }

    // 8. Listar todos os pacientes
    public void listarPacientes() {
        if (estaVazia()) {
            System.out.println("Nenhum paciente cadastrado.");
            return;
        }
        No atual = inicio;
        int posicao = 0;

        while (atual != null) {
            System.out.println("\nPosição: " + posicao);
            System.out.println(atual.getPaciente());
            System.out.println("-------------------------");

            atual = atual.getProximo();
            posicao++;
        }
    }

    // 9. Pesquisar paciente pelo CPF
    public Paciente pesquisarCpf(String cpf) {
        No atual = inicio;
        while (atual != null) {
            if (atual.getPaciente().getCpf().equals(cpf)) {
                return atual.getPaciente();
            }
            atual = atual.getProximo();
        }

        return null;
    }

    // 10. Pesquisar paciente pelo prontuário
    public Paciente pesquisarProntuario(String prontuario) {
        No atual = inicio;
        while (atual != null) {
            if (atual.getPaciente().getProntuario()
                    .equals(prontuario)) {
                return atual.getPaciente();
            }
            atual = atual.getProximo();
        }

        return null;
    }
}
