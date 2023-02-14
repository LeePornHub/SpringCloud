package com.liyh.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.liyh.bean.DlEmployee;
import com.liyh.bean.LuckyLottery;
import com.liyh.bean.LuckyLotteryInfo;
import com.liyh.service.LuckyLotteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dlEmployeeController")
public class LuckyLotteryController {

    @Autowired
    private LuckyLotteryService luckyLotteryService;
    @GetMapping("/login")
    public String login(String employeeId, String employeeName) {
        return luckyLotteryService.login(employeeId, employeeName);
    }

    @GetMapping("/getAllEmployee")
    public List<DlEmployee> getAllEmployee() {
        return luckyLotteryService.getAllEmployee();
    }

    @GetMapping("/getEmployeeLuckyLotteryInfo")
    public List<LuckyLotteryInfo> getEmployeeLuckyLotteryInfo(LuckyLotteryInfo luckyLotteryInfo) {
        return luckyLotteryService.getEmployeeLuckyLotteryInfo(luckyLotteryInfo);
    }

    @GetMapping("/getDoneEmployeeLuckyLotteryInfo")
    public IPage<LuckyLotteryInfo> getDoneEmployeeLuckyLotteryInfo(LuckyLotteryInfo luckyLotteryInfo) {
        return luckyLotteryService.getDoneEmployeeLuckyLotteryInfo(luckyLotteryInfo);
    }

    @PostMapping("/verificationLuckyLotteryInfo")
    public Map<String, Object> verificationLuckyLotteryInfo(@RequestBody LuckyLotteryInfo luckyLotteryInfo) {
        return luckyLotteryService.verificationLuckyLotteryInfo(luckyLotteryInfo);
    }

    @GetMapping("/getLuckyLotteryInfo")
    public List<LuckyLottery> getLuckyLotteryInfo() {
        return luckyLotteryService.getLuckyLotteryInfo();
    }

    @PostMapping("/saveEmployeeLuckyLotteryInfo")
    public String saveEmployeeLuckyLotteryInfo(@RequestBody List<LuckyLotteryInfo> luckyLotteryInfos) {
        return luckyLotteryService.saveEmployeeLuckyLotteryInfo(luckyLotteryInfos);
    }
    @GetMapping("/clearLuckyLotteryInfo")
    public String clearLuckyLotteryInfo() {

        return luckyLotteryService.clearLuckyLotteryInfo();
    }

    @GetMapping("/getNextLuckyLotteryInfo")
    public String getNextLuckyLotteryInfo() {

        return luckyLotteryService.getNextLuckyLotteryInfo();
    }
}
