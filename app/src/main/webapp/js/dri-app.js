var app = angular.module('dri-app', ["ngTouch", "angucomplete-alt", "ngRoute"]);
var xmlHttp = null;

app.controller("dri-app-ctrl", function ($scope, $sce, $http) {
    $scope.result = null;
    $scope.test = null;

    $scope.doGetFromServer = function (selected) {
        var drugName = selected.originalObject.name;
        
        if (selected) {
            $http.get('rest/services/getDrugDetail/' + drugName).
                    success(function (data, status, headers, config) {
                        $scope.result = data;
                        $scope.test = $sce.trustAsHtml(data.label.results[0].purpose_table[0]);
                    }).
                    error(function (data, status, headers, config) {
                        $scope.result = data;
                    });
        } else {
            $scope.result = null;
        }
    };

    // Initialation for the Label tab
    $('#label a').click(function (e) {
        e.preventDefault();
        $(this).tab('label');
    });
    
    // Initialization for the Events tab
    $('#events a').click(function (e) {
        e.preventDefault();
        $(this).tab('events');
    });

    // Initialization for the Enforcements tab
    $('#enforcements a').click(function (e) {
        e.preventDefault();
        $(this).tab('enforcements');
    });   
    

});