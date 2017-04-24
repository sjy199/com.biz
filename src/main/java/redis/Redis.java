package redis;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import pojo.Student;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import util.SerializationUtil;

public class Redis {
	private static JedisPool pool; 
	private static Jedis jedis;
	public static void setup(){
		pool=new JedisPool(new JedisPoolConfig(),"127.0.0.1");
		jedis=pool.getResource();
	}
	public static void main(String[] args) {  
		setup();
		String name;
		/*jedis.set("学生11".getBytes(), jedis.get("student11".getBytes()));
		jedis.set("学生10".getBytes() , jedis.get("student10".getBytes()));
		jedis.set("学生9".getBytes(), jedis.get("student9".getBytes()));
		jedis.set("学生8".getBytes(), jedis.get("student8".getBytes()));
		jedis.set("学生7".getBytes(), jedis.get("student7".getBytes()));
		jedis.set("学生6".getBytes(), jedis.get("student6".getBytes()));
		jedis.set("学生5".getBytes(), jedis.get("student5".getBytes()));
		jedis.set("学生4".getBytes(), jedis.get("student4".getBytes()));
		jedis.set("学生3".getBytes(), jedis.get("student3".getBytes()));
		jedis.set("学生2".getBytes(), jedis.get("student2".getBytes()));
		jedis.set("学生1".getBytes(), jedis.get("student1".getBytes()));*/
		/*jedis.lpush("Student", "学生11","学生10","学生9","学生8","学生7","学生6","学生5","学生4","学生3","学生2","学生1","张平");*/
		/*if(jedis.llen("Student")!=0){
			while(true){
				name=jedis.rpoplpush("Student", "Student1");
				System.out.println(name);
				if(name.equals("王浩")){
					System.out.println(jedis.rpoplpush("Student", "Student1"));
				}
				if(jedis.llen("Student")==0){
					break;
				}
			}
			
		}else if(jedis.llen("Student1")!=0){
			while(true){
				name=jedis.rpoplpush("Student1", "Student");
				System.out.println(name);
				if(name.equals("王浩")){
					System.out.println(jedis.rpoplpush("Student1", "Student"));
				}
				
				if(jedis.llen("Student1")==0){
					break;
				}
			}
			
		}
		System.out.println(jedis.get("student11").getBytes());*/
		/*jedis.hset("firsthash", "name", "张三");
		jedis.hset("firsthash", "avg", "66");
		System.out.println(jedis.hvals("firsthash"));;
	private String id;
	private String name;
	private Date birthday;
	private String description;
	private int avgscore;
*/
		Date date=new Date();
		int avg=70;
		/*for(int i=1;i<12;i++){
			jedis.hset("学生"+i, "id", String.valueOf(i));
			jedis.hset("学生"+i, "name", "学生" +i);
			jedis.hset("学生"+i, "birthday",date.toString());
			jedis.hset("学生"+i, "description", "描述"+i);
			jedis.hset("学生"+i, "avgscore",String.valueOf(avg));
			avg=avg+1;
		}*/
		/*for(int i=1;i<12;i++){
			System.out.println(jedis.hvals("学生"+i));;
		}*/
		/*jedis.hset("张平", "id", "12");
		jedis.hset("张平", "name", "张平");
		jedis.hset("张平", "birthday",date.toString());
		jedis.hset("张平", "description", "描述张平");
		jedis.hset("张平", "avgscore",String.valueOf(avg));*/
		/*jedis.hset("1111", "id", "13");
		jedis.hset("1111", "name", "11");
		jedis.hset("1111", "birthday",date.toString());
		jedis.hset("1111", "description", "描述1111");
		jedis.hset("1111", "avgscore",String.valueOf(avg));
		jedis.hdel("1111", "id","name","birthday","description","avgscore");*/
		jedis.hset("1111", "id", "13");
		jedis.hset("1111", "name", "11");
		jedis.hset("1111", "birthday",date.toString());
		jedis.hset("1111", "description", "描述1111");
		jedis.hset("1111", "avgscore",String.valueOf(avg));
 	}
}
