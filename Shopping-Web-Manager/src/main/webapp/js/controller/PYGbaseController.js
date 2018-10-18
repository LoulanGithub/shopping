
app.controller("PYGbaseController",function ($scope,$controller,service) {
    $controller("baseController",{$scope:$scope});

    // 分页配置
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 0,
        itemsPerPage: 5,
        perPageOptions: [5, 10, 20, 30, 40, 50],
        onChange: function () {
            $scope.reloadList();//重新加载
        }
    };

    //分页查询数据
    $scope.reloadList = function () {
        //切换页码
        $scope.findPage($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage,$scope.searchEntity);
    }

    //ajax查询分页数据
    $scope.findPage = function (pageNum, pageSize,searchContent) {
        service.findPage(pageNum,pageSize,searchContent).success(
            function (response) {
                $scope.list = response.rows;
                $scope.paginationConf.totalItems = response.total;//更新总记录数
            }
        ).error(
            function () {
                alert("数据读取失败");
            }
        );
    }
});