public class Venda {
    private int codImovel;
    private int mesVenda;
    private int anoVenda;
    private double valorVenda;

    public Venda(int pCodImovel, int pMesVenda, int pAnoVenda, double pValorVenda) {
        setCodImovel(pCodImovel);
        setMesVenda(pMesVenda);
        setAnoVenda(pAnoVenda);
        setValorVenda(pValorVenda);
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public int getAnoVenda() {
        return anoVenda;
    }

    public void setAnoVenda(int anoVenda) {
        this.anoVenda = anoVenda;
    }

    public int getMesVenda() {
        return mesVenda;
    }

    public void setMesVenda(int mesVenda) {
        this.mesVenda = mesVenda;
    }

    public int getCodImovel() {
        return codImovel;
    }

    public void setCodImovel(int codImovel) {
        this.codImovel = codImovel;
    }


    


}