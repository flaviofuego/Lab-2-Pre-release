/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab2prealpha;

import Sonido.SClip;

/**
 *
 * @author flavi
 */


/*
* Estructura de Datos II
Simulación de Movimiento Táctico en un Equipo de Fútbol
Descripción:
Imagina que estás desarrollando un programa en el lenguaje de programación de tu
preferencia para simular el movimiento táctico de un equipo de fútbol durante un partido.
Cada jugador en el campo se representa como un nodo en un grafo, y estos nodos tienen
atributos que incluyen la velocidad, la posesión y la habilidad de remate del jugador. Tu
tarea es crear un sistema que permita determinar el camino óptimo para llegar a la portería
contraria según las circunstancias del juego.
Instrucciones:
Define una clase Jugador que represente a un jugador de fútbol. Cada instancia de la
clase Jugador debe tener atributos para la velocidad, la posesión y la habilidad de remate
del jugador.
Crea una clase Campo que represente el campo de juego como un grafo. Los jugadores
se representarán como nodos en el grafo, y las aristas entre los nodos indicarán las rutas
posibles para avanzar hacia la portería contraria.
Implementa un método en la clase Campo que permita especificar en un momento dado
del partido si el equipo desea enfocarse en la velocidad, la posesión o el remate. Esto
influirá en la elección de la ruta óptima para avanzar hacia la portería contraria.
Desarrolla un algoritmo que, dada la estrategia especificada (velocidad, posesión o
remate), determine el camino óptimo a seguir en el grafo desde la posición actual del
balón hasta la portería contraria. Ten en cuenta los atributos de velocidad, posesión y
remate de los jugadores para tomar decisiones.
Evaluación:
Se evaluará tu capacidad para:
1. Diseñar clases y estructuras de datos en el lenguaje de programación de tu
preferencia para representar jugadores y el campo de juego como un grafo.
2. Implementar un sistema que pueda cambiar la estrategia en función de la
velocidad, la posesión o el remate deseados.
3. Utilizar algoritmos de grafos para determinar el camino óptimo en el campo en
función de la estrategia elegida y los atributos de los jugadores.
4. Demostrar un entendimiento sólido de cómo utilizar grafos en un contexto práctico,
como el movimiento táctico en un juego de fútbol.
5. La entrada de los datos de los jugadores debe ser en formato CSV (valores
separados por coma), ejemplo:
Nombre,Velocidad,Remates,Posesión
Jugador1,85,70,75
Jugador2,80,65,80
Jugador3,75,80,70
Jugador4,70,85,65
Jugador5,82,75,78
Jugador6,78,82,73
Jugador7,75,70,80
Jugador8,79,73,85
Jugador9,81,68,75
Jugador10,73,80,77
Jugador11,77,75,78
Matriz de adyacencia:
Jugador1,0,1,1,0,0,0,0,0,0,0,0
Jugador2,1,0,0,0,1,0,0,0,0,0,0
Jugador3,1,0,0,0,0,1,0,0,0,0,0
Jugador4,0,0,0,0,0,0,1,0,0,0,0
Jugador5,0,1,0,0,0,0,0,1,0,0,0
Jugador6,0,0,1,0,0,0,0,0,1,0,0
Jugador7,0,0,0,1,0,0,0,0,0,1,0
Jugador8,0,0,0,0,1,0,0,0,0,0,1
Jugador9,0,0,0,0,0,1,0,0,0,0,0
Jugador10,0,0,0,0,0,0,1,0,0,0,0
Jugador11,0,0,0,0,0,0,0,1,0,0,0
6. Nota: Asegúrate de incluir comentarios explicativos en tu código para que los
evaluadores puedan entender tu lógica y tu implementación. Además, podrías
considerar la posibilidad de utilizar bibliotecas gráficas para visualizar la
simulación del juego en tiempo real
Bono:
a. Agregar interactividad al momento de ejecutar los algoritmos.
b. Investigar y explicar que tan óptima/eficiente es su implementación y como
esta se compara a otras implementaciones.
1. Requerimientos de código/funcionales
a. Debe validar todas las entradas de ser necesarias.
b. Debe cumplir con todos los requerimientos.
c. El programa no debe cerrarse inesperadamente.
*
*
*
*
*
*
*
* */

public class Lab2PreAlpha {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SClip welove = new SClip("sound/videoplayback.wav");

        welove.play();


    }
    
}
