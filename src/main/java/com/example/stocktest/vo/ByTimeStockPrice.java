package com.example.stocktest.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * 종목별 시간별시세
 */
@Getter
@Setter
public class ByTimeStockPrice {
    /** 종목코드 */
    String stockCd;
    /** 체결시각 */
    String finalPriceTime;
    /** 체결가 */
    String finalPrice;
    /** 전일비 */
    String dayOnDayPrice;
    /** 매도가 */
    String sellPrice;
    /** 매수가 */
    String buyPrice;
    /** 거래량 */
    String tradingVolume;
    /** 변동량 */
    String changeVolume;
}
