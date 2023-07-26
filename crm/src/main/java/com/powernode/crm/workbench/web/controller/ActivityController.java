package com.powernode.crm.workbench.web.controller;

import com.powernode.crm.commons.constants.Constants;
import com.powernode.crm.commons.domain.ReturnObject;
import com.powernode.crm.commons.utils.DateUtils;
import com.powernode.crm.commons.utils.HSSFUtil;
import com.powernode.crm.commons.utils.UUIDUtils;
import com.powernode.crm.settings.domain.User;
import com.powernode.crm.settings.service.UserService;
import com.powernode.crm.workbench.domain.Activity;
import com.powernode.crm.workbench.domain.ActivityRemark;
import com.powernode.crm.workbench.service.ActivityRemarkService;
import com.powernode.crm.workbench.service.ActivityService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.ExcelGeneralNumberFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.*;

@Controller
public class ActivityController {
    @Autowired
    UserService userService;

    @Autowired
    ActivityService activityService;

    @Autowired
    ActivityRemarkService activityRemarkService;

    @RequestMapping("/workbench/activity/index.do")
    public String index(HttpServletRequest request){
        List<User> userList = userService.queryAllUsers();


        request.setAttribute("userList", userList);

        // 请求转发到市场活动主页面
        return "workbench/activity/index";
    }


    @RequestMapping("/workbench/activity/saveCreateActivity.do")
    @ResponseBody // 返回的是json字符串给ajax，所以要加 @ResponseBody，这样就自动生成json字符串
    public Object saveCreateActivity(Activity activity, HttpSession session) {
        User user = (User) session.getAttribute(Constants.SESSION_USER);
        // 封装参数
        activity.setId(UUIDUtils.getUUID());
        activity.setCreateTime(DateUtils.formatDateTime(new Date()));
        activity.setCreateBy(user.getId());

        ReturnObject returnObject = new ReturnObject();
        try {
            // 调用service方法，保存创建的市场活动
            int ret = activityService.saveCreateActivity(activity);
            if (ret > 0) {
                returnObject.setCode(Constants.RETURN_OBJECT_CODE_SUCCESS);
            } else {
                returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("系统忙，请稍后重试...");
            }
        } catch (Exception e) {
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("系统忙，请稍后重试...");
        }
        return returnObject;
    }

    @RequestMapping("/workbench/activity/queryActivityByConditionForPage.do")
    @ResponseBody
    public Object queryActivityByConditionForPage(String name, String owner, String startDate, String endDate, int pageNo, int pageSize) {
        // 封装参数
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("owner", owner);
        map.put("startDate", startDate);
        map.put("endDate", endDate);
        map.put("beginNo", (pageNo - 1) * pageSize);
        map.put("pageSize", pageSize);

        // 调用service层方法，查询数据
        List<Activity> activityList = activityService.queryActivityByConditionForPage(map);
        int totalRows = activityService.queryCountOfActivityByCondition(map);

        // 根据查询结果，生成响应信息
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("activityList", activityList);
        resultMap.put("totalRows", totalRows);

        return resultMap;
    }

    @RequestMapping("/workbench/activity/deleteActivityIds.do")
    @ResponseBody
    public Object deleteActivityIds(String[] id) {

        ReturnObject returnObject = new ReturnObject();
        try {
            int ret = activityService.deleteActivityByIds(id);
            if (ret > 0) {
                returnObject.setCode(Constants.RETURN_OBJECT_CODE_SUCCESS);
            } else {
                returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("系统忙，请稍后重试...");
            }

        } catch (Exception e) {
            e.printStackTrace();
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("系统忙，请稍后重试...");
        }
        return returnObject;
    }


    @RequestMapping("/workbench/activity/queryActivityById.do")
    @ResponseBody
    public Object queryActivityById(String id) {
        Activity activity = activityService.queryActivityById(id);
        return activity;
    }

    @RequestMapping("/workbench/activity/saveEditActivity.do")
    @ResponseBody
    public Object saveEditActivity(Activity activity, HttpSession session){

        User user = (User) session.getAttribute(Constants.SESSION_USER);
        // 封装参数
        activity.setEditTime(DateUtils.formatDateTime(new Date()));
        activity.setEditBy(user.getId());

        ReturnObject returnObject = new ReturnObject();
        try {
            // 调用service层方法
            int ret = activityService.saveEditActivity(activity);
            if (ret > 0) {
                returnObject.setCode(Constants.RETURN_OBJECT_CODE_SUCCESS);
            } else {
                returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
                returnObject.setMessage("系统忙，请稍后再试...");
            }

        } catch (Exception e) {
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("系统忙，请稍后再试...");
            e.printStackTrace();
        }

        return returnObject;
    }

