package com.yoprogramo.practicasjava;

/**
 *
 * @author Norberto Llopiz
 */

import java.util.Date;
import java.util.Scanner; //para carga por teclado

public class Practica0Java {

    public static void main(String[] args) {

//**********************Práctica Teoría
                
        System.out.println("Hello World!");
        
        //instancia del objeto Date
        Date fecha = new Date();
        //Mostrar la fecha como string
        System.out.println(fecha.toString());
        
        //Operadores aritméticos        
        int a = 10;
        int b = 20;
        int c = 25;
        int d = 25;
        
        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("b / a = " + (b / a));
        System.out.println("b % a = " + (b % a));
        System.out.println("c % a = " + (c % a));
        System.out.println("a++ = " + (a++));
        System.out.println("a-- = " + (a--));
        
        System.out.println("d++ = " + (d++));
        System.out.println("++d = " + (++d));
        
        //Operadores relacionales
        System.out.println("a == b = " + (a == b));
        System.out.println("a != b = " + (a != b));
        System.out.println("a > b = " + (a > b));
        System.out.println("a < b = " + (a < b));
        
        //Operadores lógicos
        // && || !
        
        //Operadores de asignación
        // = += -= *= /= %= 
        
        //Estructuras de Control
        //While
        System.out.println("While");
        int w = 20;
        while(w < 30){
            System.out.print("valor de w: " + w);
            w++;
            System.out.print("\n");
        }
        //For
        System.out.println("For");
        for(int x = 1; x <= 10; x += 1) {
            System.out.print("Valor de x: " + x + "\n");
        }
        
        int [] numbers = {10, 20, 30, 40, 50};
        
        for(int x: numbers) {
            System.out.print( x + ", ");
        }
        
        String [] names = {"Juan", "Lucas", "Tomás", "Mili"};
        
        for(String name: names){
            System.out.print(name + ", ");
        }
        
        //Do While
        System.out.println("\n\nDo While");
        w=20;
        do {
            System.out.print("Valor de w: " + w);
            w++;
            System.out.print("\n");
        }while (w<30);
        
        //break
        System.out.println("\nBreak");
        for(int x: numbers) {
            System.out.print( x + ", ");
            if(x==30){
                break;
            }
        }
        
        //continue
        System.out.println("\nContinue");
        for(int x: numbers) {
            if(x==30){
                continue;
            }
            System.out.print( x + ", ");
        }
        
        //Estructuras de decisión
        //IF
        System.out.println("\nIf");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        if(a < b){
            System.out.print("a es menor que b");
        } else {
            System.out.print("a es mayor que b");
        }
        //If anidados
        System.out.println("\nIf anidados");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("d = " + d);
        if(a < b){   
            if(a < c) {
                System.out.print("a es manor que b y c");
            }
        }
        
        //Switch Case
        System.out.println("\n\nSwitch Case");
        String nota = "MB";
        System.out.print("nota = " + nota + "\n");
        System.out.print("Tu nota es: ");
        switch(nota) {
            case "B":
                System.out.print("Bien");
                break;
            case "MB":
                System.out.print("Muy Bien");
                break;
            case "E":
                System.out.print("Excelente");
                break;
            default :
                System.out.print("Nota incorrecta");
                break;
        }
        //desde main llamamos los métodos
        System.out.println("\n\nMétodos");
        System.out.print("metodoEscribirSaludo: ");
        metodoEscribirSaludo("Milagros");
        System.out.print("\nEl mínimo entre 10 y 20 es: " + minimo(10, 20));
        
        //Arreglos
        //Cargar un arreglo
        System.out.println("\n\nArreglos");
        //Vectores
        System.out.println("\n\n   Vectores");
        int numerosVector[] = new int[10];
        for(int i = 0; i<10; i++){
            numerosVector[i] = i+1;
        }
        //Leer un arreglo
        for(int i = 0; i<10; i++){
            System.out.print("Pos " + i + ": " + numerosVector[i] + "\n");
            
        }
        //Matrices
        System.out.println("\n\n   Matrices");
        int numerosMatriz [][] = new int[3][3];
        //Cargar Matriz
        int k = 1;
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                numerosMatriz[i][j] = k;
                k++;
            }            
        }
        //Leer Matriz
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                System.out.print(numerosMatriz[i][j] + ", ");
            }
            System.out.print("\n");
        }
        
        //Cargar Matriz con ayuda del usuario
        Scanner teclado = new Scanner (System.in);
        int matriz[][] = new int [3][3];
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                System.out.println("Ingrese un valor para la fila: " + i + " columna: " + j);
                int tecla = teclado.nextInt();
                matriz[i][j] = tecla;
            }            
        }
        //Leer Matriz cargada
        System.out.println("Los valores cangados son:");
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                System.out.print(matriz[i][j] + ", ");
            }
            System.out.print("\n");
        }        
    }

        
    public static void metodoEscribirSaludo(String nombre) {
        System.out.print("Hola " + nombre);
    }
    
    public static int minimo(int valor1, int valor2) {
        int min;
        if(valor1 > valor2) {
            min = valor2;
        } else {
            min = valor1;
        }
        return min;
    }

}
