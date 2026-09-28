package estudos;

public class Arrays6 {
    public static void main(String[] args) {
        int [][] arrayInt= new int[2][];

        arrayInt [0]= new int[]{1,2,3,4,5,6};
        arrayInt [1]= new int[]{1,2,3,4,5,6};

        int[][] arrayInt2 ={{0,0},{0,0,0},{0,0,0,0}}; 
        

        for(int[] arrBase: arrayInt2){
            System.out.println("\n-----");
            for(int num: arrBase){
                System.out.print(num +" ");
            }
        }
    }
}
// println = imprimi pulando uma linha
// print = imprimi tudo na mesma linha
