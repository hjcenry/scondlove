package com.mochasoft.second.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mochasoft.second.model.DealMessage;
import com.mochasoft.util.mapper.MyBatisRepository;

@MyBatisRepository
public interface DealMessageMapper {

	List<DealMessage> geDealMessage(@Param("dealtype")String dealtype,@Param("page") int page, @Param("rows")int row,@Param("classify") String classify);

	int geDealMessageCount(@Param("dealtype")String dealtype,@Param("classify") String classify);

	int insertDealMessage(DealMessage dealMessage);

	DealMessage getDealMessageOne(String dealId);

	int updateDealStatus(@Param("dealStatus")int dealStatus, @Param("dealId")String dealId);

	int updateDealMessage(DealMessage dealMessage);
	
	
	
}
