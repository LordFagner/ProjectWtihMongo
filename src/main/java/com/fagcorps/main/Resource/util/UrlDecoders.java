package com.fagcorps.main.Resource.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class UrlDecoders {

	
	public static String DecodeParams(String text) {
		
		
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO 'Auto-generated catch block
			return "";
		}
		
		
	}
	
	
	
}
