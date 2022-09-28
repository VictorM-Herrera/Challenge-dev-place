package com.Challenge.utils;

import java.util.ArrayList;

public class Estructuras {
    /**
     * @param listaEnteros pide una lista de enteros cargada aleatoriamente
     * @param numero pide un numero ingresado por teclado
     * esta funcion recorre una lista y elimina todos los valores que coincidan con el numero ingresado por el usuario
     *               Ejercicio 1:
     * */
    public void modificarLista(ArrayList<Integer> listaEnteros, int numero)
    {
        for (int i=0; i<listaEnteros.size();i++)
        {

            if (listaEnteros.get(i) == numero)
            {
                listaEnteros.remove(i);
                i--;
            }
        }
    }
    /**
     * @param listaEnteros pide una lista de enteros vacia
     * Esta funcion carga 10 valores aleatorios en una lista de enteros
     *          uso en Ejercicio 1 y 3:
     * */
    public void cargarListaRandom(ArrayList<Integer> listaEnteros)
    {
        for (int i=0; i<10; i++)
        {
            int numero = (int)(Math.random()*10+1);
            listaEnteros.add(numero);
        }
    }
    /**
     * @param listaEnteros pide una lista de enteros cargada aleatoriamente
     * @return retorna un String cargado con todos los elementos de la lista
     * Esta funcion recorre la lista de enteros añadiendo cada uno de sus valores a un String builder para poder ser impreso en su llamado
     *          uso en Ejercicio 1 y 3:
     * */
    public String mostrarLista(ArrayList<Integer> listaEnteros)
    {
        StringBuilder sb= new StringBuilder();
        for (int i=0; i<listaEnteros.size();i++)
        {
            sb.append(listaEnteros.get(i).toString()).append(",");
        }
        return sb.toString();
    }
    /**
     * @param listaEnteros pide una lista de enteros cargada aleatoriamente
     * @return retorna un entero con la suma almacenada de los valores de la lista.
     * esta funcion utiliza la recursividad para sumar todos los elementos de una lista, la condicion de corte es que la dimension del arreglo llegue a 0
     * ya que empieza a recorrer y sumar recursivamente desde el final de la lista
     *          Ejercicio 3:
     * */

    public int sumaRecursiva(ArrayList<Integer> listaEnteros, int size)//numero es 0 de base
    {
        int dim= size;
        int rta;
        if (dim==0)
        {
            return listaEnteros.get(dim);
        }else {
            rta= listaEnteros.get(dim) + sumaRecursiva(listaEnteros, dim-1);
        }
        return rta;
    }
}
