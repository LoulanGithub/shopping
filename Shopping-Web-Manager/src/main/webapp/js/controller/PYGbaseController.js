
app.controller("PYGbaseController",function ($scope,$controller) {
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
});