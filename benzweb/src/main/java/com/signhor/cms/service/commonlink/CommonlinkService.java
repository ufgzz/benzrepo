package com.signhor.cms.service.commonlink;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.signhor.cms.dao.commonlink.ICommonlinkDao;
import com.signhor.cms.dao.commonlink.ICommonlinkTypeDao;
import com.signhor.cms.model.commonlink.Commonlink;
import com.signhor.cms.model.commonlink.CommonlinkType;
import com.signhor.cms.util.page.Pager;

@Service("commonlinkService")
public class CommonlinkService {
	
	private ICommonlinkTypeDao commonlinkTypeDao;
	private ICommonlinkDao commonlinkDao;

	public ICommonlinkTypeDao getCommonlinkTypeDao() {
		return commonlinkTypeDao;
	}

	@Resource
	public void setCommonlinkTypeDao(ICommonlinkTypeDao commonlinkTypeDao) {
		this.commonlinkTypeDao = commonlinkTypeDao;
	}
	
	@Resource
	public void setCommonlinkDao(ICommonlinkDao commonlinkDao) {
		this.commonlinkDao = commonlinkDao;
	}

	
	public boolean addCommonlinkType(CommonlinkType commonlinkType) {
    
		Integer maxOrderId = commonlinkTypeDao.getMaxCommonlinkTypeOrderId(commonlinkType);
		if(null == maxOrderId){
			maxOrderId = 0;
		}
		commonlinkType.setOrderId(maxOrderId+1);
		int result  = commonlinkTypeDao.addCommonlinkeType(commonlinkType);
		if (result >= 1) {
			return true;
		}
		return false;
	}

	public boolean deleteCommonlinkType(CommonlinkType commonlinkType) {
		int result  = commonlinkTypeDao.deleteCommonlinkType(commonlinkType);
		if (result >= 1) {
			return true;
		}
		return false;
	}
	
	public boolean updateCommonlinkType(CommonlinkType commonlinkType) {
		int result  = commonlinkTypeDao.updateCommonlinkType(commonlinkType);
		if (result >= 1) {
			return true;
		}
		return false;
	}

	public int findCommonlinkTypeCountByName(CommonlinkType commonlinkType) {
		int count  = commonlinkTypeDao.findCommonlinkTypeCountByName(commonlinkType);
		return count;
	}

	public Pager<CommonlinkType> findCommonlinkTypeList(CommonlinkType commonlinkType,PageBounds pb) {
		int count = commonlinkTypeDao.findCommonlinkTypeCount(commonlinkType);
		List<CommonlinkType> list = commonlinkTypeDao.findCommonlinkTypeList(commonlinkType.getUserId(),pb);
		Pager<CommonlinkType> pages = new Pager<CommonlinkType>(count,list);
		return pages;
	}
	
	////////////////////////////////
	public int findCommonlinkCountByNameUrl(Commonlink commonlink){
		int count  = commonlinkDao.findCommonlinkCountByNameUrl(commonlink);
		return count;
	}
	
	public boolean addCommonlink(Commonlink commonlink){
		Integer maxOrderId = commonlinkDao.getMaxCommonlinkOrderId(commonlink);
		if(null == maxOrderId){
			maxOrderId = 0;
		}
		commonlink.setOrderId(maxOrderId+1);
		int result  = commonlinkDao.addCommonlink(commonlink);
		if (result >= 1) {
			return true;
		}
		return false;
	}
	
	public boolean deleteCommonlink(Commonlink commonlink){
		int result  = commonlinkDao.deleteCommonlink(commonlink);
		if (result >= 1) {
			return true;
		}
		return false;
	}
	
	public boolean updateCommonlink(Commonlink commonlink){
		int result  = commonlinkDao.updateCommonlink(commonlink);
		if (result >= 1) {
			return true;
		}
		return false;
	}
	
	public List<Commonlink> findCommonlinkList(List<String> types,CommonlinkType commonlink){
		Map<String, Object> params = new HashMap<String, Object>(2);
        params.put("userId", commonlink.getUserId());
         params.put("types", types);
		List<Commonlink> list = commonlinkDao.findCommonlinkList(params);
		return list;
	}
	
	public Pager<Commonlink> findCommonlinkListByTypeId(Commonlink commonlink, PageBounds pb){
		int count = commonlinkDao.findCommonlinkCountByTypeId(commonlink);
		List<Commonlink> list = commonlinkDao.findCommonlinkListByTypeId(commonlink,pb);
		Pager<Commonlink> pages = new Pager<Commonlink>(count,list);
		return pages;
	}

}
