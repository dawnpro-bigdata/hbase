package com.dawnpro.bigdata.hbase;

public class Record {
    public Record(String baowen) {
        this.baowen = baowen;
    }

    private String baowen;

    public String getBaowen() {
        return baowen;
    }

    public void setBaowen(String baowen) {
        this.baowen = baowen;
    }
}
