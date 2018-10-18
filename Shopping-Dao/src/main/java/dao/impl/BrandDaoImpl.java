package dao.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dao.BrandDao;
import entity.PageResult;
import mapper.TbBrandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pojo.TbBrand;
import pojo.TbBrandExample;

import java.util.List;

/*********************************************************
 ** @Description: 和数据库进行交互
 ** @Date: Created in 2018/10/9  0:39
 ** @author: 杨
 *********************************************************/
@Component
public class BrandDaoImpl implements BrandDao
{
	@Autowired
	private TbBrandMapper brandMapper;
	/**
	 * @Description -保存获取分页信息
	 * @Date        -2018/9/28  23:05
	 * @para        -pageNum：当前页码
	 * 				 pageSize:总页数
	 * */
	public PageResult findPage(Integer pageNum, Integer pageSize,TbBrand tbBrand)
	{
		PageHelper.startPage(pageNum, pageSize);

		TbBrandExample brandExample = new TbBrandExample();
		TbBrandExample.Criteria criteria = brandExample.createCriteria();
		if (tbBrand != null)
		{
			criteria.andNameLike("%" + tbBrand.getName() + "%");
			criteria.andFirstCharLike("%"+tbBrand.getFirstChar()+"%");
		}

		List<TbBrand> tbBrandList = brandMapper.selectByExample(brandExample);

		PageInfo<TbBrand> brandPage = new PageInfo<TbBrand>(tbBrandList);

		PageResult page = new PageResult(brandPage.getTotal(), brandPage.getList());

		return page;
	}

	/**
	 * @Description -添加一个brand对象
	 * @Date        -2018/10/10  23:57
	 * @para        -tbBrand:对象参数
	 * */
	public int addBrand (TbBrand tbBrand)
	{
		return brandMapper.insertSelective(tbBrand);
	}

	/**
	 * @Description -更新一个品牌对象
	 * @Date        -2018/10/11  23:56
	 * @para        -
	 * */
	public int updateBrand(TbBrand tbBrand)
	{
		//updateByPrimaryKeySelective会对字段进行判断再更新(如果为Null就忽略更新)，如果你只想更新某一字段，可以用这个方法。
		return brandMapper.updateByPrimaryKeySelective(tbBrand);
	}

	/**
	 * @Description -更具id找品牌对象
	 * @Date        -2018/10/11  22:48
	 * @para        -
	 * */
	public TbBrand findById(Long id)
	{
		return brandMapper.selectByPrimaryKey(id);
	}

	/**
	 * @Description -品牌对象的删除
	 * @Date        -2018/10/13  1:24
	 * @para        -
	 * */
	public int deleteBrand (List<Long> ids)
	{

		TbBrandExample tbBrandExample = new TbBrandExample();
		TbBrandExample.Criteria criteria = tbBrandExample.createCriteria();

		criteria.andIdIn(ids);

		int deleteFlag = brandMapper.deleteByExample(tbBrandExample);

		return deleteFlag;
	}
}
