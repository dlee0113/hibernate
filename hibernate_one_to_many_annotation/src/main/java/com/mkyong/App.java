package com.mkyong;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.mkyong.stock.Stock;
import com.mkyong.stock.StockDailyRecord;
import com.mkyong.util.HibernateUtil;

public class App {
	private static Logger log = Logger.getLogger(App.class);
	
	public static void main(String[] args) throws ParseException {
		log.info("Hibernate one to many (Annotation)");
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		Stock stock = new Stock();
		stock.setStockId(HibernateUtil.getNextStockSequenceNumber(session));;
        stock.setStockCode("7052");
        stock.setStockName("PADINI");
        
        log.info("stock - " + stock);
        session.save(stock);
        
        StockDailyRecord stockDailyRecord1 = new StockDailyRecord();
        stockDailyRecord1.setRecordId(HibernateUtil.getNextStockDailyRecordSequenceNumber(session));
        stockDailyRecord1.setPriceOpen(new Float("1.2"));
        stockDailyRecord1.setPriceClose(new Float("1.1"));
        stockDailyRecord1.setPriceChange(new Float("10.0"));
        stockDailyRecord1.setVolume(3000000L);
        stockDailyRecord1.setDate(new SimpleDateFormat("yyyy/MM/dd").parse("2013/01/01"));
        
        stockDailyRecord1.setStock(stock);        
        stock.getStockDailyRecords().add(stockDailyRecord1);

        log.info("stockDailyRecord1 - " + stockDailyRecord1);
        session.save(stockDailyRecord1);
        
        StockDailyRecord stockDailyRecord2 = new StockDailyRecord();
        stockDailyRecord2.setRecordId(HibernateUtil.getNextStockDailyRecordSequenceNumber(session));
        stockDailyRecord2.setPriceOpen(new Float("2.2"));
        stockDailyRecord2.setPriceClose(new Float("2.1"));
        stockDailyRecord2.setPriceChange(new Float("20.0"));
        stockDailyRecord2.setVolume(4000000L);
        stockDailyRecord2.setDate(new SimpleDateFormat("yyyy/MM/dd").parse("2013/01/02"));
        
        stockDailyRecord2.setStock(stock);        
        stock.getStockDailyRecords().add(stockDailyRecord2);

        log.info("stockDailyRecord2 - " + stockDailyRecord2);
        session.save(stockDailyRecord2);

		session.getTransaction().commit();
		
		session.beginTransaction();

		List<Stock> stockList = session.createQuery("from Stock").list();
		for (Stock s: stockList) {
			log.info("stock - " + s);
		}
		
		List<StockDailyRecord> stockDetailRecordList =  session.createQuery("from StockDailyRecord").list();
		for (StockDailyRecord sdr: stockDetailRecordList) {
			log.info("stockDailyRecord - " + sdr);
		}
		
		session.close();
		
		log.info("Done");
	}
}
