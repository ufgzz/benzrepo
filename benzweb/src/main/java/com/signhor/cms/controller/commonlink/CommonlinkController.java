package com.signhor.cms.controller.commonlink;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.signhor.cms.model.User;
import com.signhor.cms.model.commonlink.CommonlinkType;
import com.signhor.cms.service.commonlink.CommonlinkService;
import com.signhor.cms.util.AppUtil;
import com.signhor.cms.util.page.PageBoundsUtil;
import com.signhor.cms.util.page.Pager;

@Controller
@RequestMapping("/commonlink")
public class CommonlinkController {
	 
	@Resource
	HttpServletRequest request;
	
	@Resource
	private CommonlinkService commonlinkService;
	
	
	@RequestMapping(value = "/list/commonlinktype", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)  
	public @ResponseBody Object findCommonlinkTypeList( @RequestParam(value = "page", defaultValue = "1") int page,  @RequestParam(value = "pagenum", defaultValue = "10") int pageNum){
		Map<String, Object> respMap = new HashMap<String, Object>();
		respMap.put("count", 0);
		respMap.put("commonlinktypelist", "");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("loginUser");
		if(null != user){
			PageBounds pb = PageBoundsUtil.PageBoundsOrderExtend("orderId.desc");
			pb.setPage(page);
			pb.setLimit(pageNum);
			CommonlinkType commonlinkType = new CommonlinkType(String.valueOf(user.getId()));
			Pager<CommonlinkType> commonLinkPage = commonlinkService.findCommonlinkTypeList(commonlinkType,pb);
			if(null != commonLinkPage && commonLinkPage.getTotal() > 0){
				respMap.put("count",commonLinkPage.getTotal());
				respMap.put("commonlinktypelist", commonLinkPage);
			}
		} else {
			user = new User();
			user.setId(6);
			PageBounds pb = PageBoundsUtil.PageBoundsOrderExtend("orderId.desc");
			pb.setPage(page);
			pb.setLimit(pageNum);
			CommonlinkType commonlinkType = new CommonlinkType(String.valueOf(user.getId()));
			Pager<CommonlinkType> commonLinkPage = commonlinkService.findCommonlinkTypeList(commonlinkType,pb);
			if(null != commonLinkPage && commonLinkPage.getTotal() > 0){
				respMap.put("count",commonLinkPage.getTotal());
				respMap.put("commonlinktypelist", commonLinkPage);
			}
		}
		return AppUtil.returnObject(request, respMap);
	}
	
}
