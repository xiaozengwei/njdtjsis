package com.gx.soft.sb.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gx.soft.common.util.DateUtil;
import com.gx.soft.common.util.FileUtil;
import com.gx.soft.sb.persistence.domain.FileRecord;
import com.gx.soft.sb.persistence.manager.FileRecordManager;
import com.gx.soft.sys.persistence.domain.VUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mvc.extensions.ajax.AjaxUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gx.core.util.StringUtils;
import com.gx.soft.sys.persistence.domain.GxSysUser;
@Controller
@RequestMapping("fileRecord")
@SessionAttributes("user_session")
public class FileRecordController {
	private ObjectMapper objectMapper = null;
	private JsonGenerator jsonGenerator = null;
	@Autowired
	private FileRecordManager fileRecordManager;

	@ModelAttribute
	public void ajaxAttribute(WebRequest request, Model model) {
		model.addAttribute("ajaxRequest", AjaxUtils.isAjaxRequest(request));
	}

	@RequestMapping(method = RequestMethod.GET)
	public void fileUploadForm() {
	}

	private FileRecordController() {
		super();
		// TODO Auto-generated constructor stub
		objectMapper = new ObjectMapper();
		try {
			jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(
					System.out, JsonEncoding.UTF8);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * 文件上传
	 * @param file
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(method = RequestMethod.POST,value = "fileUpload")
	public void processUpload(
			@RequestParam MultipartFile file,String relationId,
			@ModelAttribute("user_session") VUser user,
			HttpServletResponse response, Model model, HttpSession session) throws IOException {
		model.addAttribute("message", "File '" + file.getOriginalFilename()+ "' uploaded successfully");
		String statusCode = "200", message = "上传成功";
		Map<String, Object> resMap = new HashMap<String, Object>();
		String fileOriginalName = file.getOriginalFilename();
		int index = fileOriginalName.lastIndexOf(".");
		String file_type = fileOriginalName.substring(index+1);
		FileRecord fileRecord = null;
		try {
			if (!StringUtils.isEmpty(fileOriginalName)) {
				FileUtil fileHelper = new FileUtil();
				String decodeFileName = fileHelper.getDecodeFileName(fileOriginalName);// 文件名编码
				String mFilePath = session.getServletContext().getRealPath(""); // 取得服务器路径
				mFilePath = mFilePath.substring(0, 2) + "\\njdtjsis" + "\\sb\\" + decodeFileName;
				fileHelper.createFile(mFilePath, file.getBytes());
				fileRecord = new FileRecord();
				if(relationId != null && relationId.length() > 0){
					fileRecord.setRelationId(relationId);
				}
				fileRecord.setFilePath(mFilePath);
				fileRecord.setFileName(fileOriginalName);
				fileRecord.setFileType(file_type);
				fileRecord.setUploadUserId(user.getUserId());
				fileRecord.setUploadUserName(user.getUserName());
				fileRecord.setUploadTime(DateUtil.getDate());
				fileRecord.setFileIdentifyName(decodeFileName);
				//保存
				fileRecordManager.save(fileRecord);
				resMap.put("fileRecord", fileRecord);
			} else {
				message = "请选择上传文件";
				statusCode = "300";
			}
		} catch (Exception e) {
			statusCode = "300";
			message = "上传失败";
			e.printStackTrace();
		}
		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		String returnString = objectMapper.writeValueAsString(resMap);
		response.setCharacterEncoding("UTF-8"); // 设置编码格式
		response.setContentType("text/html"); // 设置数据格式
		PrintWriter out = response.getWriter(); // 获取写入对象
		out.print(returnString); // 将json数据写入流中
		out.flush();
	}

	/**
	 * 附件删除
	 * @param fileId
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(method = RequestMethod.POST, value = "fileDelete", produces = "application/json")
	public @ResponseBody
	Map<String, Object> fileDelete(@RequestParam String fileId)
			throws IOException {
		Map<String, Object> resMap = new HashMap<String, Object>();
		String statusCode = "200", message = "删除成功";
		FileRecord fileRecord = fileRecordManager.get(fileId);
		fileRecordManager.removeById(fileId);
		String filePath = fileRecord.getFilePath();
		FileUtil fileHelper = new FileUtil();
		boolean isDelete = true;
		try {
			fileHelper.deleteFile(filePath);
			if (!isDelete) {
				statusCode = "300";
				message = "删除失败";
			}
		} catch (Exception e) {
			statusCode = "300";
			e.printStackTrace();
		}
		resMap.put("statusCode", statusCode);
		resMap.put("message", message);
		return resMap;
	}

	/**
	 * 附件下载
	 * 
	 * @param fileId
	 *            文件ID
	 * @return 下载
	 * @throws IOException
	 */
	@RequestMapping(method = RequestMethod.GET, value = "fileDownload")
	public void fileDownLoad(String fileId, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		FileRecord fileRecord = fileRecordManager.get(fileId);
		String filePath = fileRecord.getFilePath();
		String fileName = fileRecord.getFileName();
		FileUtil fileHelper = new FileUtil();
		fileHelper.downloadFile(filePath, request, response, fileName);
	}

}
