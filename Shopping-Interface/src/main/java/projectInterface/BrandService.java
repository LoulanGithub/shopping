package projectInterface;

import entity.PageResult;
import pojo.TbBrand;

/*********************************************************
 ** @Description: 品牌的service接口
 ** @Date: Created in 2018/9/28  23:03
 ** @author: 杨
 *********************************************************/
public interface BrandService
{
	/**
	 * @Description -保存获取分页信息
	 * @Date        -2018/9/28  23:05
	 * @para        -pageNum：当前页码
	 * 				 pageSize:总页数
	 * */
	public PageResult findPage(Integer pageNum, Integer pageSize,TbBrand tbBrand);

	/**
	 * @Description -保存一个品牌对象
	 * @Date        -2018/10/11  0:07
	 * @para        -
	 * */
	public int addBrand (TbBrand tbBrand);

	/**
	 * @Description -保存一个品牌对象
	 * @Date        -2018/10/11  0:07
	 * @para        -
	 * */
	public int updateBrand (TbBrand tbBrand);

	/**
	 * @Description -更具id找品牌对象
	 * @Date        -2018/10/11  22:46
	 * @para        -
	 * */
	public TbBrand findById (String id);

	/**
	 * @Description -删除品牌对象
	 * @Date        -2018/10/13  1:27
	 * @para        -
	 * */
	public int deleteBrand(Long[] ids);
}
