package com.award.sy.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.award.core.beans.WherePrams;
import com.award.core.sql.where.C;
import com.award.sy.dao.GroupDetailsDao;
import com.award.sy.entity.GroupDetails;
import com.award.sy.entity.bean.QueryCondition;
import com.award.sy.service.GroupDetailsService;
import com.award.sy.web.view.DatatablesView;

@Service("groupDetailsService")
public class GroupDetailsServiceImpl implements GroupDetailsService{

	@Autowired 
	private GroupDetailsDao groupDetailsDao;

	public DatatablesView<GroupDetails> getGroupDetailsByCondition(QueryCondition query) {
		DatatablesView<GroupDetails> dataView = new DatatablesView<GroupDetails>();
		
		//构建查询条件
		WherePrams where = groupDetailsDao.structureConditon(query);
		
		Long count = groupDetailsDao.count(where);
		List<GroupDetails> list = groupDetailsDao.list(where);
		
		dataView.setRecordsTotal(count.intValue());
		dataView.setData(list);
		
		return dataView;
	}
	
	public List<GroupDetails> getAllGroupDetails(){
		return groupDetailsDao.list();
	}
	
	public GroupDetails getGroupDetailsById(long groupDetailsId){
		return groupDetailsDao.get(groupDetailsId);
	}
	
	public int addGroupDetails(GroupDetails groupDetails){
		return groupDetailsDao.addLocal(groupDetails);
	}
	
	public int editGroupDetails(GroupDetails groupDetails){
		WherePrams where = new WherePrams();
		where.and("groupDetails_id", C.EQ, groupDetails.getDetails_id());
		return groupDetailsDao.updateLocal(groupDetails,where);
	}
	
	public int removeGroupDetails(long groupDetailsId){
		return groupDetailsDao.del(groupDetailsId);
	}

	@Override
	public List<Map<String,Object>> getGroupDetailsByLatLng(Map<String,double[]> map,long userId) {
		List<Map<String,Object>> list = groupDetailsDao.listBySql("select a.*,b.head_img,b.birth,b.user_name,b.sex,b.country,b.invisible from tb_groupDetails a, tb_user b where a.user_id = b.user_id and a.user_id <> "+userId+" and a.lat > "+ map.get("rightBottomPoint")[0]+" and a.lat < "+ map.get("leftTopPoint")[0] + " and a.lng > "+map.get("leftTopPoint")[1]+" and a.lng < "+map.get("rightBottomPoint")[1]);
		return list;
	}

	@Override
	public List<Map<String,Object>> getLimitGroupDetailsByLatLng(double lat, double lng,
			int start, int count, long userId) {
		// TODO Auto-generated method stub
		List<Map<String,Object>> list = groupDetailsDao.listBySql("select a.*,b.head_img,b.birth,b.user_name,b.sex,b.country,b.invisible,(POWER(MOD(ABS(lng - "+lng+"),360),2) + POWER(ABS(lat - "+lat+"),2)) AS distance from tb_groupDetails a, tb_user b where a.user_id = b.user_id and a.user_id <> "+userId+" ORDER BY distance LIMIT "+start+","+count);
		//SELECT lng,lat, (POWER(MOD(ABS(lng - $lng),360),2) + POWER(ABS(lat - $lat),2)) AS distance FROM `user_groupDetails` ORDER BY distance LIMIT 100 
		return list;
	}
//	
	/**
	 * 获取群组下的user头像及username
	 */
	@Override
	public List<Map<String, Object>> getUserGroupDetails(long groupId) {
		// TODO Auto-generated method stub
		List<Map<String,Object>> list = groupDetailsDao.listBySql("select u.* from tb_user u left  JOIN tb_group_details gd   on gd.member_id = u.user_id where gd.group_id ="+groupId);
		return list;
	}

	@Override
	public int deleteUserFromGroup(long userId) {
		// TODO Auto-generated method stub
		WherePrams where = new WherePrams();
		where.orStart();
		where.and("member_id", C.EQ, userId);
		where.orEnd();
		return groupDetailsDao.del(where);
	}

	@Transactional
	@Override
	public int deleteUserAdminFromGroup(long userId,long groupId) {
		// TODO Auto-generated method stub
		//获取第二个用户
		List<Map<String,Object>> secondUser = groupDetailsDao.listBySql("SELECT member_id FROM tb_group_details  WHERE group_id = "+groupId+" ORDER BY join_time ASC LIMIT 1, 1");
		long secondUserId = (long) secondUser.get(0).get("member_id");
		//用户退出删除
		int i = deleteUserFromGroup(userId);
		//设置第二个用户为管理员
		int j = groupDetailsDao.excuse("UPDATE tb_group_details SET is_admin = 1 WHERE member_id ="+secondUserId+" and group_id ="+groupId);
		if(i > 0 && j > 0){
			return 1;
		}
		return 0;
	}

}
