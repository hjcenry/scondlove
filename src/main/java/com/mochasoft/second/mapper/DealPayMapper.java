package com.mochasoft.second.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mochasoft.second.model.DealPay;
import com.mochasoft.util.mapper.MyBatisRepository;

@MyBatisRepository
public interface DealPayMapper {

	List<DealPay> getAllDealPaysById(String dealId);

	int insertDealPay(DealPay dealPay);

	int agreeDealPay(DealPay dealMessage);	
}
