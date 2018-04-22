package com.award.sy.service;

import java.util.List;
import java.util.Map;
/**
 * 获取群组细节
* <p>Title: GroupDetailsService</p>  
* <p>Description: </p>  
* @author w77996  
* @date 2018年4月20日
 */
public interface GroupDetailsService {
	/**
	 * 功能描述：获取所有位置信息
	 * @return
	 */
	public List<GroupDetails> getAllGroupDetails();
	
	/**
	 * 功能描述：根据条件获取位置信息
	 * @return
	 */
	public DatatablesView<GroupDetails> getGroupDetailsByCondition(QueryCondition query);
	
	/**
	 * 功能描述：根据ID获取位置信息
	 * @param AreaId
	 * @return
	 */
	public GroupDetails getGroupDetailsById(long groupDetailsId);
	
	public List<Map<String,Object>> getGroupDetailsByLatLng(Map<String,double[]> map,long userId);
	
	public List<Map<String,Object>> getLimitGroupDetailsByLatLng(double lat,double lng,int start,int count,long userId);
	
	/**
	 * 功能描述：添加位置信息
	 * @param GroupDetailsDao
	 * @return
	 */
	public int addGroupDetails(GroupDetails groupDetails);
	
	/**
	 * 功能描述：修改位置信息
	 * @param GroupDetailsDao
	 * @return
	 */
	public int editGroupDetails(GroupDetails groupDetails);
	
	/**
	 * @功能描述：删除位置信息
	 * @param groupDetailsId
	 * @return int
	 */
	public int removeGroupDetails(long groupDetailsId);
	/**
	 * 获取群组名称及群组ID
	 */
	List<Map<String,Object>> getUserGroupDetails(long useId);
	/**
	 * 普通用户退出群聊
	 * <p>Title: deleteUserFromGroup</p>  
	 * <p>Description: </p>  
	 * @param userId
	 * @return
	 */
	int deleteUserFromGroup(long userId);
	
	/**
	 * 管理员用户退出群聊
	 * <p>Title: deleteUserAdminFromGroup</p>  
	 * <p>Description: </p>  
	 * @param userId
	 * @return
	 */
	int deleteUserAdminFromGroup(long userId,long groupId);
	
/*	User getGroupAdmin(long )*/

}
