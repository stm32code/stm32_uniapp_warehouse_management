package com.bs.glr.service.impl;

import com.bs.glr.bean.BsGoodsSort;
import com.bs.glr.bean.BsGoodsSortExample;
import com.bs.glr.mapper.BsGoodsSortMapper;
import com.bs.glr.service.GoodsSortService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @作者 9999
 * @时间 9999-02-27 22:07
 * @描述 ${var}
 */
@Service
public class GoodsSortServiceImpl implements GoodsSortService {
    @Resource
    BsGoodsSortMapper goodsSortMapper;

    @Override
    public Integer insertGoodsSort(String sortName) {
        BsGoodsSort bsGoodsSort = new BsGoodsSort();
        bsGoodsSort.setSortName(sortName);
        return goodsSortMapper.insertSelective(bsGoodsSort);
    }

    @Override
    public Integer delGoodsSort(Integer sid) {
        return goodsSortMapper.deleteByPrimaryKey(sid);
    }

    @Override
    public Integer updateGoodsSortById(Integer sid, String sortName) {
        BsGoodsSort bsGoodsSort = new BsGoodsSort();
        bsGoodsSort.setId(sid);
        bsGoodsSort.setSortName(sortName);
        return goodsSortMapper.updateByPrimaryKeySelective(bsGoodsSort);
    }

    @Override
    public PageInfo<BsGoodsSort> selectGoodsSortByPage(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        BsGoodsSortExample ex = new BsGoodsSortExample();
        ex.setOrderByClause("id desc");

        List<BsGoodsSort> bsGoodsSorts = goodsSortMapper.selectByExample(ex);
        PageInfo<BsGoodsSort> bsGoodsSortPageInfo = new PageInfo<>(bsGoodsSorts);
        return bsGoodsSortPageInfo;
    }

    @Override
    public List<BsGoodsSort> getSortOption() {
        return goodsSortMapper.selectByExample(null);
    }

    @Override
    public BsGoodsSort selectGoodsSortById(Integer sortId) {
        return goodsSortMapper.selectByPrimaryKey(sortId);
    }
}
