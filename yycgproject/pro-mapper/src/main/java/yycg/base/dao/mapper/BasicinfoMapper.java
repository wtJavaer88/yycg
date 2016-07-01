package yycg.base.dao.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import yycg.base.pojo.po.Basicinfo;
import yycg.base.pojo.po.BasicinfoExample;

public interface BasicinfoMapper {
    int countByExample(BasicinfoExample example);

    int deleteByExample(BasicinfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(Basicinfo record);

    int insertSelective(Basicinfo record);

    List<Basicinfo> selectByExample(BasicinfoExample example);

    Basicinfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Basicinfo record, @Param("example") BasicinfoExample example);

    int updateByExample(@Param("record") Basicinfo record, @Param("example") BasicinfoExample example);

    int updateByPrimaryKeySelective(Basicinfo record);

    int updateByPrimaryKey(Basicinfo record);
}