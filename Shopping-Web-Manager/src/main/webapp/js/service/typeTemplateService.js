
app.service("typeTemplateService",function ($http) {

    //分页查询数据
    this.findPage = function (pageNum, pageSize,searchContent)
    {
        return $http.post('../typeTemplate/getTypeTemplateMessage.action?pageNum=' + pageNum + '&pageSize=' + pageSize, searchContent);
    }
});