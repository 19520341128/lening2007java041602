package com.lening.service;

import com.lening.entity.TraineeBean;
import com.lening.utils.Page;

import java.util.List;

/**
 * 创建时间: 2021-04-12 上午 09:46
 * 撩妹贼溜: 肖彬
 */

public interface TraineeService {
    Page<TraineeBean> findAll(TraineeBean traineeBean, Integer pageNum, Integer pageSize);

    TraineeBean TestRedis(Integer a);
}
