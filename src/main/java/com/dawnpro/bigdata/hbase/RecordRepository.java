package com.dawnpro.bigdata.hbase;

import java.util.List;


import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.hadoop.hbase.HbaseTemplate;
import org.springframework.data.hadoop.hbase.RowMapper;
import org.springframework.data.hadoop.hbase.TableCallback;
import org.springframework.stereotype.Repository;

@Repository
public class RecordRepository {
    @Autowired
    private HbaseTemplate hbaseTemplate;

    public List<Record> findByKey(String vin, String date) {
        String key = vin.concat(date);
        String dateStart = key.concat(" 00:00:0");
        String dateEnd = key.concat(" 23:59.59");
        Scan query = new Scan(dateStart.getBytes(), dateEnd.getBytes());
        query.addColumn("data".getBytes(), "hexStr".getBytes());

        return hbaseTemplate.find("evmraw", query, new RowMapper<Record>() {
            @Override
            public Record mapRow(Result result, int rowNum) throws Exception {
                return new Record(Bytes.toString(result.getValue("data".getBytes(), "hexStr".getBytes())));
            }
        });

    }
}
