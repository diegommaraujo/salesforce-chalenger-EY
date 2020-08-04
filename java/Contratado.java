public class Contratado extends Vendedor {
    private String nroCartTrabalho;
    private double salario;

    public Contratado(final int pCodigo, final String pNome, final String pNroCartTrabalho, final double pSalario) {
        super(pCodigo, pNome);
        setSalario(pSalario);
        setNroCartTrabalho(pNroCartTrabalho);
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getNroCartTrabalho() {
        return nroCartTrabalho;
    }

    public void setNroCartTrabalho(String nroCartTrabalho) {
        this.nroCartTrabalho = nroCartTrabalho;
    }

    public String getDados() {
        String ret = "";
        ret+="| Nome: "+getNome();
        ret+="| Carteira de Trabalho: "+getNroCartTrabalho();
        ret+="| Salario Bruto: "+getSalario();
        return ret;
    }

    public double calculaRenda(final int pMes, final int pAno) {
        double ret = getSalario();

        for(Venda iVenda: getVendas()){
            if(iVenda.getAnoVenda()==pAno && iVenda.getMesVenda()==pMes){
                ret += iVenda.getValorVenda() * 0.01;
            }
        }
        return ret;
   }

    
}