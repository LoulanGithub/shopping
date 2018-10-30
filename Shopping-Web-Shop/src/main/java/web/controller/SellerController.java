package web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.seller.TbSeller;
import projectInterface.SellerService;

/*********************************************************
 ** Package: web.controller<br>
 ** Description： TODO <br>
 ** Date: Created in 2018/10/30 16:44<br>
 ** Copyright: Copyright (c) 2018<br>
 *********************************************************/
@Controller
@RequestMapping("/seller")
public class SellerController
{
	@Reference
	private SellerService sellerService;


	/**
	 * @Description -进行数据的注册保存添加
	 * @Date        -2018/10/30  17:34
	 * @para        -
	 * */
	@RequestMapping("/add")
	@ResponseBody
	public Result add(@RequestBody TbSeller tbSeller)
	{
		Result result = sellerService.add (tbSeller);
		return result;
	}
}
