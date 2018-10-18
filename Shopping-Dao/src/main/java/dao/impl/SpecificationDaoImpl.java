package dao.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dao.SpecificationDao;
import entity.PageResult;
import entity.Result;
import mapper.TbSpecificationMapper;
import mapper.TbSpecificationOptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pojo.specification.TbSpecification;
import pojo.specification.TbSpecificationExample;
import pojo.specificationOption.TbSpecificationOption;
import pojo.specificationOption.TbSpecificationOptionExample;

import java.util.List;
import java.util.Map;

/*********************************************************
 ** @Description: TODO
 ** @Date: Created in 2018/10/17  14:31
 ** @author: 杨
 *********************************************************/
@Component
public class SpecificationDaoImpl implements SpecificationDao
{
	@Autowired
	private TbSpecificationMapper tbSpecificationMapper;

	@Autowired
	private TbSpecificationOptionMapper tbSpecificationOptionMapper;

	/**
	 * @Description -获取规格的分页数
	 * @Date        -2018/10/17  14:28
	 * @para        -
	 * */
	public PageResult findPage(int pageNum, int pageSize, TbSpecification tbSpecification)
	{
		PageHelper.startPage(pageNum, pageSize);

		TbSpecificationExample tbSpecificationExample = new TbSpecificationExample();

		TbSpecificationExample.Criteria criteria = tbSpecificationExample.createCriteria();
		if (tbSpecification != null)
		{
			criteria.andSpecNameLike("%" + tbSpecification.getSpecName() + "%");
		}

		List<TbSpecification> tbSpecificationList = tbSpecificationMapper.selectByExample(tbSpecificationExample);

		PageInfo<TbSpecification> pageInfo = new PageInfo<TbSpecification>(tbSpecificationList);

		PageResult page = new PageResult(pageInfo.getTotal(), tbSpecificationList);

		return page;
	}

	/**
	 * @Description -根据主键id查询规格对象
	 * @Date        -2018/10/17  15:44
	 * @para        -
	 * */
	public TbSpecification findById(String id)
	{
		TbSpecification tbSpecification = tbSpecificationMapper.selectByPrimaryKey(Long.parseLong(id));
		return  tbSpecification;
	}

	/**
	 * @Description -根据外键id查询指定的规格选项
	 * @Date        -2018/10/17  15:44
	 * @para        -
	 * */
	public List<TbSpecificationOption> findOptions(String id)
	{
		TbSpecificationOptionExample tbSpecificationOptionExample = new TbSpecificationOptionExample();
		TbSpecificationOptionExample.Criteria criteria = tbSpecificationOptionExample.createCriteria();
		criteria.andSpecIdEqualTo(Long.parseLong(id));

		return tbSpecificationOptionMapper.selectByExample(tbSpecificationOptionExample);
	}

	/**
	 * @Description -规格数据更新
	 * @Date        -2018/10/17  22:14
	 * @para        -
	 * */
	public int update(TbSpecification tbSpecification)
	{
		int flag = tbSpecificationMapper.updateByPrimaryKeySelective(tbSpecification);
		return flag;
	}

	/**
	 * @Description -对规格选项进行更新
	 * @Date        -2018/10/17  22:17
	 * @para        -
	 * */
	public int updateOption(List<TbSpecificationOption> tbSpecificationOptionList,Long id)
	{
		for (TbSpecificationOption tbSpecificationOption : tbSpecificationOptionList)
		{
			//有id的进行更新，没有id的说明是刚添加的，进行插入数据
			if (tbSpecificationOption.getId() != null)
			{
				int flag = tbSpecificationOptionMapper.updateByPrimaryKeySelective(tbSpecificationOption);
				if (flag <= 0)
				{
					return 0;
				}
			}
			else
			{
				tbSpecificationOption.setSpecId(id);
				int flag = tbSpecificationOptionMapper.insertSelective(tbSpecificationOption);
				if (flag <= 0)
				{
					return 0;
				}
			}
		}
		return 1;
	}

	/**
	 * @Description -对指定id的规格选项进行删除
	 * @Date        -2018/10/17  23:11
	 * @para        -
	 * */
	public void deleteOptionById(Long id)
	{
		tbSpecificationOptionMapper.deleteByPrimaryKey(id);
	}

	/**
	 * @Description -添加一个规格对象
	 * @Date        -2018/10/17  23:47
	 * @para        -
	 * */
	public int add(TbSpecification specification)
	{
		List<Map<String, Object>> id = tbSpecificationMapper
				.sqlEquals("select MAX(id) as id from tb_specification");
		Long sid = (Long) id.get(0).get("id")+1;

		specification.setId(sid);
		int flag = tbSpecificationMapper.insertSelective(specification);

		if (flag > 0)
		{
			return (int)((long)(sid));
		}
		return 0;
	}

	/**
	 * @Description -添加规格选项对象
	 * @Date        -2018/10/17  23:51
	 * @para        -
	 * */
	public int addOption(List<TbSpecificationOption> specificationOptionList, Long id)
	{
		for (TbSpecificationOption tbSpecificationOption : specificationOptionList)
		{
			tbSpecificationOption.setSpecId(id);
			int flag = tbSpecificationOptionMapper.insertSelective(tbSpecificationOption);
			if (flag <= 0)
			{
				return 0;
			}
		}
		return 1;
	}

	/**
	 * @Description -删除指定id的规格数据
	 * @Date        -2018/10/18  11:00
	 * @para        -
	 * */
	public int delete (Long[] ids)
	{
		for (int i = 0; i < ids.length; i++)
		{
			try
			{
				tbSpecificationMapper.deleteByPrimaryKey(ids[i]);
			} catch (Exception ex)
			{
				return 0;
			}
		}

		return 1;
	}
}
