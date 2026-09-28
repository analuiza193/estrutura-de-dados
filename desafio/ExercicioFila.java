package desafio;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ExercicioFila {
    public static void main(String[] args) {
        Queue<Integer> fila = new LinkedList<>();

        fila.add(10);
        fila.add(20);
        fila.add(30);
        fila.add(40);

        System.out.println("Fila original: " + fila);
        Stack<Integer> pilha = new Stack<>();

        while (!fila.isEmpty()) {
            pilha.push(fila.poll());
        }
        while (!pilha.isEmpty()) {
            fila.add(pilha.pop());
        }
        System.out.println("Fila invertida: " + fila);
    }
}
