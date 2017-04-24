package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


/**
 * Servlet implementation class ShowAllStudent
 */
@WebServlet("/ShowAllStudent")
public class ShowAllStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static JedisPool pool; 
	private static Jedis jedis;
    /**
     * Default constructor. 
     */
    public ShowAllStudent() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request. setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response. setCharacterEncoding("UTF-8");
		String page=request.getParameter("page");
		if(page==null){
			page="1";
		}
		int p=Integer.parseInt(page);
		
		pool=new JedisPool(new JedisPoolConfig(),"127.0.0.1");
		jedis=pool.getResource();
		//获取所有学生目录
		List list=new ArrayList();
		if(jedis.llen("Student")!=0&&list.size()==0){
			while(true){
				String ss=jedis.rpoplpush("Student", "Student1");
				if(ss!=null){
					list.add(ss);
				}
				
				if(jedis.llen("Student")==0){
					break;
				}
			}
			
		}else if(jedis.llen("Student1")!=0&&list.size()==0){
			while(true){
				String ss=jedis.rpoplpush("Student1", "Student");
				list.add(ss);
				if(jedis.llen("Student1")==0){
					break;
				}
			}
		}
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		//获取所有学生实体
		PrintWriter out=response.getWriter();
		List<List> list1=new ArrayList<List>();
		for(int i=0;i<list.size();i++){
			System.out.println(jedis.hvals((String) list.get(i)));
			list1.add(jedis.hvals((String) list.get(i)));
		}
		/*for(int i=0;i<11;i++){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的m
			try {
				Date date=sdf.parse((String) list1.get(i).get(2));
				list1.get(i).set(2, date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		for(int i=0;i<list1.size();i++){
			Date date=new Date((String)list1.get(i).get(2));
			list1.get(i).set(2, date);
			
		}
		//冒泡排序
		for (int i=0;i<list1.size();i++) {
			List list2=list1.get(i);
			for(int j=i;j<list1.size();j++){
				if(Integer.parseInt((String) list1.get(j).get(4))>Integer.parseInt((String) list1.get(i).get(4))){
					list1.set(i, list1.get(j));
					list1.set(j, list2);
					list2=list1.get(i);
				}
			}
		}
		
		//分页
		int maxSize=p*10-1;
		if((p*10-1)>=list1.size()){
			maxSize=list1.size()-1;
		}
		List<List> list3=new ArrayList<List>();
		
		for(int i=(p-1)*10;i<=maxSize;i++){
			list3.add(list1.get(i));
		}
		request.getSession().setAttribute("list", list3);
		request.getSession().setAttribute("listsize", list1.size());
		request.getSession().setAttribute("page", p);
		request.getRequestDispatcher("index.jsp").forward(request,response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
