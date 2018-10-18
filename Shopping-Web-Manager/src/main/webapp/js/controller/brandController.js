
//品牌控制barndController
app.controller('brandController',function ($scope, $controller,$http,brandService) {

    //继承品优购基础控制器部分
    $controller("PYGbaseController",{$scope:$scope,service:brandService});

    $scope.searchEntity = {name:"",firstChar:""};


    //数据保存
    $scope.save = function () {
        brandService.save($scope.entity.id,$scope.entity).success(
            function (response) {
                if (response.flag) {
                    $scope.reloadList();
                }
                else {
                    alert(response.message);
                }
            }
        );
    }

    //根据id查找品牌对象
    $scope.findById = function (id) {
        brandService.findById(id).success(
            function (response) {
                $scope.entity = response;
            }
        ).error(
            function () {
                alert("数据读取失败");
            }
        );
    }

    $scope.selectedIds=[];
    //复选框点击事件
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
        brandService.dele($scope.selectedIds).success(
            function(data){
                alert(data);
                $scope.selectedIds=[];
                $scope.reloadList();
            }
        );
    }
});