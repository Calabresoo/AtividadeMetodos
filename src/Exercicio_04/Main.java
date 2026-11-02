package Exercicio_04;

public class Main {

    public static void main(String[] args) {

        int resultado = calcularQuadrado(5);
        System.out.println("O quadrado de " + (5) + " é: " + resultado);


        int triplo = calcularTriplo(5);
        System.out.println("O triplo de " + (5) + " é: " + triplo);

    }

    public static int calcularQuadrado(int a) {
        return a * a;
    }

    public static int calcularTriplo(int b) {
        return b * 3;
    }

}
