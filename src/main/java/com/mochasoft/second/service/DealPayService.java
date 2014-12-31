package com.mochasoft.second.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mochasoft.second.mapper.DealPayMapper;
import com.mochasoft.second.model.DealPay;

@Component
public class DealPayService {

	@Autowired
	private DealPayMapper dealPayMapper;

	public List<DealPay> getAllDealPaysById(String dealId) {
		return dealPayMapper.getAllDealPaysById(dealId);
	}

	public int agreeDealPay(DealPay dealMessage) {
		return dealPayMapper.agreeDealPay(dealMessage);
	}

	public int insertDealPay(DealPay dealPay) {
		return dealPayMapper.insertDealPay(dealPay);
	}
}
