package com.gx.soft.robot.web;

import com.gx.soft.robot.persistence.domain.RobotWords;
import com.gx.soft.robot.persistence.manager.RobotWordsManager;
import org.apache.commons.collections.map.HashedMap;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.io.StringReader;
import java.util.*;

/**
 * 机器人接口控制器
 * 
 * @author optimus
 * @date 2019-4-22
 */
@Controller
@RequestMapping("robot")
public class RobotChatController {

	@Autowired
	private RobotWordsManager robotWordsManager;
	// 日志
	private static Logger logger = LoggerFactory
			.getLogger(RobotChatController.class);

	/**
	 * 对话接口
	 * 
	 * @param
	 * @param
	 * @param askString
	 * @return
	 */
	@RequestMapping(value = "ask", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	Map<String, Object> robotAsk(String userId, String askString, String type,String versionCode) {

		logger.info("Robot Ask------->robotAsk 机器人问句："+userId+":"+askString+":"+type);

		String statusCode = "200";// 登录失败
		String message = "接口调用成功";
		Map<String, Object> resMap = new HashMap<String, Object>();
//		String answerWords = "今天工地现场施工50人、其中外来人员5人、管理人员1人、施工工人39人";
		String answerWords = "";
		if(askString != null && askString.length() > 0){
			//基于java语言开发的轻量级的中文分词工具包;
			//创建分词对象
			//遍历分词数据
			List<String> list =  new ArrayList<String>();
			try {
				IKAnalyzer anal=new IKAnalyzer(true);
				StringReader reader=new StringReader(askString);
				//分词
				TokenStream ts=anal.tokenStream("", reader);
				CharTermAttribute term=ts.getAttribute(CharTermAttribute.class);
				while(ts.incrementToken()){
					list.add(term.toString());
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//		List<RobotWords> robotWordsList = new ArrayList<>();
//		for(String s : list){
//			List<RobotWords> tempList = robotWordsManager.findBy("askRwords",s);
//			if(tempList != null && tempList.size() > 0){
//				for(RobotWords robotWords : tempList){
//					robotWordsList.add(robotWords);
//				}
//			}
//		}
			String hql = "from RobotWords where askRwords like '%"+list.get(0)+"%'";
			if(list.size() == 1){
			}else{
				for(String s : list){
					hql += " or askRwords like '%"+s+"%'";
				}
			}
			List<RobotWords> robotWordsList = robotWordsManager.find(hql);

			Map<String,Integer> countMap = new HashMap<>();
			for(RobotWords robotWords : robotWordsList){
				int count = 0;
				for(String s : list){
					if(robotWords.getAskRwords().indexOf(s) != -1){
						count ++;
					}
				}
				countMap.put(robotWords.getAnswerRwords(),count);
			}
			Integer tempCount = 0;

			for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
				if(entry.getValue() > tempCount){
					tempCount = entry.getValue();
					answerWords = entry.getKey();
				}
			}
			if(answerWords.equals("")){
				answerWords = "抱歉，没有查到相关信息~~";
			}
		}else{
			answerWords = "您在说什么？";
		}
//		List<String> set = new ArrayList<>();
//		for (int i = 0; i < robotWordsList.size(); i++) {
//			for (int j = i + 1; j < robotWordsList.size(); j++) {
//				if (robotWordsList.get(i).getAnswerRwords().equals(robotWordsList.get(j).getAnswerRwords())) {
//					set.add(robotWordsList.get(i).getAnswerRwords());
//					break;
//				}
//			}
//		}
//		Map<String,Integer> countMap = new HashMap<>();
//		for (String string : set) {
//			int count  = 0;
//			for(RobotWords robotWords : robotWordsList){
//				if(string.equals(robotWords.getAnswerRwords())){
//					count ++;
//				}
//			}
//			countMap.put(string,count);
//		}
//		Set<Map.Entry<String, Integer>> entrySet = countMap.entrySet();
//		Integer count = 0;
//		String answerRwords = "";
//		for (Map.Entry<String, Integer> entry : entrySet) {
//			if(entry.getValue() > count){
//				count = entry.getValue();
//				answerRwords = entry.getKey();
//			}
//		}
		resMap.put("statusCode", statusCode);
		resMap.put("answerRwords", answerWords);
		resMap.put("message", message);
		return resMap;
	}

}
