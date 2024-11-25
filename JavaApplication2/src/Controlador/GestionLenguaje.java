/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.LenguajeProgramacion;
import java.util.Arrays;
/**
 *
 * @author FERNANDA
 */
public class GestionLenguaje {
 
    private LenguajeProgramacion[] arregloLenguajes;
    private int contadorLenguajes;
    private static final int FACTOR_CRECIMIENTO = 2;

    // Constructor
    public GestionLenguaje() {
        this.arregloLenguajes = new LenguajeProgramacion[FACTOR_CRECIMIENTO];
        this.contadorLenguajes = 0;
    }

    // Método para agregar un nuevo lenguaje
    public void agregarLenguaje(int anioCreacion, String caracteristicaPrincipal, String nombre, String utilizacion) {
        if (contadorLenguajes == arregloLenguajes.length) {
            crecerArreglo();
        }
        arregloLenguajes[contadorLenguajes++] = new LenguajeProgramacion(anioCreacion, caracteristicaPrincipal, nombre, utilizacion);
    }

    // Método para buscar un lenguaje por nombre
    public LenguajeProgramacion buscarLenguaje(String nombre) {
        for (int i = 0; i < contadorLenguajes; i++) {
            if (arregloLenguajes[i].getNombre().equalsIgnoreCase(nombre)) {
                return arregloLenguajes[i];
            }
        }
        return null; // Retorna null si no se encuentra el lenguaje
    }

    // Método para eliminar un lenguaje por nombre
    public boolean eliminarLenguaje(String nombre) {
        for (int i = 0; i < contadorLenguajes; i++) {
            if (arregloLenguajes[i].getNombre().equalsIgnoreCase(nombre)) {
                // Desplazar elementos para eliminar el espacio
                for (int j = i; j < contadorLenguajes - 1; j++) {
                    arregloLenguajes[j] = arregloLenguajes[j + 1];
                }
                arregloLenguajes[--contadorLenguajes] = null;
                return true;
            }
        }
        return false; // Retorna false si no se encuentra el lenguaje
    }

    // Método para obtener todos los lenguajes en un arreglo
    public LenguajeProgramacion[] getArregloLenguajes() {
        return Arrays.copyOf(arregloLenguajes, contadorLenguajes);
    }

    // Método para imprimir todos los lenguajes
    public void imprimirLenguajes() {
        if (contadorLenguajes == 0) {
            System.out.println("No hay lenguajes registrados.");
        } else {
            for (int i = 0; i < contadorLenguajes; i++) {
                System.out.println(arregloLenguajes[i]);
            }
        }
    }

    // Método privado para hacer crecer dinámicamente el arreglo
    private void crecerArreglo() {
        LenguajeProgramacion[] nuevoArreglo = new LenguajeProgramacion[arregloLenguajes.length * FACTOR_CRECIMIENTO];
        System.arraycopy(arregloLenguajes, 0, nuevoArreglo, 0, arregloLenguajes.length);
        arregloLenguajes = nuevoArreglo;
    }
}

    
