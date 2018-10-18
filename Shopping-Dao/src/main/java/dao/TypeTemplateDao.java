package dao;

import entity.PageResult;
import pojo.typeTemplate.TbTypeTemplate; /*********************************************************
 ** Package: 模板管理的Dao层接口
 ** Description： TODO <br>
 ** Date: Created in 2018/10/18 17:34<br>
 ** Copyright: Copyright (c) 2018<br>
 *********************************************************/
public interface TypeTemplateDao
{
	/**
	 * @Description -模板管理的条件分页查询
	 * @Date        -2018/10/18  17:48
	 * @para        -
	 * */
	PageResult findPage(int pageNum, int pageSize, TbTypeTemplate tbTypeTemplate);
}
