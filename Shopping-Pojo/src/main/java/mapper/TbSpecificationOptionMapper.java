package mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pojo.specificationOption.TbSpecificationOption;
import pojo.specificationOption.TbSpecificationOptionExample;

import java.util.List;

public interface TbSpecificationOptionMapper
{
    long countByExample(TbSpecificationOptionExample example);

    int deleteByExample(TbSpecificationOptionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbSpecificationOption record);

    int insertSelective(TbSpecificationOption record);

    List<TbSpecificationOption> selectByExampleWithRowbounds(TbSpecificationOptionExample example, RowBounds rowBounds);

    List<TbSpecificationOption> selectByExample(TbSpecificationOptionExample example);

    TbSpecificationOption selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbSpecificationOption record,
			@Param("example") TbSpecificationOptionExample example);

    int updateByExample(@Param("record") TbSpecificationOption record,
			@Param("example") TbSpecificationOptionExample example);

    int updateByPrimaryKeySelective(TbSpecificationOption record);

    int updateByPrimaryKey(TbSpecificationOption record);
}