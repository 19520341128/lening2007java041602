package com.lening.service;

import com.lening.entity.SubjectBean;
import com.lening.entity.TraineeBean;

import java.util.List;

/**
 * 创建时间: 2021-04-12 下午 04:30
 * 撩妹贼溜: 肖彬
 */

public interface SubjectService {
    List<SubjectBean> getSubjectList();

    List<TraineeBean> getToTrainee(Integer subjectId);

    String addTime(Integer time, String subjectName, String datestr);
}
