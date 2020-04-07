package bbs.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.servlet4preview.http.HttpServletMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import bbs.model.Users;

@Controller
public class indexController2 {

	@RequestMapping(value = "login")
	public String login() {
		//使用转发，直接返回页面
		return "login";
		//System.out.println("登陆成功");
		//重定向
		//return "redirect:index1";
	}
	@RequestMapping(value = "login",method = RequestMethod.POST)
	public String login(Users u1,ModelMap mm,HttpSession session) {
	if (u1.getAccount().equals("stevenzhang")&& u1.getPassword().equals("1908")) {
		u1.setName("张康阳");
		session.setAttribute("Users", u1);
		System.out.println("登录成功！！");
		return "redirect:index1";
	}else {
		mm.addAttribute("msg", "账号或密码又错误");
		return "login";
	}
	}
	
//	@RequestMapping(value = "login",method = RequestMethod.POST)
//	public ModelAndView login1(Users u1) {
//		ModelAndView mv=new ModelAndView();
//		if (u1.getAccount().equals("stevenzhang")&& u1.getPassword().equals("1908")) {
//			System.out.println("登录成功！！");
//			mv.setViewName("redirect:index1");
//			return  mv;
//		}else {
//			mv.addObject("msg", "账号或密码错误");
//			return mv;
//		}
//	}
	
	@RequestMapping(value = "index1",method = RequestMethod.GET)
	public String index() {
		//WEB-INF/index1.jsp 视图解析器拼接
		return "index1";
	}
	
	@RequestMapping(value = "index2")
	public String index2(String userid) {
	System.out.println("userid="+ userid);
	return "redirect:/index1";	
	}
	
	@RequestMapping(value = "index3")
	public String index3(@RequestParam("acc") String account) {
	System.out.println("account="+ account);
	return "redirect:/index1";	
	}
	
	//文件的上传
	@RequestMapping(value = "index4",method = RequestMethod.POST)
	public String index4(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest req) throws IllegalStateException, IOException {
		// 获取文件存储路径（绝对路径）
	    String path = req.getServletContext().getRealPath("/upload");
	    //D:\javaproject\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\TestMybatis/upload
	    //System.out.println(path);
	    
	    //获取原始文件名
	    String originalFilename = file.getOriginalFilename();
	    //生成文件名
	    long l=System.currentTimeMillis();//系统时间
	    //获取后缀
	    String suffix=originalFilename.substring(originalFilename.indexOf("."));
	    String newFileName=path+"\\"+l+suffix;
	    file.transferTo(new File(newFileName));
		return "redirect:/index1";	
	}
	
	//多文件的上传
	@RequestMapping(value = "index5",method = RequestMethod.POST)
	public String index5(@RequestParam("file") CommonsMultipartFile[] file, HttpServletRequest req) throws IllegalStateException, IOException {
		String path = req.getServletContext().getRealPath("/upload");
		for(CommonsMultipartFile ele:file) {
		String filename = ele.getOriginalFilename();
		ele.transferTo(new File(path+"\\"+filename));
		}
		return "redirect:/index1";	
		}
	
	@RequestMapping(value = "index6/{id}/get" ,method = RequestMethod.GET)
	public String index6(@PathVariable  String id) {
		System.out.println("id="+id);
		return "redirect:/index1";	
	}
	
	@RequestMapping(value = "index7" ,method = RequestMethod.GET)
	@ResponseBody
	public List<Users> index7() {
		List<Users> list=new ArrayList<Users>();
		Users u1=new Users();
		u1.setAccount("123");
		u1.setName("123");
		u1.setPassword("123");		
		Users u2=new Users();
		u2.setAccount("1234");
		u2.setName("1234");
		u2.setPassword("1234");	
		
		list.add(u2);
		list.add(u1);
		return list;
	}
	
	@RequestMapping(value = "time" )
	public String time() {
		
		return "/time" ;
	}
	}
