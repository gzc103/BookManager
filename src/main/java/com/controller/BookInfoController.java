package com.controller;


import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Info;
import com.bean.Page;
import com.service.InfoService;

@RestController
@RequestMapping("/info")
public class BookInfoController {

    @Resource
    private InfoService isrv;

    //修改图书
    @ApiOperation("修改图书")  //给接口加注释
    @PostMapping("/update")
    //@ApiParam给参数加注释
    public String updateInfo(Info info) {
//		info.setLastUpdatetime(new Date());
        int re = isrv.update(info);
        if (re > 0) {
            return "OK";
        } else {
            return "NO";
        }
    }

    //新增图书
    @ApiOperation("新增图书")
    @PostMapping("/add")
    public String addInfo(Info info) {
        info.setUblishDate(new Date());
        int re = isrv.insert(info);
        if (re > 0) {
            return "OK";
        } else {
            return "NO";
        }
    }

    //按id删除
    @ApiOperation("按id删除图书")
    @GetMapping(value = "/delete")
    public String deleteById(@ApiParam("图书id") int id) {
        int re = isrv.delete(id);
        if (re > 0) {
            return "OK";
        } else {
            return "NO";
        }
    }

    //按id查询
    @ApiOperation("按id查询图书")
    @GetMapping(value = "/findById")
    public Map<String, Object> findById(@ApiParam("图书id") int id) {
        Map<String, Object> info = isrv.selectByPrimaryKey(id);
        if(info==null)
            return null;
        info.put("borrowed", ((Integer) info.get("borrowed") == 1 ? "已借阅" : "未借阅"));
        return info;
    }

    @ApiOperation("访问则返回hello")
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    //分页查询
    @ApiOperation("分页查询所有图书")
    @GetMapping("/selectAll")
    public String findAll(@ApiParam("当前页") Integer pageIndex) {
        Page page = new Page();
        page.setPageIndex(pageIndex);
        page.setPageSize(3);
        page.setPagePre((pageIndex - 1) * page.getPageSize());
        page.setTotalCount(isrv.findCount());
        //查询数据
        List<Map<String, Object>> infos = isrv.selectAll(page);
        //修改借阅
        for (Map<String, Object> info : infos) {
            info.put("borrowed", ((Integer) info.get("borrowed") == 1 ? "已借阅" : "未借阅"));
        }
        page.setList(infos);
        return JSON.toJSONStringWithDateFormat(page, "yyyy-MM-dd");
    }

    //按名称查询
    @ApiOperation("按名称查询图书")
    @GetMapping(value = "/findByName")
    public String findByName(@ApiParam("图书名称") @Param("name") String name) {
        List<Map<String, Object>> list = isrv.findByName(name);
        //修改借阅
        for (Map<String, Object> info : list) {
            info.put("borroweb", ((Integer) info.get("borroweb") == 1 ? "已借阅" : "未借阅"));
        }
        //return JSON.toJSONString(list);
        return JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd");
    }
}
