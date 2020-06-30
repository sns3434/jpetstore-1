package com.example.jpetstore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.jpetstore.domain.Auction;
import com.example.jpetstore.domain.Order;

public interface AuctionDao {
	/*
	 * 留덉씠�럹�씠吏��뿉 �굹�쓽 �엯李곕궡�뿭(getAuctionListByUserId)
	 * �삦�뀡�뿉�꽌 �븘�씠�뀥db�쑝濡� 媛�寃� 媛깆떊
	 * insert, update, (delete), 
	 *  
	 *  
	 *  */
	 List<Auction> getAuctionByUsername(String username) throws DataAccessException;
	
	 void updateBiddingPrice(double price)throws DataAccessException;
	 void insertAuction(Auction auction)throws DataAccessException;
	 void deleteAuctionbyAuctionId(String auctionId) throws DataAccessException;
  
   Auction getAuctionByAuctionId(int auctionId)throws DataAccessException;
	 int getMaxAuctionId(String itemId);

	String getTimeStatusByBiddingList(String username);

	void updateIsSuccessful(Auction auction);

	int getAuctionIdByItem(String itemId);
}

