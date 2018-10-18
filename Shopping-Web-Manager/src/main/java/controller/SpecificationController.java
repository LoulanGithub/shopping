package controller;

import com.alibaba.dubbo.config.annotation.Reference;
import entity.PageResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pojo.specification.TbSpecification;
import pojo.specificationOption.TbSpecificationOption;
import projectInterface.SpecificationService;
import vo.SpecificationVo;

import java.util.List;

/*********************************************************
 ** @Description: 规格参数部分
 ** @Date: Created in 2018/10/17  13:58
 ** @author: 杨
 *********************************************************/
@Controller
@RequestMapping("/specification")
public class SpecificationController
{
	@Reference
	private SpecificationService specificationService;

	/**
	 * @Description -测试controller功能正常使用
	 * @Date        -2018/10/17  14:04
	 * @para        -
	 * */
	@RequestMapping("/test")
	@ResponseBody
	public String test ()
	{
		return "test.Success";
	}

	/**
	 * @Description -查询分页数据
	 * @Date        -2018/10/17  15:38
	 * @para        -
	 * */
	@RequestMapping("/getSpecificationMessage")
	@ResponseBody
	public PageResult getSpecificationMessage(int pageNum,int pageSize,@RequestBody TbSpecification tbSpecification)
	{
		PageResult page = specificationService.findPage(pageNum, pageSize,tbSpecification);
		return page;
	}

	/**
	 * @Description -根据id查询指定对象的数据
	 * @Date        -2018/10/17  15:40
	 * @para        -
	 * */
	@RequestMapping("/findById")
	@ResponseBody
	public SpecificationVo findById( String id)
	{
		TbSpecification tbSpecification = specificationService.findById(id);
		List<TbSpecificationOption> tbSpecificationOptionList = specificationService.findOptions(id);

		SpecificationVo specificationVo = new SpecificationVo();

		specificationVo.setSpecification(tbSpecification);
		specificationVo.setSpecificationOptionList(tbSpecificationOptionList);

		return specificationVo;
	}

	/**
	 * @Description -对规格和规格选项进行数据更新
	 * @Date        -2018/10/17  17:27
	 * @para        -
	 * */
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	@ResponseBody
	public String update (@RequestBody SpecificationVo specificationVo)
	{
		int flag = specificationService.update(specificationVo.getSpecification(), specificationVo.getSpecificationOptionList());

		if (flag <= 0)
		{
			return "false";
		}
		return "true";
	}

	/**
	 * @Description -添加一个规格对象
	 * @Date        -2018/10/17  23:47
	 * @para        -
	 * */
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	@ResponseBody
	public String add(@RequestBody SpecificationVo specificationVo)
	{
		int flag = specificationService.add(specificationVo);

		if (flag <= 0)
		{
			return "false";
		}
		return "true";
	}

	/**
	 * @Description -对指定id的规格选项进行删除
	 * @Date        -2018/10/17  23:09
	 * @para        -
	 * */
	@RequestMapping("/deleteOptionOne")
	public void deleteOptionOne (Long id)
	{
		specificationService.deleteOptionById (id);
	}

	/**
	 * @Description -对指定id的规格数据进行删除
	 * @Date        -2018/10/18  10:58
	 * @para        -
	 * */
	@RequestMapping("/delete")
	@ResponseBody
	public String delete (Long[] ids)
	{
		int flag = specificationService.delete(ids);
		if (flag >0)
		{
			return "true";
		}
		else
		{
			return "false";
		}
	}

}
