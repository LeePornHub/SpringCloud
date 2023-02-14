package com.liyh.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liyh.bean.DlEmployee;
import com.liyh.bean.LuckyLottery;
import com.liyh.bean.LuckyLotteryInfo;
import com.liyh.dao.LuckyLotteryDao;
import com.liyh.service.LuckyLotteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LuckyLotteryServiceImpl implements LuckyLotteryService {

    @Autowired
    private LuckyLotteryDao luckyLotteryDao;
    @Override
    public String login(String employeeId, String employeeName) {
        DlEmployee dlEmployee = new DlEmployee();
        dlEmployee.setEmployeeId(employeeId);
        dlEmployee.setEmployeeName(employeeName);
        List<DlEmployee> dlEmployees = luckyLotteryDao.login(dlEmployee);
        if (dlEmployees.isEmpty() && (!employeeName.equals("admin") || !employeeId.equals("lenovo_admin_top_one"))) {
            return "FAIL";
        }
        return "OK";
    }

    @Override
    public List<DlEmployee> getAllEmployee() {
        String next = luckyLotteryDao.getNextLuckyLotteryCode();
        List<DlEmployee> dlEmployees = luckyLotteryDao.getAllEmployee(new DlEmployee());
        return dlEmployees;
    }

    @Override
    public List<LuckyLotteryInfo> getEmployeeLuckyLotteryInfo(LuckyLotteryInfo luckyLotteryInfo) {
        return luckyLotteryDao.getEmployeeLuckyLotteryInfo(luckyLotteryInfo);
    }

    @Override
    public IPage<LuckyLotteryInfo> getDoneEmployeeLuckyLotteryInfo(LuckyLotteryInfo luckyLotteryInfo) {
        Page<LuckyLotteryInfo> page = new Page(luckyLotteryInfo.getPageNum(), luckyLotteryInfo.getPageSize());;
        IPage<LuckyLotteryInfo> pages = luckyLotteryDao.getDoneEmployeeLuckyLotteryInfo(page, luckyLotteryInfo);
        return pages;
    }

    @Override
    public Map<String, Object> verificationLuckyLotteryInfo(LuckyLotteryInfo luckyLotteryInfo) {
        Map<String, Object> map = new HashMap<>();
        List<LuckyLotteryInfo> luckyLotteryInfos = luckyLotteryDao.getEmployeeLuckyLotteryInfo(luckyLotteryInfo);

        try {
            if (!luckyLotteryInfos.isEmpty()) {
                luckyLotteryInfos = luckyLotteryInfos.stream().filter(e -> e.getLuckyLotteryCode().equals(luckyLotteryInfo.getLuckyLotteryCode())).collect(Collectors.toList());
                if ("done".equals(luckyLotteryInfos.get(0).getVerificationStatus())) {
                    map.put("result", "already verification");
                    map.put("luckyLotteryInfo", luckyLotteryInfos.get(0));
                    return map;
                }
            }
            luckyLotteryDao.verificationLuckyLotteryInfo(luckyLotteryInfo);
        } catch (RuntimeException e) {
            map.put("result", "FAIL");
            map.put("luckyLotteryInfo", luckyLotteryInfos.get(0));
            return map;
        }
        map.put("result", "OK");
        map.put("luckyLotteryInfo", luckyLotteryInfos.get(0));
        return map;
    }

    @Override
    public List<LuckyLottery> getLuckyLotteryInfo() {
        return luckyLotteryDao.getLuckyLotteryInfo();
    }

    @Override
    public String saveEmployeeLuckyLotteryInfo(List<LuckyLotteryInfo> luckyLotteryInfos) {
        try {
            List<String> luckyLotteryCodes = luckyLotteryInfos.stream().map(e -> e.getLuckyLotteryCode()).distinct().collect(Collectors.toList());
            luckyLotteryDao.isDeleteLuckyLotteryInfo(luckyLotteryCodes);
            luckyLotteryDao.saveEmployeeLuckyLotteryInfo(luckyLotteryInfos);
        } catch (RuntimeException e) {
            return "FAIL";
        }

        return luckyLotteryDao.getNextLuckyLotteryCode();
    }

    @Override
    public String clearLuckyLotteryInfo() {
        try {
            luckyLotteryDao.clearLuckyLotteryInfo();
        } catch (RuntimeException e) {
            return "FAIL";
        }
        return "OK";
    }

    @Override
    public String getNextLuckyLotteryInfo() {
        return luckyLotteryDao.getNextLuckyLotteryCode();
    }
}
