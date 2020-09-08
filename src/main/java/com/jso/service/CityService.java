package com.jso.service;


import com.github.pagehelper.PageInfo;
import com.jso.entity.City;

import java.util.List;

/**
 * 服务接口
 *
 * @author jso
 * @since 2020-08-31 11:05:55
 * @description 由 Mybatisplus Code Generator 自动生成的代码
 */
public interface CityService {

    PageInfo<City> selectPageBySearch(Integer pageIndex, Integer pageSize, City searchCity);

    List<City> selectPro();

    City selectOne(Integer pid);

    Integer deleteOne(Integer pid);

    Integer saveOrUpdate(City cityEntity);

    Integer deleteList(List<Integer> delArray);
}
