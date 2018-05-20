package cn.tedu.store.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.IUserService;
import cn.tedu.store.service.ex.UsernameAlreadyExistException;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	
	
	@Resource
	private IUserService userService;
	@Resource
	private UserMapper um;
	//显示个人信息的页面
	@RequestMapping("/showPersonInfo.do")
	public String showPersonInfo() {
		return "personInfo";
	}
	// 显示注册页面
	@RequestMapping("/showRegister.do")
	public String showRegist() {
		return "register";
	}

	// 显示登录页面
	@RequestMapping("/showLogin.do")
	public String showLogin() {
		return "login";
	}

	// 显示密码修改页面
	@RequestMapping("/showPassword.do")
	public String showPassword() {
		return "personal_password";
	}

	/**
	 * 检查用户名是否唯一
	 * 
	 * @param username
	 * @return
	 */
	@RequestMapping("/checkUsername.do")
	@ResponseBody
	public ResponseResult<Void> checkUsername(String username) {
		ResponseResult<Void> rr = new ResponseResult<Void>();
		if (userService.checkUsername(username)) {
			rr.setState(0);
			rr.setMessage("用户名已存在，不能使用");
		} else {
			rr.setState(1);
			rr.setMessage("用户名可以使用");
		}
		return rr;
	}

	/**
	 * 检查email是否唯一
	 * 
	 * @param email
	 * @return
	 */
	@RequestMapping("/checkEmail.do")
	@ResponseBody
	public ResponseResult<Void> checkEmail(String email) {
		ResponseResult<Void> rr = new ResponseResult<Void>();
		if (userService.checkEmail(email)) {
			rr.setState(0);
			rr.setMessage("邮箱已存在，不能使用");
		} else {
			rr.setState(1);
			rr.setMessage("邮箱可以使用");
		}
		return rr;
	}

	/**
	 * 检查phone是否唯一
	 * 
	 * @param phone
	 * @return
	 */
	@RequestMapping("/checkPhone.do")
	@ResponseBody
	public ResponseResult<Void> checkPhone(String phone) {
		ResponseResult<Void> rr = new ResponseResult<Void>();
		if (userService.checkPhone(phone)) {
			rr.setState(0);
			rr.setMessage("手机号已存在，不能使用");
		} else {
			rr.setState(1);
			rr.setMessage("手机号可以使用");
		}
		return rr;
	}

	/**
	 * 注册方法
	 * 
	 * @param username
	 * @param password
	 * @param email
	 * @param phone
	 * @return
	 */
	@RequestMapping("/reRegist.do")
	@ResponseBody
	public ResponseResult<Void> register(@RequestParam("uname") String username, @RequestParam("upwd") String password,
			String email, String phone) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setPhone(phone);
		ResponseResult<Void> rr = new ResponseResult<Void>();
		try {
			userService.register(user);
			rr.setMessage("注册成功");
			rr.setState(1);
		} catch (UsernameAlreadyExistException e) {
			// TODO: handle exception
			rr.setMessage("注册失败，可能时用户名已经存在");
			rr.setState(0);
		}
		return rr;
	}

	/**
	 * 登录方法
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping("/login.do")
	@ResponseBody
	public ResponseResult<User> login(@RequestParam("lname") String username, @RequestParam("lwd") String password,
			HttpSession session) {
		ResponseResult<User> rr = new ResponseResult<User>();
		try {
			User user = userService.login(username, password);
			// 登录成功后，user对象存储到session对象中
			session.setAttribute("user", user);
			rr.setMessage("登录成功");
			rr.setState(1);
		} catch (Exception e) {
			rr.setMessage(e.getMessage());
			rr.setState(0);
		}
		return rr;
	}

	@RequestMapping("/exit.do")
	public String exit(HttpSession session) {
		// 清除session
		session.invalidate();
		// return "redirect:../main/showIndex.do";
		return "forward:/main/showIndex.do";
	}

	@RequestMapping("/modifyPassword.do")
	@ResponseBody
	public ResponseResult<Void> modifiedPassword(HttpSession session, String newPassword, String oldPassword) {
		ResponseResult<Void> rr = new ResponseResult<Void>();
		try {
			Integer id = this.getId(session);
			userService.changePassword(id, oldPassword, newPassword);
			rr.setMessage("修改成功");
			rr.setState(1);
		} catch (Exception e) {
			rr.setMessage(e.getMessage());
			rr.setState(0);
		}
		return rr;

	}
	/**
	 * 修改用户基本信息
	 * @param session
	 * @param username
	 * @param phone
	 * @param email
	 * @param gender
	 * @return
	 */
	@RequestMapping("/updateUser.do")
	@ResponseBody
	public ResponseResult<Void> updateUser(HttpSession session,String username,String phone,String email,Integer gender){
		ResponseResult<Void> rr = new ResponseResult<Void>();
		System.out.println(this.getId(session)+ username+gender+ phone+ email);
		try {
			userService.updateUser(this.getId(session), username, gender, phone, email);
			//更新Seesion
			User user = userService.getUserById(this.getId(session));
			session.setAttribute("user", user);
			//添加状态码和消息
			rr.setMessage("修改成功");
			rr.setState(1);
		}catch (Exception e) {
			// TODO: handle exception
			rr.setMessage(e.getMessage());
			rr.setState(0);
		}
		return rr;
	}
	/**
	 * 
	 * @param file
	 * @return
	 */
	@RequestMapping("/upload.do")
	@ResponseBody
	public ResponseResult<Void> upload(HttpSession session, @RequestParam("file") MultipartFile file){
		ResponseResult<Void> rr = new ResponseResult<Void>();
		try {
			//获取服务器的真实路径
			String path =  session.getServletContext().getRealPath("/");
			System.out.println(path);
			file.transferTo(new File(path,"/upload/"+file.getOriginalFilename()));
			userService.updataImageById("/upload/"+file.getOriginalFilename(), this.getId(session));
			User u = userService.getUserById(this.getId(session));
			session.setAttribute("user", u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rr.setMessage("上传失败，请重新上传，或者联系后台管理员");
			rr.setState(0);
		}
		rr.setMessage("上传成功");
		rr.setState(1);
		return rr;
	}
	@RequestMapping(value="/image.do",produces="image/png")
	@ResponseBody
	public byte[] image(HttpServletResponse response,HttpSession session) throws UnsupportedEncodingException {
		//@Responsenody 与 byte[] 配合时， Spring MVC 会将byte[] 数组填充到响应的消息正文中，发送到浏览器
		
		//还需要添加两个响应头
//		Content-Type
//		Content-Disposition:attachment;filename:"001.png"
//		相应的头部只能是iso8859-1的方式编码
		String file = URLEncoder.encode("404.html","iso8859-1");
//		添加下载所需要的响应头
//		response.setContentType("image/png");
//		html
		response.setContentType("text/html");
//		excel
//		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		
		response.setHeader("Content-Disposition", "attachment;filename=\""+file+"\"");
//		byte[] body = creteImage();
		byte[] body = creteFile(session);
		return body;
	}
	
//	读取文件
	private byte[] creteFile(HttpSession session) {
		//TODO Auto-generated method stub
		InputStream in = null;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			//获取服务器的真实路径
			String path = session.getServletContext().getRealPath("/");
			in = new FileInputStream(path+"/web/404.html");
			byte[] buf = new byte[2014*8];
			int length = 0;
			while((length = in.read(buf)) != -1) {
				out.write(buf, 0, length);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				out.close();
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return out.toByteArray();
	}
//	生成图片
	private byte[] creteImage() {
		// TODO Auto-generated method stub
		BufferedImage img = new BufferedImage(100, 50, BufferedImage.TYPE_3BYTE_BGR);
		img.setRGB(50,25, 0Xffffff);
//		out相当于 byte[] 数组容器 （内存操作比写入文件 操作快的多）
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			ImageIO.write(img, "png", out);
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] bytes = out.toByteArray();
		return bytes;
	}
//	下载Excel
	@RequestMapping("/excel.do")
	@ResponseBody
	public byte[] export(HttpServletResponse response,HttpSession session) {
		//excel
		//	相应的头部只能是iso8859-1的方式编码
		try {
			String file = URLEncoder.encode("表格.xlsx","utf-8");
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition","attachment;filename=\""+file+"\"");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] body = createExcel(session);
		return body;
		
	}
	 private byte[] createExcel(HttpSession session) {
		 InputStream in = null;
		 String path = session.getServletContext().getRealPath("/");
		 //一个Workbook代表一个excel文件
		 XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(new File(path+"/model/model.xlsx"));
		} catch (InvalidFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 //在工作簿中创建一个工作表(Shoot)
//		 XSSFSheet sheet = workbook.createSheet("Sheet1");
		//在工作簿中添加一个工作表(Shoot)
		 XSSFSheet sheet = workbook.getSheet("Sheet1");
		 sheet.setColumnWidth(1, 6000);
		 sheet.setColumnWidth(2, 10000);
		 sheet.autoSizeColumn(3,true);
	
		 XSSFCellStyle cellStyle = workbook.createCellStyle();
		 short color = 6;
		 cellStyle.setBottomBorderColor(color);
		 //在工作表中创建一行(Row) 参数时行号 ： 0，1，2，3
		 XSSFRow row = sheet.createRow(0);
		 //在行中可以添加格子（cell） 参数时列号 0，1，2
		 String[] fields = {"id","name","password","email","phone"};
		 for(int i = 0;i<fields.length;i++) {
			 row.createCell(i).setCellValue(fields[i]);
		 }
		 List<User> userList = um.selectAll();
		 for(int i = 0;i<userList.size();i++) {
			 User user = userList.get(i);
			 XSSFRow rowTag = sheet.createRow(i+1);
			 rowTag.createCell(0).setCellValue(user.getId());
			 rowTag.createCell(1).setCellValue(user.getUsername());
			 rowTag.createCell(2).setCellValue(user.getPassword());
			 rowTag.createCell(3).setCellValue(user.getEmail());
			 rowTag.createCell(4).setCellValue(user.getPhone());
		 }
			
		/* XSSFCell cell = row.createCell(0);
		 cell.setCellValue("id");*/
		 
		 ByteArrayOutputStream out = new ByteArrayOutputStream();
		 try {
			workbook.write(out);
			out.close();
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return out.toByteArray();
	 }
	 
}
