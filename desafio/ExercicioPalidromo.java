package desafio;

import java.util.Scanner;
import java.util.Stack;

public class ExercicioPalidromo {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite uma palavra: ");
        String texto = entrada.nextLine();

        Stack<Character> pilha = new Stack<>();

        for (int i = 0; i < texto.length(); i++) {
            pilha.push(texto.charAt(i));
        }
        
        String invertida = "";
        while (!pilha.isEmpty()) {
            invertida += pilha.pop();
        }
        if (texto.equalsIgnoreCase(invertida)) {
            System.out.println("É um palíndromo!");
        } else {
            System.out.println("Não é um palíndromo.");
        }

        entrada.close();
    }
}
