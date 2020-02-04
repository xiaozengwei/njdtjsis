package com.gx.soft.common.web;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gx.soft.sys.persistence.domain.GxSysUser;

;

/**
 * 登录方法控制器
 * 
 * @author optimus
 * @version 1.0
 */
@Controller
@RequestMapping("templet")
@SessionAttributes("user_session")
// Session 注解
public class TempletController {
	// 日志
	private static Logger logger = LoggerFactory.getLogger(TempletController.class);

	/**
	 * 前往主流程的方法
	 * 
	 * @param model
	 * @author optimus
	 * @category 有三个状态分别是新建start 过程中update 和查看view
	 * @return
	 */
	@RequestMapping("go-templet")
	public String goTemplet(@RequestParam Map<String, Object> parameterMap,
			@ModelAttribute("user_session") GxSysUser user, Model model) {
		logger.info("there is in templetController");
		// 嵌套页面初始化参数
		String formUrl = "/gx/common/none.jsp";// 业务表单
		String fileUrl = "/gx/common/none.jsp";// 附件表单
		String adviceUrl = "/gx/common/none.jsp";// 意见表单
		String processUrl = "/gx/common/none.jsp";// 流程表单
		String opeartorUrl = "/gx/common/none.jsp";// 按钮表单
		String redirectUrl = "/gx/common/none.jsp";// 提交后跳转URL
		String fileRelationUrl = "/gx/common/none.jsp";// 文件关联跳转URL
		String sendReadUrl = "/gx/common/none.jsp";// 阅知过程跳转URL
		// 获取参数
		// 模版类型 有三个状态分别是新建start 过程中update 和查看view
		String taskId = (String) parameterMap.get("taskId");
		String templetType = (String) parameterMap.get("templetType");
		String processKey = (String) parameterMap.get("processKey");// 流程模版ID
		String businessKey = (String) parameterMap.get("businessKey");// businessKey
		String processInstId = (String) parameterMap.get("processInstId");// 流程实例ID
		String sxpzId = (String) parameterMap.get("sxpzId");
		String type = (String) parameterMap.get("type");
		String swId = parameterMap.get("swId") == null ? ""
				: (String) parameterMap.get("swId");
		// 如果模版页面处于开始状态========================================================================
		if (templetType.equals("start")) {
			// 发文
			if (businessKey.equals("key-fw")) {
				processUrl = "/process/start-process.do?";
				processUrl = processUrl + "processKey=" + processKey
						+ "&businessKey=" + businessKey;
				formUrl = "/dispatch/dispatch-form.do?configId=" + sxpzId
						+ "&swId=" + swId;
				fileUrl = "/fileupload/fileupload-form.do";
				opeartorUrl = "/gx/common/opeartor.jsp";// 按钮表单
				redirectUrl = "/process/get-user-fw-process.do";
				fileRelationUrl = "/file-relation/list.do?piid=" + processInstId + "&docType=fw" + "&swId=" + swId;
			} else if (businessKey.equals("key-sw")) {// 收文
				processUrl = "/process/start-process.do?";
				processUrl = processUrl + "processKey=" + processKey
						+ "&businessKey=" + businessKey;
				formUrl = "/intray/intray-form.do?configId=" + sxpzId;
				fileUrl = "/fileupload/fileupload-form.do";
				opeartorUrl = "/gx/common/opeartor.jsp";// 按钮表单
				redirectUrl = "/process/get-user-sw-process.do";
				fileRelationUrl = "/file-relation/list.do?piid="
						+ processInstId + "&docType=sw";
            //测试请假流程
			}else if (businessKey.equals("key-qj")) {// 请假-发文
                processUrl = "/process/start-process.do?";
                processUrl = processUrl + "processKey=" + processKey
                        + "&businessKey=" + businessKey;
                formUrl = "/dispatch/dispatch-form.do?configId=" + sxpzId + "&swId=" + swId;
                fileUrl = "/fileupload/fileupload-form.do";
                opeartorUrl = "/gx/common/opeartor.jsp";// 按钮表单
                redirectUrl = "/process/get-user-fw-process.do";
                fileRelationUrl = "/file-relation/list.do?piid=" + processInstId + "&docType=fw" + "&swId=" + swId;

			} else if (businessKey.equals("key-ww")) {// 网文
				processUrl = "/process/start-process.do?";
				processUrl = processUrl + "processKey=" + processKey
						+ "&businessKey=" + businessKey;
				formUrl = "/net-doc/intray-form.do?configId=" + sxpzId
						+ "&type=" + type;
				fileUrl = "/fileupload/fileupload-form.do";
				opeartorUrl = "/gx/common/opeartor.jsp";// 按钮表单
				redirectUrl = "/process/get-user-ww-process.do";
				fileRelationUrl = "/file-relation/list.do?piid="
						+ processInstId + "&docType=ww";
			} else if (businessKey.equals("key-lx")) {// 工作联系单
				processUrl = "/process/start-process.do?";
				processUrl = processUrl + "processKey=" + processKey
						+ "&businessKey=" + businessKey;
				formUrl = "/workLx/lx-form.do?configId=" + sxpzId;
				fileUrl = "/fileupload/fileupload-form.do";
				opeartorUrl = "/gx/common/opeartor.jsp";// 按钮表单
				redirectUrl = "/process/get-user-lx-process.do";
			} else if (businessKey.equals("key-bw")) {// 办文办事请示单
				processUrl = "/process/start-process.do?";
				processUrl = processUrl + "processKey=" + processKey
						+ "&businessKey=" + businessKey;
				formUrl = "/workBw/bw-form.do?configId=" + sxpzId + "&type="
						+ type;
				fileUrl = "/fileupload/fileupload-form.do";
				opeartorUrl = "/gx/common/opeartor.jsp";// 按钮表单
				redirectUrl = "/process/get-user-bw-process.do";
			}
		}
		// 如果模版页面处于更新状态=========================================================================
		else if (templetType.equals("update")) {
			// 发文
			if (businessKey.equals("key-fw")) {
				processUrl = "/process/go-run-process.do?";
				processUrl = processUrl + "processKey=" + processKey
						+ "&taskId=" + taskId + "&businessKey=" + businessKey
						+ "&processInstanceId=" + processInstId;
				adviceUrl = "/dispatch/dispatch-advice-strategy-list.do?piid="
						+ processInstId;
				formUrl = "/dispatch/redirect-fw-opt.do.do?piid="
						+ processInstId + "&opt=update";
				fileUrl = "/fileupload/redirect-fileupload.do?piid="
						+ processInstId + "&docType=fw&opt=update";
				opeartorUrl = "/gx/common/opeartor.jsp";// 按钮表单
				redirectUrl = "/process/get-user-fw-process.do";
				fileRelationUrl = "/file-relation/list.do?piid="
						+ processInstId + "&docType=fw&opt=update";
			} else if (businessKey.equals("key-sw")) {// 收文
				processUrl = "/process/go-run-process.do?";
				processUrl = processUrl + "processKey=" + processKey
						+ "&taskId=" + taskId + "&businessKey=" + businessKey
						+ "&processInstanceId=" + processInstId;
				formUrl = "/intray/redirect-sw-readhandle-opt.do?piid="
						+ processInstId + "&opt=update";
				adviceUrl = "/dispatch/dispatch-advice-strategy-list.do?piid="
						+ processInstId;
				fileUrl = "/fileupload/redirect-fileupload.do?piid="
						+ processInstId + "&docType=sw&opt=update";
				opeartorUrl = "/gx/common/opeartor.jsp";// 按钮表单
				redirectUrl = "/process/get-user-sw-process.do";
				fileRelationUrl = "/file-relation/list.do?piid="
						+ processInstId + "&docType=sw&opt=update";
				sendReadUrl = "/send-read/to-list.do?piid=" + processInstId;
			} else if (businessKey.equals("key-ww")) {// 网文
				processUrl = "/process/go-run-process.do?";
				processUrl = processUrl + "processKey=" + processKey
						+ "&taskId=" + taskId + "&businessKey=" + businessKey
						+ "&processInstanceId=" + processInstId;
				formUrl = "/net-doc/redirect-ww-readhandle-opt.do?piid="
						+ processInstId + "&opt=update";
				adviceUrl = "/dispatch/dispatch-advice-strategy-list.do?piid="
						+ processInstId;
				fileUrl = "/fileupload/redirect-fileupload.do?piid="
						+ processInstId + "&docType=ww&opt=update";
				opeartorUrl = "/gx/common/opeartor.jsp";// 按钮表单
				redirectUrl = "/process/get-user-ww-process.do";
				fileRelationUrl = "/file-relation/list.do?piid="
						+ processInstId + "&docType=ww&opt=update";
				sendReadUrl = "/send-read/to-list.do?piid=" + processInstId
						+ "&docType=ww";
			} else if (businessKey.equals("key-lx")) {// 工作联系单
				processUrl = "/process/go-run-process.do?";
				processUrl = processUrl + "processKey=" + processKey
						+ "&taskId=" + taskId + "&businessKey=" + businessKey
						+ "&processInstanceId=" + processInstId;
				formUrl = "/workLx/redirect-form-opt.do?piid=" + processInstId
						+ "&opt=update";
				adviceUrl = "/dispatch/dispatch-advice-strategy-list.do?piid="
						+ processInstId;
				fileUrl = "/fileupload/redirect-fileupload.do?piid="
						+ processInstId + "&docType=lx&opt=update";
				opeartorUrl = "/gx/common/opeartor.jsp";// 按钮表单
				redirectUrl = "/process/get-user-lx-process.do";
			} else if (businessKey.equals("key-bw")) {// 办文办事请示单
				processUrl = "/process/go-run-process.do?";
				processUrl = processUrl + "processKey=" + processKey
						+ "&taskId=" + taskId + "&businessKey=" + businessKey
						+ "&processInstanceId=" + processInstId;
				formUrl = "/workBw/redirect-form-opt.do?piid=" + processInstId
						+ "&opt=update";
				adviceUrl = "/dispatch/dispatch-advice-strategy-list.do?piid="
						+ processInstId;
				fileUrl = "/fileupload/redirect-fileupload.do?piid="
						+ processInstId + "&docType=bw&opt=update";
				opeartorUrl = "/gx/common/opeartor.jsp";// 按钮表单
				redirectUrl = "/process/get-user-bw-process.do";
			}
		} else if (templetType.equals("view-djb")) {
			// 发文
			if (businessKey.equals("key-fw")) {
				adviceUrl = "/dispatch/dispatch-advice-strategy-list.do?piid="
						+ processInstId;
				formUrl = "/dispatch/redirect-fw-opt.do.do?piid="
						+ processInstId + "&opt=detail";
				// opeartorUrl ="/gx/common/view-opeartor.jsp";//按钮表单
				redirectUrl = "/process/get-user-fw-process.do";
				fileUrl = "/fileupload/redirect-fileupload.do?piid="
						+ processInstId + "&docType=fw&opt=update";
				fileRelationUrl = "/file-relation/list.do?piid="
						+ processInstId + "&docType=fw&opt=update";

			} else if (businessKey.equals("key-sw")) {// 收文
				adviceUrl = "/dispatch/dispatch-advice-strategy-list.do?piid="
						+ processInstId;
				formUrl = "/intray/redirect-sw-readhandle-opt.do?piid="
						+ processInstId + "&opt=detail";
				redirectUrl = "/process/get-user-sw-process.do";
				fileUrl = "/fileupload/redirect-fileupload.do?piid="
						+ processInstId + "&docType=sw&opt=update";
				fileRelationUrl = "/file-relation/list.do?piid="
						+ processInstId + "&docType=sw&opt=update";
				sendReadUrl = "/send-read/to-list.do?piid=" + processInstId;

			} else if (businessKey.equals("key-ww")) {// 网文
				adviceUrl = "/dispatch/dispatch-advice-strategy-list.do?piid="
						+ processInstId;
				formUrl = "/net-doc/redirect-ww-readhandle-opt.do?piid="
						+ processInstId + "&opt=detail";
				redirectUrl = "/process/get-user-ww-process.do";
				fileUrl = "/fileupload/redirect-fileupload.do?piid="
						+ processInstId + "&docType=ww&opt=update";
				fileRelationUrl = "/file-relation/list.do?piid="
						+ processInstId + "&docType=ww&opt=update";
				sendReadUrl = "/send-read/to-list.do?piid=" + processInstId
						+ "&docType=ww";

			} else if (businessKey.equals("key-lx")) {// 工作联系单
				adviceUrl = "/dispatch/dispatch-advice-strategy-list.do?piid="
						+ processInstId;
				formUrl = "/workLx/redirect-form-opt.do?piid=" + processInstId
						+ "&opt=detail";
				redirectUrl = "/process/get-user-lx-process.do";
				fileUrl = "/fileupload/redirect-fileupload.do?piid="
						+ processInstId + "&docType=lx&opt=detail";

			} else if (businessKey.equals("key-bw")) {// 办公办文请示单
				adviceUrl = "/dispatch/dispatch-advice-strategy-list.do?piid="
						+ processInstId;
				formUrl = "/workBw/redirect-form-opt.do?piid=" + processInstId
						+ "&opt=detail";
				redirectUrl = "/process/get-user-bw-process.do";
				fileUrl = "/fileupload/redirect-fileupload.do?piid="
						+ processInstId + "&docType=bw&opt=detail";

			}
		} else {// 不传数值或最后一个状态均为view
				// 只读查看状态===================================================
				// 发文
			if (businessKey.equals("key-fw")) {
				adviceUrl = "/dispatch/dispatch-advice-strategy-list.do?piid="
						+ processInstId;
				formUrl = "/dispatch/redirect-fw-opt.do.do?piid="
						+ processInstId + "&opt=detail";
				fileUrl = "/fileupload/redirect-fileupload.do?piid="
						+ processInstId + "&docType=fw&opt=detail";
				// opeartorUrl ="/gx/common/view-opeartor.jsp";//按钮表单
				redirectUrl = "/process/get-user-fw-process.do";
				fileRelationUrl = "/file-relation/list.do?piid="
						+ processInstId + "&docType=fw&opt=detail";
			} else if (businessKey.equals("key-sw")) {// 收文
				adviceUrl = "/dispatch/dispatch-advice-strategy-list.do?piid="
						+ processInstId;
				formUrl = "/intray/redirect-sw-readhandle-opt.do?piid="
						+ processInstId + "&opt=detail&also=sendread";
				fileUrl = "/fileupload/redirect-fileupload.do?piid="
						+ processInstId + "&docType=sw&opt=detail";
				opeartorUrl = "/gx/common/view-opeartor.jsp";// 按钮表单
				redirectUrl = "/process/get-user-sw-process.do";
				fileRelationUrl = "/file-relation/list.do?piid="
						+ processInstId + "&docType=sw&opt=detail";
				sendReadUrl = "/send-read/to-list.do?piid=" + processInstId;
			} else if (businessKey.equals("key-ww")) {// 网文
				adviceUrl = "/dispatch/dispatch-advice-strategy-list.do?piid="
						+ processInstId;
				formUrl = "/net-doc/redirect-ww-readhandle-opt.do?piid="
						+ processInstId + "&opt=detail&also=sendread";
				fileUrl = "/fileupload/redirect-fileupload.do?piid="
						+ processInstId + "&docType=ww&opt=detail";
				opeartorUrl = "/gx/common/view-opeartor.jsp";// 按钮表单
				redirectUrl = "/process/get-user-ww-process.do";
				fileRelationUrl = "/file-relation/list.do?piid="
						+ processInstId + "&docType=ww&opt=detail";
				sendReadUrl = "/send-read/to-list.do?piid=" + processInstId
						+ "&docType=ww";
			} else if (businessKey.equals("key-lx")) {// 工作联系单
				adviceUrl = "/dispatch/dispatch-advice-strategy-list.do?piid="
						+ processInstId;
				formUrl = "/workLx/redirect-form-opt.do?piid=" + processInstId
						+ "&opt=detail";
				fileUrl = "/fileupload/redirect-fileupload.do?piid="
						+ processInstId + "&docType=lx&opt=detail";
				opeartorUrl = "/gx/common/view-opeartor.jsp";// 按钮表单
				redirectUrl = "/process/get-user-lx-process.do";
			} else if (businessKey.equals("key-bw")) {// 办公办文请示单
				adviceUrl = "/dispatch/dispatch-advice-strategy-list.do?piid="
						+ processInstId;
				fileUrl = "/fileupload/redirect-fileupload.do?piid="
						+ processInstId + "&docType=bw&opt=detail";
				opeartorUrl = "/gx/common/view-opeartor.jsp";// 按钮表单
				redirectUrl = "/process/get-user-bw-process.do";
				formUrl = "/workBw/redirect-form-opt.do?piid=" + processInstId
						+ "&opt=detail";
			}

		}
		// 将生成的业务表单返回主页面
		model.addAttribute("formUrl", formUrl);
		model.addAttribute("fileUrl", fileUrl);
		model.addAttribute("fileRelationUrl", fileRelationUrl);
		model.addAttribute("adviceUrl", adviceUrl);
		model.addAttribute("processUrl", processUrl);
		model.addAttribute("opeartorUrl", opeartorUrl);
		model.addAttribute("redirectUrl", redirectUrl);
		model.addAttribute("templetType", templetType);
		model.addAttribute("sendReadUrl", sendReadUrl);
		return "common/templet-page";
	}

}
