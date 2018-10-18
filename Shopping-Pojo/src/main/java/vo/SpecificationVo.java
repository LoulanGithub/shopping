package vo;

import pojo.specification.TbSpecification;
import pojo.specificationOption.TbSpecificationOption;

import java.io.Serializable;
import java.util.List;

/*********************************************************
 ** @Description: TODO
 ** @Date: Created in 2018/10/17  18:09
 ** @author: 杨
 *********************************************************/
public class SpecificationVo implements Serializable
{
	private TbSpecification specification;
	private List<TbSpecificationOption> specificationOptionList;

	private static final long serialVersionUID = 1L;

	public TbSpecification getSpecification()
	{
		return specification;
	}

	public void setSpecification(TbSpecification specification)
	{
		this.specification = specification;
	}

	public List<TbSpecificationOption> getSpecificationOptionList()
	{
		return specificationOptionList;
	}

	public void setSpecificationOptionList(List<TbSpecificationOption> specificationOptionList)
	{
		this.specificationOptionList = specificationOptionList;
	}
}
