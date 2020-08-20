package com.kmu.manager.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kmu.manager.entity.Manager;
import com.kmu.manager.mapper.ManagerMapper;
import com.kmu.manager.service.ManagerService;
import com.kmu.manager.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2020-08-17
 */
@Service
public class ManagerServiceImpl extends ServiceImpl<ManagerMapper, Manager> implements ManagerService {

    @Autowired
    ManagerMapper managerMapper;

    @Override
    public Page<Manager> selectManagers(String account, Integer pageNum, Integer pageSize) {
        try {
            QueryWrapper<Manager> qw = new QueryWrapper<>();
            if (account != null && !"".equals(account)){
                //模糊查询
                qw.like("m_account","%"+account+"%");
            }
            //分页设置
            Page<Manager> page = new Page<>();
            page.setSize(pageSize);
            page.setCurrent(pageNum);
            Page<Manager> page1 = managerMapper.selectPage(page, qw);
            return page1;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public ResultEntity insert(Manager manager) {
        QueryWrapper<Manager> qw = new QueryWrapper<>();
//        new BCryptPas
        //判断帐号是否已存在
        qw.eq("m_account",manager.getAccount());
        List<Manager> managers = managerMapper.selectList(qw);
        if(managers.size() > 0 && manager != null){
//            return ResultEntity.failedWithData("该账号已注册!请重试",false);
            return ResultEntity.failed();
        }
        //保存
        int insert = managerMapper.insert(manager);
        if(insert>0){
            return ResultEntity.success();
        }else {
            return ResultEntity.failed();
        }
    }

    @Override
    public Manager findManagerById(String id) {
        Manager manager = managerMapper.selectById(id);
        return manager;
    }

    @Override
    public boolean deleteByIds(List<String> strings) {
        int i = managerMapper.deleteBatchIds(strings);
        return i>0;
    }
}
