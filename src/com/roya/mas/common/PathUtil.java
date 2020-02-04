/*****************************************
 *  ���а�Ȩ(c) �Ϻ��������ϵͳ���޹�˾       *
 *****************************************/
package com.roya.mas.common;

/**
 * Description:
 * 
 * @version $Revision: 1.1 $
 * @author yan_xt
 * @date: Nov 13, 2007
 * @time: 4:31:09 PM
 */
public class PathUtil {
	public static String getRootPath() {
		String pathStr = PathUtil.class.getResource(
				"/com/roya/mas/common/PathUtil.class").toString();
		String OS = System.getProperty("os.name").toLowerCase();
		if (OS.indexOf("windows") > -1) {
			pathStr = pathStr.substring(pathStr.indexOf("/") + 1, pathStr
					.indexOf("PathUtil.class")).replaceAll("%20", " ");	
		}
		else{
			pathStr = pathStr.substring(pathStr.indexOf("/"), pathStr
					.indexOf("PathUtil.class")).replaceAll("%20", " ");	
		}

		return pathStr;
	}
}
