public class Conversion {


    /*Declarando variables. NOTA: tener en cuenta que se toma como valor base 1, por ejemplo 1 Peso, Dolar, Real, Etc.*/

    private String baseDivisa;
    private String targetDivisa;
    private double valorCambio;

    //Constructor teniendo como parámetro el record.

    public Conversion(DivisaRecord divisaRecord){
        this.baseDivisa = divisaRecord.base_code();
        this.targetDivisa = divisaRecord.target_code();
        this.valorCambio = divisaRecord.conversion_rate();
    }

    public String getBaseDivisa() {
        return baseDivisa;
    }

    public String getTargetDivisa() {
        return targetDivisa;
    }

    public double getValorCambio() {
        return valorCambio;
    }

    @Override
    public String toString() {
        return "Base: " + baseDivisa + "\n" +
                "Target: " + targetDivisa + "\n" +
                "Valor: " + valorCambio;
    }
}
