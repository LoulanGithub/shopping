package service;

import com.alibaba.dubbo.config.annotation.Service;

import dao.TypeTemplateDao;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import pojo.typeTemplate.TbTypeTemplate;
import projectInterface.TypeTemplateService;

/*********************************************************
 ** Package: 模板管理的service层
 ** Description： TODO <br>
 ** Date: Created in 2018/10/18 17:30<br>
 ** Copyright: Copyright (c) 2018<br>
 *********************************************************/
@Service
public class TypeTemplateServiceImpl implements TypeTemplateService
{
	@Autowired
	private TypeTemplateDao typeTemplateDao;
	/**
	 * @Description -模板管理的条件分页查询
	 * @Date        -2018/10/18  17:45
	 * @para        -
	 * */
	public PageResult findPage(int pageNum, int pageSize, TbTypeTemplate tbTypeTemplate)
	{
		PageResult page = typeTemplateDao.findPage(pageNum,pageSize,tbTypeTemplate);
		return page;
	}
}
