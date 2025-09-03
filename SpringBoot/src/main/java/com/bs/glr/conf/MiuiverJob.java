package com.bs.glr.conf;

import com.bs.glr.MsgUtils;
import com.bs.glr.bean.*;
import com.bs.glr.mapper.BsScoreMapper;
import com.bs.glr.mapper.BsVerdueRecordMapper;
import com.bs.glr.service.BorrowService;
import com.bs.glr.service.UserService;
import com.github.pagehelper.PageInfo;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @作者 9999
 * @时间 9999-06-18 14:16
 * @描述 ${var}
 */
@Slf4j
@Component
public class MiuiverJob extends QuartzJobBean {


    @Resource
    UserService userService;
    @Resource
    BorrowService borrowService;
    @Resource
    BsVerdueRecordMapper verdueRecordMapper;
    @Resource
    BsScoreMapper scoreMapper;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {



    }

    //逾期记录表中是否有记录
    public Boolean isE(List<BsVerdueRecord> bsVerdueRecords,Integer id){
        for (BsVerdueRecord bsVerdueRecord : bsVerdueRecords) {

            if(bsVerdueRecord.getBorrowId().equals(id)){
                return true;
            }
        }

        return false;
    }

}
