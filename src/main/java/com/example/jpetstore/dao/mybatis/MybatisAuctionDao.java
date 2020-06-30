package com.example.jpetstore.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.jpetstore.dao.AuctionDao;
import com.example.jpetstore.dao.mybatis.mapper.AuctionMapper;
import com.example.jpetstore.domain.Auction;

@Repository
public class MybatisAuctionDao implements AuctionDao {
	@Autowired
	private AuctionMapper auctionMapper;
	@Override
	public List<Auction> getAuctionByUsername(String username) throws DataAccessException {
		
		return auctionMapper.getAuctionByUsername(username);
		
	}
	
	/*@Override
	public getAuctionByAuctionId(String auctionId) throws DataAccessException {
		return auctionMapper.getAuctionByAuctionId(auctionId);
	}*/

	@Override
	public void updateBiddingPrice(double price) throws DataAccessException {
		// TODO Auto-generated method stub
		auctionMapper.updateBiddingPrice(price);
		
	}

	@Override
	public void insertAuction(Auction auction) throws DataAccessException {
		// TODO Auto-generated method stub
		auctionMapper.insertAuction(auction);
	}

	@Override
	public void deleteAuctionbyAuctionId(String auctionId) throws DataAccessException {
		// TODO Auto-generated method stub
		auctionMapper.deleteAuctionbyAunctionId(auctionId);
		
	}

	@Override
	public Auction getAuctionByAuctionId(int auctionId) throws DataAccessException {
		// TODO Auto-generated method stub
		return auctionMapper.getAuctionByAuctionId(auctionId);
	}	

	public int getMaxAuctionId(String itemId) {
		return auctionMapper.getMaxAuctionId(itemId);
	}

	@Override
	public String getTimeStatusByBiddingList(String username) {
		// TODO Auto-generated method stub
		return auctionMapper.getTimeStatusByBiddingList(username);
		
	}

	@Override
	public void updateIsSuccessful(Auction auction) {
		// TODO Auto-generated method stub
		auctionMapper.updateIsSuccessful(auction);
	}
	

	@Override
	public int getAuctionIdByItem(String itemId) {
		// TODO Auto-generated method stub
		return auctionMapper.getAuctionIdByItem(itemId);
	}

}
