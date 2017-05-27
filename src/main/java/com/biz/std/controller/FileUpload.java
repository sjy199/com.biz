package com.biz.std.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FileUpload {
	@RequestMapping("/imgUpload")
	@ResponseBody
	public Map<String,String> imgUpload(HttpServletRequest request){
		UUID uuid=UUID.randomUUID();
		
		System.out.println();
		String filename=uuid.toString().replace("-", "")+".jpg";
		String path=request.getSession().getServletContext().getRealPath("/")+"/image";
		Map<String,String> map=new HashMap<String,String>();
		map.put("filename", filename);
		//��ô����ļ���Ŀ����    
        DiskFileItemFactory factory = new DiskFileItemFactory();    
        //���û�����������õĻ����ϴ���� �ļ� ��ռ�� �ܶ��ڴ棬    
        //������ʱ��ŵ� �洢�� , ����洢�ң����Ժ� ���մ洢�ļ� ��Ŀ¼��ͬ    
        /**  
         * ԭ�� �����ȴ浽 ��ʱ�洢�ң�Ȼ��������д�� ��ӦĿ¼��Ӳ���ϣ�   
         * ������˵ ���ϴ�һ���ļ�ʱ����ʵ���ϴ������ݣ���һ������ .tem ��ʽ��   
         * Ȼ���ٽ�������д�� ��ӦĿ¼��Ӳ����  
         */    
        System.out.println(path);
        factory.setRepository(new File(path));    
        //���� ����Ĵ�С�����ϴ��ļ������������û���ʱ��ֱ�ӷŵ� ��ʱ�洢��    
        factory.setSizeThreshold(1024*1024) ;    
        //��ˮƽ��API�ļ��ϴ�����    
        ServletFileUpload upload = new ServletFileUpload(factory);    
          
        try {    
            //�����ϴ�����ļ�    
            List<FileItem> list = upload.parseRequest(request);    
              
            for(FileItem item : list)  {    
                //�����ȡ�� ����Ϣ����ͨ�� �ı� ��Ϣ    
                if(item.isFormField())  {                       
                    //��ȡ�û�����������ַ��� ���������ͦ�ã���Ϊ���ύ�������� �ַ������͵�    
                    String value = item.getString() ;    
                } else{    
                    //�Դ���ķ� �򵥵��ַ������д��� ������˵�����Ƶ� ͼƬ����Ƶ��Щ    
                    /**  
                     * ������������Ҫ��ȡ �ϴ��ļ�������  
                     */    
                    //��ȡ·����    
                    String value = item.getName() ;    
                    //���������һ����б��    
                    int start = value.lastIndexOf("\\");   
                    //����д��������    
                    //���׳����쳣 ��exception ��׽    
                    //item.write( new File(path,filename) );//�������ṩ��    
                    //�ֶ�д��    
                    if(!new File(path).exists()){
                    	System.out.println(new File(path).mkdirs());
                    }
                    File file3=new File(path,filename);
                    System.out.println(file3.getPath());
                    OutputStream out = new FileOutputStream(new File(path,filename));    
                    InputStream in = item.getInputStream() ;    
                    int length = 0 ;    
                    byte [] buf = new byte[1024] ;    
                    // in.read(buf) ÿ�ζ��������ݴ����   buf ������    
                    while( (length = in.read(buf) ) != -1)  {    
                        //��   buf ������ ȡ������ д�� ���������������    
                        out.write(buf, 0, length);      
                    }    
                    in.close();    
                    out.close();    
                }    
            }    
        } catch (FileUploadException e) {    
            return map;
        } catch (Exception e) {    
              return map;
        }    
        return map;  
}
	}
