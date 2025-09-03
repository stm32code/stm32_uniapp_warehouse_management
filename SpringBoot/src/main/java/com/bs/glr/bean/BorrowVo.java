package com.bs.glr.bean;

import lombok.Data;

/**
 * @作者 9999
 * @时间 9999-03-12 21:45
 * @描述 ${var}
 */
@Data
public class BorrowVo  extends BsGoodsInfo {
    Integer id;
    String endTime;
    String status;
    String getTime;
    String returnTime;
    String userNameCh;
    String userName;
    String overdue;
}
