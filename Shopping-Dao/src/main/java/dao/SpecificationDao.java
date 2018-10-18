package dao;

import entity.PageResult;
import pojo.specification.TbSpecification;
import pojo.specificationOption.TbSpecificationOption;

import java.util.List;

/*********************************************************
 ** @Description: TODO
 ** @Date: Created in 2018/10/17  14:30
 ** @author: 杨
 *********************************************************/
public interface SpecificationDao
{
	/**
	 * @Description -获取规格的分页数
	 * @Date        -2018/10/17  14:28
	 * @para        -
	 * */
	public PageResult findPage(int pageNum, int pageSize, TbSpecification tbSpecification);

	/**
	 * @Description -根据主键id查询规格对象
	 * @Date        -2018/10/17  15:44
	 * @para        -
	 * */
	TbSpecification findById(String id);

	/**
	 * @Description -根据外键id查询指定的规格选项
	 * @Date        -2018/10/17  15:44
	 * @para        -
	 * */
	List<TbSpecificationOption> findOptions(String id);

	/**
	 * @Description -规格数据更新
	 * @Date        -2018/10/17  22:14
	 * @para        -
	 * */
	int update(TbSpecification tbSpecification);

	/**
	 * @Description -对规格选项进行更新
	 * @Date        -2018/10/17  22:17
	 * @para        -
	 * */
	int updateOption(List<TbSpecificationOption> tbSpecificationOptionList,Long id);

	/**
	 * @Description -对指定id的规格选项进行删除
	 * @Date        -2018/10/17  23:11
	 * @para        -
	 * */
	void deleteOptionById(Long id);

	/**
	 * @Description -添加一个规格对象
	 * @Date        -2018/10/17  23:47
	 * @para        -
	 * */
	int add(TbSpecification specification);

	/**
	 * @Description -添加规格选项对象
	 * @Date        -2018/10/17  23:51
	 * @para        -
	 * */
	int addOption(List<TbSpecificationOption> specificationOptionList, Long id);

	/**
	 * @Description -删除指定id的规格数据
	 * @Date        -2018/10/18  11:00
	 * @para        -
	 * */
	public int delete (Long[] ids);
}
