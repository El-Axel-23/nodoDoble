/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.uthh.edd.unidad2.listas;

import java.util.Scanner;

/**
 * Nodo de una lista ligada simple.
 * Guarda un dato entero y una referencia al siguiente nodo.
 * @author Axel
 */

public class MainPracticaListasLigadas {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        ListaEnlazada lista = new ListaEnlazada();
        int opcion;

        do {
            System.out.println("\n===== MENU LISTA LIGADA =====");
            System.out.println("1. Insertar al inicio");
            System.out.println("2. Insertar al final");
            System.out.println("3. Insertar ordenadamente");
            System.out.println("4. Buscar un valor");
            System.out.println("5. Eliminar un valor");
            System.out.println("6. Mostrar la lista");
            System.out.println("7. Ver tamanio");
            System.out.println("8. Eliminar al inicio");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");

            opcion = teclado.nextInt();

            switch (opcion) {

                case 1:
                    System.out.print("Valor: ");
                    lista.insertarInicio(teclado.nextInt());
                    break;

                case 2:
                    System.out.print("Valor: ");
                    lista.insertarFinal(teclado.nextInt());
                    break;

                case 3:
                    System.out.print("Valor a insertar: ");
                    lista.insertarOrdenado(teclado.nextInt());
                    System.out.println("Valor insertado correctamente.");
                    break;

                case 4:
                    System.out.print("Valor a buscar: ");
                    int buscado = teclado.nextInt();

                    System.out.println(lista.buscar(buscado)
                            ? "Sí está en la lista"
                            : "No está en la lista");
                    break;

                case 5:
                    System.out.print("Valor a eliminar: ");
                    int eliminado = teclado.nextInt();

                    System.out.println(lista.eliminarPorVair(eliminado)
                            ? "Valor eliminado correctamente"
                            : "Valor no encontrado");
                    break;

                case 6:
                    System.out.println("Lista: " + lista.toString());
                    break;

                case 7:
                    System.out.println("Tamaño: " + lista.getTamanio());
                    break;

                case 8:
                    if (!lista.estaVacia()) {
                        System.out.println("Elemento eliminado: "
                                + lista.eliminarInicio());
                    } else {
                        System.out.println("La lista esta vacía.");
                    }
                    break;

                case 0:
                    System.out.println("Hasta luego");
                    break;

                default:
                    System.out.println("Opcion inválida");
            }

        } while (opcion != 0);

        teclado.close();
    }
}
