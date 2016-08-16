
angular.module('myBanqueApp',[])

.controller('myBanqueController',function($scope,$http)
{
    $scope.compte=null;
    $scope.codeCompte=null;
    $scope.operation={type:"versement",montant:"0"};
    $scope.pageOperations = [];
    $scope.pageCourante = 0;
    $scope.pageSize = 3;
    $scope.pages = [];
    $scope.operation.codeCompteTo = null;
    $scope.errorMessage = null;
    
    
    $scope.test="ceci est un test";
    
    //fonction qui charge le compte
    $scope.chargerCompte = function()
    {
        $scope.errorMessage = null;
        $scope.pageCourante=0;
        $scope.compte=null;
        $http.get("/comptes/"+$scope.codeCompte)
                .success(function(data)
                {
                    console.log("chargement compte");
                    $scope.compte = data;
                    
                    $scope.chargerOperations();
                    
                })
                .error(function(data)
                {
                    $scope.errorMessage = data.message;
                });
                
                
    };
    
    //focntion qui charge les operations
    $scope.chargerOperations = function()
    {
        $http.get("/operations?codeCompte="+$scope.codeCompte+"&pageStart="+$scope.pageCourante+"&size="+$scope.pageSize)
                .success(function(data)
                {
                    $scope.pageOperations = data;
                    $scope.pages = new Array(data.totalPages);
                });
                
    };
    
    $scope.goToPage = function(p)
    {
        $scope.pageCourante = p;
        $scope.chargerOperations();
    };
    
    //fonction qui realise les operations de viremenet et retrait
    $scope.saveOperation = function()
    {
        var params = "";
        $scope.errorMessage = null;
        if($scope.operation.type == "virement")
        {
            //change param name in operationsoapServices to : montant instead of solde
            params = "codeCompteFrom="+$scope.codeCompte+"&codeCompteTo="+$scope.operation.codeCompteTo+"&solde="+$scope.operation.montant+"&codeEmp=1";
        }
        else
        {
            params = "code="+$scope.codeCompte+"&montant="+$scope.operation.montant+"&codeEmp=1";
        }
        
        $http
        ({
            method : 'PUT',
            url : $scope.operation.type,
            data : params,
            headers : {'Content-Type' : 'application/x-www-form-urlencoded'}
            
        })
        .success(function(data)
        {
            $scope.chargerCompte();
            //$scope.loadOperations();
        })
        .error(function(data)
        {
            $scope.errorMessage = data.message;
        });
    };
    
    $scope.gotoPage = function(page)
    {
        $scope.pageCourante = page;
        //$scope.loadOperations();
        
    };
    
});

