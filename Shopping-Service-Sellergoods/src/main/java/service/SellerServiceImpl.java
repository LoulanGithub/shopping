package service;

import com.alibaba.dubbo.config.annotation.Service;
import dao.SellerDao;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import pojo.seller.TbSeller;
import projectInterface.SellerService;

/*********************************************************
 ** Package: service<br>
 ** Description： TODO <br>
 ** Date: Created in 2018/10/30 17:30<br>
 ** Copyright: Copyright (c) 2018<br>
 *********************************************************/
@Service
public class SellerServiceImpl implements SellerService
{

	@Autowired
	private SellerDao sellerDao;

	/**
	 * @Description -进行数据的注册保存添加
	 * @Date        -2018/10/30  17:34
	 * @para        -
	 * */
	@Override
	public Result add(TbSeller tbSeller)
	{
		Result result = new Result();
		try
		{
			int yn = sellerDao.add(tbSeller);
			if (yn > 0)
			{
				result.setFlag(true);
				result.setMessage("数据保存成功");

			}
			else
			{
				result.setFlag(false);
				result.setMessage("数据保存失败");
			}
		} catch (Exception ex)
		{
			result.setFlag(false);
			result.setMessage("数据保存失败");
		}
		return result;
	}
}
