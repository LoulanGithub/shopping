package projectInterface;

import entity.PageResult;
import entity.Result;
import pojo.TbBrand;
import pojo.specification.TbSpecification;
import pojo.specificationOption.TbSpecificationOption;
import vo.SpecificationVo;

import java.util.List;

/*********************************************************
 ** @Description: TODO
 ** @Date: Created in 2018/10/17  14:14
 ** @author: 杨
 *********************************************************/
public interface SpecificationService
{
	/**
	 * @Description -分页获取规格数据
	 * @Date        -2018/10/17  14:15
	 * @para        -
	 * */
	public PageResult findPage (int pageNum, int pageSize,TbSpecification tbSpecification);

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
	 * @Description -对规格和规格选项进行数据更新
	 * @Date        -2018/10/17  17:27
	 * @para        -
	 * */
	int update(TbSpecification tbSpecification, List<TbSpecificationOption> tbSpecificationOptionList);

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
	int add(SpecificationVo specificationVo);

	/**
	 * @Description -删除指定规格的id数据
	 * @Date        -2018/10/18  11:05
	 * @para        -
	 * */
	int delete(Long[] ids);
}
