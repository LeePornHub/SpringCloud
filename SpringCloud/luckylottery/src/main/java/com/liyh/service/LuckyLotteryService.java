package com.liyh.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.liyh.bean.DlEmployee;
import com.liyh.bean.LuckyLottery;
import com.liyh.bean.LuckyLotteryInfo;

import java.util.List;
import java.util.Map;

public interface LuckyLotteryService {
    String login(String employeeId, String employeeName);
    List<DlEmployee> getAllEmployee();
    List<LuckyLotteryInfo> getEmployeeLuckyLotteryInfo(LuckyLotteryInfo luckyLotteryInfo);
    IPage<LuckyLotteryInfo> getDoneEmployeeLuckyLotteryInfo(LuckyLotteryInfo luckyLotteryInfo);
    Map<String, Object> verificationLuckyLotteryInfo(LuckyLotteryInfo luckyLotteryInfo);
    List<LuckyLottery> getLuckyLotteryInfo();
    String saveEmployeeLuckyLotteryInfo(List<LuckyLotteryInfo> luckyLotteryInfos);
    String clearLuckyLotteryInfo();
    String getNextLuckyLotteryInfo();
}
