package com.bs.glr.controller;

import com.bs.glr.bean.BsGoodsSort;
import com.bs.glr.bean.OptionVO;
import com.bs.glr.bean.ResultBean;
import com.bs.glr.service.GoodsSortService;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @作者 9999
 * @时间 9999-02-27 22:05
 * @描述 ${var}
 */
@RestController
@RequestMapping("/auth/goods/sort/")
public class GoodsSortController {

    @Resource
    GoodsSortService goodsSortService;

    //添加物品分类
    @RequestMapping("addGoodsSort")
    public ResultBean addGoodsSort (String sortName){
        if(StringUtils.isEmpty(sortName)){
            return ResultBean.returnError("请将信息输入完整");
        }

        Integer line = goodsSortService.insertGoodsSort(sortName);
        if(line>0){
            return ResultBean.returnOk();
        }
        return ResultBean.returnError();

    }

    //删除物品分类
    @RequestMapping("delGoodsSortById")
    public ResultBean delGoodsSortById (Integer sid){

        Integer line = goodsSortService.delGoodsSort(sid);
        if(line>0){
            return ResultBean.returnOk();
        }
        return ResultBean.returnError();

    }

    //更新物品分类
    @RequestMapping("updateGoodsSortById")
    public ResultBean updateGoodsSortById (Integer sid,String sortName){

        Integer line = goodsSortService.updateGoodsSortById(sid,sortName);
        if(line>0){
            return ResultBean.returnOk();
        }
        return ResultBean.returnError();

    }

    //查询物品分类
    @RequestMapping("selectGoodsSortByPage")
    public ResultBean selectGoodsSortByPage (Integer page,Integer limit){


        if(page == null ){
            page = 1;
        }
        if(limit == null){
            limit =10;
        }

        PageInfo<BsGoodsSort> pageInfo = goodsSortService.selectGoodsSortByPage(page,limit);

        long total = pageInfo.getTotal();
        List<BsGoodsSort> list = pageInfo.getList();
        return ResultBean.returnOk().pushData("total", total).pushData("list",list);
    }

    //获取分类信息 用于下拉框
    @RequestMapping("getSortOption")
    public ResultBean getSortOption (){
        List<BsGoodsSort> bsGoodsSorts = goodsSortService.getSortOption();
        List<OptionVO> list = new ArrayList<>();
        for (BsGoodsSort bsGoodsSort : bsGoodsSorts) {
            OptionVO optionVO = new OptionVO();
            optionVO.setLabel(bsGoodsSort.getSortName());
            optionVO.setValue(bsGoodsSort.getId().toString());
            list.add(optionVO);
        }
        return ResultBean.returnOk().pushData("data",list);
    }

}
