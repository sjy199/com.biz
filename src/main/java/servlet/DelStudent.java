package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Servlet implementation class DelStudent
 */
@WebServlet("/DelStudent")
public class DelStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static JedisPool pool; 
	private static Jedis jedis;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelStudent() {
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
		String name=request.getParameter("name");
		jedis.del((name).getBytes());
		if(jedis.llen("Student")!=0){
			while(true){
				if(jedis.rpoplpush("Student", "Student1").equals(name)){
					jedis.lpop("Student1");
				}
				if(jedis.llen("Student")==0){
					break;
				}
			}
			
		}else if(jedis.llen("Student1")!=0){
			while(true){
				if(jedis.rpoplpush("Student1", "Student").equals(name)){
					jedis.lpop("Student");
				}
				
				if(jedis.llen("Student1")==0){
					break;
				}
			}
			
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
