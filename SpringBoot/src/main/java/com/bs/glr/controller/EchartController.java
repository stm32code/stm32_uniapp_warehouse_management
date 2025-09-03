package com.bs.glr.controller;

import com.bs.glr.bean.BsUser;
import com.bs.glr.bean.EchartBean;
import com.bs.glr.bean.ResultBean;
import com.bs.glr.service.GoodsInfoService;
import com.bs.glr.service.EchartService;
import com.bs.glr.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @作者 9999
 * @时间 9999-05-01 23:47
 * @描述 ${var}
 */
@RestController
@RequestMapping("/auth/echart")
public class EchartController {

    @Resource
    EchartService echartService;

    @Resource
    UserService userService;

    @Resource
    GoodsInfoService goodsInfoService;

    /**
     * @Author 9999
     * @desc //获取用户类型饼状图
     * @Date  9999/5/2
     **/
    @RequestMapping("getUserInfoChart")
    public ResultBean getUserInfoChart (){
        //获取不活跃读者数量
        List<BsUser> inactiveList = userService.getInactiveUser();
        //获取一般读者数量
        List<BsUser> commonlyList = userService.getCommonlyUser();
        //获取活跃读者数量
        List<BsUser> activeList = userService.getActiveUser();
        List<EchartBean> list = new ArrayList<>();
        list.add(new EchartBean("不活跃",inactiveList.size()));
        list.add(new EchartBean("一般",commonlyList.size()));
        list.add(new EchartBean("活跃",activeList.size()));

        return ResultBean.returnOk().pushData("data",list);
    }
    /**
     * @Author 9999
     * @desc //获取借阅物品类型占比
     * @Date  9999/5/2
     **/
    @RequestMapping("getGoodsTypeInfoChart")
    public ResultBean getGoodsTypeInfoChart (){
        List<EchartBean> echartBeans = goodsInfoService.getGoodsTypeInfoChart();
        return ResultBean.returnOk().pushData("data",echartBeans);
    }


    /**
     * @Author wkm
     * @desc //获取借阅物品类型占比
     * @Date  9999/5/8
     **/
    @RequestMapping("getGoodsTypeInfoChartByUid")
    public ResultBean getGoodsTypeInfoChartByUid (Integer uid){
        List<EchartBean> echartBeans = goodsInfoService.getGoodsTypeInfoChartByUid(uid);
        return ResultBean.returnOk().pushData("data",echartBeans);
    }


    /**
     * @Author 9999
     * @desc //setBootCountChart
     * @Date  9999/5/2
     **/
    @RequestMapping("getBootCountChart")
    public ResultBean getBootCountChart (){
        List<EchartBean> echartBeans = goodsInfoService.getBootCountChart();
        List<String> xData = new ArrayList<>();
        List<Integer> yData = new ArrayList<>();

        for (EchartBean echartBean : echartBeans) {
            xData.add(echartBean.getName());
            yData.add(echartBean.getValue());
        }

        return ResultBean.returnOk().pushData("xData",xData).pushData("yData",yData);
    }



}
