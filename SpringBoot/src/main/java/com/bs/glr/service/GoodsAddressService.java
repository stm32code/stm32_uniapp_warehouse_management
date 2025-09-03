package com.bs.glr.service;

import com.bs.glr.bean.BsGoodsAddress;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @作者 9999
 * @时间 9999-02-27 22:06
 * @描述 ${var}
 */
public interface GoodsAddressService {
    Integer insertGoodsAddress(String addressName);

    Integer delGoodsAddress(Integer aid);

    Integer updateGoodsAddressById(Integer sid, String addressName);

    PageInfo<BsGoodsAddress> selectGoodsAddressByPage(Integer page, Integer limit);

    List<BsGoodsAddress> getAddressOption();

    BsGoodsAddress selectGoodsAddressById(Integer addressId);
}
