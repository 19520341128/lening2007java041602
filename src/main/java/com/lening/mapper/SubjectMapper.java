package com.lening.mapper;

import com.lening.entity.SubjectBean;
import com.lening.entity.SubjectBeanExample;
import com.lening.entity.TraineeBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SubjectMapper {
    long countByExample(SubjectBeanExample example);

    int deleteByExample(SubjectBeanExample example);

    int deleteByPrimaryKey(Integer sId);

    int insert(SubjectBean record);

    int insertSelective(SubjectBean record);

    List<SubjectBean> selectByExample(SubjectBeanExample example);

    SubjectBean selectByPrimaryKey(Integer sId);

    int updateByExampleSelective(@Param("record") SubjectBean record, @Param("example") SubjectBeanExample example);

    int updateByExample(@Param("record") SubjectBean record, @Param("example") SubjectBeanExample example);

    int updateByPrimaryKeySelective(SubjectBean record);

    int updateByPrimaryKey(SubjectBean record);


    List<TraineeBean> getToTrainee(@Param("subjectId") Integer subjectId);

    List<Integer> getRecordId(@Param("subjectName") String subjectName);

    void updateRecord(@Param("datestr") String datestr,@Param("time") Integer time,@Param("recordId") Integer recordId);

    void updateMiddle(@Param("a") Integer a,@Param("recordId") Integer recordId);
}