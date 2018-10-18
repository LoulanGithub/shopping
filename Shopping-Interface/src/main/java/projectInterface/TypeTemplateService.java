package projectInterface;

import entity.PageResult;
import pojo.typeTemplate.TbTypeTemplate; /*********************************************************
 ** Package: projectInterface<br>
 ** Description： TODO <br>
 ** Date: Created in 2018/10/18 17:29<br>
 ** Copyright: Copyright (c) 2018<br>
 *********************************************************/
public interface TypeTemplateService
{
	/**
	 * @Description -模板管理的条件分页查询
	 * @Date        -2018/10/18  17:45
	 * @para        -
	 * */
	PageResult findPage(int pageNum, int pageSize, TbTypeTemplate tbTypeTemplate);
}
