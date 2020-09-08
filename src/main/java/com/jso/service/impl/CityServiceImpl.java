package com.jso.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jso.entity.City;
import com.jso.mapper.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.jso.service.CityService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 服务接口实现
 *
 * @author jso
 * @since 2020-08-31 11:05:55
 * @description 由 Mybatisplus Code Generator 自动生成的代码
 */
@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityMapper cityMapper;

    /**
     * 分页搜索查询
     * @param pageIndex 当前页
     * @param pageSize 分页大熊啊
     * @param searchCity 搜索条件
     * @return
     */
    @Override
    public PageInfo<City> selectPageBySearch(Integer pageIndex, Integer pageSize, City searchCity){
        QueryWrapper<City> cityQueryWrapper = new QueryWrapper<>();
        /*判断查询条件对象是否存在*/
        if (searchCity != null) {
            /*判断是否需要查询名字*/
            if (!searchCity.getPname().equals("")) {
                cityQueryWrapper.like("pname", "%" + searchCity.getPname() + "%");
            }
            /*判断是否需要查询省份*/
            if (searchCity.getFid() != 0){
                cityQueryWrapper.eq("fid",  searchCity.getFid());
            }
        }
        /*开启分页*/
        PageHelper.startPage(pageIndex,pageSize);
        /*根据条件查询*/
        List<City> list = cityMapper.selectList(cityQueryWrapper);
        /*返回分页数据*/
        return new PageInfo<>(list);
    }

    /**
     * 查询所有省份
     * @return
     */
    public List<City> selectPro(){
        QueryWrapper<City> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("fid",0);
        return cityMapper.selectList(queryWrapper);
    }

    /**
     * 查询一个
     * @return 城市
     */
    @Override
    public City selectOne(Integer pid) {
        return cityMapper.selectById(pid);
    }

    /**
     * 根据主键删除一个
     * @param pid 主键
     * @return 删除个数
     */
    @Override
    public Integer deleteOne(Integer pid) {
        return cityMapper.deleteById(pid);
    }

    /**
     * * 添加或更新
     * @param cityEntity 操作对象
     * @return 操作成功与否
     */
    @Override
    public Integer saveOrUpdate(City cityEntity) {
        if (cityEntity.getPid() == 0){
            return cityMapper.insert(cityEntity);
        }else{
            return cityMapper.updateById(cityEntity);
        }
    }

    @Override
    public Integer deleteList(List<Integer> delArray) {
        return cityMapper.deleteBatchIds(delArray);
    }
}