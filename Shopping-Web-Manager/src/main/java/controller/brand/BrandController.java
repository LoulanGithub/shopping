package controller.brand;

import com.alibaba.dubbo.config.annotation.Reference;
import entity.PageResult;
import entity.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.TbBrand;
import projectInterface.BrandService;

/*********************************************************
 ** @Description: TODO
 ** @Date: Created in 2018/9/30  18:26
 ** @author: 杨
 *********************************************************/
@Controller
@RequestMapping("/brand")
public class BrandController
{
	@Reference
	private BrandService brandService;

	/**
	 * @Description -用来测试功能是否可以正常使用
	 * @Date        -2018/9/30  18:33
	 * @para        -
	 * */
	@RequestMapping("/test")
	@ResponseBody
	public String test ()
	{
		return "test.Success";
	}

	/**
	 * @Description -获取手机品牌信息
	 * @Date        -2018/10/8  23:55
	 * @para        -
	 * */
	@RequestMapping("/getBrandMessage")
	@ResponseBody
	public PageResult getBrandMessage(int pageNum,int pageSize)
	{
		PageResult page = brandService.findPage(pageNum, pageSize);
		return page;
	}

	/**
	 * @Description -登录之后的页面
	 * @Date        -2018/10/8  23:55
	 * @para        -
	 * */
	@RequestMapping("/login")
	public String login ()
	{
		return "/admin/brand.html";
	}

	/**
	 * @Description -保存一个brand对象
	 * @Date        -2018/10/11  0:17
	 * @para        -
	 * */
	@ResponseBody
	@RequestMapping("/add")
	public Result addBrand(@RequestBody TbBrand tbBrand)
	{
		try
		{
			int brandFlag = brandService.addBrand(tbBrand);
			if(brandFlag <= 0)
			{
				return new Result(false, "数据保存失败");
			}
			else
			{
				return new Result(true, "数据保存成功");
			}
		} catch (Exception ex)
		{
			return new Result(false, "数据保存失败");
		}
	}
}
