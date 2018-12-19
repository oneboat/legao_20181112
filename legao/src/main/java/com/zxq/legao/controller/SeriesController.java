package com.zxq.legao.controller;

import com.zxq.legao.entity.po.SeriesPO;
import com.zxq.legao.entity.vo.SeriesVO;
import com.zxq.legao.service.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
@Controller
public class SeriesController {
    @Autowired
    private SeriesService seriesService;

    // 跳转到seriesAdd
    @RequestMapping("/seriesAdd")
    public String jumpSeriesAdd(HttpServletRequest request) {
        request.setAttribute("type", request.getAttribute("type"));
        return "series/seriesAdd";
    }

    //查询课程
    @RequestMapping("/selectSeries")
    public String selectSeries(SeriesPO seriesPO, HttpServletRequest request, Integer page) {

        return seriesService.selectSeries(page, seriesPO, request);
    }

    // 添加课程
    @RequestMapping("/insertSeries")
    public String insertSeries(SeriesPO series, HttpServletRequest request) {
        if (seriesService.insertSeries(series) > 0) {
            request.setAttribute("type", "yes");
        } else {
            request.setAttribute("type", "no");
        }
        return "series/seriesAdd";
    }

    // 删除课程
    @RequestMapping("/deleteSeriess")
    public String deleteSeriess(Integer[] caption, HttpServletRequest request) {

        seriesService.deleteSeries(Arrays.asList(caption));

        return "forward:/selectSeries";


    }

    // 根据id查找课程
    @RequestMapping("/editSeries")
    public String editSeries(@RequestParam("seriesId") Integer seriesId, HttpServletRequest request) {
        SeriesVO seriesVO = seriesService.selectSeriesByID(seriesId);
        request.setAttribute("seriesByID", seriesVO);
        return "forward:/editSeriesFrom";

    }

    // 根据给编辑页赋值
    @RequestMapping("/editSeriesFrom")
    public String editSeriesFrom(HttpServletRequest request) {
        SeriesVO seriesVO = (SeriesVO) request.getAttribute("seriesByID");
        request.setAttribute("seriesEdit", seriesVO);
        return "series/seriesEdit";

    }

    // 保存编辑值
    @RequestMapping("/saveSeries")
    public String saveSeries(SeriesPO series) {
        seriesService.updateSeries(series);
        return "redirect:/selectSeries";

    }
}
