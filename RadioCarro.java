public class RadioCarro {
    public class RadioCarro{
private boolean encendido;
private Banda banda;
private int estacionAM;
private double estacionFM;
private int[] botonesAM;
private double[] botonesFM;

private static int AM_MIN = 530;
private static int AM_MAX = 1700;
private static int AM_STEP = 10;
private static double FM_MIN = 87.9;
private static double FM_MAX = 107.9;
private static double FM_STEP = 0.2;

//Constructor
RadioCarro() {
    this.encendido = false;
    this.banda = Banda.FM;
    this.estacionAM = AM_MIN;
    this.estacionFM = FM_MIN;
    this.botonesAM = new int[12];
    this.botonesFM = new double[12];
}

void prenderRadio() {
    this.encendido = true;
}

void apagarRadio() {
    this.encendido = false;

}

void avanzarEstacion() {
    if (this.banda == Banda.AM) {
        this.estacionAM += AM_STEP;
        if (this.estacionAM > AM_MAX) {
            this.estacionAM = AM_MIN;
        }
    } else {
        this.estacionFM += FM_STEP;
        if (this.estacionFM > FM_MAX) {
            this.estacionFM = FM_MIN;
        }
    }
}

void guardarEstacion(int numeroBoton){
    if (this.banda == Banda.AM) {
        this.botonesAM[numeroBoton] = this.estacionAM;
    } else {
        this.botonesFM[numeroBoton] = this.estacionFM;
    }
}

void cargarEstacion(int numeroBoton){
    if (this.banda == Banda.AM) {
        this.estacionAM = this.botonesAM[numeroBoton];
    } else {
        this.estacionFM = this.botonesFM[numeroBoton];
    }
}

void cambiarFM() {
    if (this.banda == Banda.AM) {
        this.banda = Banda.FM;
    } else {
        this.banda = Banda.AM;
    }
}

void cambiarAM(){
    if (this.banda == Banda.FM) {
        this.banda = Banda.AM;
    } else {
        this.banda = Banda.FM;
    }
}

public boolean getEncendido() {
    return encendido;
}

public Banda getBanda() {
    return banda;
}

public int getEstacion() {
    if (this.banda == Banda.AM) {
        return estacionAM;
    } else {
        return (int) estacionFM;
    }
}

public int[] getBotonesAM() {
    return botonesAM;
    
}

public double[] getBotonesFM() {
    return botonesFM;
}
}
}
