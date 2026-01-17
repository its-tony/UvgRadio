import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RadioCarroTest {

    @Test
    public void testAvanzarEstacionAM() {
        RadioCarro radio = new RadioCarro();
        radio.prenderRadio();

        radio.avanzarEstacion();

        assertEquals(540, radio.getEstacionActual());
    }

}
