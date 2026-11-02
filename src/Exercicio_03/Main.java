package Exercicio_03;

public class Main {


    public static void main(String[] args) {

        mostrarDobro(8);
        mostrarSoma(10, 5);
        mostrarMaior(10, 5);
        mostrarMaior(90, 100);


    }

    public static void mostrarDobro(int numero) {
        int dobro = numero * 2;
        System.out.println("O Dobro é " + dobro + ".");
    }

    public static void mostrarSoma(int a, int b) {
        int soma = a + b;
        System.out.println("A soma é " + soma + ".");
    }

    public static void mostrarMaior(int a, int b){

        if(a > b){
            System.out.println(a + " É MAIOR QUE " + b);
        }else{
            System.out.println(a + " É MENOR OU IGUAL A " + b);
        }

    }


}


