var app = angular.module('dri-app', ["ngTouch", "angucomplete-alt", "ngRoute"]);
var xmlHttp = null;

app.controller("dri-app-ctrl", function ($scope, $http) {
    $scope.result = null;
    $scope.debugtext = "";

    $scope.doGetFromServer = function (selected) {
        if (selected) {
            var drugName = selected.originalObject.name;
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
    };

    $scope.inputChanged = function (str) {
        $scope.debugtext = "hope";
    };

});