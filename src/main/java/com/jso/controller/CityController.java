package com.jso.controller;

import com.github.pagehelper.PageInfo;
import com.jso.entity.City;
import com.jso.service.CityService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 服务控制器
 *
 * @author jso
 * @since 2020-08-31 11:05:55
 * @description 由 Mybatisplus Code Generator 自动生成的代码
 */
@RestController
@CrossOrigin    //代表可用跨域访问,一般用在Controller层上
@Api(value = "城市管理控制台",tags = "城市管理1.0") //Swagger Api入口
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityService cityService;

    /**
     * 分页综合查询
     * @param pageIndex 当前页
     * @param pageSize 分页大小
     * @param searchCity 综合查询条件
     * @return 分页综合查询结果
     */
    @ApiOperation(value = "分页综合查询",notes = "分页综合查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageIndex", value = "当前页" , required = true , dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "分页大小" , required = true , dataType = "int"),
            @ApiImplicitParam(name = "searchCity", value = "综合查询条件" , required = false , dataType = "City")
    })
    @PostMapping("/selectPageBySearch")
    public PageInfo<City> selectPageBySearch(
            @RequestParam("pageIndex") Integer pageIndex,
            @RequestParam("pageSize") Integer pageSize,
            @RequestBody(required = false) City searchCity){
        return cityService.selectPageBySearch(pageIndex,pageSize,searchCity);
    }

    /**
     * 查询一个
     * @param pid 城市编号
     * @return
     */
    @ApiOperation(value = "查询一个",notes = "查询一个")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pid", value = "城市编号" , required = true , dataType = "int"),
    })
    @GetMapping("/selectOne/{pid}")
    public City selectOne(@PathVariable("pid") Integer pid){
        return cityService.selectOne(pid);
    }

    /**
     * 查询所有省
     * @return 所有省
     */
    @ApiOperation(value = "查询所有省",notes = "查询所有省")
    @GetMapping("/selectPro")
    public List<City> selectPro(){
        return cityService.selectPro();
    }


    /**
     * 添加或更新
     * @param cityEntity 操作对象
     * @return 操作成功与否
     */
    @ApiOperation(value = "添加或更新",notes = "添加或更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cityEntity", value = "操作对象" , required = true , dataType = "City"),
    })
    @PostMapping("/saveOrUpdate")
    public Boolean saveOrUpdate(@RequestBody City cityEntity){
        if (cityService.saveOrUpdate(cityEntity)>0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 根据城市编号删除
     * @param pid 城市编号
     * @return 删除信息
     */
    @ApiOperation(value = "根据城市编号删除",notes = "根据城市编号删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pid", value = "城市编号" , required = true , dataType = "int" ,paramType = "path"),
    })
    @PostMapping("/deleteCity/{pid}")
    public Integer deleteCity(@PathVariable("pid") Integer pid){
        return cityService.deleteOne(pid);
    }

    /**
     * 批量删除
     * @param delArray 批量删除数组
     * @return
     */
    @ApiOperation(value = "批量删除",notes = "批量删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "delArray", value = "批量删除数组" , required = true ,allowMultiple = true, dataType = "int"),
    })
    @PostMapping("/deleteCityList")
    public Integer deleteCityList(@RequestBody List<Integer> delArray){
        return cityService.deleteList(delArray);
    }

}