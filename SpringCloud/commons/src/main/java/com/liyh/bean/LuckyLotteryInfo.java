package com.liyh.bean;

import lombok.Data;

import java.util.Date;

@Data
public class LuckyLotteryInfo {
    private String luckyLotteryCode;
    private String luckyLotteryName;
    private String employeeName;
    private String employeeId;
    private String verificationStatus;
    private Date verificationDate;
    private int pageSize;
    private int pageNum;
}
