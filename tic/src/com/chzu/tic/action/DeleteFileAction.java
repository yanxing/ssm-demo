package com.chzu.tic.action;

import org.apache.struts2.ServletActionContext;

import com.chzu.tic.model.File;

public class DeleteFileAction extends TeacherBaseAction {

	private static final long serialVersionUID = 1L;
	
	public String execute()throws Exception{
		String idString=ServletActionContext.getRequest().getParameter("file.id");
		Integer id = Integer.parseInt(idString);
		File file = teacherService.getFile(id);
		deleteDiskFile(file.getPath());//先删除磁盘记录
		teacherService.deleteFile(id);//再删除数据库中记录
		return SUCCESS;
	}
	
   //删除磁盘上文件
	public Boolean deleteDiskFile(String filePath){
		java.io.File file = new java.io.File(filePath);     
        if(file.exists()){     
            if(file.delete()){
            	return true;
            }
            else {
				return false;
			}
        }
           return true;
	}
}
