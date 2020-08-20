package com.kmu.manager.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kmu.manager.entity.Manager;
import com.kmu.manager.service.ManagerService;
import com.kmu.manager.util.ResultEntity;
import com.kmu.manager.util.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
public class ManagerController {

    @Autowired
    ManagerService managerService;

    //通过ids批量删除
    @ResponseBody
    @PostMapping("/delAll.do")
    public ResultEntity delAll(String ids){
        String[] split = ids.split(",");
        //将字符串数组转为字符串集合
        List<String> strings = Arrays.asList(split);
        boolean b=managerService.deleteByIds(strings);
        if (b) {
            return ResultEntity.success();
        }else
            return ResultEntity.failed();
    }

    //通过id删除
    @PostMapping("/delByManagerId.do")
    @ResponseBody
    public ResultEntity delByManagerId(String id){
        boolean b = managerService.removeById(id);
        if (b) {
            return  ResultEntity.success();
        }else{
            return ResultEntity.failed();
        }
    }

    //通过id修改
    @PostMapping("/updateManager.do")
    @ResponseBody
    public ResultEntity updateManager(Manager manager){
        boolean b = managerService.updateById(manager);
        if (b) {
            return  ResultEntity.success();
        }else{
            return  ResultEntity.failed();
        }
    }

    //通过id查询
    @ResponseBody
    @GetMapping("/findByManagerId.do")
    public ResultEntity findByManagerId(String id){
         Manager manager=managerService.findManagerById(id);
        return  ResultEntity.successWithData(manager);
    }

    //增加管理员
    @ResponseBody
    @PostMapping("/insertManager.do")
    public ResultEntity insertManager(Manager manager){
        //添加日期
        Date date = new Date();
        manager.setCreateDate(date);

        ResultEntity insert = managerService.insert(manager);
        if (insert.getCode()== ResultEntity.CODE_SUCCESS) {
            return ResultEntity.success();
        }else{
            return ResultEntity.failed();
        }
    }

    @Value("${disk.picPrefix}")
    String picPrefix;
    //上传头像
    @PostMapping("/submitPic.do")
    @ResponseBody
    public ResultEntity  submitPic(MultipartFile file, HttpSession session) throws IOException {
        String randomString = UploadUtil.randomString();
        String picName=randomString+file.getOriginalFilename();
//        file.transferTo(new File("E:\\uploadFile\\"+picName));
        file.transferTo(new File(picPrefix+picName));
        return ResultEntity.successWithData(picName);
    }


    //模糊+分页查询
    @RequestMapping("/manager.html")
    public String managerAccount(@RequestParam(defaultValue = "",required = false) String account
            , @RequestParam(defaultValue = "1",required = false) Integer pageNum
            , @RequestParam(defaultValue = "5",required = false) Integer pageSize, Model model){

        Page<Manager> lpages= managerService.selectManagers(account,pageNum,pageSize);
        ResultEntity result = ResultEntity.successWithData(lpages);
//        System.out.println(lpages.getRecords());
//        System.out.println(lpages.getCurrent());
        model.addAttribute("result",result);
        return "manager";
    }

    //便于页面查看，假的
    @RequestMapping("/{path}.html")
    public String page(@PathVariable("path") String path){
        return path;
    }
}
