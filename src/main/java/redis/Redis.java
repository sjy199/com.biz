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
		/*jedis.set("ѧ��11".getBytes(), jedis.get("student11".getBytes()));
		jedis.set("ѧ��10".getBytes() , jedis.get("student10".getBytes()));
		jedis.set("ѧ��9".getBytes(), jedis.get("student9".getBytes()));
		jedis.set("ѧ��8".getBytes(), jedis.get("student8".getBytes()));
		jedis.set("ѧ��7".getBytes(), jedis.get("student7".getBytes()));
		jedis.set("ѧ��6".getBytes(), jedis.get("student6".getBytes()));
		jedis.set("ѧ��5".getBytes(), jedis.get("student5".getBytes()));
		jedis.set("ѧ��4".getBytes(), jedis.get("student4".getBytes()));
		jedis.set("ѧ��3".getBytes(), jedis.get("student3".getBytes()));
		jedis.set("ѧ��2".getBytes(), jedis.get("student2".getBytes()));
		jedis.set("ѧ��1".getBytes(), jedis.get("student1".getBytes()));*/
		/*jedis.lpush("Student", "ѧ��11","ѧ��10","ѧ��9","ѧ��8","ѧ��7","ѧ��6","ѧ��5","ѧ��4","ѧ��3","ѧ��2","ѧ��1","��ƽ");*/
		/*if(jedis.llen("Student")!=0){
			while(true){
				name=jedis.rpoplpush("Student", "Student1");
				System.out.println(name);
				if(name.equals("����")){
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
				if(name.equals("����")){
					System.out.println(jedis.rpoplpush("Student1", "Student"));
				}
				
				if(jedis.llen("Student1")==0){
					break;
				}
			}
			
		}
		System.out.println(jedis.get("student11").getBytes());*/
		/*jedis.hset("firsthash", "name", "����");
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
			jedis.hset("ѧ��"+i, "id", String.valueOf(i));
			jedis.hset("ѧ��"+i, "name", "ѧ��" +i);
			jedis.hset("ѧ��"+i, "birthday",date.toString());
			jedis.hset("ѧ��"+i, "description", "����"+i);
			jedis.hset("ѧ��"+i, "avgscore",String.valueOf(avg));
			avg=avg+1;
		}*/
		/*for(int i=1;i<12;i++){
			System.out.println(jedis.hvals("ѧ��"+i));;
		}*/
		/*jedis.hset("��ƽ", "id", "12");
		jedis.hset("��ƽ", "name", "��ƽ");
		jedis.hset("��ƽ", "birthday",date.toString());
		jedis.hset("��ƽ", "description", "������ƽ");
		jedis.hset("��ƽ", "avgscore",String.valueOf(avg));*/
		/*jedis.hset("1111", "id", "13");
		jedis.hset("1111", "name", "11");
		jedis.hset("1111", "birthday",date.toString());
		jedis.hset("1111", "description", "����1111");
		jedis.hset("1111", "avgscore",String.valueOf(avg));
		jedis.hdel("1111", "id","name","birthday","description","avgscore");*/
		jedis.hset("1111", "id", "13");
		jedis.hset("1111", "name", "11");
		jedis.hset("1111", "birthday",date.toString());
		jedis.hset("1111", "description", "����1111");
		jedis.hset("1111", "avgscore",String.valueOf(avg));
 	}
}