    @RequestMapping("/workbench/activity/fileDownload.do")
    public void fileDownload(HttpServletResponse response) throws Exception {
        // 返回excel文件

        //1. 设置响应类型
        //response.setContentType("text/html;charset=UTF-8");
        response.setContentType("application/octet-stream;charset=UTF-8");

        //2. 获取输出流
        // PrintWriter writer = response.getWriter(); // 字符流
        ServletOutputStream outputStream = response.getOutputStream(); // 字节流


        // 浏览器默认是直接在显示窗口中打开文件，只有实在打不开，才会激活下载功能
        // 可以设置响应头信息，使浏览器接收到响应信息之后，直接激活文件下载窗口
        response.addHeader("Content-Disposition", "attachment;filename=studentList.xls");


        //3. 获取输入流，读取磁盘文件
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Admin\\Documents\\Student\\stu.xls");
        byte[] buffer = new byte[256];
        int len = 0;

        //4. 一边读取文件，一边写出文件，读完了也写完了
        while ((len=fileInputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, len);
        }

        //5. 关闭资源
        fileInputStream.close();
        outputStream.flush();
    }

    @RequestMapping("/workbench/activity/exportAllActivities.do")
    public void exportAllActivities(HttpServletResponse response) throws Exception {
        List<Activity> activityList = activityService.queryAllActivities();
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("市场活动列表");
        HSSFRow row = sheet.createRow(0);
        HSSFCell cell = row.createCell(0);
        cell.setCellValue("ID");
        cell = row.createCell(1);
        cell.setCellValue("所有者");
        cell = row.createCell(2);
        cell.setCellValue("名称");
        cell = row.createCell(3);
        cell.setCellValue("开始日期");
        cell = row.createCell(4);
        cell.setCellValue("结束日期");
        cell = row.createCell(5);
        cell.setCellValue("成本");
        cell = row.createCell(6);
        cell.setCellValue("描述");
        cell = row.createCell(7);
        cell.setCellValue("创建时间");
        cell = row.createCell(8);
        cell.setCellValue("创建者");
        cell = row.createCell(9);
        cell.setCellValue("修改时间");
        cell = row.createCell(10);
        cell.setCellValue("修改者");

        Activity activity;

        if (activityList != null && activityList.size() > 0) {
            for (int i = 0; i < activityList.size(); i++) {
                activity = activityList.get(i);

                row = sheet.createRow(i + 1);

                cell = row.createCell(0);
                cell.setCellValue(activity.getId());
                cell = row.createCell(1);
                cell.setCellValue(activity.getOwner());
                cell = row.createCell(2);
                cell.setCellValue(activity.getName());
                cell = row.createCell(3);
                cell.setCellValue(activity.getStartDate());
                cell = row.createCell(4);
                cell.setCellValue(activity.getEndDate());
                cell = row.createCell(5);
                cell.setCellValue(activity.getCost());
                cell = row.createCell(6);
                cell.setCellValue(activity.getDescription());
                cell = row.createCell(7);
                cell.setCellValue(activity.getCreateTime());
                cell = row.createCell(8);
                cell.setCellValue(activity.getCreateBy());
                cell = row.createCell(9);
                cell.setCellValue(activity.getEditTime());
                cell = row.createCell(10);
                cell.setCellValue(activity.getEditBy());
            }
        }



        // -------------- 方法一：先写到磁盘，再将磁盘数据发送到用户的浏览器

        // 这里先把文件保存到web server的目录下
//        OutputStream os = new FileOutputStream("C:\\Users\\Admin\\Documents\\ServerDir\\activityList.xls");
//        wb.write(os);
//
//        os.close();
//        wb.close();
//
//        // 再把文件下载到用户的电脑
//        response.setContentType("application/octet-stream;charset=UTF-8");
//        response.addHeader("Content-Disposition", "attachment;filename=activityList.xls");
//        ServletOutputStream out = response.getOutputStream();
//        FileInputStream is = new FileInputStream("C:\\Users\\Admin\\Documents\\ServerDir\\activityList.xls");
//
//        byte[] buffer = new byte[256];
//        int len = 0;
//        while ((len=is.read(buffer)) != -1) {
//            out.write(buffer, 0, len);
//        }
//
//        is.close();
//        out.flush();



        // -------------- 方法二：直接将wb的数据发送给用户的浏览器，从内存到内存，不经过磁盘

        response.setContentType("application/octet-stream;charset=UTF-8");
        response.addHeader("Content-Disposition", "attachment;filename=activityList.xls");
        ServletOutputStream out = response.getOutputStream();

        wb.write(out);

        wb.close();
        out.flush();

    }

