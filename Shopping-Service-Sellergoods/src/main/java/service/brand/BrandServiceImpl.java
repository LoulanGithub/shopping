package service.brand;

import com.alibaba.dubbo.config.annotation.Service;
import dao.brand.BrandDao;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import pojo.TbBrand;
import projectInterface.BrandService;

/*********************************************************
 ** @Description: TODO
 ** @Date: Created in 2018/9/28  23:53
 ** @author: 杨
 *********************************************************/

//@org.springframework.stereotype.Service  //test测试的时候使用的
@Service
public class BrandServiceImpl implements BrandService
{
	@Autowired
	private BrandDao brandDao;

	/**
	 * @Description -保存获取分页信息
	 * @Date -2018/9/28  23:05
	 * @para -pageNum：当前页码
	 * pageSize:总页数
	 */
	public PageResult findPage(Integer pageNum, Integer pageSize)
	{
		return brandDao.findPage(pageNum, pageSize);
	}

	/**
	 * @Description -保存一个品牌对象
	 * @Date        -2018/10/11  0:07
	 * @para        -
	 * */
	public int addBrand(TbBrand tbBrand)
	{
		return brandDao.addBrand(tbBrand);
	}
}
