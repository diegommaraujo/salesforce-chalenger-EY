public class Comissionado extends Vendedor {
    private String nroCPF;
    private float comissao;

    public Comissionado(int pCodigo, String pNome, String pNroCPF, float pComissao) {
        super(pCodigo, pNome);
        setNroCPF(pNroCPF);
        setComissao(pComissao);
    }

    public void setComissao(float comissao) {
        this.comissao = comissao;
    }

    public void setNroCPF(String nroCPF) {
        this.nroCPF = nroCPF;
    }

    public float getComissao() {
        return comissao;
    }

    public String getNroCPF() {
        return nroCPF;
    }

    public String getDados() {
        String ret = "";
        ret+="| Nome: "+getNome();
        ret+="| CPF: "+getNroCPF();
        ret+="| Comissão: "+getComissao()+"%";
        return ret;
    }

    public double calculaRenda(final int pMes, final int pAno) {
        double ret = 0;

        for(Venda iVenda: getVendas()){
            if(iVenda.getAnoVenda()==pAno && iVenda.getMesVenda()==pMes){
                ret += iVenda.getValorVenda()*getComissao()/100;
            }
        }
        return ret;
    }
}