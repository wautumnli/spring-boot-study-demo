package com.ql.util.easyexcel;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;

/**
 * Author： wanqiuli
 * DateTime: 2021/2/20 13:32
 */
public class EasyExcelDemo {

    private static final String PATH = "D:\\wanqiuli\\Downloads";

    public static void main(String[] args) {

        String fileName = "test.xlsx";
        String filePath = PATH + "\\" + fileName;
        // EasyExcel Write需要路径，写入类
        // 写法1
        EasyExcel.write(filePath, User.class).sheet("test").doWrite(getData());
        // 写法2
//        ExcelWriter excelWriter = null;
//        try {
//            excelWriter = EasyExcel.write(filePath, User.class).build();
//            WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
//            excelWriter.write(getData(), writeSheet);
//        } finally {
//            // 千万别忘记finish 会帮忙关闭流
//            if (excelWriter != null) {
//                excelWriter.finish();
//            }
//        }
    }

    public static List<User> getData() {
        List<User> userList = new ArrayList<>();

        User user;
        for (int i = 0; i < 10; i++) {
            user = new User();
            user.setId(i);
            user.setName(i + "号");
            user.setTips(i + "tips");
            userList.add(user);
        }

        return userList;
    }
}
