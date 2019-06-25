package com.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import com.dao.Newsinfofaba_dao;
import com.domain.NewsInfofabu;

/**
 * Servlet implementation class ImagefabuServlet
 */
public class ImagefabuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImagefabuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("ghhhhhhhhh");
		Map<String, String> map = new HashMap<String, String>();
		NewsInfofabu newsinfofabu = new NewsInfofabu();
		try {
			// 设置ContentType字段值
			response.setContentType("text/html;charset=utf-8");
			// 创建DiskFileItemFactory工厂对象
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 设置文件缓存目录，如果该目录不存在则新创建一个
			File f = new File("E:\\eclipexiangmuTempFolder");
			if (!f.exists()) {
				f.mkdirs();
			}
			// 设置文件的缓存路径
			factory.setRepository(f);
			// 创建 ServletFileUpload对象
			ServletFileUpload fileupload = new ServletFileUpload(factory);
			// 设置字符编码
			fileupload.setHeaderEncoding("utf-8");
			// 解析 request，得到上传文件的FileItem对象
			List<FileItem> fileitems = fileupload.parseRequest(request);
			// 获取字符流
			PrintWriter writer = response.getWriter();
			// 遍历集合
			for (FileItem fileitem : fileitems) {
				System.out.println("ghh5555555555555hhhhhhh");
				// 判断是否为普通字段
				if (fileitem.isFormField()) {
					map.put(fileitem.getFieldName(),fileitem.getString("utf-8"));
				} else {
					// 获取上传的文件名
					String filename = fileitem.getName();
					System.out.println("图片原始名称是:" + filename);
					// 处理上传文件
					if (filename != null && !filename.equals("")) {
//						writer.print("上传的文件名称是：" + filename + "<br>");
						// 截取出文件名
						filename = filename.substring(filename.lastIndexOf("\\") + 1);
						// 文件名需要唯一
						filename = UUID.randomUUID().toString() + "_"+ filename;
						// 在服务器创建同名文件
						String webPath = "/picture/";
						String realpath = getServletContext().getRealPath("/picture/");
						System.out.println("真是路径:" + realpath);
						// 将服务器中文件夹路径与文件名组合成完整的服务器端路径
						String filepath = getServletContext().getRealPath(
								webPath + filename);
						// 创建文件
						File file = new File(filepath);
						file.getParentFile().mkdirs();
						file.createNewFile();
						// 获得上传文件流
						InputStream in = fileitem.getInputStream();
						// 使用FileOutputStream打开服务器端的上传文件
						FileOutputStream out = new FileOutputStream(file);
						// 将输入流中数据刷到输出流，并释放资源
						IOUtils.copy(in, out);
						IOUtils.closeQuietly(in);
						IOUtils.closeQuietly(out);
						map.put("imagepath", "/" + webPath + "/" + filename);
						System.out.println("===" + "/" + webPath + "/"+ filename);
					}
				}
				BeanUtils.populate(newsinfofabu, map);
				System.out.println("========得到的照片:"+newsinfofabu.getImagepath());
			}
			Newsinfofaba_dao newimagesdao=new Newsinfofaba_dao();
			int ret_count=newimagesdao.inser_news_images(newsinfofabu);
			if(ret_count==1) {
				 PrintWriter pw = response.getWriter();	
				 
					
//		request.setAttribute("newsinfofabu", newsinfofabu);
//		NewsInfofabu newsfabuget=newimagesdao.getnewsfrom_table();
//		HttpSession session=request.getSession();
//				session.setAttribute("newsfabuget", newsfabuget);
//				System.out.println("========得到的照片路径:"+newsinfofabu.getImagepath());
		//request.getRequestDispatcher("index.jsp").forward(request, response);	
		pw.print("<script language=javascript>alert(`添加信息成功`);window.location.href='index.jsp'</script>");
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
