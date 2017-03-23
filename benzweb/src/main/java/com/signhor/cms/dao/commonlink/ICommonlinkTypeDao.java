package com.signhor.cms.dao.commonlink;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.signhor.cms.model.commonlink.CommonlinkType;


public interface ICommonlinkTypeDao{
	
	public int addCommonlinkeType(CommonlinkType commonlinkType);

	public int deleteCommonlinkType(CommonlinkType commonlinkType);

	public int updateCommonlinkType(CommonlinkType commonlinkType);

	public int findCommonlinkTypeCountByName(CommonlinkType commonlinkType);

	public List<CommonlinkType> findCommonlinkTypeList(String userId, PageBounds pageBounds);

	public Integer getMaxCommonlinkTypeOrderId(CommonlinkType commonlinkType);

	public int findCommonlinkTypeCount(CommonlinkType commonlinkType);
	
}
