package com.company;

/**
 * @author dubetskyi_ov on 04.02.2019
 */

public class DataModelExcel {
    private int KEY;
    private Double W;
    private Long TIMELog;
    private String STRINGDATA;
    private String STRINGTIME;
    private String OPERADOR;

    public int getKEY() {
        return KEY;
    }

    public void setKEY(int KEY) {
        this.KEY = KEY;
    }

    public Double getW() {
        return W;
    }

    public void setW(Double w) {
        W = w;
    }

    public Long getTIMELog() {
        return TIMELog;
    }

    public void setTIMELog(Long TIMELog) {
        this.TIMELog = TIMELog;
    }

    public String getSTRINGDATA() {
        return STRINGDATA;
    }

    public void setSTRINGDATA(String STRINGDATA) {
        this.STRINGDATA = STRINGDATA;
    }

    public String getSTRINGTIME() {
        return STRINGTIME;
    }

    public void setSTRINGTIME(String STRINGTIME) {
        this.STRINGTIME = STRINGTIME;
    }

    public String getOPERADOR() {
        return OPERADOR;
    }

    public void setOPERADOR(String OPERADOR) {
        this.OPERADOR = OPERADOR;
    }

    public DataModelExcel(int KEY, Double w, Long TIMELog, String STRINGDATA, String STRINGTIME, String OPERADOR) {
        this.KEY = KEY;
        W = w;
        this.TIMELog = TIMELog;
        this.STRINGDATA = STRINGDATA;
        this.STRINGTIME = STRINGTIME;
        this.OPERADOR = OPERADOR;
    }
}


