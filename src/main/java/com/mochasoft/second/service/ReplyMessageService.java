package com.mochasoft.second.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mochasoft.second.model.ReplyMessage;
import com.mochasoft.second.mapper.ReplyMessageMapper;

@Component
public class ReplyMessageService {

	@Autowired
	private ReplyMessageMapper replyMessageMapper;

	public List<ReplyMessage> getAllReplyMessagesByDealId(String dealId) {
		return replyMessageMapper.getAllReplyMessagesByDealId(dealId);
	}

	public int indexReply(ReplyMessage replyMessage) {
		return replyMessageMapper.indexReply(replyMessage);
	}

}
