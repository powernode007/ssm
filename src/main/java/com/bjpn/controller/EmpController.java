package com.bjpn.controller;


import com.bjpn.bean.Emp;
import com.bjpn.service.EmpService;
import com.bjpn.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    EmpService empService;

    @RequestMapping("/delEmp.action")
    public void delEmp(Integer id, HttpServletResponse response) throws IOException {
        empService.deleteOneEmp(id);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("删除成功");

    }

    @RequestMapping("/zhongzhuan.action")
    public String zhongzhuan(Integer id2, HttpServletResponse response, HttpServletRequest request) throws IOException, ServletException {


        return "emp/updateEmp";
    }

    @RequestMapping("/huixian.action")
    public String huixian(Integer id2, HttpSession session, HttpServletRequest request) throws IOException, ServletException {
        System.out.println("123" + id2);
        Emp emp = empService.selectOneEmp(id2);
        System.out.println("emp = " + emp);
        session.setAttribute("emp", emp);
        return "emp/updateEmp";

    }

    @RequestMapping("/update.action")
    public String updateEmp(Emp emp, MultipartFile upImg, HttpServletResponse response, HttpServletRequest request) throws IOException {
        String originalFilename = upImg.getOriginalFilename();
        String fileTypeName = originalFilename.substring(originalFilename.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String fileName = uuid + fileTypeName;
        String path = request.getServletContext().getRealPath("/fileupload");
        upImg.transferTo(new File(path + "/" + fileName));
        emp.setEmpPhoto(fileName);
        boolean b = empService.updateOneEmp(emp);
        if (b) {
            //成功 修改结束  去展示页面
            return "redirect:/emp/toEmpByPage.action";//跳中央处理器让其处理，要list
        } else {
            request.setAttribute("updateError", "修改失败");
            return "emp/updateEmp";
        }

    }

    @RequestMapping("/toAddEmp.action")
    public String toAddEmp() {
        return "emp/addEmp";//添加失败跳着里
    }

    @RequestMapping("/saveEmp.action")//添加员工
    public String saveEmp(Emp emp, MultipartFile upImg, HttpServletRequest request) throws IOException {
        //员工添加  先完成文件上传才能得到头像的图片名称
        String originalFilename = upImg.getOriginalFilename();
        String fileTypeName = originalFilename.substring(originalFilename.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String fileName = uuid + fileTypeName;
        String path = request.getServletContext().getRealPath("/fileupload");
        upImg.transferTo(new File(path + "/" + fileName));
        emp.setEmpPhoto(fileName);
        boolean b = empService.saveEmp(emp);
//        String empName = emp.getEmpName();
//        Double empSal = emp.getEmpSal();
//        for (int i = 0; i < 50; i++) {
//            emp.setEmpName(empName + i);
//            emp.setEmpSal(empSal + i);
//            empService.saveEmp(emp);
//        }
        if (b) {
            //成功 保存结束  去展示页面
            return "redirect:/emp/toEmpByPage.action";//跳中央处理器让其处理，要list
        } else {
            request.setAttribute("saveError", "添加失败");
            return "emp/addEmp";
        }
    }

    @RequestMapping("/toEmpByPage.action")
    public String toEmpByPage(HttpServletRequest request, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize, String likeName) {

        System.out.println(" ");
        //先查询数据库  在展示信息
        //分页需要起始下标和步长
        if (likeName == null) {
            likeName = "";
        }
        //根据总条数  计算总页数
        int count = empService.getCountService(likeName);
        PageUtil pageUtil = PageUtil.pageConfig(pageNum, count);
        List<Emp> allEmp = empService.findAllEmp(pageUtil.getStartIndex(), pageSize, likeName);
        request.setAttribute("pageUtil", pageUtil);
        request.setAttribute("allEmp", allEmp);
        request.setAttribute("likeName", likeName);
        return "emp/emp";
    }
}
