(function() {    
    angular.module('petclinicPublic')  
        .factory('ownersFactory', ownersFactory);     
    function ownersFactory($http){ 
        
        var currentOwner;
          
        var interfaz = {            
            //Metodos del servicio
            getOwners:  function(){
                return $http.get('http://localhost:8080/owner/list');
            },               
            getOwner:  function(ownerId){
                return $http.get('http://localhost:8080/owner/'+ ownerId);
            },
            createOwner: function(owner){
                return $http.post("http://localhost:8080/owner", owner);
            },        
            editOwner: function(id, owner){
                return $http.put("http://localhost:8080/owner/" + id, owner);
            },
            login: function(email,password){
                return $http.post("http://localhost:8080/owner/login?email="+email+"&password="+password);
            },
            logout: function(){
                currentOwner = undefined;
            },
            setCurrentOwner: function(owner){
                currentOwner = owner;
            },
            getCurrentOwner: function(){
                return currentOwner;
            },
            isLogged: function(){
                return typeof(currentOwner) !== "undefined"
            }
        }
        return interfaz;
    }    
}())