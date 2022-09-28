package com.Challenge.utils;


import java.util.ArrayList;

import java.util.Scanner;

public class Algoritmos {
    static Scanner scan= new Scanner(System.in);
    /**
     * @param num pide un numero para verificar si es primo
     * @return esta funcion retorna un booleano true si el numero es primo y false si no lo es
     * la funcion verifica si el numero ingresado es mayor a 1 y distinto de 4, luego en un ciclo for comprueba si el numero ingresado cumple con las condiciones para ser primo
     *              Ejercicio 1:
     * */
    public boolean numeroPrimo(int num)
    {
        boolean rta=true;
        if (num>1 && num!= 4){
            for (int i=1; i < num/2;i++){
                if(num % i==0)
                {
                    rta=false;
                }else
                {
                    rta=true;
                }
            }
        }else{
            rta=false;
        }
        return rta;
    }
    /**
     * @param contra pide un string cargado con una contraseña
     * esta funcion le da 3 oportunidades al usuario para ingresar correctamente la contraseña.
     * para ello compara la primer contraseña ingresada por parametro con las ingresadas en la funcion y muestra un mensaje en caso de ser o no iguales.
     *                Ejercicio 2:
     * */
    public void contraseña(String contra)
    {
        boolean acceso=false;
        int i=0;
        String intento;
        do{
            System.out.println("Ingresa la contraseña denuevo: (tienes 3 intentos)");
            intento=scan.nextLine();
            acceso=intento(contra, intento);
            i++;
        }while(!acceso && i<3);
        if (acceso)
        {
            System.out.println("------------------------------------");
            System.out.println("Felicitaciones, recordás tu contraseña");
            System.out.println("------------------------------------");
        }else {
            System.out.println("------------------------------------");
            System.out.println("Tenes que ejercitar la memoria");
            System.out.println("------------------------------------");
        }
    }
    /**
     * @param contra pide por parametro un String cargado con la contraseña
     * @param intento pide por parametro un String cargado con el intento
     * @return retorna un booleano falso si la contraseña y el intento son distintas y un booleano true si son iguales.
     * esta funcion esta alojada en la funcion "contraseña", compara con un equals si los 2 strings ingresados son iguales
     *                      Ejercicio 2:
     * */
    private boolean intento (String contra, String intento) {
        boolean rta = false;
        if (contra.equals(intento)) {
            rta = true;
        }
        return rta;
    }

    /**
     * @param valorXHoras pide por parametro un entero con el precio por hora que se le paga a un empleado
     * esta funcion crea un empleado almacenando los datos en sus respectivas variables
     * ademas llama a otras funciones para calcular el total a pagar y para imprimir un String con todos estos datos
     *                    Ejercicio 3:
     * */
    public void creaEmpleado(int valorXHoras)
    {
        String nombre;
        int antiguedad, hsTrabajadas, total;// (antiguedad x años), (hs trabajadas x mes)
        do {
            System.out.println("Ingresa nombre del empleado: ");
            nombre=scan.nextLine();
        }while (nombre.equals(""));
        do {
            System.out.println("Ingresa las horas que trabajo el empleado: ");
            hsTrabajadas= scan.nextInt();
        }while (hsTrabajadas== 0);
        do {
            System.out.println("Ingresa la cantidad de años que el empleado tiene en la empresa: ");
            antiguedad= scan.nextInt();
        }while(antiguedad==0);
        total= calculaTotal(hsTrabajadas,antiguedad,valorXHoras);
        imprimirEmpleado(nombre,antiguedad, total);

    }

    /**
     * @param hsTrabajadas pide por parametro un entero con la cantidad de hs trabajadas por el empleado
     * @param antiguedad pide por parametro un entero con la antiguedad en años del empleado
     * @param valor pide por parametro un entero con la cantidad del valor a pagar x hora al empleado
     * @return retorna la cantidad a cobrar por antiguedad (si esta es mayor a los 10 años), mas la cantidad a cobrar por horas trabajadas (en el mes)
     * Esta funcion esta alojada en la funcion "creaEmpleado"
     *          Ejercicio 3:
     * */
    private int calculaTotal(int hsTrabajadas, int antiguedad, int valor)
    {
        int total=0;
        if(antiguedad>10)
        {
            total+= antiguedad*30;
        }
        total+= hsTrabajadas*valor;
        return total;
    }

