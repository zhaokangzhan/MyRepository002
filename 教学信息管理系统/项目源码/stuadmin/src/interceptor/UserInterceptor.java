package interceptor;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class UserInterceptor extends MethodFilterInterceptor {
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//�ж�session���Ƿ�����û�
		Object user_id = ServletActionContext.getRequest().getSession().getAttribute("user_id");
		//Object user_name = ServletActionContext.getRequest().getSession().getAttribute("user_name");
		//System.out.println("======================拦截器user_name="+user_name);
		System.out.println("======================拦截器user_id="+user_id);
		if(user_id==null||user_id==""){			
			ActionSupport action = (ActionSupport) invocation.getAction();
			ServletActionContext.getRequest().getSession().setAttribute("message1", "信息错误，请重新登录!!!");
			//action.addActionMessage("������˼����û�з���Ȩ��!!!���ù���Ա�˺ŵ�¼!!!");
			return action.LOGIN;
		}else{
			return invocation.invoke();
		}
	}

}
