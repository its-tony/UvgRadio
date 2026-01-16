/**
 * Implementación concreta de un radio de carro.
 *
 * <p>Maneja bandas AM/FM, estaciones actuales, avance por pasos y memoria de
 * 12 botones por cada banda.</p>
 */
public class RadioCarro implements Radio {

  // AM
  /** Mínimo permitido para AM. */
  private static final int AM_MIN = 530;

  /** Máximo permitido para AM. */
  private static final int AM_MAX = 1610;

  /** Paso de avance para AM. */
  private static final int AM_STEP = 10;

  // FM
  /** Mínimo permitido para FM. */
  private static final double FM_MIN = 87.9;

  /** Máximo permitido para FM. */
  private static final double FM_MAX = 107.9;

  /** Paso de avance para FM. */
  private static final double FM_STEP = 0.2;

  // ESTADO INTERNO
  private boolean encendido;
  private Banda banda;

  private int estacionAm;
  private double estacionFm;

  private final int[] botonesAm;
  private final double[] botonesFm;

  /**
   * Crea un radio inicializado en estado apagado.
   *
   * <ul>
   *   <li>Banda por defecto: FM</li>
   *   <li>AM inicia en 530</li>
   *   <li>FM inicia en 87.9</li>
   *   <li>Botones vacíos</li>
   * </ul>
   */
  public RadioCarro() {
    encendido = false;
    banda = Banda.FM;

    estacionAm = AM_MIN;
    estacionFm = FM_MIN;

    botonesAm = new int[12];
    botonesFm = new double[12];
  }

  /** {@inheritDoc} */
  @Override
  public void prenderRadio() {
    encendido = true;
  }

  /** {@inheritDoc} */
  @Override
  public void apagarRadio() {
    encendido = false;
  }

  /** {@inheritDoc} */
  @Override
  public void cambiarAM() {
    if (!encendido) {
      return;
    }
    banda = Banda.AM;
  }

  /** {@inheritDoc} */
  @Override
  public void cambiarFM() {
    if (!encendido) {
      return;
    }
    banda = Banda.FM;
  }

  /** {@inheritDoc} */
  @Override
  public void avanzarEstacion() {
    if (!encendido) {
      return;
    }

    if (banda == Banda.AM) {
      avanzarAm();
    } else {
      avanzarFm();
    }
  }

  /** {@inheritDoc} */
  @Override
  public void guardarEstacion(int numeroBoton) {
    if (!encendido) {
      return;
    }

    int idx = validarBoton(numeroBoton);
    if (banda == Banda.AM) {
      botonesAm[idx] = estacionAm;
    } else {
      botonesFm[idx] = estacionFm;
    }
  }

  /** {@inheritDoc} */
  @Override
  public void cargarEstacion(int numeroBoton) {
    if (!encendido) {
      return;
    }

    int idx = validarBoton(numeroBoton);
    if (banda == Banda.AM) {
      if (botonesAm[idx] != 0) {
        estacionAm = botonesAm[idx];
      }
    } else {
      if (botonesFm[idx] != 0.0) {
        estacionFm = botonesFm[idx];
      }
    }
  }

  /**
   * Devuelve un texto amigable del estado del radio.
   *
   * <p>Útil para imprimir en consola sin agregar getters a la interfaz.</p>
   *
   * @return estado del radio (encendido/banda/estación)
   */
  public String estadoActual() {
    if (!encendido) {
      return "Radio apagado";
    }
    if (banda == Banda.AM) {
      return "Encendido | AM | " + estacionAm;
    }
    return "Encendido | FM | " + estacionFm;
  }

  // ===== Helpers privados =====

  /**
   * Avanza estación AM respetando límites y reinicio.
   */
  private void avanzarAm() {
    estacionAm += AM_STEP;
    if (estacionAm > AM_MAX) {
      estacionAm = AM_MIN;
    }
  }

  /**
   * Avanza estación FM respetando límites y reinicio.
   *
   * <p>Se redondea a 1 decimal para evitar errores de punto flotante.</p>
   */
  private void avanzarFm() {
    estacionFm = redondearAUnDecimal(estacionFm + FM_STEP);
    if (estacionFm > FM_MAX) {
      estacionFm = FM_MIN;
    }
  }

  /**
   * Valida que el número de botón esté entre 1 y 12.
   *
   * @param numeroBoton número de botón (1..12)
   * @return índice basado en cero (0..11)
   * @throws IllegalArgumentException si no está en el rango 1..12
   */
  private int validarBoton(int numeroBoton) {
    if (numeroBoton < 1 || numeroBoton > 12) {
      throw new IllegalArgumentException("El botón debe estar entre 1 y 12.");
    }
    return numeroBoton - 1;
  }

  /**
   * Redondea un valor a 1 decimal.
   *
   * @param valor valor original
   * @return valor redondeado a 1 decimal
   */
  private double redondearAUnDecimal(double valor) {
    return Math.round(valor * 10.0) / 10.0;
  }
}
