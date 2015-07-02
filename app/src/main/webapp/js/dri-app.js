var app = angular.module('dri-app', ["ngTouch", "angucomplete-alt", "ngRoute"]);
var xmlHttp = null;

app.controller("dri-app-ctrl", function ($scope, $http) {
    $scope.result = null;
    $scope.debugtext = "";

    $scope.doGetFromServer = function (selected) {
        var drugName = selected.originalObject.name;
        
        if (selected) {
            $http.get('rest/services/getDrugDetail/' + drugName).
                    success(function (data, status, headers, config) {
                        $scope.result = data;
                    }).
                    error(function (data, status, headers, config) {
                        $scope.result = data;
                    });
        } else {
            $scope.result = null;
        }
        $scope.searchingStatus = "";
    };

    $scope.inputChanged = function (str) {
        $scope.debugtext = "hope";
    };
    
    $('#label a').click(function (e) {
        e.preventDefault();
        $(this).tab('label');
    });
    
    $('#enforcements a').click(function (e) {
        e.preventDefault();
        $(this).tab('enforcements');
    });   
    
    $('#events a').click(function (e) {
        e.preventDefault();
        $(this).tab('events');
    });

});