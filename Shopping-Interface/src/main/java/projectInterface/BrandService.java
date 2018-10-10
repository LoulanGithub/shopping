package projectInterface;

import entity.PageResult;

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
	public PageResult findPage(Integer pageNum, Integer pageSize);
}
