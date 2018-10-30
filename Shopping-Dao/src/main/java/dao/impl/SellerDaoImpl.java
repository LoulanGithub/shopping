package dao.impl;

import dao.SellerDao;
import mapper.TbSellerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pojo.seller.TbSeller;

/*********************************************************
 ** Package: dao.impl<br>
 ** Description： seller的Dao层处理类
 ** Date: Created in 2018/10/30 17:35<br>
 ** Copyright: Copyright (c) 2018<br>
 *********************************************************/
@Component
public class SellerDaoImpl implements SellerDao
{

	@Autowired
	private TbSellerMapper tbSellerMapper;

	/**
	 * @Description -进行注册数据的添加保存
	 * @Date        -2018/10/30  17:40
	 * @para        -
	 * */
	@Override
	public int add(TbSeller tbSeller)
	{
		int yn = tbSellerMapper.insertSelective(tbSeller);
		return yn;
	}
}
