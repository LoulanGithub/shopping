
//定义服务层
app.service("specificationService",function ($http) {
    //分页查询指定信息
    this.findPage = function (pageNum, pageSize,searchContent)
    {
        return $http.post('../specification/getSpecificationMessage.action?pageNum=' + pageNum + '&pageSize=' + pageSize, searchContent);
    }

    //根据id查找指定的数据
    this.findOne = function(id)
    {
        return $http.post('../specification/findById.action?id='+id);
    }

    //数据对象的保存
    this.save = function (entity,method) {
        return $http.post("../specification/"+method+".action",entity);
    }

    //删除指定id的规格选项
    this.deleteOptionOne = function (id) {
        $http.post("../specification/deleteOptionOne.action?id="+id);
    }

    //删除指定id的规格数据
    this.dele = function (ids) {
        return $http.post("../specification/delete.action?ids="+ids);
    }
});