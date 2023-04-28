package com.uracle.sample.api.home;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HomeController {

    private Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/")
    public String home() throws Exception{
        throw new Exception("예외 발생");
    }

    @PostMapping("/")
    public String homePost() {
        return "Hello world Post";
    }

    @GetMapping("/map")
    public Map<String, String> map() {
        Map<String, String> hw = new HashMap<>();
        hw.put("Hello","World");
        return hw;
    }

    @GetMapping("/map/list")
    public List<Map<String, String>> mapList() {
        List<Map<String, String>> hwList = new ArrayList<>();

        Map<String, String> hw1 = new HashMap<>();
        hw1.put("key","Hello1");
        hw1.put("value","World1");
        Map<String, String> hw2 = new HashMap<>();
        hw2.put("key","Hello1");
        hw2.put("value","World1");

        hwList.add(hw1);
        hwList.add(hw2);

        return hwList;
    }

    @GetMapping("/vo")
    public HomeVo homeVo() {
        HomeVo homeVo = new HomeVo();
        homeVo.setKey("Hello");
        homeVo.setValue("World");
        logger.debug("VO 내용 : {}", homeVo);
        return homeVo;
    }

    @GetMapping("/vo/list")
    public List<HomeVo> homeVoList() {
        List<HomeVo> homeVoList = new ArrayList<>();

        HomeVo homeVo1 = new HomeVo();
        homeVo1.setKey("Hello1");
        homeVo1.setValue("World1");

        HomeVo homeVo2 = new HomeVo();
        homeVo2.setKey("Hello2");
        homeVo2.setValue("World2");

        homeVoList.add(homeVo1);
        homeVoList.add(homeVo2);

        for(HomeVo homeVo: homeVoList) {
            logger.debug(">>> homeVo : {}", homeVo);
        }

        return homeVoList;
    }
}
