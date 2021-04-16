package com.lening.mapper;

import com.lening.entity.CoachBean;
import com.lening.entity.CoachBeanExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CoachMapper {
    long countByExample(CoachBeanExample example);

    int deleteByExample(CoachBeanExample example);

    int deleteByPrimaryKey(Integer cId);

    int insert(CoachBean record);

    int insertSelective(CoachBean record);

    List<CoachBean> selectByExample(CoachBeanExample example);

    CoachBean selectByPrimaryKey(Integer cId);

    int updateByExampleSelective(@Param("record") CoachBean record, @Param("example") CoachBeanExample example);

    int updateByExample(@Param("record") CoachBean record, @Param("example") CoachBeanExample example);

    int updateByPrimaryKeySelective(CoachBean record);

    int updateByPrimaryKey(CoachBean record);

    CoachBean selectByCoachId(Integer coachId);
}