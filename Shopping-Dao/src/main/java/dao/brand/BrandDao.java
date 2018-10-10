package dao.brand;

import entity.PageResult;
import pojo.TbBrand;

/*********************************************************
 ** @Description: TODO
 ** @Date: Created in 2018/10/11  0:01
 ** @author: 杨
 *********************************************************/
public interface BrandDao
{
	/**
	 * @Description -保存获取分页信息
	 * @Date        -2018/9/28  23:05
	 * @para        -pageNum：当前页码
	 * 				 pageSize:总页数
	 * */
	public PageResult findPage(Integer pageNum, Integer pageSize);

	/**
	 * @Description -添加一个brand对象
	 * @Date        -2018/10/10  23:57
	 * @para        -tbBrand:对象参数
	 * */
	public int addBrand (TbBrand tbBrand);
}
