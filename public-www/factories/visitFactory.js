(function() {    
    angular.module('petclinicPublic')  
        .factory('visitFactory', visitFactory);     
    function visitFactory($http){ 
          
        var interfaz = {            
            //Metodos del servicio
            showVets: function(){
                return $http.get('http://localhost:8080/vets');
            },
            addVisit: function(visit) {
                return $http.post("http://localhost:8080/owners/"+visit.ownerId+"/pets/"+visit.petId+"/request-visits", visit);
            },
            showOldVisits: function(ownerId) {
                return $http.get("http://localhost:8080/owners/"+ownerId+"/visits");
            },
            showRequestVisits: function(ownerId) {
                return $http.get("http://localhost:8080/owner/"+ownerId+"/requestvisits");
            }
        }
        return interfaz;
    }    
}())