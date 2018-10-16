
//定义服务层
app.service("brandService",function ($http) {
    //分页查询指定信息
    this.findPage = function (pageNum, pageSize,searchContent)
    {
        return $http.post('../brand/getBrandMessage.action?pageNum=' + pageNum + '&pageSize=' + pageSize, searchContent);
    }

    //新增数据保存
    this.save = function (id,saveContent) {
        var method = "add";
        if (id != null && id != "") {
            method = "update";
        }
         return $http.post("../brand/" + method + ".action", saveContent);
    }

    //根据id进行数据输出
    this.findById = function (id) {
        return $http.get("../brand/findById.action?id=" + id);
    }

    //删除指定id的数据
    this.dele = function (ids) {
        return $http.get("../brand/delete.action?ids=" + ids);
    }
});