    /**
     * @param nombre pide por parametro un String cargado con el nombre del empleado
     * @param antiguedad pide por parametro un entero con la antiguedad en años del empleado
     * @param total pide por parametro el monto total a cobrar del empleado
     * Esta funcion de encarga de imprimir los datos del empleado y se encuentra incluida en la funcion "creaEmpleado"
     *              Ejercicio 3:
     * */
    private void imprimirEmpleado(String nombre, int antiguedad, int total)
    {
        System.out.println("--------------------------");
        System.out.println("Nombre: " + nombre);
        System.out.println("Antiguedad: "+ antiguedad);
        System.out.println("Total a cobrar: $" + total);
        System.out.println("--------------------------");
    }

    /**
     * @param random pide por parametro un numero con un valor aleatorio desconocido
     * esta funcion se trata de un juego en donde el usuario debe ingresar un numero hasta encontrar el numero random
     * compara si el numero ingresado es mayor o menor al random y le indica esto para que pueda encontrarlo.
     *               Ejercicio 4:
     * */
    public void encuentraRandom(int random)
    {
        boolean rta= false;
        do {
            System.out.println("Ingrese un numero del 1 al 1000 para encontrar el numero aleatorio:");
            int num= scan.nextInt();
            if (num>=1 && num <=1000)
            {
                if(num< random)
                {
                    System.out.println("es Mayor a: " + num);
                }
                else if(num> random){
                    System.out.println("es menor a: "+num);
                }else {
                    rta=true;
                }
            }
        }while (!rta);
    }

    /**
     * Esta funcion pide al usuario ingresar la cantidad de numeros que quiera, luego le imprime cual numero de esos es el mayor, el menor, la suma de todos los numeros
     * y la suma de estos 3 resultados.
     *          Ejercicio 5:
     * */
    public void numerosRepetidos()
    {
        int num;
        ArrayList<Integer> listaNum= new ArrayList<>();
        do {
            System.out.println("ingresa la cantidad de numeros que quieras: (finaliza ingresando -1)");
            num=scan.nextInt();
            if(num!= -1)
            {
                listaNum.add(num);
            }
        }while(num!=-1);
        imprimeResultadosEj5(listaNum);
    }

    /**
     * @param lista pide una lista de enteros cargada
     * @return retorna la suma de todos los numeros de la lista
     * esta funcion se encarga de recorrer la lista sumando todos los numeros que tiene, se encuentra alojada en la funcion "numerosRepetidos"
     *          Ejercicio 5:
     * */
    private int sumaNumerosDeLista(ArrayList<Integer> lista)
    {
        int suma=0;
        for (int i=0;i<lista.size();i++)
        {
            suma+= lista.get(i);
        }
        return suma;
    }

    /**
     * @param lista pide una lista de enteros cargada
     * @return retorna el numero con el mayor valor de la lista
     * esta funcion se encarga de recorrer la lista comparando cual de sus valores es el mayor, se encuentra alojada en la funcion "numerosRepetidos"
     *          Ejercicio 5:
     * */
    private int mayorNumero(ArrayList<Integer> lista)
    {
        int mayor= lista.get(0);
        for (int i=0; i< lista.size();i++)
        {
            if (mayor< lista.get(i))
            {
                mayor= lista.get(i);
            }
        }
        return mayor;
    }

    /**
     * @param lista pide una lista de enteros cargada
     * @return retorna el numero con el menor valor de la lista
     * esta funcion se encarga de recorrer la lista comparando cual de sus valores es el menor, se encuentra alojada en la funcion "numerosRepetidos"
     *          Ejercicio 5:
     * */
    private int menorNumero(ArrayList<Integer> lista)
    {
        int menor= lista.get(0);
        for (int i=0; i< lista.size();i++)
        {
            if (menor> lista.get(i))
            {
                menor= lista.get(i);
            }
        }
        return menor;
    }
    /**
     * @param lista pide una lista de enteros cargada
     * esta funcion se encarga de imprimir los resultados pedidos en el ejercicio 5, se encuentra alojada en la funcion "numerosRepetidos"
     *          Ejercicio 5:
     * */
    private void imprimeResultadosEj5(ArrayList<Integer> lista)
    {
        System.out.println("--------------------");
        System.out.println("El mayor de los numeros ingresados es: " + mayorNumero(lista));
        System.out.println("El menor de los numeros ingresados es: " + menorNumero(lista));
        System.out.println("El total de la suma de los numeros es: " + sumaNumerosDeLista(lista));
        System.out.println("La suma de estos tres numeros es: " + (mayorNumero(lista) + menorNumero(lista) + sumaNumerosDeLista(lista)));
        System.out.println("--------------------");
    }

}
