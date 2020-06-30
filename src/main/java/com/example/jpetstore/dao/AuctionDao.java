package com.example.jpetstore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.jpetstore.domain.Auction;
import com.example.jpetstore.domain.Order;

public interface AuctionDao {
	/*
	 * 筌띾뜆�뵠占쎈읂占쎌뵠筌욑옙占쎈퓠 占쎄돌占쎌벥 占쎌뿯筌↔퀡沅∽옙肉�(getAuctionListByUserId)
	 * 占쎌궑占쎈�∽옙肉됵옙苑� 占쎈툡占쎌뵠占쎈�쩮b占쎌몵嚥∽옙 揶쏉옙野껓옙 揶쏄퉮�뻿
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
	
	void closeAuction(String itemId);
}

