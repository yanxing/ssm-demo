package com.chzu.tic.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class UploadAction extends TeacherBaseAction{

	private static final long serialVersionUID = 1L;
	private File content;// 文件内容
	// 封装上传文件content的类型属性(ContentType)和文件名属性(FileName)
	private String contentContentType;
	private String contentFileName;
	private String savePath;// 上传文件的保存路径，在struts.xml配置相对路径
	// 处理登录后的提示信息
    private String tip;
    com.chzu.tic.model.File ticFile=new com.chzu.tic.model.File();
	public File getContent() {
		return content;
	}

	public void setContent(File content) {
		this.content = content;
	}

	public String getContentContentType() {
		return contentContentType;
	}

	public void setContentContentType(String contentContentType) {
		this.contentContentType = contentContentType;
	}

	public String getContentFileName() {
		return contentFileName;
	}

	public void setContentFileName(String contentFileName) {
		this.contentFileName = contentFileName;
	}

	/**
	 * @return 上传文件放在d盘upload目录， 加上struts.xml配置文件savePath的值
	 */
	public String getSavePath() {
		String directory = "D:"+"\\"+savePath;
		File file=new File("D:\\upload");
		  if (!(file.exists())&&!(file.isDirectory())) {//如果upload文件夹不存在
            file.mkdirs();//创建upload文件夹
	}
		return directory;
	}

	/**
	 * 接收struts.xml配置文件中保存文件的相对路径
	 * 
	 * @param savePath
	 *            struts.xml中配置的保存文件路径savePath的值
	 */
	public void setSavePath(String savePath) {
		this.savePath = savePath;
		
	} 
	
	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
	
	/**
	 * 
	 * 验证用户上传的文件是否存在
	 */
	public Boolean exit(){
		if(teacherService.exit(getContentFileName())){//文件已存在
			setTip("相同文件名已存在！");
			return true;
		}
		else {
			return false;
		}
	}
	 
	public String execute() throws Exception {
		if(exit()){
			return "input";
		}
		// 把上传的文件写入到upload文件夹下
		FileOutputStream fos = new FileOutputStream(getSavePath() + "\\"
				+ getContentFileName());
		FileInputStream fis = new FileInputStream(getContent());
		byte[] butter = new byte[1024];
		int len = 0;
		while ((len = fis.read(butter)) > 0) {
			fos.write(butter, 0, len);
		}
		fos.close();
		fis.close();
		ticFile.setName(getContentFileName());
		ticFile.setPath(getSavePath()+"\\"+getContentFileName());
		teacherService.upload(ticFile);
		return "success";
	}
	
	/**
	 * 文件大小大于struts.xml全局上传的文件大小，
	 * 将对参数maximumSize注入失败，即在upload.jsp不能显示上传的文件最大为40M提示
	 * 重写addActionError方法目的解决struts.xml对内置参数maximumSize可能注入失败
	 * 另外，在jsp页面会重复提示两次错误信息，原因是用了fileUpload拦截器，又用了默认拦截器
	 * 不用默认拦截器，收到文件的将为null
	 * @param anErrorMessage
	 *            添加文件大小大于struts.xml全局上传的文件大小错误信息
	 */
	@Override
	public void addActionError(String anErrorMessage) {
			//从国际化里取值,网上是说文件过大(超过全局文件上传大小)错误信息是
		    //以the request was rejected because its size开头
		    //发现是以Request exceeded allowed size limit开头
			if (anErrorMessage
					.startsWith("Request exceeded allowed size limi")) {
				super.addActionError(getText("struts.multipart.maxSize.limit"));
			} else {
				super.addActionError(anErrorMessage);
			}
	}

}
