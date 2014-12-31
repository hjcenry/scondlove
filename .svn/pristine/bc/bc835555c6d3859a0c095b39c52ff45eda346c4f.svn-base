package com.mochasoft.second.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mochasoft.second.mapper.DealMessageMapper;
import com.mochasoft.second.model.DealMessage;

@Component
public class DealMessageService {

	@Autowired
	private DealMessageMapper dealMessageMapper;

	public List<DealMessage> geDealMessageList(String dealtype,int start ,int rows, String classify) {
		return dealMessageMapper.geDealMessage(dealtype,start ,rows, classify);
	}

	public int geDealMessageCount(String dealtype, String classify) {
		return dealMessageMapper.geDealMessageCount(dealtype, classify);
	}

	public int insertDealMessage(DealMessage dealMessage) {
		return dealMessageMapper.insertDealMessage(dealMessage);
	}

	public DealMessage getDealMessageOne(String dealId) {
		return dealMessageMapper.getDealMessageOne(dealId);
	}

	public int updateDealMessage(DealMessage dealMessage) {
		return dealMessageMapper.updateDealMessage(dealMessage);
	}

	public int updateDealStatus(int dealStatus, String dealId) {
		return dealMessageMapper.updateDealStatus(dealStatus,dealId);
	}

}
