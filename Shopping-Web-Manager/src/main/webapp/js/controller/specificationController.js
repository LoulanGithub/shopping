
app.controller('specificationController',function ($scope,$controller,specificationService) {
    //继承品优购基础控制器部分
    $controller("PYGbaseController",{$scope:$scope,service:specificationService});

    $scope.searchEntity = {specName:""};

    //根据id查找对象数据
    $scope.findOne = function (id) {
        specificationService.findOne(id).success(
            function (response) {
                $scope.entity = response;
            }
        ).error(
            function () {
                alert ("数据读取失败");
            }
        );
    }

    //新增规格选项
    $scope.addTableRow = function () {
        $scope.entity.specificationOptionList.push({});
    }

    //删除一个option选项
    $scope.deleteOptionOne = function (id) {
        specificationService.deleteOptionOne(id);
    }

    //删除一行规格选项
    $scope.deleteTableRow = function (index,id) {
        $scope.entity.specificationOptionList.splice(index,1);

        if (id!=null && id!="")
        {
            $scope.deleteOptionOne(id);
        }
    }

    //进行数据的修改
    $scope.save = function () {
        var method = "add";
        if ($scope.entity.specification.id!=null && $scope.entity.specification.id!="")
        {
            method = "update";
        }

        specificationService.save($scope.entity,method).success(
            function (flag) {
                if(flag)
                {
                    alert ("数据保存成功");
                    //保存成功刷新数据
                    $scope.reloadList();
                }
                else
                {
                    alert("数据保存失败");
                }
            }
        ).error(
            function (flag) {
                alert("数据保存失败");
            }
        );
    }

    //复选框点击事件
    $scope.selectedIds=[];
    $scope.updateSelection = function ($event, id) {
        if ($event.target.checked) {//如果是被选中,则增加到数
            $scope.selectedIds.push(id);
        } else {
            var idx = $scope.selectedIds.indexOf(id);
            $scope.selectedIds.splice(idx, 1);//删除
        }
    }

    //删除
    $scope.dele=function(){
        specificationService.dele($scope.selectedIds).success(
            function(data){
                $scope.selectedIds=[];
                $scope.reloadList();
            }
        );
    }
});