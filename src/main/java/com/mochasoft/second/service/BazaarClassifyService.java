package com.mochasoft.second.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mochasoft.second.mapper.BazaarClassifyMapper;
import com.mochasoft.second.model.BazaarClassify;

@Component
public class BazaarClassifyService {

	@Autowired
	private BazaarClassifyMapper bazaarClassifyMapper;

	public List<BazaarClassify> getAllClassify(int status) {
		return bazaarClassifyMapper.getAllClassify(status);
	}

}
