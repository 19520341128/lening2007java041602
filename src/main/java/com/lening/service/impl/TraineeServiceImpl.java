package com.lening.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lening.entity.CoachBean;
import com.lening.entity.TraineeBean;
import com.lening.entity.TraineeBeanExample;
import com.lening.mapper.CoachMapper;
import com.lening.mapper.TraineeMapper;
import com.lening.redis.RedisUtil;
import com.lening.service.TraineeService;
import com.lening.utils.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 创建时间: 2021-04-12 上午 09:46
 * 撩妹贼溜: 肖彬
 */

@Service
public class TraineeServiceImpl implements TraineeService {

    @Resource
    private TraineeMapper traineeMapper;
    @Resource
    private CoachMapper coachMapper;
    @Resource
    private RedisUtil redisUtil;


    @Override
    public Page<TraineeBean> findAll(TraineeBean traineeBean, Integer pageNum, Integer pageSize) {
        //开启分页
        PageHelper.startPage(pageNum, pageSize);

        //条件查询
        TraineeBeanExample traineeBeanExample = new TraineeBeanExample();
        TraineeBeanExample.Criteria criteria = traineeBeanExample.createCriteria();
        if (traineeBean!=null){
            if (traineeBean.gettName()!=null && traineeBean.gettName().length()>=1){
                criteria.andTNameLike("%"+traineeBean.gettName()+"%");
            }
        }

        //对查出的数据进行处理
        List<TraineeBean> list = traineeMapper.selectByExample(traineeBeanExample);
        for (TraineeBean bean : list) {
            if (bean.getCoachId()!=null){
                /*CoachBeanExample example = new CoachBeanExample();
                CoachBeanExample.Criteria criteria1 = example.createCriteria();
                criteria1.andCIdEqualTo(bean.getCoachId());
                List<CoachBean> beanList = coachMapper.selectByExample(example);
                bean.setCoachBeanList(beanList);*/
                CoachBean coachBean = coachMapper.selectByPrimaryKey(bean.getCoachId());
                //CoachBean coachBean = coachMapper.selectByCoachId(bean.getCoachId());
                bean.setCoachBean(coachBean);
            }
            String s = traineeMapper.selectSubjectByTid(bean.gettId());
            bean.setSubjectName(s);
        }

        //分页
        PageInfo<TraineeBean> pageInfo = new PageInfo<>(list);
        Long total = pageInfo.getTotal();
        Page<TraineeBean> page = new Page<>(pageInfo.getPageNum() + "", total.intValue(), pageInfo.getPageSize() + "");
        page.setList(pageInfo.getList());
        return page;
    }

    @Override
    public TraineeBean TestRedis(Integer tid) {

        if (tid>0){
            TraineeBean traineeBean = null;
            //从缓存中获取
            Object object = (TraineeBean) redisUtil.getObject("a");

            //判断缓存中是否存在
            if (object != null){ //不空，则强转返回
                System.out.println("redis中存在，直接返回");
                traineeBean = (TraineeBean) object;
            }else {
                System.out.println("redis缓存中不存在，从数据库中取出，并且放入缓存");
                //查询数据库，取出
                traineeBean = traineeMapper.selectByPrimaryKey(1);
                //放入缓存中
                redisUtil.putObject("a", traineeBean);

                /**
                 * 一般在执行增删改之后都要删除缓存中的数据
                 * redisUtil.removeObject("");
                 */
            }

            return traineeBean;
        }

        return null;
    }
}
