package com.Challenge.utils;

import com.Challenge.models.Password;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    static Scanner scan= new Scanner(System.in);

    public void Menu1()
    {
        int op;
        do {
            System.out.println("Challenge DEV PLACE");
            System.out.println("Menu Principal");
            System.out.println("1. Modulo Algoritmos");
            System.out.println("2. Estructura de datos");
            System.out.println("3. Modulo POO");
            System.out.println("0. Salir");
            System.out.println("ingrese una opcion: ");
            op=scan.nextInt();
            switch (op)
            {
                case 1:
                    Menu2();
                    break;
                case 2:
                    Menu3();
                    break;
                case 3:
                    Menu4();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("OPCION INGRESADA INVALIDA");
                    break;
            }
        }while(op!=0);
    }

    public void Menu2()
    {
        Algoritmos aux= new Algoritmos();
        int op;
        do {
            System.out.println("Menu de algoritmos");
            System.out.println("1. Ejercicio 1");
            System.out.println("2. Ejercicio 2");
            System.out.println("3. Ejercicio 3");
            System.out.println("4. Ejercicio 4");
            System.out.println("5. Ejercicio 5");
            System.out.println("0. Volver");
            System.out.println("ingrese una opcion: ");
            op=scan.nextInt();
            switch (op)
            {
                case 1:
                    System.out.println("Ingrese un numero para indicar si es primo o no");
                    int num= scan.nextInt();
                    boolean rta= aux.numeroPrimo(num);
                    if (rta)
                    {
                        System.out.println("El numero es primo");
                    }else{
                        System.out.println("El numero no es primo");
                    }
                    break;
                case 2:
                    String contra;
                    scan.nextLine();//limpio el buffer
                    do {
                        System.out.println("Ingrese una contraseña: ");
                        contra= scan.nextLine();
                    }while (contra.equals(""));
                    aux.contraseña(contra);
                    break;
                case 3:
                    System.out.println("Ingresa el valor x horas de un empleado: ");
                    int valor= scan.nextInt();
                    aux.creaEmpleado(valor);
                    break;
                case 4:
                    int random= (int)(Math.random()*999+1);//genero un numero random entre el 1 y el 1000
                    aux.encuentraRandom(random);
                    System.out.println("Encontraste el numero random!!!!");
                    break;
                case 5:
                    aux.numerosRepetidos();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("OPCION INGRESADA INVALIDA");
                    break;
            }
        }while(op!=0);
    }

    public void Menu3()
    {

        Estructuras aux= new Estructuras();
        int op;
        do {
            System.out.println("Menu Estructura de datos");
            System.out.println("1. Ejercicio 1");
            System.out.println("2. Ejercicio 3");
            System.out.println("0. Volver");
            System.out.println("ingrese una opcion: ");
            op=scan.nextInt();
            switch (op)
            {
                case 1:
                    ArrayList<Integer> listaEnteros= new ArrayList<>();
                    aux.cargarListaRandom(listaEnteros);
                    System.out.println("Lista cargada aleatoriamente: ");
                    System.out.println(aux.mostrarLista(listaEnteros));
                    System.out.println("ingrese un numero para eliminarlo de la lista: ");
                    int num= scan.nextInt();
                    aux.modificarLista(listaEnteros,num);
                    System.out.println("Lista sin el numero ingresado:");
                    System.out.println(aux.mostrarLista(listaEnteros));
                    break;
                case 2:
                    ArrayList<Integer> listaEnt= new ArrayList<>();
                    aux.cargarListaRandom(listaEnt);
                    System.out.println("Lista cargada aleatoriamente: ");
                    System.out.println(aux.mostrarLista(listaEnt));
                    int suma= aux.sumaRecursiva(listaEnt, listaEnt.size()-1);
                    System.out.println("La suma de los elementos de la lista es: "+ suma);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("OPCION INGRESADA INVALIDA");
                    break;
            }
        }while(op!=0);
    }

    public void Menu4()
    {
        int op;
        do {
            System.out.println("Menu de POO");
            System.out.println("1. Ingresar longitud y crear un contraseña aleatoriamente");
            System.out.println("2. Crear una contraseña de 8 digitos y ver si es fuerte o no");
            System.out.println("0. Volver");
            System.out.println("ingrese una opcion: ");
            op=scan.nextInt();
            switch (op)
            {
                case 1:
                    int longitud;
                    System.out.println("Ingrese la cantidad de caracteres de su contraseña");
                    longitud= scan.nextInt();
                    Password pass= new Password(longitud);
                    System.out.println("Su contraseña es: " + pass.getContrasena());
                    break;
                case 2:
                    String contra;
                    boolean rta;
                    scan.nextLine();//limpio el buffer
                    System.out.println("Ingrese una contraseña de 8 digitos: ");
                    contra= scan.nextLine();
                    Password pass2= new Password(contra);
                    pass2.setLongitud(contra.length());//seteo la longitud al tamaño de la contraseña actual
                    rta=pass2.esFuerte();
                    if (rta)
                    {
                        System.out.println("La contraseña: " + pass2.getContrasena() + "es fuerte");
                    }else {
                        System.out.println("La contraseña: " + pass2.getContrasena() + "es debil");
                    }

                    break;
                case 0:
                    break;
                default:
                    System.out.println("OPCION INGRESADA INVALIDA");
                    break;
            }
        }while(op!=0);
    }
}
