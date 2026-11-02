package Exercicio_05;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        double media = calcularMedia(8.0, 6.0);
        boolean aprovado = estaAprovado(media);
        mostrarResultado(media, aprovado);

//////////////////////////////////desaaafiiioooooooooo//////////////////////////////////////////////////////////////////
        Scanner sc = new Scanner(System.in);

         System.out.print("\nDigite a nota 1: ");

        double n1 = sc.nextDouble();

                System.out.print("Digite a nota 2: ");

        double n2 = sc.nextDouble();





        double mediaLida = calcularMedia(n1, n2);



        boolean aprovadoLido = estaAprovado(mediaLida);


        mostrarResultado(mediaLida, aprovadoLido);

        sc.close();










    }

          public static double calcularMedia(double n1, double n2) {

        return (n1 + n2) / 2;

    }

         public static boolean estaAprovado(double media) {

        return media >= 7;

    }


               public static void mostrarResultado(double media, boolean aprovado) {
        System.out.println("Média: " + media);


        if (aprovado) {
                 System.out.println("Situação: APROVADO");
        } else {
            System.out.println("Situação: REPROVADO");
        }
    }

}
