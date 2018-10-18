
app.controller("typeTemplateController",function ($scope, $controller,typeTemplateService) {
    //继承品优购基础控制器部分
    $controller("PYGbaseController",{$scope:$scope,service:typeTemplateService});

    $scope.searchEntity = {name:""};

});