package filter;


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class EncodingFilter implements Filter {
	public void init(FilterConfig filterConfig) throws ServletException {
	}
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		// �������е����� ���ȫվ��������
		// ָ�� request �� response �ı���
		request.setCharacterEncoding("utf-8"); // ֻ����Ϣ����Ч
		response.setContentType("text/html;charset=utf-8");
		// ��request���а�װ
		CharacterRequest characterRequest = new CharacterRequest(request);
		chain.doFilter(characterRequest, response);
	}
	public void destroy() {
	}
}
// �̳� Ĭ�ϰ�װ��HttpServletRequestWrapper
class CharacterRequest extends HttpServletRequestWrapper {
	private HttpServletRequest request;
	public CharacterRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}
	// ����̳и���һ���ḲдһЩ�������˴�������дgetParamter()����
	public String getParameter(String name) {
		// ���ñ���װ�����getParameter()����������������
		String value = super.getParameter(name);
		if (value == null)
			return null;
		// �ж�����ʽ
		String method = super.getMethod();
		if ("get".equalsIgnoreCase(method)) {
			try {
					value = new String(value.getBytes("iso-8859-1"), "utf-8");
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException(e);
			}
		}
		// �������󷵻ؽ��
		return value;
	}
}