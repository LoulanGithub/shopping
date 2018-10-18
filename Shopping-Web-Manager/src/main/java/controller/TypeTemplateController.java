package controller;

import com.alibaba.dubbo.config.annotation.Reference;
import entity.PageResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.typeTemplate.TbTypeTemplate;
import projectInterface.TypeTemplateService;

/*********************************************************
 ** Package: 模板管理的controller层
 ** Description： TODO <br>
 ** Date: Created in 2018/10/18 17:28<br>
 ** Copyright: Copyright (c) 2018<br>
 *********************************************************/
@Controller
@RequestMapping("/typeTemplate")
public class TypeTemplateController
{
	@Reference
	private TypeTemplateService typeTemplateService;

	/**
	 * @Description -仅做测试使用
	 * @Date        -2018/10/18  18:19
	 * @para        -
	 * */
	@RequestMapping("/test")
	@ResponseBody
	public String test ()
	{
		return "test.Success";
	}

	/**
	 * @Description -获取模板管理的条件分页数据
	 * @Date        -2018/10/18  17:40
	 * @para        -
	 * */
	@RequestMapping("/getTypeTemplateMessage")
	@ResponseBody
	public PageResult getTypeTemplateMessage (int pageNum,int pageSize,@RequestBody TbTypeTemplate tbTypeTemplate)
	{
		PageResult page = typeTemplateService.findPage (pageNum,pageSize,tbTypeTemplate);
		return page;
	}
}
