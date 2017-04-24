package servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


/**
 * Servlet implementation class Addstudent
 */
@WebServlet("/Addstudent")
public class Addstudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static JedisPool pool; 
	private static Jedis jedis;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addstudent() {
        super();
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
		pool=new JedisPool(new JedisPoolConfig(),"127.0.0.1");
		jedis=pool.getResource();
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String year=request.getParameter("year");
		int y=Integer.parseInt(year);
		String month=request.getParameter("month");
		int m=Integer.parseInt(month);
		String day=request.getParameter("day");
		int d=Integer.parseInt(day);
		Date birthday =new Date(y-1990,m-1,d);
		String description=request.getParameter("description");
		String avgscore=request.getParameter("avgscore");
		jedis.hset(name, "id",id);
		jedis.hset(name, "name", name);
		jedis.hset(name, "birthday", birthday.toString());
		jedis.hset(name, "description", description);
		jedis.hset(name, "avgscore", avgscore);
		if(jedis.llen("Student")==0){
			jedis.lpush("Student1", name);
		}
		else if(jedis.llen("Student1")==0){
			jedis.lpush("Student", name);
		}
		
		request.getRequestDispatcher("ShowAllStudent").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
