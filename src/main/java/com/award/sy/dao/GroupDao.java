package com.award.sy.dao;

import org.springframework.stereotype.Repository;

import com.award.core.beans.WherePrams;
import com.award.core.dao.impl.DaoImpl;
import com.award.core.sql.where.C;
import com.award.sy.entity.Group;
import com.award.sy.entity.bean.QueryCondition;

@Repository("groupDao")
public class GroupDao extends DaoImpl<Group, Long>{
	
	/**
	 * ������ѯ����
	 * @param query
	 * @return
	 */
	public WherePrams structureConditon(QueryCondition query){
		WherePrams where = new WherePrams();
		
		//�ؼ���
		if(query.getKeyword() != null && !"".equals(query.getKeyword())){
			where.orStart();
			where.or("user_id", C.LIKE, query.getKeyword());
			where.orEnd();
		}
		
		where.orderBy("last_time DESC");
		where.limit(query.getStart(), query.getLength());
		
		return where;
	}
}

