(function() {
    
    angular.module('petclinicPublic')
        .controller('VisitController', visitController);
    
    function visitController(ownersFactory, visitFactory, $state,$stateParams) {        
        var vm = this;
        vm.owner = ownersFactory.getCurrentOwner();
        vm.nueva = {
            'id':'',
            'ownerId':vm.owner.id,
            'vetId':'',
            'petId':'',
            'date':''   
        }

        visitFactory.showVets().then(function (res) {
            vm.vets = res.data;
        }, function (res) {
            vm.error = "Se ha producido un error al traer la lista de vets";
        })
        
        vm.nuevaVisita = function () {
            //vm.nueva.date++;
            visitFactory.addVisit(vm.nueva).then(function (res) {
                vm.nueva = res.data;
                vm.nueva = {
                    'id':'',
                    'ownerId':vm.owner.id,
                    'vetId':'',
                    'petId':'',
                    'date':''
                };
                $state.go('miscitas');
            }, function (res) {
                vm.error = "Se ha producido un error al crear la visita";
            });
        }
        
         visitFactory.showOldVisits(vm.owner.id).then(function (res) {
            vm.old_visits = res.data;
        }, function (res) {
            vm.error = "Se ha producido un error al traer la lista de visits";
        })
        
         visitFactory.showRequestVisits(vm.owner.id).then(function (res) {
            vm.new_visits = res.data;
        }, function (res) {
            vm.error = "Se ha producido un error al traer la lista de visits";
        })
    }    
    
}()); // Sintáxis JS para invocación inmediata