package com.signhor.cms.util;

import java.util.UUID;

public class Utils {
	public static String getUuid(){
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}

}
