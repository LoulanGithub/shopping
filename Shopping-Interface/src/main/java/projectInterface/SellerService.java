package projectInterface;

import entity.Result;
import pojo.seller.TbSeller;

/*********************************************************
 ** Package: projectInterface<br>
 ** Description： TODO <br>
 ** Date: Created in 2018/10/30 17:31<br>
 ** Copyright: Copyright (c) 2018<br>
 *********************************************************/
public interface SellerService
{
	/**
	 * @Description -进行数据的注册保存添加
	 * @Date        -2018/10/30  17:34
	 * @para        -
	 * */
	Result add(TbSeller tbSeller);
}
