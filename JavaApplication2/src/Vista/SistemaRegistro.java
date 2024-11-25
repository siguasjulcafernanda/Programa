/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;
import Controlador.GestionLenguaje;
import Modelo.LenguajeProgramacion;
 import java.util.Scanner;
/**
 *
 * @author FERNANDA
 */
public class SistemaRegistro {

    private final GestionLenguaje gestionLenguaje = new GestionLenguaje(); // Instancia del controlador

    public static void main(String[] args) {
        SistemaRegistro sistema = new SistemaRegistro();
        sistema.menu(); // Inicia el menú interactivo
    }

    // Método para mostrar el menú
    public void menu() {
        try (Scanner scanner = new Scanner(System.in)) {
            int opcion;
            
            do {
                System.out.println("\n--- Menu de Registro de Lenguajes de Programacion ---");
                System.out.println("1. Agregar Lenguaje");
                System.out.println("2. Buscar Lenguaje");
                System.out.println("3. Eliminar Lenguaje");
                System.out.println("4. Imprimir Lenguajes");
                System.out.println("5. Salir");
                System.out.print("Seleccione una opcion: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                
                switch (opcion) {
                    case 1 -> agregarLenguaje(scanner);
                    case 2 -> buscarLenguaje(scanner);
                    case 3 -> eliminarLenguaje(scanner);
                    case 4 -> imprimirLenguajes();
                    case 5 -> System.out.println("Saliendo del sistema...");
                    default -> System.out.println("Opción no válida. Intente de nuevo.");
                }
            } while (opcion != 5);
        }
    }

    // Método para agregar un lenguaje
    private void agregarLenguaje(Scanner scanner) {
        System.out.print("Ingrese el año de creacion: ");
        int anioCreacion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        System.out.print("Ingrese la caracteristica principal: ");
        String caracteristicaPrincipal = scanner.nextLine();

        System.out.print("Ingrese el nombre del lenguaje: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la utilizacion del lenguaje: ");
        String utilizacion = scanner.nextLine();

        gestionLenguaje.agregarLenguaje(anioCreacion, caracteristicaPrincipal, nombre, utilizacion);
        System.out.println("Lenguaje agregado correctamente.");
    }

    // Método para buscar un lenguaje
    private void buscarLenguaje(Scanner scanner) {
        System.out.print("Ingrese el nombre del lenguaje a buscar: ");
        String nombre = scanner.nextLine();

        LenguajeProgramacion lenguaje = gestionLenguaje.buscarLenguaje(nombre);
        if (lenguaje != null) {
            System.out.println("Lenguaje encontrado: " + lenguaje);
        } else {
            System.out.println("Lenguaje no encontrado.");
        }
    }

    // Método para eliminar un lenguaje
    private void eliminarLenguaje(Scanner scanner) {
        System.out.print("Ingrese el nombre del lenguaje a eliminar: ");
        String nombre = scanner.nextLine();

        boolean eliminado = gestionLenguaje.eliminarLenguaje(nombre);
        if (eliminado) {
            System.out.println("Lenguaje eliminado correctamente.");
        } else {
            System.out.println("Lenguaje no encontrado. No se pudo eliminar.");
        }
    }

    // Método para imprimir todos los lenguajes
    private void imprimirLenguajes() {
        System.out.println("\n--- Lista de Lenguajes Registrados ---");
        gestionLenguaje.imprimirLenguajes();
    }
}

