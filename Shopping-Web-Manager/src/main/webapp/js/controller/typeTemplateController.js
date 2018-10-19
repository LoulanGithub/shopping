
app.controller("typeTemplateController",function ($scope, $controller,typeTemplateService) {
    //继承品优购基础控制器部分
    $controller("PYGbaseController",{$scope:$scope,service:typeTemplateService});

    $scope.searchEntity = {name:""};

    //获取关联想的名称属性
    $scope.jsonToString = function (str, field) {
        var jsons = JSON.parse(str);
        var text = "";

        for (var i=0;i<jsons.length;i++) {
            if (i==jsons.length-1) {
                text += jsons[i][field];
            }
            else
            {
                text += jsons[i][field]+",";
            }
        }
        return text;
    }

    //对象数据进行保存
    $scope.save = function () {
        
    }

    //点击修改按钮
    $scope.findOne = function (id) {
        // var jsons = JSON.parse($scope.entity);
        console.info($scope.list.length)
        for (var i=0;i<$scope.list.length;i++) {
            if ($scope.list[i].id == id) {
                $scope.entity = $scope.list[i];
                $scope.brandList = JSON.parse(str$scope.list[i].brandIds);
            }
        }
    }

});