package com.example.stocktest.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * 종목별 일별시세
 */
@Getter
@Setter
public class ByDayStockPrice {
    /** 종목코드 */
    String stockCd;
    /** 날짜 */
    String stockDate;
    /** 종가 */
    String finishPrice;
    /** 전일비 */
    String dayOnDayPrice;
    /** 시가 */
    String startPrice;
    /** 고가 */
    String highPrice;
    /** 저가 */
    String lowPrice;
    /** 거래량 */
    String tradingVolume;
}
