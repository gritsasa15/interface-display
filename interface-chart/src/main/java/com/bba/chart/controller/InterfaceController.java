package com.bba.chart.controller;

import com.bba.chart.entity.InterfaceRela;
import com.bba.chart.service.InterfaceRelaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/interface")
public class InterfaceController {

    @Autowired
    private InterfaceRelaService interfaceRelaService;


    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public List<InterfaceRela> getAll() {
        return interfaceRelaService.getAll();
    }

    @RequestMapping(value = "/queryByApp", method = RequestMethod.POST)
    public List<InterfaceRela> queryByApp(@RequestParam String app) {
        return interfaceRelaService.queryByApp(app);
    }

    @RequestMapping(value = "/queryBySrcApp", method = RequestMethod.POST)
    public List<InterfaceRela> queryBySrcApp(@RequestParam String app) {
        return interfaceRelaService.queryBySrcApp(app);
    }

    @RequestMapping(value = "/queryByDesApp", method = RequestMethod.POST)
    public List<InterfaceRela> queryByDesApp(@RequestParam String app) {
        return interfaceRelaService.queryByDesApp(app);
    }


}
