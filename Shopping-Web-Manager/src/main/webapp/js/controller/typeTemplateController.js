
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
        console.info($scope.entity)
        typeTemplateService.findPage(1,1,"{id:'"+id+"'}").success(
            function (response) {
                $scope.entity= response.rows[0];
                var d1=  JSON.parse($scope.entity.brandIds);//转换品牌列表
                var d2=  JSON.parse($scope.entity.specIds);//转换规格列表
                $('#test1').select2({
                    allowClear: true,                  //有占位符时允许清除
                    tags: true,
                    data: d1,
                    multiple:true,

                });
                $('#test1').select2('val',"");
                $('#test2').select2({
                    allowClear: true,                  //有占位符时允许清除
                    tags: true,
                    data: d2,
                    multiple:true,

                });
                $('#test2').select2('val',"");

                $scope.entity.customAttributeItems= JSON.parse($scope.entity.customAttributeItems);//转换扩展属性

            }
        );
    }

});