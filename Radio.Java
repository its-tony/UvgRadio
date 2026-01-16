/**
 * Interfaz que define el comportamiento básico de un radio de carro.
 *
 * <p>Permite encender o apagar, avanzar estación, guardar/cargar estaciones
 * en 12 botones y cambiar entre bandas AM y FM.</p>
 */
public interface Radio {

  /** Enciende el radio. */
  void prenderRadio();

  /** Apaga el radio. */
  void apagarRadio();

  /**
   * Avanza a la siguiente estación dependiendo de la banda actual.
   *
   * <p>AM avanza de 10 en 10 (530 hasta 1610). FM avanza de 0.2 en 0.2 (87.9 hasta 107.9).
   * Al pasar el máximo, vuelve al mínimo :D </p>
   */
  void avanzarEstacion();

  /**
   * Guarda la estación actual en el botón indicado.
   *
   * @param numeroBoton número del botón (1 a 12)
   * @throws IllegalArgumentException si el botón no está en el rango 1..12
   */
  void guardarEstacion(int numeroBoton);

  /**
   * Carga la estación guardada en el botón indicado.
   *
   * <p>Si el botón no tiene una estación guardada, no realiza cambios.</p>
   *
   * @param numeroBoton número del botón (1 a 12)
   * @throws IllegalArgumentException si el botón no está en el rango 1..12
   */
  void cargarEstacion(int numeroBoton);

  /**
   * Cambia la banda a AM.
   *
   * <p>Si el radio está apagado, no realiza cambios.</p>
   */
  void cambiarAM();

  /**
   * Cambia la banda a FM.
   * <p>Si el radio está apagado, no realiza cambios.</p>
   */
  void cambiarFM();
}
