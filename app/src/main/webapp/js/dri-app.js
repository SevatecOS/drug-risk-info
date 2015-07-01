var app = angular.module('dri-app', ["ngTouch", "angucomplete-alt", "ngRoute"]);

app.controller("driAppCtrl", ['$scope', function($scope) {
	$scope.greeting = "Hola!";
}]);