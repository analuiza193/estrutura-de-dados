package estudos;

public class Arrays4 {
    public static void main(String[] args) {
        int[] numeros = new int[3];
        // para econnomizar linha e n colocar de um por um 
        int[] numeros2 = {1,2,3,4,5};
        // outra forma
        int[] numeros3 = new int[]{5,4,3,2,1};

        for(int i= 0; i<numeros3.length; i++){
            System.out.println(numeros3[i]);
        }
        // outra forma de imprimir mais simples, se n for alterar i++ ou i--;
        for(int num : numeros3){
            System.out.println(num);

        }

    }
}
