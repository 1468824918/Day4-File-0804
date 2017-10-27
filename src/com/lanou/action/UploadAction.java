package com.lanou.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.IOException;

/**
 * Created by dllo on 17/10/26.
 */
    public class UploadAction extends ActionSupport{

    //获取上传过来的文件
    //定义File对象,变量名为表单数据提交时name属性
    private File photo;
    //获取真实上传名字
    //变量名固定格式:xxxFileName
    private String photoFileName;
    //获得上传文件的文件类型(MIME)
    private String photoContentType;

    @Override
    public void validate() {
        super.validate();
        if (photo == null){
            addFieldError("photo","请选择文件");
        }
    }

    public String upload(){
        //获取一个通用路径(同时适用于开发和部署环境)
        //路径 目录 文件
        String dirPath = ServletActionContext.getServletContext().getRealPath("files");
        File dir = new File(dirPath);
        //如果该目录不存在则新建目录
        if (!dir.exists()){
            dir.mkdirs();
        }
        //根据上传过来的文件名新建一个空的文件
        File file = new File(dir,photoFileName);
        //新建文件
        if (file.exists()){
            file.delete();
        }
        try {
            file.createNewFile();
            //将上传过来的文件copy到新的文件
            FileUtils.copyFile(photo,file);
        } catch (IOException e) {
            e.printStackTrace();
            return ERROR;
        }

        return SUCCESS;
    }

    public File getPhoto() {
        return photo;
    }

    public void setPhoto(File photo) {
        this.photo = photo;
    }

    public String getPhotoFileName() {
        return photoFileName;
    }

    public void setPhotoFileName(String photoFileName) {
        this.photoFileName = photoFileName;
    }

    public String getPhotoContentType() {
        return photoContentType;
    }

    public void setPhotoContentType(String photoContentType) {
        this.photoContentType = photoContentType;
    }
}
