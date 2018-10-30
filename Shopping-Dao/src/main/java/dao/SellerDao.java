package dao;

import pojo.seller.TbSeller;

/*********************************************************
 ** Package: dao<br>
 ** Description： TODO <br>
 ** Date: Created in 2018/10/30 17:35<br>
 ** Copyright: Copyright (c) 2018<br>
 *********************************************************/
public interface SellerDao
{
	/**
	 * @Description -进行注册数据的添加保存
	 * @Date        -2018/10/30  17:41
	 * @para        -
	 * */
	int add(TbSeller tbSeller);
}
