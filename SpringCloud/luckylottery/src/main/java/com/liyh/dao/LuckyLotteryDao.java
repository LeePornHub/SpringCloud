package com.liyh.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liyh.bean.DlEmployee;
import com.liyh.bean.LuckyLottery;
import com.liyh.bean.LuckyLotteryInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface LuckyLotteryDao {
    List<DlEmployee> login(@Param("dlEmployee") DlEmployee dlEmployee);
    List<DlEmployee> getAllEmployee(@Param("dlEmployee") DlEmployee dlEmployee);
    void saveEmployeeLuckyLotteryInfo(@Param("luckyLotteryInfos") List<LuckyLotteryInfo> luckyLotteryInfos);
    void isDeleteLuckyLotteryInfo(@Param("luckyLotteryCodes") List<String > luckyLotteryCodes);
    List<LuckyLottery> getLuckyLotteryInfo();
    void verificationLuckyLotteryInfo(@Param("luckyLotteryInfo") LuckyLotteryInfo luckyLotteryInfo);
    IPage<LuckyLotteryInfo> getDoneEmployeeLuckyLotteryInfo(@Param("page") Page page, @Param("luckyLotteryInfo") LuckyLotteryInfo luckyLotteryInfo);
    List<LuckyLotteryInfo> getEmployeeLuckyLotteryInfo(@Param("luckyLotteryInfo") LuckyLotteryInfo luckyLotteryInfo);

    void clearLuckyLotteryInfo();
    String getNextLuckyLotteryCode();
}
