package com.bs.glr.controller;

import com.bs.glr.bean.BsGoodsAddress;
import com.bs.glr.bean.OptionVO;
import com.bs.glr.bean.ResultBean;
import com.bs.glr.service.GoodsAddressService;
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
@RequestMapping("/auth/goods/address")
public class GoodsAddressController {

    @Resource
    GoodsAddressService goodsAddressService;

    //添加物品物理区域
    @RequestMapping("addGoodsAddress")
    public ResultBean addGoodsAddress (String addressName){
        if(StringUtils.isEmpty(addressName)){
            return ResultBean.returnError("请将信息输入完整");
        }

        Integer line = goodsAddressService.insertGoodsAddress(addressName);
        if(line>0){
            return ResultBean.returnOk();
        }
        return ResultBean.returnError();

    }

    //删除物品物理区域
    @RequestMapping("delGoodsAddressById")
    public ResultBean delGoodsAddressById (Integer aid){

        Integer line = goodsAddressService.delGoodsAddress(aid);
        if(line>0){
            return ResultBean.returnOk();
        }
        return ResultBean.returnError();

    }

    //更新物品物理区域
    @RequestMapping("updateGoodsAddressById")
    public ResultBean updateGoodsAddressById (Integer sid,String addressName){

        Integer line = goodsAddressService.updateGoodsAddressById(sid,addressName);
        if(line>0){
            return ResultBean.returnOk();
        }
        return ResultBean.returnError();

    }

    //查询物品物理区域
    @RequestMapping("selectGoodsAddressByPage")
    public ResultBean selectGoodsAddressByPage (Integer page,Integer limit){


        if(page == null ){
            page = 1;
        }
        if(limit == null){
            limit =10;
        }

        PageInfo<BsGoodsAddress> pageInfo = goodsAddressService.selectGoodsAddressByPage(page,limit);

        long total = pageInfo.getTotal();
        List<BsGoodsAddress> list = pageInfo.getList();
        return ResultBean.returnOk().pushData("total", total).pushData("list",list);
    }

    //获取地址信息 用于下拉框
    @RequestMapping("getAddressOption")
    public ResultBean getAddressOption (){
        List<BsGoodsAddress> bsGoodsAddressses = goodsAddressService.getAddressOption();
        List<OptionVO> list = new ArrayList<>();
        for (BsGoodsAddress goodsAddress : bsGoodsAddressses) {
            OptionVO optionVO = new OptionVO();
            optionVO.setLabel(goodsAddress.getAddressName());
            optionVO.setValue(goodsAddress.getId().toString());
            list.add(optionVO);
        }
        return ResultBean.returnOk().pushData("data",list);
    }
}
