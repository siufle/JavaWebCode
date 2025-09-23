package com.cyx.jsp.servlet;

import com.cyx.jsp.excel.ExcelUtil;
import com.cyx.jsp.pojo.Student;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@WebServlet("/upload")
public class UploadServlet extends HttpServlet {

    private static final String SAVE_DIR = "D:\\java_code\\javaWeb\\JavaWeb6\\upload";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(ServletFileUpload.isMultipartContent(req)){ //是文件上传请求
            DiskFileItemFactory factory = new DiskFileItemFactory();//创建一个磁盘文件项工厂
            factory.setDefaultCharset("UTF-8");//设置字符集编码
            factory.setRepository(new File("java.io.tmpdir"));//设置临时文件存储地址
            factory.setSizeThreshold(4 * 1024 * 1024);//设置上传文件最大大小为4M 超过这个大小则存在临时文件存储文件夹中
            ServletFileUpload upload = new ServletFileUpload(factory);//创建文件项上传的对象
            upload.setFileSizeMax(5 * 1024 * 1024);//设置每个文件上传的大小最大为5M
            upload.setSizeMax(50 * 1024 * 1024);//设置每次上传文件的总大小最大为50M
            upload.setHeaderEncoding("UTF-8");
            try {
                List<FileItem> items = upload.parseRequest(req);//开始解析请求 得到文件项
                for (FileItem item : items) {
                    if (item.isFormField()) {//是普通的表单字段
                        //打印参数名和参数值
                        System.out.println(item.getFieldName() + "=>" + item.getString());
                    }else{//不是表单字段 则说明是上传的文件
                        File dir = new File(SAVE_DIR);
                        if (!dir.exists()) {
                            dir.mkdirs();
                        }
                        File saveFile = new File(dir,item.getName());
                        InputStream is = item.getInputStream();
                        //List<Student> students = ExcelUtil.readExcel(is, Student.class);
                        OutputStream os = new FileOutputStream(saveFile);
                        //将输入流的数据拷贝到输出流中
                        IOUtils.copy(is, os);
                        IOUtils.closeQuietly(is);
                        IOUtils.closeQuietly(os);
                    }
                }
                resp.setCharacterEncoding("UTF-8");
                resp.setContentType("text/html;charset=utf-8");
                resp.getWriter().print("上传成功");
            } catch (FileUploadException e) {
                e.printStackTrace();
                resp.setCharacterEncoding("UTF-8");
                resp.setContentType("text/html;charset=utf-8");
                resp.getWriter().print("上传失败");
            }
        }else{//抛出运行间异常
            throw new RuntimeException("请求头中未发现multipart/form-data");
        }
    }
}
