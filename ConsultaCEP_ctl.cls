public class ConsultaCEP_ctl {

    @AuraEnabled
    public static String consultaJSON(String cep) {

        //Não esquecer de cadastrar o viacep como site remoto
        HttpRequest req = new HttpRequest();
        req.setEndpoint('https://viacep.com.br/ws/' + cep + '/json/');
        req.setMethod('GET');
        req.setHeader('Content-Type', 'application/json');
        req.setTimeout(120000);
        try {
            Http h = new Http();
            HttpResponse res = h.send(req);
            system.debug(res.getBody());
            if (res.getStatusCode() == 200) {
                ViaCep dados = parse(res.getBody());
                if (dados.erro == true) {
                    return 'erro';
                }
                return JSON.serialize(dados);
            }
        } catch (Exception e) {
            system.debug('erro' + e.getMessage());
            return 'erro';

        }

        return null;
    }

    @AuraEnabled
    public static String salvaJSON(String cep) {

        ViaCEP data = (ViaCEP)JSON.deserialize(cep, ViaCEP.class);
        Account conta;
        List<Account> contas = [
            SELECT Id, Name, OwnerId, Owner.Name, Phone,
            ShippingStreet, ShippingCity, ShippingState, ShippingPostalCode, ShippingCountry, 
            BillingStreet, BillingCity, BillingState, BillingPostalCode, BillingCountry
            FROM Account WHERE Name LIKE 'EY Brasil'
        ];

        if(contas.size()>0) {
            conta = contas.get(0);
            conta.BillingStreet = data.logradouro;
            conta.BillingCity = data.localidade;
            conta.BillingState = data.uf;
            conta.BillingPostalCode = data.cep;
            conta.BillingCountry = 'Brasil';

            conta.ShippingStreet = data.logradouro;
            conta.ShippingCity = data.localidade;
            conta.ShippingState = data.uf;
            conta.ShippingPostalCode = data.cep;
            conta.ShippingCountry = 'Brasil';

            update conta;
        }

        return '';
    }

    public class XMLCEPClass {

        public ViaCep xmlcep;

        public XMLCEPClass parse(String json) {
            return (XMLCEPClass) System.JSON.deserialize(json, XMLCEPClass.class);
        }
    }

    public class ViaCep {
        public String cep;
        public String logradouro;
        public String complemento;
        public String bairro;
        public String localidade;
        public String uf;
        public String unidade;
        public String ibge;
        public String gia;
        public Boolean erro;
    }


    public static ViaCep parse(String json) {
        return (ViaCep) System.JSON.deserialize(json, ViaCep.class);
    }
}