package com.whu.pro.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.whu.pro.mapper.param.CaseQueryParam;
import com.whu.pro.mapper.result.CaseQueryResult;
import com.whu.pro.service.CaseQueryService;

@Controller
@RequestMapping("CaseQueryController")
public class CaseQueryController {
    @Resource
    private CaseQueryService casequeryService;

    @ResponseBody
    @RequestMapping(value = "getAllCase", method = { RequestMethod.GET, RequestMethod.POST })
    public Object getAllCase(String beginTime, String endTime, String pro, String city, String dis) {
        if (beginTime.equals("")) {
            beginTime = "0000-00-00";
        }
        if (endTime.equals("")) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
            endTime = df.format(new Date());
        }

        CaseQueryParam cqp = new CaseQueryParam();
        cqp.setBeginTime(beginTime);
        cqp.setEndTime(endTime);
        cqp.setPro(pro);
        cqp.setCity(city);
        cqp.setDis(dis);
        ArrayList<CaseQueryResult> list = casequeryService.getAllCase(cqp);
        System.out.println("----------------" + list.size());
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "getBurnCase", method = { RequestMethod.GET, RequestMethod.POST })
    public Object getBurnCase(String beginTime, String endTime, String pro, String city, String dis) {
        if (beginTime.equals("")) {
            beginTime = "0000-00-00";
        }
        if (endTime.equals("")) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
            endTime = df.format(new Date());
        }

        CaseQueryParam cqp = new CaseQueryParam();
        cqp.setBeginTime(beginTime);
        cqp.setEndTime(endTime);
        cqp.setPro(pro);
        cqp.setCity(city);
        cqp.setDis(dis);
        ArrayList<CaseQueryResult> list = casequeryService.getBurnCase(cqp);
        System.out.println("----------------" + list.size());
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "getBomCase", method = { RequestMethod.GET, RequestMethod.POST })
    public Object getBomCase(String beginTime, String endTime, String pro, String city, String dis) {
        if (beginTime.equals("")) {
            beginTime = "0000-00-00";
        }
        if (endTime.equals("")) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
            endTime = df.format(new Date());
        }

        CaseQueryParam cqp = new CaseQueryParam();
        cqp.setBeginTime(beginTime);
        cqp.setEndTime(endTime);
        cqp.setPro(pro);
        cqp.setCity(city);
        cqp.setDis(dis);
        ArrayList<CaseQueryResult> list = casequeryService.getBomCase(cqp);
        System.out.println("----------------" + list.size());
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "getGrabCase", method = { RequestMethod.GET, RequestMethod.POST })
    public Object getGrabCase(String beginTime, String endTime, String pro, String city, String dis) {
        if (beginTime.equals("")) {
            beginTime = "0000-00-00";
        }
        if (endTime.equals("")) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
            endTime = df.format(new Date());
        }

        CaseQueryParam cqp = new CaseQueryParam();
        cqp.setBeginTime(beginTime);
        cqp.setEndTime(endTime);
        cqp.setPro(pro);
        cqp.setCity(city);
        cqp.setDis(dis);
        ArrayList<CaseQueryResult> list = casequeryService.getGrabCase(cqp);
        System.out.println("----------------" + list.size());
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "getKillCase", method = { RequestMethod.GET, RequestMethod.POST })
    public Object getKillCase(String beginTime, String endTime, String pro, String city, String dis) {
        if (beginTime.equals("")) {
            beginTime = "0000-00-00";
        }
        if (endTime.equals("")) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
            endTime = df.format(new Date());
        }

        CaseQueryParam cqp = new CaseQueryParam();
        cqp.setBeginTime(beginTime);
        cqp.setEndTime(endTime);
        cqp.setPro(pro);
        cqp.setCity(city);
        cqp.setDis(dis);
        ArrayList<CaseQueryResult> list = casequeryService.getKillCase(cqp);
        System.out.println("----------------" + list.size());
        return list;
    }

}
