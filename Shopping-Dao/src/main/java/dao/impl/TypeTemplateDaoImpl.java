package dao.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dao.TypeTemplateDao;
import entity.PageResult;
import mapper.TbTypeTemplateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pojo.typeTemplate.TbTypeTemplate;
import pojo.typeTemplate.TbTypeTemplateExample;

import java.util.List;

/*********************************************************
 ** Package: 模板管理的dao层实现
 ** Description： TODO <br>
 ** Date: Created in 2018/10/18 17:34<br>
 ** Copyright: Copyright (c) 2018<br>
 *********************************************************/
@Component
public class TypeTemplateDaoImpl implements TypeTemplateDao
{

	@Autowired
	private TbTypeTemplateMapper tbTypeTemplateMapper;

	/**
	 * @Description -模板管理的条件分页查询
	 * @Date        -2018/10/18  17:48
	 * @para        -
	 * */
	public PageResult findPage(int pageNum, int pageSize, TbTypeTemplate tbTypeTemplate)
	{
		//设置分页信息
		PageHelper.startPage(pageNum, pageSize);

		//创建条件对象
		TbTypeTemplateExample tbTypeTemplateExample = new TbTypeTemplateExample();

		TbTypeTemplateExample.Criteria criteria = tbTypeTemplateExample.createCriteria();

		//写入条件
		if (tbTypeTemplate.getName() != null)
		{
			criteria.andNameLike("%" + tbTypeTemplate.getName() + "%");
		}

		//数据查询
		List<TbTypeTemplate> tbTypeTemplateList = tbTypeTemplateMapper.selectByExample(tbTypeTemplateExample);

		//创建页信息对象
		PageInfo<TbTypeTemplate> pageInfo = new PageInfo<>(tbTypeTemplateList);

		return new PageResult(pageInfo.getTotal(),tbTypeTemplateList);
	}
}
