/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uthh.edd.unidad2.listas;

/**
 *
 * @author Axel
 */
public class Nodo {
    private int dato;
    private Nodo siguiente;

    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
    
    public Nodo(int x, Nodo sig){
        dato=x;
        siguiente=sig;
    }
    
    public void setDato(int x){
        dato=x;
    }
    
    public int getDato(){
        return dato;
    }
    
    public void setSiguiente(Nodo sig){
        siguiente=sig;
    }
    
    public Nodo getSiguiente(){
        return siguiente;
    }
}
