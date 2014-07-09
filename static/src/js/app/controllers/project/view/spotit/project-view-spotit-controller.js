angular.module('senseItWeb', null, null).controller('ProjectViewSpotItCtrl', function ($scope) {

    $scope.templates.menu = 'partials/project/view/spotit/spotit-view-menu.html';
    $scope.templates.outlineData = 'partials/project/view/spotit/spotit-view-outline.html';

    $scope.templates.dataTable = 'partials/project/view/spotit/data-table-spotit.html';


    $scope.dataInfo = {
        type: 'spotit'
    };

    if ($scope.projectData.project.activity.geolocated) {
        $scope.mapData = {
            mapVariables: $scope.dataInfo.tableVariables.map(function(v) {
                return {id: v.id, label: v.label(), weight: v.weight};
            }),
            value: function(item, v) {
                return item.varValue[v.id].v[0];
            },
            location: function(item) {
                return JSON.parse(item.geolocation);
            }
        };
    }

});