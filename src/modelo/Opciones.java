package modelo;

public class Opciones {
    private String opcionModelo;
    private String opcionMotor;
    private String opcionColor;
    private int opcionRuedas;
    private byte opcionPilotoAutomatico;

    public Opciones(String opcionModelo, String opcionMotor, String opcionColor, int opcionRuedas, byte opcionPilotoAutomatico) {
        this.opcionModelo = opcionModelo;
        this.opcionMotor = opcionMotor;
        this.opcionColor = opcionColor;
        this.opcionRuedas = opcionRuedas;
        this.opcionPilotoAutomatico = opcionPilotoAutomatico;
    }


    public String getOpcionModelo() {
        return opcionModelo;
    }

    public String getOpcionMotor() {
        return opcionMotor;
    }

    public String getOpcionColor() {
        return opcionColor;
    }

    public int getOpcionRuedas() {
        return opcionRuedas;
    }

    public byte getOpcionPilotoAutomatico() {
        return opcionPilotoAutomatico;
    }


}
