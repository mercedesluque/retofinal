(function() {
    
    angular.module('petclinicPublic')
        .controller('LoginController', loginController);
    
    function loginController(ownersFactory,$state,$stateParams) {        
        var vm = this;
        vm.currentOwner = ownersFactory.getCurrentOwner();

        vm.login = function () {            
            ownersFactory.login(vm.email,vm.password)         
                .then(function (response) {
                    vm.error = false;
                    vm.msgerror = '';                   
                    vm.currentOwner = response.data;                    
                    if(typeof(vm.currentOwner.id) == "undefined"){
                        vm.error = true;
                        vm.msgerror = "Email o contraseña incorrecto";   
                    }else{
                        ownersFactory.setCurrentOwner(vm.currentOwner);
                        $state.go('micuenta');
                    }
                }, function (response) {
                    vm.error = true;
                    vm.msgerror = response.data;                    
                });
                   
        };
        
        vm.logout = function () {
            ownersFactory.logout(); 
            $state.go('login');
            delete vm.currentOwner;
        };
        
        vm.isLogged = function () {
            return ownersFactory.isLogged();  
        };
    }    
    
}()); // Sintáxis JS para invocación inmediata