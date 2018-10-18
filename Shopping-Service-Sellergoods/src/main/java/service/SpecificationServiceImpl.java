package service;

import com.alibaba.dubbo.config.annotation.Service;
import dao.SpecificationDao;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pojo.specification.TbSpecification;
import pojo.specificationOption.TbSpecificationOption;
import projectInterface.SpecificationService;
import vo.SpecificationVo;

import java.util.List;

/*********************************************************
 ** @Description: TODO
 ** @Date: Created in 2018/10/17  14:27
 ** @author: 杨
 *********************************************************/
@Service
public class SpecificationServiceImpl implements SpecificationService
{
	@Autowired
	private SpecificationDao specificationDao;
	/**
	 * @Description -获取规格的分页数
	 * @Date        -2018/10/17  14:28
	 * @para        -
	 * */
	public PageResult findPage(int pageNum, int pageSize, TbSpecification tbSpecification)
	{
		PageResult page = specificationDao.findPage(pageNum, pageSize, tbSpecification);
		return page;
	}

	/**
	 * @Description -根据主键id查询规格对象
	 * @Date        -2018/10/17  15:44
	 * @para        -
	 * */
	public TbSpecification findById(String id)
	{
		return specificationDao.findById (id);
	}

	/**
	 * @Description -根据外键id查询指定的规格选项
	 * @Date        -2018/10/17  15:44
	 * @para        -
	 * */
	public List<TbSpecificationOption> findOptions(String id)
	{
		return specificationDao.findOptions(id);
	}

	/**
	 * @Description -对规格和规格选项进行数据更新
	 * @Date        -2018/10/17  17:27
	 * @para        -
	 * */
	@Transactional(propagation = Propagation.REQUIRED , readOnly = false)
	public int update(TbSpecification tbSpecification, List<TbSpecificationOption> tbSpecificationOptionList)
	{
		int flag = specificationDao.update(tbSpecification);
		int flagOption = specificationDao.updateOption(tbSpecificationOptionList,tbSpecification.getId());

		if (flag <= 0 || flagOption <= 0)
		{
			return 0;
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
		specificationDao.deleteOptionById (id);
	}

	/**
	 * @Description -添加一个规格对象
	 * @Date        -2018/10/17  23:47
	 * @para        -
	 * */
	@Transactional(propagation = Propagation.REQUIRED , readOnly = false)
	public int add(SpecificationVo specificationVo)
	{
		int id = specificationDao.add(specificationVo.getSpecification());
		int flagOption = specificationDao.addOption(specificationVo.getSpecificationOptionList(),(long)id);

		if (flagOption <= 0)
		{
			return 0;
		}

		return 1;
	}

	/**
	 * @Description -删除指定id的规格数据
	 * @Date        -2018/10/18  11:06
	 * @para        -
	 * */
	public int delete(Long[] ids)
	{
		int flag = specificationDao.delete(ids);
		return flag;
	}
}