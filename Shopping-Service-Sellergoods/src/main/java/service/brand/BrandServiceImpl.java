package service.brand;

import com.alibaba.dubbo.config.annotation.Service;
import dao.brand.BrandDao;
import entity.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import pojo.TbBrand;
import projectInterface.BrandService;

import java.util.ArrayList;
import java.util.List;

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
	public PageResult findPage(Integer pageNum, Integer pageSize,TbBrand tbBrand)
	{
		return brandDao.findPage(pageNum, pageSize,tbBrand);
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

	/**
	 * @Description -更新一个品牌对象
	 * @Date        -2018/10/11  23:55
	 * @para        -
	 * */
	public int updateBrand(TbBrand tbBrand)
	{
		return brandDao.updateBrand(tbBrand);
	}

	/**
	 * @Description -更具id找品牌对象
	 * @Date        -2018/10/11  22:48
	 * @para        -
	 * */
	public TbBrand findById(String id)
	{
		return brandDao.findById(Long.parseLong(id));
	}

	/**
	 * @Description -删除品牌对象
	 * @Date        -2018/10/13  1:27
	 * @para        -
	 * */
	public int deleteBrand(Long[] ids)
	{
		List<Long> longs = new ArrayList<>();
		for (Long id : ids)
		{
			longs.add(id);
		}

		return brandDao.deleteBrand(longs);
	}
}
