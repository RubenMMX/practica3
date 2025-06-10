package modelo;

public class Pedidos {
    private int id;
    private String modelo;
    private String motor;
    private String color;
    private int ruedas;
    private byte pilotoAutomatico;

    public Pedidos( int id,String modelo, String motor, String color, int ruedas, byte pilotoAutomatico) {
        this.id = id;
        this.modelo = modelo;
        this.motor = motor;
        this.color = color;
        this.ruedas = ruedas;
        this.pilotoAutomatico = pilotoAutomatico;
    }

    @Override
    public String toString() {
        boolean pAut = this.pilotoAutomatico == 1 ? true:false;
        return  id+" " + modelo +" "+ motor +" "+ color +" "+ ruedas +" "+ pAut ;
    }

    public int getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMotor() {
        return motor;
    }

    public String getColor() {
        return color;
    }

    public int getRuedas() {
        return ruedas;
    }

    public byte getPilotoAutomatico() {
        return pilotoAutomatico;
    }
}
