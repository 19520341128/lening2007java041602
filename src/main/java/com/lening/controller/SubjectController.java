package com.lening.controller;

import com.lening.entity.SubjectBean;
import com.lening.entity.TraineeBean;
import com.lening.service.SubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 创建时间: 2021-04-12 下午 04:29
 * 撩妹贼溜: 肖彬
 */

@RequestMapping("/subject")
@Controller
public class SubjectController {

    @Resource
    private SubjectService subjectService;

    @RequestMapping("/getSubjectList")
    @ResponseBody
    public List<SubjectBean> getSubjectList(){
        return subjectService.getSubjectList();
    }

    @RequestMapping("/getToTrainee")
    @ResponseBody
    public List<TraineeBean> getToTrainee(Integer subjectId){
        return subjectService.getToTrainee(subjectId);
    }

    @RequestMapping("/addTime")
    @ResponseBody
    public String addTime(Integer time, String subjectName,String datestr){
        String str = subjectService.addTime(time,subjectName,datestr);
        return str;
    }
}
