import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RadioCarroTest {

    @Test
    public void testAvanzarEstacionAM() {
        RadioCarro radio = new RadioCarro();
        radio.prenderRadio();
        radio.cambiarAM();
        radio.avanzarEstacion();

        assertEquals(540, radio.getEstacionActual());
    }
@Test
    public void testCambiarBandaAFM() {
        RadioCarro radio = new RadioCarro();
        radio.prenderRadio();
        radio.cambiarFM();   
        assertEquals(Banda.FM, radio.getBandaActual());
        assertEquals(87.9, radio.getEstacionActual());
    }

    @Test
    public void testGuardarYCargarEstacion() {
        RadioCarro radio = new RadioCarro();
        radio.prenderRadio();
        radio.cambiarFM();   

        radio.avanzarEstacion(); // 88.1
        radio.guardarEstacion(1);

        radio.avanzarEstacion(); // 88.3
        radio.cargarEstacion(1);

        assertEquals(88.1, radio.getEstacionActual());
    }
    @Test
    public void testNoAvanzaSiRadioEstaApagado() {
    RadioCarro radio = new RadioCarro();

    radio.avanzarEstacion();

    assertEquals(87.9, radio.getEstacionActual());
}

}
