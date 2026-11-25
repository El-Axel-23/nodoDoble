/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uthh.edd.unidad2.listas;

/**
 *
 * @author Axel
 */
public class listaDoble {
    private int tamanio;
    private nodoDoble cabeza, cola;
    
    public listaDoble(){
        tamanio=0;
        cabeza=null;
        cola=null;
    }
    
    public boolean estaVacia(){
        return cabeza == null;
    }
    
    public int getTamanio(){
        return tamanio;
    }
    
    public boolean buscar(int dato){
        nodoDoble aux = cabeza;
        while(aux!=null){
            if(aux.getDato()==dato){
                return true;
            }
            aux=aux.getSiguiente();
        }
        return false;
    }
    
    @Override
    public String toString(){
        String res="null";
        nodoDoble aux=cabeza;
        while(aux!=null){
            res += "<-["+aux.getDato()+"]->";
            aux=aux.getSiguiente();
        }
        res+="null";
        return res;
    }
    
    public nodoDoble obtenerNodo(int pos){
        if(pos<=0 ||pos>tamanio){
            throw new IllegalStateException("Valor fuera de rango");
        }
        nodoDoble aux=cabeza;
        for(int i=1;i<pos;i++){
            aux=aux.getSiguiente();
        }
        return aux;
    }
    
    public void actualizar(int pos, int valor){
        nodoDoble val=obtenerNodo(pos);
        val.setDato(valor);
    }
    
    public void insertarInicio(int valor){
        nodoDoble nuevo = new nodoDoble(valor);
        if(estaVacia()){
            cabeza=nuevo;
            cola=nuevo;
        }else{
            cabeza.setAnterior(nuevo);
            nuevo.setSiguiente(cabeza);
            cabeza=nuevo;
        }
        tamanio++;
    }
    public void insertarFinal(int valor){
        nodoDoble nuevo = new nodoDoble(valor);
        if(estaVacia()){
            cola=nuevo;
            cabeza=nuevo;
        }else{
            cola.setSiguiente(nuevo);
            nuevo.setAnterior(cola);
            cola=nuevo;
        }
        tamanio++;
    }
    
    public int eliminarInicio(){
        if(estaVacia()){
            throw new IllegalStateException("No se puede eliminar con la lista vacia");
        }        
        int dato=cabeza.getDato();
        
        if(tamanio==1){
            cabeza=null;
            cola=null;
        }else{
            cabeza=cabeza.getSiguiente();
            cabeza.setAnterior(null);
        }
        tamanio--;
        return dato;
    }
    
    public void insertarEnPosicion(int pos, int dato){
        if(pos<=0 || pos>tamanio+1){
            throw new IllegalStateException("Valor fuera de rango");
        }
        if(pos==1){
            insertarInicio(dato);
            return;
        }
        nodoDoble aux=obtenerNodo(pos-1);
        nodoDoble nuevo=new nodoDoble(dato);
        
        nuevo.setSiguiente(aux.getSiguiente());
        nuevo.setAnterior(aux);
        aux.setSiguiente(nuevo);
        aux.setAnterior(nuevo);
        tamanio++;
    }
    
    public boolean eliminarPorValor(int valor){
       if (estaVacia()){
            return false;
        }                            
        nodoDoble aux=cabeza;
        while(aux!=null){
            if (aux.getDato()==valor){
                if (aux==cabeza){
                 cabeza=aux.getSiguiente();   
                }else{
                    aux.getAnterior().setAnterior(aux.getAnterior());
                }                
                if(aux==cola){
                    cola=aux.getAnterior();
                }else{
                    aux.getSiguiente().setAnterior(aux.getAnterior());
                }               
                tamanio--;
                return true;            
            }
            aux=aux.getSiguiente();            
        }
        return false;
    }
    
    public int eliminarEnPosicion(int pos){
        if (pos<=0 || pos>tamanio){
            throw new IllegalStateException("Valor fuera de rango");
        }
        
        if(pos==1){
            return eliminarInicio();
        }
        
        nodoDoble aux=obtenerNodo(pos-1);
        nodoDoble objetivo=aux.getSiguiente();
        int dato = objetivo.getDato();
        aux.setSiguiente(objetivo.getSiguiente());
        tamanio--;
        return dato;
    }
    
    public int eliminarUltimo(){
        if(estaVacia()){
            throw new IllegalStateException("No se puede eliminar con la lista vacia");
        }        
        int dato=cola.getDato();
        
        if(tamanio==1){
            cola=null;
            cabeza=null;
        }else{
            cola=cola.getAnterior();
            cola.setSiguiente(null);
        }
        tamanio--;
        return dato;
    }
    
    public void insertarOrdenado(int dato){
        nodoDoble nuevo = new nodoDoble(dato);   
        if (estaVacia()) { 
            cabeza = nuevo;
            cola=nuevo;
        }else if (dato <= cabeza.getDato()) {
            nuevo.setSiguiente(cabeza);    
            cabeza.setAnterior(nuevo);
            cabeza = nuevo;                 
            tamanio++;
        }else{  
            nodoDoble actual = cabeza;               
            while (actual.getSiguiente() != null && actual.getSiguiente().getDato() <= dato) {
                actual = actual.getSiguiente(); 
            }            
            nuevo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(nuevo);      
            
            if(actual.getSiguiente() != null){
                actual.getSiguiente().setAnterior(nuevo);
            }else{
                cola=nuevo;
            }
            actual.setSiguiente(nuevo);
        }
        tamanio++;        
    }
    
}
