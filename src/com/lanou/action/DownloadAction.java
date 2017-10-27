package com.lanou.action;

import com.lanou.utils.FIleNameEncoder;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

/**
 * Created by dllo on 17/10/26.
 */
public class DownloadAction extends ActionSupport{
    //变量名不要写成in
    private InputStream inputStream;
    private String fileName;

    public String download(){
        //直接给成员变量inputStream对象赋值,浏览器即可进行下载
        String dirPath = ServletActionContext.getServletContext().getRealPath("files");
        //创建File对象
        File file = new File(dirPath,"你好.jpg");
        fileName = file.getName();
        //对文件名进行编码
        try {
            fileName = FIleNameEncoder.filenameEncoding(fileName,ServletActionContext.getRequest());
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return ERROR;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return SUCCESS;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
