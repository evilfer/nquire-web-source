angular.module('senseItWeb', null, null).controller('AdminProjectsItemCtrl', function ($scope) {

    if ($scope.project) {

        // ng-repeat context.
        $scope.form = new SiwFormManager($scope.admin.data.projects, [ $scope.project.id ], function () {
            var idx = $scope.project._idx
              , projects = $scope.admin.data.projects;

            $scope.admin.setProjectFilter(projects[ idx ].id, projects[ idx ].filters);

            $scope.log("Project filter updated: ", $scope, projects[ idx ]);
        });

    }

    $scope.log("Project: ", $scope.project);
});