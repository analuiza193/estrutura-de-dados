package projeto;

public class ListarPacientes {
    private No inicio;
    private int tamanho;

    public ListarPacientes() {
        this.inicio = null;
        this.tamanho = 0;
    }

    public int getTamanho() {
        return tamanho;
    }

    public boolean estaVazia() {
        return inicio == null;
    }

    public void inserirInicio(Paciente paciente) {
        No novo = new No(paciente);
        novo.setProximo(inicio);
        inicio = novo;
        tamanho++;
    }
  
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
    
    public Paciente removerInicio() {
        if (estaVazia()) {
            return null;
        }
        Paciente removido = inicio.getPaciente();
        inicio = inicio.getProximo();
        tamanho--;

        return removido;
    }

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
