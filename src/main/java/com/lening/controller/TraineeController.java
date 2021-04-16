package com.lening.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.lening.entity.TraineeBean;
import com.lening.service.TraineeService;
import com.lening.utils.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 创建时间: 2021-04-12 上午 09:45
 * 撩妹贼溜: 肖彬
 */

@RequestMapping("/trainee")
@Controller
public class TraineeController {

    @Resource
    private TraineeService traineeService;

    @RequestMapping("/findAll")
    @ResponseBody
    public Page<TraineeBean> findAll(@RequestBody TraineeBean traineeBean, @RequestParam(defaultValue = "1")Integer pageNum, @RequestParam(defaultValue = "3")Integer pageSize){
        /**
         * 实体转化为json字符串后出现了$ref字样的东西，这是因为在传输的数据中出现相同的对象时，fastjson默认开启引用检测将相同的对象写成引用的形式
         * 全局配置关闭
         * JSON.DEFAULT_GENERATE_FEATURE |= SerializerFeature.DisableCircularReferenceDetect.getMask();
         * 单个关闭
         * JSON.toJSONString(page, SerializerFeature.DisableCircularReferenceDetect);
         */
        Page<TraineeBean> page = traineeService.findAll(traineeBean, pageNum, pageSize);
        //全局配置关闭
        JSON.DEFAULT_GENERATE_FEATURE |= SerializerFeature.DisableCircularReferenceDetect.getMask();
        return page;
    }

    @RequestMapping("/redis")
    @ResponseBody
    public TraineeBean TestRedis(Integer tid){
        System.out.println(tid);
        TraineeBean traineeBean = traineeService.TestRedis(tid);
        return traineeBean;
    }
}
