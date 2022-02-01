package com.example.stocktest.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * 코스피종목정보
 */
@Getter
@Setter
public class StockInfo {
    /** 종목순위 */
    int stockRank;
    /** 종목명 */
    String stockNm;
    /** 종목코드 */
    String stockCd;
    /** 현재가 */
    String currPrice;
    /** 등락구분 */
    String upDownF;
    /** 전일비 */
    String dayOnDayPrice;
    /** 등락률 */
    String upDownRatio;
    /** 거래량 */
    String tradingVolume;
    /** 거래대금(백만) */
    String transactionAmt;
    /** 시가총액(억) */
    String marketCap;

    @Override
    public String toString() {
        return "StockInfo{" +
                "stockRank=" + stockRank +
                ", stockNm='" + stockNm + '\'' +
                ", stockCd='" + stockCd + '\'' +
                ", currPrice='" + currPrice + '\'' +
                ", upDownF='" + upDownF + '\'' +
                ", dayOnDayPrice='" + dayOnDayPrice + '\'' +
                ", upDownRatio='" + upDownRatio + '\'' +
                ", tradingVolume='" + tradingVolume + '\'' +
                ", transactionAmt='" + transactionAmt + '\'' +
                ", marketCap='" + marketCap + '\'' +
                '}';
    }
}
