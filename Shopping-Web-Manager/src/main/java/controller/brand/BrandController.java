package controller.brand;

import com.alibaba.dubbo.config.annotation.Reference;
import entity.PageResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
}
