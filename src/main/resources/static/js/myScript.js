
angular.module('myBanqueApp',[])

.controller('myBanqueController',function($scope,$http)
{
    $scope.compte=null;
    $scope.codeCompte=null;
    $scope.operation={type:"versement",montant:"0"};
    
    $scope.test="ceci est un test";
    
    $scope.chargerCompte = function()
    {
        
        $http.get("/comptes/"+$scope.codeCompte)
                .success(function(data)
                {
                    console.log("chargement compte");
                    $scope.compte = data;
                });
                
    };
    
});

