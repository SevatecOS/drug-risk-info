/* global angular */

var app = angular.module('dri-app', ['ngTouch', 'angucomplete-alt', 'ngRoute']);
var xmlHttp = null;

app.controller("dri-app-ctrl", function ($scope, $sce, $http) {
    // Overall result
    $scope.result = null;
    $scope.searchItem = null;
    
    // Result elements with HTML data
    $scope.activeIngredientTable = null;
    $scope.clinicalPharmacologyTable = null;
    $scope.pharmacodynamicsTable = null;
    $scope.pharmacokineticsTable = null;
    $scope.purposeTable = null;
    $scope.warningsTable = null;
    $scope.recentsearches = null;
    
    $http.get('rest/services/getRecentSearches').
            success(function(data, status, headers, config){
                $scope.recentsearches = data;
            }).
            error(function(data, status, headers, config){
                $scope.recentsearches = data;
            });

    $scope.doGetFromServer = function (selected) {
        var drugName = selected.originalObject.name;
        var myModal = $('#myModal');
               
        if (selected) {
            myModal.find('.modal-body').text(drugName);
            myModal.modal('show');
            $http.get('rest/services/getDrugDetail/' + drugName).
                    success(function (data) {
                        $scope.result = data;
                        $scope.activeIngredientTable = $sce.trustAsHtml(data.label.results[0].active_ingredient_table[0]);
                        $scope.clinicalPharmacologyTable = $sce.trustAsHtml(data.label.results[0].clinical_pharmacology_table[0]);
                        $scope.pharmacodynamicsTable = $sce.trustAsHtml(data.label.results[0].pharmacodynamics_table[0]);
                        $scope.pharmacokineticsTable = $sce.trustAsHtml(data.label.results[0].pharmacokinetics_table[0]);
                        $scope.purposeTable = $sce.trustAsHtml(data.label.results[0].purpose_table[0]);
                        $scope.warningsTable = $sce.trustAsHtml(data.label.results[0].warnings_table[0]);
                    }).
                    error(function (data, status) {
                        $scope.result = data;
                    }).
                    finally(function() {
                        myModal.modal('hide');                    
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