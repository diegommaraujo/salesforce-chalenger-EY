import java.util.ArrayList;

public class TestaImpl {
    public static void main(String args[]) {    
        ArrayList<Vendedor> ven = new ArrayList<>();    
        Contratado contr = new Contratado (1, "Joao da Silva", "1111", 1000);    
        contr.adicionaVenda(100, 10, 2012, 200000);    
        contr.adicionaVenda(101, 10, 2012, 300000);    
        contr.adicionaVenda(102, 11, 2012, 600000);    
        ven.add(contr);    
        
        Comissionado comis = new Comissionado (2, "Jose da Silva", "2222",    7);    
        comis.adicionaVenda(200, 10, 2012, 200000);    
        comis.adicionaVenda(201, 10, 2012, 300000);    
        comis.adicionaVenda(202, 11, 2012, 600000);    
        ven.add(comis);    
        
        for (Vendedor v: ven){    
            System.out.println(v.getDados());    
            System.out.println(" teve rendimento de " + v.calculaRenda(10,    2012));    
            System.out.println(" no mês 10 de 2012.");    
 
        }       
    }
} 