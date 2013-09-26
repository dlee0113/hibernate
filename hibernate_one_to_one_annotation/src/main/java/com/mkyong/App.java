package com.mkyong;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.mkyong.stock.Stock;
import com.mkyong.stock.StockDetail;
import com.mkyong.util.HibernateUtil;

public class App {
	private static Logger log = Logger.getLogger(App.class);
	
	public static void main(String[] args) {
		log.info("Hibernate one to one (Annotation)");
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		Stock stock = new Stock();
		stock.setStockId(HibernateUtil.getNext(session));
		stock.setStockCode("100");
		stock.setStockName("GOOG");
		
		log.info("stock - " + stock);

		StockDetail stockDetail = new StockDetail();
		stockDetail.setCompName("PADINI Holding Malaysia");
		stockDetail.setCompDesc("one stop shopping");
		stockDetail.setRemark("vinci vinci");
		stockDetail.setListedDate(new Date());
		stock.setStockDetail(stockDetail);
		stockDetail.setStock(stock);

		log.info("stockDetail - " + stockDetail);
		
		session.save(stock);
		session.getTransaction().commit();
		
		session.beginTransaction();

		List<Stock> stockList = session.createQuery("from Stock").list();
		for (Stock s: stockList) {
			log.info("stock - " + s);
		}
		
		List<StockDetail> stockDetailList =  session.createQuery("from StockDetail").list();
		for (StockDetail sd: stockDetailList) {
			log.info("stockDetail - " + sd);
		}
		
		session.close();
		
		log.info("Done");
	}
}
