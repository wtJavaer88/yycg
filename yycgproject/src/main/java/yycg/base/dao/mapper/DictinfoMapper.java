package yycg.base.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import yycg.base.pojo.po.Dictinfo;
import yycg.base.pojo.po.DictinfoExample;

public interface DictinfoMapper {
    int countByExample(DictinfoExample example);

    int deleteByExample(DictinfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(Dictinfo record);

    int insertSelective(Dictinfo record);

    List<Dictinfo> selectByExample(DictinfoExample example);

    Dictinfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Dictinfo record, @Param("example") DictinfoExample example);

    int updateByExample(@Param("record") Dictinfo record, @Param("example") DictinfoExample example);

    int updateByPrimaryKeySelective(Dictinfo record);

    int updateByPrimaryKey(Dictinfo record);
}