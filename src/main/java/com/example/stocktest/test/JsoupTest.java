package com.example.stocktest.test;

import com.example.stocktest.vo.StockInfo;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class JsoupTest {
    public static void main(String[] args) {
//        String connUrl = "https://finance.naver.com/sise/entryJongmok.naver?&page=";

        Document doc = null;
        try {
            List<StockInfo> stockInfoList = new ArrayList<>();

            for (int k = 1; k <= 20; k++) {
                String connUrl = "https://finance.naver.com/sise/entryJongmok.naver?&page=" + k;

                doc = Jsoup.connect(connUrl).get();

                Elements elements = doc.select("table.type_1 tbody tr");

//                System.out.println(">>>>> connUrl: " + connUrl);

                int stockRank = (k-1)*10;	// 종목순위
                String stockNm = "";	// 종목명
                String stockCd = "";	// 종목코드
                String currPrice = "";	// 현재가
                String dayOnDayPrice = "";	// 전일비
                String upDownRatio = "";	// 등락률
                String tradingVolume = "";	// 거래량
                String transactionAmt = "";	// 거래대금(백만)
                String marketCap = "";	// 시가총액(억)

                for (int i = 2; i < 12; i++) {
                    Elements tdEl = elements.get(i).select("td");

                    StockInfo stockInfo = new StockInfo();

                    stockRank++;

//                    System.out.println(">>>>> stockRank: " + stockRank);

                    stockInfo.setStockRank(stockRank);

                    for (int j = 0; j < tdEl.size(); j++) {
                        if(j==0) {
                            String href = tdEl.get(j).select("a").attr("href");
                            stockCd = href.split("=")[1];

                            stockInfo.setStockCd(stockCd);

                            stockNm = tdEl.get(j).text();

                            stockInfo.setStockNm(stockNm);
                        } else if(j==1) {
                            currPrice = tdEl.get(j).text();
                            currPrice = currPrice.replace(",", "");

                            stockInfo.setCurrPrice(currPrice);
                        } else if(j==2) {
                            String alt = tdEl.get(j).select("img").attr("alt");

                            if(alt.equals("상승")) stockInfo.setUpDownF("up");
                            else if(alt.equals("하락")) stockInfo.setUpDownF("down");

                            dayOnDayPrice = tdEl.get(j).text();

                            stockInfo.setDayOnDayPrice(dayOnDayPrice);
                        } else if(j==3) {
                            upDownRatio = tdEl.get(j).text();
                            upDownRatio = upDownRatio.substring(1).replace("%", "");

                            stockInfo.setUpDownRatio(upDownRatio);
                        } else if(j==4) {
                            tradingVolume = tdEl.get(j).text();	// 거래량
                            tradingVolume = tradingVolume.replace(",", "");

                            stockInfo.setTradingVolume(tradingVolume);
                        } else if(j==5) {
                            transactionAmt = tdEl.get(j).text();	// 거래대금(백만)
                            transactionAmt = transactionAmt.replace(",", "");

                            stockInfo.setTransactionAmt(transactionAmt);
                        } else if(j==6) {
                            marketCap = tdEl.get(j).text();	// 시가총액(억)
                            marketCap = marketCap.replace(",", "");

                            stockInfo.setMarketCap(marketCap);
                        }
                    }

                    stockInfoList.add(stockInfo);
                }
            }

            for (StockInfo stockInfo : stockInfoList) {
                log.info(">>>>> stockInfo: {}", stockInfo.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

//        System.out.println(doc.toString());
    }
}
