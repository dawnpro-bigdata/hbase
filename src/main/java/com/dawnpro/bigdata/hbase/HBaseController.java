package com.dawnpro.bigdata.hbase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HBaseController {
    @Autowired
    RecordRepository recordRepository;

    @RequestMapping("/evmraw")
    public List<Record> getRaw(@RequestParam(value="vin") String vin, @RequestParam(value="date") String date) {
        return recordRepository.findByKey(vin, date);
    }
}
