/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uthh.edd.unidad2.listas;

/**
 *
 * @author Axel
 */
public class ListaEnlazada {
    
    private Nodo cabeza;
    private int tamanio;
    
    public ListaEnlazada(){
        this.cabeza=null; //empieza desde 0
        this.tamanio=0; //saber nodos que maneja la lista
    }
    
    public boolean estaVacia() {
        //return cabeza == null;
        if(cabeza==null){
            return true;
        }else{
            return false;
        }
    }
    
    public int getTamanio(){
        return tamanio;
    }
    
    public void insertarInicio(int x){
        Nodo nuevo = new Nodo(x,cabeza);
        cabeza=nuevo;
        tamanio++;
    }
    
    public void insertarFinal(int dato){
        Nodo nuevo = new Nodo(dato);
        if(estaVacia()){
            cabeza=nuevo;
        }else{
            Nodo aux=cabeza;
            while(aux.getSiguiente()!=null){
            aux=aux.getSiguiente();
        }
            aux.setSiguiente(nuevo);
        }
        tamanio++;
    }
    
    public int eliminarInicio(){
        if(estaVacia()){
            throw new IllegalStateException("No se puede eliminar con la lista vacia");
        }
        
        int datoEliminado=cabeza.getDato();
        cabeza=cabeza.getSiguiente();
        tamanio--;
        return datoEliminado;
    }
    
    public boolean eliminarPorVair (int valor){
        if (estaVacia()){
            return false;
        }            
        
        if(cabeza.getDato()==valor){
            cabeza=cabeza.getSiguiente();
            tamanio--;
            return true;
        }
        
        Nodo aux=cabeza;
        while(aux.getSiguiente()!=null){
            if (aux.getSiguiente().getDato()==valor){
                aux.setSiguiente(aux.getSiguiente().getSiguiente());
                tamanio--;
                return true;
            }
            aux=aux.getSiguiente();
        }
        return false;
    }
    
    public boolean buscar(int dato){
        Nodo aux = cabeza;
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
        String res="";
        Nodo aux=cabeza;
        while(aux!=null){
            res += "["+aux.getDato()+"]->";
            aux=aux.getSiguiente();
        }
        res+="null";
        return res;
    }
    
    public Nodo obtenerNodo(int pos){
        if(pos<=0 ||pos>tamanio){
            throw new IllegalStateException("Valor fuera de rango");
        }
        Nodo aux=cabeza;
        for(int i=1;i<pos;i++){
            aux=aux.getSiguiente();
        }
        return aux;
    }
    
    public void actualizar(int pos, int valor){
        Nodo val=obtenerNodo(pos);
        val.setDato(valor);
    }
    
    public void insertarEnPosicion(int pos,int valor){
        if(pos<=0 || pos>tamanio){
            throw new IllegalStateException("Valor fuera de rango");
        }
        if(pos==1){
            insertarInicio(valor);
            return;
        }
       Nodo aux=obtenerNodo(pos-1);
       Nodo nuevo=new Nodo(11);
        
       nuevo.setSiguiente(aux.getSiguiente());
       aux.setSiguiente(nuevo);
       tamanio++;
    }
    
    public int eliminarEnPosicion(int pos){
        if (pos<=0 || pos>tamanio){
            throw new IllegalStateException("Valor fuera de rango");
        }
        
        if(pos==1){
            return eliminarInicio();
        }
        
        Nodo aux=obtenerNodo(pos-1);
        Nodo objetivo=aux.getSiguiente();
        int dato = objetivo.getDato();
        aux.setSiguiente(objetivo.getSiguiente());
        tamanio--;
        return dato;
    }
    
    public void insertarOrdenado(int dato) {
        Nodo nuevo = new Nodo(dato);//inicializar nuevo nodo
        if (estaVacia()) {  //verificar si esta vacia
            cabeza = nuevo; //si no el nuevo valor insertado se agrega como la cabeza
            tamanio++;      //y el tamaño aumenta
        } else if (dato <= cabeza.getDato()) {  //si no se verifica si el dato insertado es menor o igual al dato de la cabeza
            insertarInicio(dato);   //de ser asi se inserta al inicio
            return; //y se devuelve el valor
        } else {    //si no se cumplio ningun caso anterior
            Nodo actual = cabeza;   //el nodo actual se convierte en la cabeza
            //en el while se evaluan los valores de los datos que ya estan y verifican si cumplen con las condiciones
            //actual.getSiguiente() != null evalua que el dato siguiente sea diferente de null
            //actual.getSiguiente().getDato() <= dato evalua que el dato siguiente sea menor al actual
            while (actual.getSiguiente() != null && actual.getSiguiente().getDato() <= dato) {
                actual = actual.getSiguiente(); //Esto hace que la cabeza valla avanzando hacia la derecha y pueda comprobar sus valores siguientes
            }
            nuevo.setSiguiente(actual.getSiguiente());//esto hace que el nuevo nodo apunte a null(ejem: 7->null)
            actual.setSiguiente(nuevo);//esto hace que el nodo actual apunte al nuevo(osea al nuevo dato agregado, ejem: 5->7->null)
            tamanio++;//esto solo aumenta el contador de tamaño
        }
    }
}
