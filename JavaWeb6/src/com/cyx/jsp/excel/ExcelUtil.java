package com.cyx.jsp.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.Listener;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.cyx.jsp.pojo.Student;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtil {

    private static final int MAX_COUNT_PER_SHEET = 5000;

    public static <T> void writeExcel(OutputStream os, List<T> dataList, Class<T> clazz, String sheetName){
        ExcelWriter writer = EasyExcel.write(os, clazz).build();
        int size = dataList.size();
        int sheetCount = size/MAX_COUNT_PER_SHEET;
        if(size%MAX_COUNT_PER_SHEET>0){
            sheetCount++;
        }
        //EasyExcel写excel是必须指定excel存放位置 还需要指定excel的表头与属性的对应关系
        for(int i=0; i<sheetCount; i++){
            int start = i*MAX_COUNT_PER_SHEET;
            int end = (i+1)*MAX_COUNT_PER_SHEET;
            List<T> sheetData = dataList.subList(start, end);
            WriteSheet writeSheet = new WriteSheet();
            writeSheet.setSheetNo(i);
            writeSheet.setSheetName(sheetName + (i+1));
            writer.write(sheetData,writeSheet);
        }
    }

    public static  <T> List<T> readExcel(InputStream is, Class<T> clazz) {
        List<T> dataList = new ArrayList<>();
        ReadListener<T> listener = new ReadListener<T>() {

            @Override
            public void invoke(T t, AnalysisContext analysisContext) {
                dataList.add(t);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                System.out.println("读取完毕");
            }
        };
        //EasyExcel读取excel时需要指定读取的excel位置 还需要指定读取的类型 因为这个类型中就指定了excel表头与类型定义属性
        //的映射关系 还需要指定行的监听器 EasyExcel是按行读取的 这个监听器就是感知一行的读取过程
        EasyExcel.read(is, clazz,listener).doReadAll();
        return dataList;
    }

}
