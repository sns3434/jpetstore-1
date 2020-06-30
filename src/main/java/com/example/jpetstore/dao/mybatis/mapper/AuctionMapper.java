package com.example.jpetstore.dao.mybatis.mapper;

import java.util.Date;
import java.util.List;

import com.example.jpetstore.domain.Auction;

public interface AuctionMapper {
	
	void updateBiddingPrice(double price);
	
	void insertAuction(Auction auction);
	
	void deleteAuctionbyAuctionId(int auctionId);
	
	List <Auction> getAuctionByUsername(String username);

	Auction getAuctionByAuctionId(int auctionId);
	
	int getMaxAuctionId(String itemId);
	
	String getTimeStatusByBiddingList(String username);
	
	  void closeEvent(String itemId);

	void closeAuction(String itemId);

	void updateIsSuccessful(Auction auction);

	int getAuctionIdByItem(String itemId);
}
