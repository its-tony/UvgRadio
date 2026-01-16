import java.util.Scanner;

/**
 * Clase principal (consola) para interactuar con el radio.
 *
 * <p>Depende de la interfaz {@link Radio} para reducir acoplamiento.
 * Cambiar la implementación debe requerir una sola línea.</p>
 */
public class Main {

  private final Radio radio;

  /**
   * Crea el programa principal con una implementación de radio.
   *
   * <p>Para cambiar de implementación, reemplaza {@code new RadioCarro()}.</p>
   */
  public Main() {
    radio = new RadioCarro();
  }

  /**
   * Imprime el menú de opciones en consola.
   */
  public void mostrarMenu() {
    System.out.println("\n===== RADIO CARRO =====");
    System.out.println("1) Prender radio");
    System.out.println("2) Apagar radio");
    System.out.println("3) Cambiar a AM");
    System.out.println("4) Cambiar a FM");
    System.out.println("5) Avanzar estación");
    System.out.println("6) Guardar estación en botón (1-12)");
    System.out.println("7) Cargar estación de botón (1-12)");
    System.out.println("0) Salir");
    System.out.print("Elige una opción: ");
  }

  /**
   * Ejecuta el ciclo principal del programa hasta que el usuario salga.
   */
  public void ejecutar() {
    Scanner scanner = new Scanner(System.in);
    int opcion;

    do {
      imprimirEstadoSiEsPosible();
      mostrarMenu();
      opcion = leerEntero(scanner);

      try {
        ejecutarOpcion(opcion, scanner);
      } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
      }
    } while (opcion != 0);

    scanner.close();
  }

  /**
   * Punto de entrada del programa.
   *
   * @param args argumentos de línea de comandos
   */
  public static void main(String[] args) {
    new Main().ejecutar();
  }

  // ===== Helpers privados =====

  /**
   * Ejecuta la opción seleccionada por el usuario.
   *
   * @param opcion opción del menú
   * @param scanner lector de entrada
   */
  private void ejecutarOpcion(int opcion, Scanner scanner) {
    switch (opcion) {
      case 1:
        radio.prenderRadio();
        break;
      case 2:
        radio.apagarRadio();
        break;
      case 3:
        radio.cambiarAM();
        break;
      case 4:
        radio.cambiarFM();
        break;
      case 5:
        radio.avanzarEstacion();
        break;
      case 6:
        System.out.print("Botón (1-12): ");
        radio.guardarEstacion(leerEntero(scanner));
        break;
      case 7:
        System.out.print("Botón (1-12): ");
        radio.cargarEstacion(leerEntero(scanner));
        break;
      case 0:
        System.out.println("Saliendo...");
        break;
      default:
        System.out.println("Opción inválida.");
        break;
    }
  }

  /**
   * Lee un entero desde consola, repitiendo si el usuario ingresa texto inválido.
   *
   * @param scanner lector de entrada
   * @return entero ingresado
   */
  private int leerEntero(Scanner scanner) {
    while (!scanner.hasNextInt()) {
      scanner.next();
      System.out.print("Ingresa un número: ");
    }
    return scanner.nextInt();
  }

  /**
   * Imprime el estado del radio si la implementación lo soporta.
   *
   * <p>Esto mantiene que {@code Main} trabaje con la interfaz {@link Radio},
   * pero permite mostrar estado cuando la implementación es {@link RadioCarro}.</p>
   */
  private void imprimirEstadoSiEsPosible() {
    if (radio instanceof RadioCarro) {
      RadioCarro radioCarro = (RadioCarro) radio;
      System.out.println("\nEstado: " + radioCarro.estadoActual());
    }
  }
}
