package com.gx.soft.common.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;

public class FileUtil {
	/**
	 * decode文件名，加入时间防止有名字冲突
	 * 
	 * @param fileName
	 * @return
	 */
	public String getDecodeFileName(String fileName) {
		String fileStrName = "";
		if (fileName != null && fileName.length() > 0) {
			String[] filenames = fileName.split("\\.");
			long times = DateUtil.getDate().getTime();
			String fileSuffix = "";
			if (filenames.length == 2) {
				fileSuffix = filenames[1];
			}

			// fileStrName = filenames[0] + times + fileSuffix;
			// fileStrName = UUID.fromString(fileStrName).toString();
			fileStrName = UUID.randomUUID() + "." + fileSuffix;
		}
		return fileStrName;
	}

	// 第一种获取文件内容方式
	public byte[] getContent(String filePath) throws IOException {
		File file = new File(filePath);

		long fileSize = file.length();
		if (fileSize > Integer.MAX_VALUE) {
			System.out.println("file too big...");
			return null;
		}

		FileInputStream fi = new FileInputStream(file);

		byte[] buffer = new byte[(int) fileSize];

		int offset = 0;

		int numRead = 0;

		while (offset < buffer.length

		&& (numRead = fi.read(buffer, offset, buffer.length - offset)) >= 0) {

			offset += numRead;

		}

		// 确保所有数据均被读取

		if (offset != buffer.length) {

			throw new IOException("Could not completely read file "
					+ file.getName());

		}

		fi.close();

		return buffer;
	}

	// 第二种获取文件内容方式
	public byte[] getContent2(String filePath) throws IOException {
		FileInputStream in = new FileInputStream(filePath);

		ByteArrayOutputStream out = new ByteArrayOutputStream(1024);

		System.out.println("bytes available:" + in.available());

		byte[] temp = new byte[1024];

		int size = 0;

		while ((size = in.read(temp)) != -1) {
			out.write(temp, 0, size);
		}

		in.close();

		byte[] bytes = out.toByteArray();
		System.out.println("bytes size got is:" + bytes.length);

		return bytes;
	}

	/**
	 * 将byte数组写入文件
	 * 
	 * @param path
	 * @param content
	 * @throws IOException
	 */
	public void createFile(String path, byte[] content) throws IOException {

		File file = new File(path);
		if (!file.exists()) {// 文件路径不存在，创建
			File pfiles = file.getParentFile();
			pfiles.mkdirs();
			file.createNewFile();
		}
		FileOutputStream fos = new FileOutputStream(file);

		fos.write(content);
		fos.close();
	}

	/**
	 * 删除文件
	 * 
	 * @param filePath
	 *            文件路径
	 */
	/**
	 * 删除文件
	 * 
	 * @param filePath
	 *            文件路径
	 * @return 删除成功true;失败false
	 */
	public boolean deleteFile(String filePath) {
		File file = new File(filePath);
		// 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
		if (file.exists() && file.isFile()) {
			if (!file.delete()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 下载文件
	 * 
	 * @param downLoadPath
	 *            下载路径
	 * @param response
	 * @param fileName
	 *            文件名
	 */
	public void downloadFile(String downLoadPath, HttpServletRequest request,
			HttpServletResponse response, String fileName) {
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			long fileLength = new File(downLoadPath).length();
			/*
			 * response.setContentType("application/x-msdownload;");
			 * response.setHeader("Content-disposition", "attachment; filename="
			 * + fileName);
			 */

			String userAgent = request.getHeader("User-Agent");
			// 针对IE或者以IE为内核的浏览器：
			if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
				fileName = URLEncoder.encode(fileName, "UTF-8");
			} else {
				// 非IE浏览器的处理：
				fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
			}
			response.setHeader("Content-disposition",
					String.format("attachment; filename=\"%s\"", fileName));
			response.setContentType("application/octet-stream;charset=utf-8");
			response.setCharacterEncoding("UTF-8");

			response.setHeader("Content-Length", String.valueOf(fileLength));
			bis = new BufferedInputStream(new FileInputStream(downLoadPath));
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[2048];
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * 下载文件
	 * 
	 * @param downLoadPath
	 *            下载路径
	 * @param response
	 * @param fileName
	 *            文件名
	 */
	public void getFile(String downLoadPath, HttpServletRequest request,
			HttpServletResponse response, String fileName) {

		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			long fileLength = new File(downLoadPath).length();

			String userAgent = request.getHeader("User-Agent");
			// 针对IE或者以IE为内核的浏览器：
			if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
				fileName = URLEncoder.encode(fileName, "UTF-8");
			} else {
				// 非IE浏览器的处理：
				fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
			}
			response.setHeader("Content-disposition",
					String.format("attachment; filename=\"%s\"", fileName));
			response.setContentType("application/octet-stream;charset=utf-8");
			response.setCharacterEncoding("UTF-8");

			response.setHeader("Content-Length", String.valueOf(fileLength));
			bis = new BufferedInputStream(new FileInputStream(downLoadPath));
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[2048];
			int bytesRead;
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
}