    public Object fileUpload(String userName, MultipartFile myFile) throws Exception {
        System.out.println("userName=" + userName);
        String originalFilename=myFile.getOriginalFilename();
        File file = new File("C:\\Users\\Admin\\Documents\\ServerDir", originalFilename);
        myFile.transferTo(file);

        ReturnObject returnObject = new ReturnObject();
        returnObject.setCode(Constants.RETURN_OBJECT_CODE_SUCCESS);
        returnObject.setMessage("上传成功");
        return returnObject;
    }


    @RequestMapping("/workbench/activity/importActivity.do")
    @ResponseBody
    public Object importActivity(MultipartFile activityFile, String userName, HttpSession session) {
        System.out.println(userName);

        User user = (User) session.getAttribute(Constants.SESSION_USER);
        ReturnObject returnObject = new ReturnObject();
        try {
            // 方法一： 把接受的excel文件，先写到server的磁盘，再从磁盘读取成workbook
            // String originalFilename = activityFile.getOriginalFilename();
            // File file = new File("C:\\Users\\Admin\\Documents\\ServerDir\\", originalFilename);
            // activityFile.transferTo(file);

            // 解析excel文件，并封装成activityList
            // InputStream is = new FileInputStream("C:\\Users\\Admin\\Documents\\ServerDir\\"+ originalFilename);
            // HSSFWorkbook wb = new HSSFWorkbook(is);

            // 方法2：从内存到内存，从文件直接到workbook
            InputStream is = activityFile.getInputStream();
            HSSFWorkbook wb = new HSSFWorkbook(is);

            HSSFSheet sheet = wb.getSheetAt(0);

            HSSFRow row = null;
            HSSFCell cell = null;
            Activity activity;
            List<Activity> activityList = new ArrayList<>();

            for (int i = 1; i < sheet.getLastRowNum(); i++) {
                row = sheet.getRow(i);

                activity = new Activity();
                activity.setId(UUIDUtils.getUUID());
                activity.setOwner(user.getId());
                activity.setCreateTime(DateUtils.formatDateTime(new Date()));
                activity.setCreateBy(user.getId());

                for (int j = 0; j < row.getLastCellNum(); j++) {
                    cell = row.getCell(j);
                    String cellValue = HSSFUtil.getCellValueForStr(cell);
                    if (j == 0) {
                        activity.setName(cellValue);
                    } else if (j == 1) {
                        activity.setStartDate(cellValue);
                    } else if (j == 2) {
                        activity.setEndDate(cellValue);
                    } else if (j == 3) {
                        activity.setCost(cellValue);
                    } else if (j == 4) {
                        activity.setDescription(cellValue);
                    }
                }

                activityList.add(activity);
            }

            int ret = activityService.saveCreateActivityListBy(activityList);
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_SUCCESS);
            returnObject.setRetData(ret);
        } catch (Exception e) {
            e.printStackTrace();
            returnObject.setCode(Constants.RETURN_OBJECT_CODE_FAIL);
            returnObject.setMessage("系统忙，请稍后再试...");
        }

        return returnObject;
    }


    @RequestMapping("/workbench/activity/detailActivity.do")
    public String detailActivity(String id, HttpServletRequest request){
        // 调用service层方法
        Activity activity = activityService.queryActivityForDetailById(id);
        List<ActivityRemark> activityRemarks = activityRemarkService.queryActivityRemarkForDetailByActivityId(id);

        // 数据保存到request作用域
        request.setAttribute("activity", activity);
        request.setAttribute("remarkList", activityRemarks);

        return "workbench/activity/detail";
    }

}
