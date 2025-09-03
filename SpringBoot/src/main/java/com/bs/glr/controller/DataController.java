package com.bs.glr.controller;

import com.bs.glr.bean.BsDataCk;
import com.bs.glr.bean.ResultBean;
import com.bs.glr.mapper.BsDataCkMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @作者 GLQ
 * @时间 2023-07-16 17:21
 * @描述
 */
@RestController
public class DataController {
    @Resource
    BsDataCkMapper dataCkMapper;
    @RequestMapping("/stm/setStmData")
    public ResultBean stmData (String wd,String sd,String yw){
        System.out.println(wd+","+sd);
        BsDataCk dataCk = new BsDataCk();
        dataCk.setId(1);
        dataCk.setWd(wd);
        dataCk.setSd(sd);
        dataCk.setYw(yw);
        dataCkMapper.updateByPrimaryKeySelective(dataCk);
        return ResultBean.returnOk();
    }

    @RequestMapping("/user/getData")
    public ResultBean getData (){
        BsDataCk bsDataCk = dataCkMapper.selectByPrimaryKey(1);
        return ResultBean.returnOk().pushData("data",bsDataCk);
    }


}
