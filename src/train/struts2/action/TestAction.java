package train.struts2.action;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import train.struts2.domain.User;

import com.opensymphony.xwork2.ActionSupport;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@SuppressWarnings("serial")
public class TestAction extends ActionSupport implements ServletRequestAware {
	List<User> userList = new ArrayList<User>();
	Map<String, Object> map = new HashMap<String, Object>();
	HttpServletRequest request;

	@Override
	public String execute() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (int i = 1; i <= 20; i++) {
			User user = new User(i, "test" + i, sdf.parse("2001-02-03 04:05:06" + i * 100000), 0 == i % 3 ? false : true);
			userList.add(user);
		}
		
		// 生成静态文件
		generateHTML(userList, request.getServletContext());
		
		return SUCCESS;
	}
	
	/**
	 * Generate HTML File
	 * 
	 * @throws Exception
	 */
	private void generateHTML(List<User> userList, ServletContext servletContext) throws Exception {
		map.put("userList", userList);
		generateHTML("WEB-INF/ftl/user", "UserList.ftl", "UserList.html", map, servletContext);
	}
	
	/**
	 * 生成纯静态的HTML文件
	 * 
	 * @param folderName 文件夹名称
	 * @param ftl FTL文件
	 * @param htmlName HTML文件名
	 * @param map Key-Value数据
	 * @throws IOException
	 * @throws TemplateException
	 */
	public static void generateHTML(String folderName, String ftl, String htmlName, Map<String, Object> map, ServletContext servletContext) throws IOException, TemplateException {
		Configuration cfg = new Configuration();
		cfg.setServletContextForTemplateLoading(servletContext, File.separator + folderName);
		cfg.setEncoding(Locale.getDefault(), "UTF-8");
		Template template = cfg.getTemplate(ftl);
		template.setEncoding("UTF-8");
		String path = servletContext.getRealPath("/");
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path + htmlName));
		File htmlFile = new File(path + htmlName);
		Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(htmlFile), "UTF-8"));
		// map.put("JspTaglibs", new TaglibFactory(servletContext));
		template.process(map, out);
		bufferedWriter.close();
		out.flush();
		out.close();
	}

	@Override
	public void setServletRequest(HttpServletRequest httpServletRequest) {
		this.request = httpServletRequest;
	}
	
	public List<User> getUserList() {
		return userList;
	}

}
