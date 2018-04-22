package com.award.sy.web.openapi;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.award.core.util.JsonUtils;
import com.award.sy.common.DateUtil;
import com.award.sy.entity.Mission;
import com.award.sy.entity.User;
import com.award.sy.service.MissionService;
import com.award.sy.service.UserService;

@Controller
public class ChatOpenController {

	protected Logger log = LoggerFactory.getLogger(this.getClass());

	@Resource
	private UserService userService;
	
	@Resource
	private MissionService missionService;
	
	/**
	 * 查询附近的人
	 * 
	 * @param request
	 * @param query
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/open/addGroup", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getAllMission(HttpServletRequest request) {
		String start = request.getParameter("start");
		String count = request.getParameter("count");
		String returnStr = JsonUtils.writeJson(0, 0, "参数为空");
		if(!StringUtils.isBlank(start) && !StringUtils.isBlank(count)) {
			List<Map<String,Object>> list = missionService.getAllMissionLimit(Integer.parseInt(start), Integer.parseInt(count));
			returnStr = JsonUtils.writeJson(1, "获取成功", list, "object");
		}
		return returnStr;
	}

}
