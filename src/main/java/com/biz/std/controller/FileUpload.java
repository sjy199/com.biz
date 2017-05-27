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
		//获得磁盘文件条目工厂    
        DiskFileItemFactory factory = new DiskFileItemFactory();    
        //如果没以下两行设置的话，上传大的 文件 会占用 很多内存，    
        //设置暂时存放的 存储室 , 这个存储室，可以和 最终存储文件 的目录不同    
        /**  
         * 原理 它是先存到 暂时存储室，然后在真正写到 对应目录的硬盘上，   
         * 按理来说 当上传一个文件时，其实是上传了两份，第一个是以 .tem 格式的   
         * 然后再将其真正写到 对应目录的硬盘上  
         */    
        System.out.println(path);
        factory.setRepository(new File(path));    
        //设置 缓存的大小，当上传文件的容量超过该缓存时，直接放到 暂时存储室    
        factory.setSizeThreshold(1024*1024) ;    
        //高水平的API文件上传处理    
        ServletFileUpload upload = new ServletFileUpload(factory);    
          
        try {    
            //可以上传多个文件    
            List<FileItem> list = upload.parseRequest(request);    
              
            for(FileItem item : list)  {    
                //如果获取的 表单信息是普通的 文本 信息    
                if(item.isFormField())  {                       
                    //获取用户具体输入的字符串 ，名字起得挺好，因为表单提交过来的是 字符串类型的    
                    String value = item.getString() ;    
                } else{    
                    //对传入的非 简单的字符串进行处理 ，比如说二进制的 图片，视频这些    
                    /**  
                     * 以下三步，主要获取 上传文件的名字  
                     */    
                    //获取路径名    
                    String value = item.getName() ;    
                    //索引到最后一个反斜杠    
                    int start = value.lastIndexOf("\\");   
                    //真正写到磁盘上    
                    //它抛出的异常 用exception 捕捉    
                    //item.write( new File(path,filename) );//第三方提供的    
                    //手动写的    
                    if(!new File(path).exists()){
                    	System.out.println(new File(path).mkdirs());
                    }
                    File file3=new File(path,filename);
                    System.out.println(file3.getPath());
                    OutputStream out = new FileOutputStream(new File(path,filename));    
                    InputStream in = item.getInputStream() ;    
                    int length = 0 ;    
                    byte [] buf = new byte[1024] ;    
                    // in.read(buf) 每次读到的数据存放在   buf 数组中    
                    while( (length = in.read(buf) ) != -1)  {    
                        //在   buf 数组中 取出数据 写到 （输出流）磁盘上    
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
