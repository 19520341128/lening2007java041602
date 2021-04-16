package com.lening.service.impl;

import com.lening.entity.RecordBean;
import com.lening.entity.SubjectBean;
import com.lening.entity.TraineeBean;
import com.lening.mapper.RecordMapper;
import com.lening.mapper.SubjectMapper;
import com.lening.service.SubjectService;
import org.springframework.stereotype.Service;
import sun.util.calendar.LocalGregorianCalendar;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 创建时间: 2021-04-12 下午 04:30
 * 撩妹贼溜: 肖彬
 */

@Service
public class SubjectServiceImpl implements SubjectService {

    @Resource
    private SubjectMapper subjectMapper;
    @Resource
    private RecordMapper recordMapper;

    @Override
    public List<SubjectBean> getSubjectList() {
        return subjectMapper.selectByExample(null);
    }

    @Override
    public List<TraineeBean> getToTrainee(Integer subjectId) {
        List<TraineeBean> toTrainee = subjectMapper.getToTrainee(subjectId);
        return toTrainee;
    }

    @Override
    public String addTime(Integer time, String subjectName, String datestr) {

        //获取学车记录表的id
        List<Integer> recordIds = subjectMapper.getRecordId(subjectName);
        if (datestr==""){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            String format1 = format.format(date);
            datestr = format1;
        }
        //修改
        subjectMapper.updateRecord(datestr,time,recordIds.get(0));

        //做判断
        RecordBean recordBean = recordMapper.selectByPrimaryKey(recordIds.get(0));
        /**
         * 无论怎么样都进行修改一次
         * 如果表中还没有这条记录需要另写添加语句（中间表）没写！
         */
        if (recordBean.getrDuration()<=10 && recordBean.getrDuration()>0){
            //证明在学科目一
            subjectMapper.updateMiddle(1,recordIds.get(0));
            return "编辑成功";
        }else if (recordBean.getrDuration()<=20 && recordBean.getrDuration()>10){
            //证明在学科目二
            subjectMapper.updateMiddle(2,recordIds.get(0));
            return "编辑成功";
        }else if (recordBean.getrDuration()<=30 && recordBean.getrDuration()>20){
            //证明在学科目三
            subjectMapper.updateMiddle(3,recordIds.get(0));
            return "编辑成功";
        }else if (recordBean.getrDuration()>30){
            /**
             * 如果已经完成学习，需要删除数据
             *
             *
             *
             */
            return "您已出师";
        }else {
            return null;
        }
    }
}
