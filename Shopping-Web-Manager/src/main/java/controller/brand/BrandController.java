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
	public PageResult getBrandMessage(int pageNum,int pageSize,@RequestBody TbBrand tbBrand)
	{
		PageResult page = brandService.findPage(pageNum, pageSize,tbBrand);
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

	/**
	 * @Description -更新一个brand对象
	 * @Date        -2018/10/11  0:17
	 * @para        -
	 * */
	@ResponseBody
	@RequestMapping("/update")
	public Result updateBrand(@RequestBody TbBrand tbBrand)
	{
		try
		{
			int brandFlag = brandService.updateBrand(tbBrand);
			if(brandFlag <= 0)
			{
				return new Result(false, "数据更新失败");
			}
			else
			{
				return new Result(true, "数据更新成功");
			}
		} catch (Exception ex)
		{
			return new Result(false, "数据更新失败");
		}
	}

	/**
	 * @Description -根据id查找品牌对象
	 * @Date        -2018/10/11  0:17
	 * @para        -
	 * */
	@ResponseBody
	@RequestMapping("/findById")
	public TbBrand findById (String id)
	{
		TbBrand byId = brandService.findById(id);
		return byId;
	}

	/**
	 * @Description -品牌数据删除
	 * @Date        -2018/10/13  0:49
	 * @para        -
	 * */
	@ResponseBody
	@RequestMapping("/delete")
	public String delete (Long[] ids)
	{
		try
		{
			int deleteFlag = brandService.deleteBrand(ids);
			if (deleteFlag <= 0)
			{
				return "数据删除失败";
			}
		} catch (Exception ex)
		{
			return "数据删除失败";
		}
		return "数据删除成功";
	}
}
