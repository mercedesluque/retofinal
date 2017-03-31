(function() {

    var petClinicApp = angular.module("petclinicPublic",['ui.router']);
    petClinicApp.config(function($stateProvider,$urlRouterProvider){
        
        $urlRouterProvider.otherwise("login");
        
        $stateProvider
            .state('login',{
                url: "/login"    ,
                templateUrl: "templates/login.html",
                controller: 'LoginController',
                controllerAs: 'vm'
            })
            .state('micuenta',{
                url: "/micuenta"    ,
                templateUrl: "templates/micuenta.html",
                controller: 'LoginController',
                controllerAs: 'vm'
            })
            .state('nuevavisita',{
                url: "/nuevavisita"    ,
                templateUrl: "templates/nueva-solicitud.html",
                controller: 'VisitController',
                controllerAs: 'vm'
            })
            .state('miscitas',{
                url: "/misvisitas"    ,
                templateUrl: "templates/mis-citas.html",
                controller: 'VisitController',
                controllerAs: 'vm'
            })
    });
    
}())
