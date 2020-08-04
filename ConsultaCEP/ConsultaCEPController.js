({
    handleClick : function(component, event, helper) {
      var searchText = component.get('v.searchText');
      var action = component.get('c.consultaJSON');
      action.setParams({cep: searchText});
      action.setCallback(this, function(response) {
        var state = response.getState();
        if (state === 'SUCCESS') {
          var ids = response.getReturnValue();
          var resul = JSON.parse(ids);
          component.set("v.cepIds", ids);
          component.set("v.cepResultado", 
          "Logradouro: "+resul.logradouro+"\n"+
          "Bairro: "+resul.bairro+"\n"+
          "Cidade: "+resul.localidade+"\n"+
          "Estado: "+resul.uf+"\n"+
          "CEP: "+resul.cep+"\n"
          );
          
        }
      });
      $A.enqueueAction(action);
    },

    handleClick2 : function(component, event, helper) {
        var searchText = component.get('v.cepIds');
        var action = component.get('c.salvaJSON');
        action.setParams({cep: searchText});
        action.setCallback(this, function(response) {
          var state = response.getState();
          if (state === 'SUCCESS') {
            var ids = response.getReturnValue();
            console.log(response);            
          }
        });
        $A.enqueueAction(action);
      }
})