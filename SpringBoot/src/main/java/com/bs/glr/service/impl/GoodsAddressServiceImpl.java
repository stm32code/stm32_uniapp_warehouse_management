package com.bs.glr.service.impl;

import com.bs.glr.bean.BsGoodsAddress;
import com.bs.glr.bean.BsGoodsAddressExample;
import com.bs.glr.mapper.BsGoodsAddressMapper;
import com.bs.glr.service.GoodsAddressService;
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
public class GoodsAddressServiceImpl implements GoodsAddressService {
    @Resource
    BsGoodsAddressMapper goodsAddressMapper;

    @Override
    public Integer insertGoodsAddress(String sortName) {
        BsGoodsAddress bsGoodsAddress = new BsGoodsAddress();
        bsGoodsAddress.setAddressName(sortName);
        return goodsAddressMapper.insertSelective(bsGoodsAddress);
    }

    @Override
    public Integer delGoodsAddress(Integer sid) {
        return goodsAddressMapper.deleteByPrimaryKey(sid);
    }

    @Override
    public Integer updateGoodsAddressById(Integer sid, String sortName) {
        BsGoodsAddress bsGoodsAddress = new BsGoodsAddress();
        bsGoodsAddress.setId(sid);
        bsGoodsAddress.setAddressName(sortName);
        return goodsAddressMapper.updateByPrimaryKeySelective(bsGoodsAddress);
    }

    @Override
    public PageInfo<BsGoodsAddress> selectGoodsAddressByPage(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        BsGoodsAddressExample bsGoodsAddressExample = new BsGoodsAddressExample();
        bsGoodsAddressExample.setOrderByClause("id desc");
        List<BsGoodsAddress> bsGoodsSorts = goodsAddressMapper.selectByExample(bsGoodsAddressExample);
        PageInfo<BsGoodsAddress> bsGoodsSortPageInfo = new PageInfo<>(bsGoodsSorts);
        return bsGoodsSortPageInfo;
    }

    @Override
    public List<BsGoodsAddress> getAddressOption() {
        return goodsAddressMapper.selectByExample(null);
    }

    @Override
    public BsGoodsAddress selectGoodsAddressById(Integer addressId) {
        return goodsAddressMapper.selectByPrimaryKey(addressId);
    }
}
