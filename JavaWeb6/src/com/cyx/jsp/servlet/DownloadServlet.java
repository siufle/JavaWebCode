package com.cyx.jsp.servlet;

import com.cyx.jsp.excel.ExcelUtil;
import com.cyx.jsp.pojo.Student;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
    private static final String DOWNLOAD_DIR = "D:\\";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        File file = new File(DOWNLOAD_DIR, name);
        if (file.exists()) {
            byte[] data = name.getBytes(StandardCharsets.UTF_8);//获取下载的文件名的字节数据
            //转换编码格式，重新构建字符串，因为浏览器默认支持的编码是ISO_8859_1,因此，要转换为这种编码下中文才能正常显示
            name = new String(data, StandardCharsets.ISO_8859_1);
            //设置内容处理方案：以附件的形式处理
            resp.setHeader("Content-Disposition", "attachment;filename="+name);
            InputStream is = new FileInputStream(file);
            OutputStream os = resp.getOutputStream();//获取响应的输出流 这个输出流会将信息输出到页面 从而形成下载的效果
            /*List<Student> students = new ArrayList<>();
            ExcelUtil.writeExcel(os,students,Student.class,"学生信息表");*/
            IOUtils.copy(is, os);
            IOUtils.closeQuietly(is);
            IOUtils.closeQuietly(os);
        }else{
            resp.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter writer = resp.getWriter();
            writer.print("下载文件不存在");
            writer.flush();
            writer.close();
        }
    }
}
