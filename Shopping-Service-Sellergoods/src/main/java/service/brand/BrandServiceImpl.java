package service.brand;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dao.brand.BrandDao;
import entity.PageResult;
import mapper.TbBrandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import pojo.TbBrand;
import pojo.TbBrandExample;
import projectInterface.BrandService;

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
	 * @Date        -2018/9/28  23:05
	 * @para        -pageNum：当前页码
	 * 				 pageSize:总页数
	 * */
	public PageResult findPage(Integer pageNum, Integer pageSize)
	{
		return brandDao.findPage(pageNum, pageSize);
	}
}
