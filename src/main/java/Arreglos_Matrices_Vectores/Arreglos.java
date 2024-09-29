package Arreglos_Matrices_Vectores;

import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Arreglos {

    private int lista_Numeros[] = new int[20];
    int contador = 0;

    public Arreglos() {
    }

    public int[] getLista_Numeros() {
        return lista_Numeros;
    }

    public void setLista_Numeros(int[] lista_Numeros) {
        this.lista_Numeros = lista_Numeros;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public boolean agregarNumero(int numero, boolean aleatorio) {
        if (contador >= lista_Numeros.length) {
            System.out.println("La lista está llena, no se puede agregar más números.");
            return false; // Indica que la lista está llena
        }

        if (aleatorio) {
            // Usamos IntStream para generar 20 números aleatorios
            Random random = new Random();
            IntStream.range(0, 20) // Genera un rango de 0 a 19
                    .map(i -> random.nextInt(20) + 1) // Mapea cada índice a un número aleatorio
                    .forEach(n -> {
                        if (contador < lista_Numeros.length) {
                            lista_Numeros[contador++] = n; // Agrega el número aleatorio y incrementa el contador
                        }
                    });
        } else {
            if (contador < lista_Numeros.length) {
                lista_Numeros[contador++] = numero; // Agrega el número específico
            }
        }

        System.out.println("Números añadidos con éxito");
        return true; // Indica que el número o los números fueron añadidos con éxito
    }

    public void mostrarNumeros() {
        for (int i = 0; i < contador; i++) {
            System.out.println("Número en posición " + i + ": " + lista_Numeros[i]);
        }
    }

    public String buscarNumero(int numero) {
        for (int i = 0; i < contador; i++) {
            if (lista_Numeros[i] == numero) {
                return "El número " + numero + " se encuentra en la posición " + i;
            }
        }
        return "El número " + numero + " no se encuentra en la lista.";
    }

    // Método para leer un número desde la consola y buscarlo
    public void buscarNumeroDesdeConsola() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el número a buscar: ");
        int numeroBuscado = scanner.nextInt(); // Leer el número ingresado por el usuario

        String resultado = buscarNumero(numeroBuscado);
        System.out.println(resultado);
    }
}
