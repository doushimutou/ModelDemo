package com.example.server;

import com.alibaba.fastjson.JSONObject;
import com.example.api.domain.result.DispatchFilterResultDTO;
import com.example.api.provider.DispatchFilterConfigProvider;
import com.example.impl.provider.DispatchFilterProviderConfigImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServerApplication.class)
public class ServerApplicationTests {
	private static final Logger logger = LoggerFactory.getLogger(ServerApplicationTests.class);


	@Resource
	DispatchFilterProviderConfigImpl dispatchFilterConfigProvider;
	@Test
	public void contextLoads() {

		List<DispatchFilterResultDTO> dispatchFilterResultDTOList =dispatchFilterConfigProvider.queryAll();

		logger.info(JSONObject.toJSONString(dispatchFilterResultDTOList));

	}

}
