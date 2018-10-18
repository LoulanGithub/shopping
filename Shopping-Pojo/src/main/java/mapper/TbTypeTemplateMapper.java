package mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import pojo.typeTemplate.TbTypeTemplate;
import pojo.typeTemplate.TbTypeTemplateExample;

import java.util.List;

public interface TbTypeTemplateMapper
{
    long countByExample(TbTypeTemplateExample example);

    int deleteByExample(TbTypeTemplateExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbTypeTemplate record);

    int insertSelective(TbTypeTemplate record);

    List<TbTypeTemplate> selectByExampleWithRowbounds(TbTypeTemplateExample example, RowBounds rowBounds);

    List<TbTypeTemplate> selectByExample(TbTypeTemplateExample example);

    TbTypeTemplate selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbTypeTemplate record,
			@Param("example") TbTypeTemplateExample example);

    int updateByExample(@Param("record") TbTypeTemplate record, @Param("example") TbTypeTemplateExample example);

    int updateByPrimaryKeySelective(TbTypeTemplate record);

    int updateByPrimaryKey(TbTypeTemplate record);
}