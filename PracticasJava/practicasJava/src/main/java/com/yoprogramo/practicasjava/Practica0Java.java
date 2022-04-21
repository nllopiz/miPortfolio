package com.yoprogramo.practicasjava;

/**
 *
 * @author Norberto Llopiz
 */

//import java.util.Date;
import java.util.Scanner; //para carga por teclado

public class Practica0Java {

    public static void main(String[] args) {

        /*
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
*/

/*
//************************Práctica Vectores
//Ejercicio 1
        System.out.println("Práctica Vectores");
        System.out.println("""
                           1. Se necesita de un vector que sea capaz de almacenar 
                             10 n\u00fameros enteros entre 1 y 100. Realizar un programa 
                             que permita la carga por teclado de los 10 n\u00fameros solicitados.
                           """);
        
        int vector1[] = new int[10];
        Scanner teclado = new Scanner(System.in);
        int num = 0;
        //cargar números
        for(int i = 0; i<10; i++){            
            //si no se ingresa un numero entre 1 y 100 se vuelve a pedir
            while(num > 100 || num < 1){
                System.out.println("Ingrese un número entre 1 y 100 en pos: " + i);
                num = teclado.nextInt();
            }
            //si el número es válido se guarda en el vector
            vector1[i] = num;
            num = 0;
        }
        //mostrar vector
        System.out.print("Vector 1: ");
        for(int i = 0; i<10; i++){            
            System.out.print(vector1[i] + ", ");            
        }
        
        
//Ejercicio 2
        System.out.println("""
                           2. En un vector de 15 posiciones se almacenan las edades de 15 alumnos.
                             Se desea un programa que sea capaz de determinar cuál es la mayor edad y 
                             cuál es la menor edad que se encuentra entre los estudiantes.""");
        //cargar edades
        int vector2[] = new int[15];
        for(int i = 0; i < 15; i++) {
            System.out.println("Ingrese la edad del alumno " + i + ":");
            int edad = teclado.nextInt();
            vector2[i] = edad;
        }
        //mostrar vector
        System.out.print("Vector 2: ");
        for(int i = 0; i<15; i++){            
            System.out.print(vector2[i] + ", ");            
        }
        //mostrar la mayor y menor edad
        int min=99, max = 0, edad;
        for(int i = 0; i < 15; i++) {            
            edad = vector2[i];
            if(edad > max){
                max = edad;
            } if(edad < min) {
                min = edad;
            }
        }
        System.out.println("\nEdad máxima: " + max);
        System.out.println("Edad mínima: " + min);

//Ejercicio 3
        System.out.println("""
                           3. Se tienen tres vectores. En el primero de ellos se guarda un n\u00famero 
                             de dni, en el segundo un nombre y en el tercero un apellido. 
                             Se desea un programa que sea capaz de recorrer los tres vectores 
                             AL MISMO TIEMPO y mostrar cada uno de estos datos por pantalla. 
                             Pista: tener en cuenta que el \u00edndice de cada vector es correspondiente 
                             al \u00edndice de los dem\u00e1s, es decir, los datos contenidos en el \u00edndice cero 
                             del vector de dni, se corresponde con el \u00edndice cero del vector de 
                             nombres y el de apellidos.""");
        //Vectores
        int vNumero[] = {2,2,5,1,9,3,3,0};
        String vNombre[] = {"N","o","r","b","e","r","t","o"};
        String vApellido[] = {"L", "l", "o", "p", "i", "z"};
        int maxLargo;        
        //Obtener el largo máximo
        if(vNumero.length >  vNombre.length){
            maxLargo = vNumero.length;
        } if(vNombre.length > vApellido.length){
            maxLargo = vNombre.length;
        } else {
            maxLargo = vApellido.length;
        }
        //Mostrar contenido de vectores en simultáneo comparando largos con el 
        //el largo máximo
        for(int i = 0; i < maxLargo; i++){
            if(i < vNumero.length) System.out.print(vNumero[i] + ", ");
            if(i < vApellido.length) System.out.print(vApellido[i] + ", ");            
            if(i < vNombre.length) System.out.print(vNombre[i] + ", ");
            System.out.print("\n");
        }

//Ejercicio 4
        System.out.println("""
                           4. En un vector de 23 posiciones se tienen las temperaturas máximas de
                            las capitales de las 23 provincias argentinas en el último mes. A partir 
                            de esta información, un noticiero desea determinar el top 5 de las 
                            temperaturas más altas para poder mostrar en la pantalla de su programa, 
                            para ello se necesita un programa que sea capaz de recorrer el vector de 
                            temperaturas, determinar las 5 más altas y copiarlas en un nuevo vector 
                            de 5 posiciones.""");
        
        int temp[] = {20,23,25,21,26,33,30,29,28,27,21,22,23,20,23,25,21,26,24,31,32,19,35};
        int aux;
        //mostrar vector
        System.out.println("Temperaturas: ");
        for(int i = 0; i<temp.length; i++){            
            System.out.print(temp[i] + " ");            
        }
        //ordenar método burbuja
        for(int i=1; i<temp.length; i++){
            for(int j=0; j<temp.length-1; j++){
                if(temp[j]<temp[j+1]){
                    aux = temp[j];
                    temp[j] = temp[j+1];
                    temp[j+1] = aux;
                }
            }
        }
        //mostrar vector ordenado, las primeras 5
        System.out.println("\nTop 5 Temperaturas más altas: ");
        for(int i = 0; i<5; i++){            
            System.out.print(temp[i] + " ");            
        }
        
//Ejercicio 5
        System.out.println("""
                            \n5. Se necesita un vector que permita cargar por teclado el nombre de 
                            10 animales. A partir de esta carga, se desea otro vector que copie los 
                            mismos nombres pero en el orden inverso, es decir, si los nombres son: 
                            perro, gato, lagartija, el nuevo vector debe contener: lagartija, gato, 
                            perro. Una vez realizado el cambio, mostrar por pantalla ambos vectores 
                            para compararlos.
                           """);
        
        String animales[] = new String[10];
        //Scanner teclado = new Scanner(System.in);
        //cargar animales por teclado
        for(int i=0; i<animales.length; i++) {
            System.out.println("Animal " + i + ": ");
            animales[i] = teclado.next();
        }
        //mostrar animales
        System.out.print("Animales: ");
        for (String animal : animales) {
            System.out.print(animal + " ");
        }        
        //invertir vector
        String vAux[] = new String[animales.length];
        int cant = animales.length-1;
        for(int i=0;i<animales.length; i++) {
            vAux[i] = animales[cant];
            cant--;
        }
        //mostrar animales invertido
        System.out.print("\nAnimales invertido: ");
        for (String animal : vAux) {
            System.out.print(animal + " ");
        }
        
*/
//*****************************Práctica Matrices
        //Ejercicio 1
        System.out.print("""
                         \n1. Una matriz de 5 filas x 3 columnas almacena el total de goles de 5 jugadores
                         de fútbol en los últimos 3 partidos que jugaron, donde cada fila representa a 
                         un jugador y cada columna a la cantidad de goles que hizo.
                         Se necesita un programa que sea capaz de permitir la carga de los goles,
                         calcular el promedio de goles realizado por cada jugador y almacenar el 
                         resultado en un vector de 5 posiciones, donde cada posición representará a un 
                         jugador.
                         Nota: tener en cuenta que el promedio de goles puede dar como resultado un número
                         que NO SEA ENTERO.""");
        
        int jugadores = 5;
        int partidos = 3;
        int jugadorGoles[][] = new int[jugadores][partidos];
        double promedios[] = new double[5];
        
        //cargar matriz
        Scanner teclado = new Scanner(System.in);
        for(int f=0;f<jugadores;f++) {
            for(int c=0; c<partidos; c++) {
                System.out.print("\nGoles del Jugador " + (f+1) + " Partido " + (c+1) + ": ");
                int entrada = teclado.nextInt();
                jugadorGoles[f][c] = entrada;
            }
        }
        
        //mostrar matriz
        int sumaGoles = 0;
        System.out.println("Goles por partido: ");
        for(int f=0;f<jugadores;f++) {
            System.out.print("Jugador " + (f+1) + ": ");
            for(int c=0; c<partidos; c++) {
                System.out.print(jugadorGoles[f][c] + " ");
                //suma de goles del jugador para el promedio
                sumaGoles = sumaGoles + jugadorGoles[f][c];                
            }
            System.out.print("\n");
            //promedio de goles por jugador
            promedios[f] = sumaGoles / partidos;
            sumaGoles = 0;
        }
        
        //mostrar promedios
        System.out.print("\nPromedios: \n");
        for(int f=0;f<jugadores;f++) {
            System.out.print("\nPromedio de Goles del Jugador " + (f+1) + ": ");           
            System.out.print(promedios[f] + " ");
        }
        
        
        
    }

/*        
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
*/
}
