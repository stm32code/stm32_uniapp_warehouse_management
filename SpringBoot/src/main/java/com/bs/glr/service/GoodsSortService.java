package com.bs.glr.service;

import com.bs.glr.bean.BsGoodsSort;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @作者 9999
 * @时间 9999-02-27 22:06
 * @描述 ${var}
 */
public interface GoodsSortService {
    Integer insertGoodsSort(String sortName);

    Integer delGoodsSort(Integer sid);

    Integer updateGoodsSortById(Integer sid, String sortName);

    PageInfo<BsGoodsSort> selectGoodsSortByPage(Integer page, Integer limit);

    List<BsGoodsSort> getSortOption();

    BsGoodsSort selectGoodsSortById(Integer sortId);
}
