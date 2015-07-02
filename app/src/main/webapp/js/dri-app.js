var app = angular.module('dri-app', ["ngTouch", "angucomplete-alt", "ngRoute"]);
var xmlHttp = null;

app.controller("dri-app-ctrl", ['$scope', function($scope) {
	$scope.result = null;
        $scope.debugtext = "";
        
        $scope.doGetFromServer = function( selected ) {
            if (selected) {
              var drugName = selected.originalObject.name;
              // need to send request to rest/services/getDrugDetail/{drugName}
              $scope.result = drugName;
            } else {
              $scope.result = null;
            }            
        }

        $scope.inputChanged = function(str) {
            $scope.debugtext = "hope";
        }
    }
]);

