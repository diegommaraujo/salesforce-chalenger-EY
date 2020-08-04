public with sharing class EYTesteController {
    public Credential__c logData;
    public String accessToken {get;set;}
    public Account conta {get;set;}
    public Contact contato {get;set;}

    public EYTesteController() {
        List<Credential__c> cred = [SELECT Id, Name, AccessToken__c, ClientId__c, ClientSecret__c, Username__c, Password__c FROM Credential__c];
        logData = cred.get(0);
        getDadosConta();

    }

    public void getDadosConexao(){
        String reqBody = '?grant_type=password&client_id='+logData.ClientId__c+'&client_secret='+logData.ClientSecret__c+'&username='+logData.Username__c+'&password='+logData.Password__c+logData.AccessToken__c;
        System.debug(reqBody);
        Http h = new Http();
        HttpRequest req = new HttpRequest();
        req.setBody(reqBody);
        req.SetMethod('POST');
        req.setEndpoint('https://login.salesforce.com/services/oauth2/token'+reqBody);
        
        HttpResponse res = h.send(req);

        deserializeResponse resp1 = (deserializeResponse)JSON.deserialize(res.getbody(),deserializeResponse.class);
        accessToken = resp1.access_token;       
                        
    }

    public void setAtualizarContato(){
        
        update contato;

    }
    
    public List<Account> getDadosConta(){
        List<Account> contas = [
            SELECT Id, Name, OwnerId, Owner.Name, Phone,
            ShippingStreet, ShippingCity, ShippingState, ShippingPostalCode, ShippingCountry, 
            BillingStreet, BillingCity, BillingState, BillingPostalCode, BillingCountry, 
            (SELECT Id, OwnerId, FirstName, LastName, Owner.Name, Name, Phone, Account.Name, Title, Email FROM Contacts),
            (SELECT Id, OwnerId, Owner.Name, Name, Account.Name, LeadSource FROM Opportunities)
            FROM Account WHERE Name LIKE 'EY Brasil'
        ];

        if(contas.size()>0) {
            conta = contas.get(0);
            contato = conta.Contacts.get(0);
        }

        return contas;
    }

    public class deserializeResponse{
        public String id;
        public String access_token;
    }
}