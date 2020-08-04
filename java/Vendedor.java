import java.util.ArrayList;

public abstract class Vendedor {
    private int codigo;
    private String nome;
    private ArrayList<Venda> vendas = new ArrayList<>();

    public Vendedor(int pCodigo, String pNome) {
        setCodigo(pCodigo);
        setNome(pNome);
    }

    public ArrayList<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(ArrayList<Venda> vendas) {
        this.vendas = vendas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void adicionaVenda(int pCodImovel, int pMes, int pAno, double pValor) {
        Venda iVenda = new Venda(pCodImovel, pMes, pAno, pValor);
        this.vendas.add(iVenda);

    }

    abstract String getDados();
    abstract double calculaRenda(int pMes, int pAno);
}