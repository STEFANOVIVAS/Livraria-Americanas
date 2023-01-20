public class Caixa {
    private Double saldo;

    public Caixa(){
        this.saldo=1000.0;
    }

    public Caixa(Double saldo) {
        this.saldo = saldo;
    }


    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
}
