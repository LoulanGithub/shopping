package dao.brand.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dao.brand.BrandDao;
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
	public PageResult findPage(Integer pageNum, Integer pageSize)
	{
		PageHelper.startPage(pageNum, pageSize);

		TbBrandExample brandExample = new TbBrandExample();
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
		return brandMapper.insert(tbBrand);
	}
}
