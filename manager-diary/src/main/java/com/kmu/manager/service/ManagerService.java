package com.kmu.manager.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kmu.manager.entity.Manager;
import com.kmu.manager.util.ResultEntity;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2020-08-17
 */
public interface ManagerService extends IService<Manager> {

    Page<Manager> selectManagers(String account, Integer pageNum, Integer pageSize);

    ResultEntity insert(Manager manager);

    Manager findManagerById(String id);

    boolean deleteByIds(List<String> strings);
}
