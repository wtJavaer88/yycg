package yycg.base.dao.mapper;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import yycg.base.pojo.po.Sysuser;
import yycg.base.pojo.po.SysuserExample;
import yycg.util.UUIDBuild;
import junit.framework.TestCase;

public class SysuserMapperTest extends TestCase {

	private ApplicationContext applicationContext;
	
	private SysuserMapper sysuserMapper;

	protected void setUp() throws Exception {
		// 获取spring容器
		applicationContext = new ClassPathXmlApplicationContext(new String[] {
				"spring/applicationContext.xml", "spring/applicationContext-dao.xml"

		});
		sysuserMapper = (SysuserMapper) applicationContext.getBean("sysuserMapper");
	}
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	//根据主键删除
	public void testDeleteByPrimaryKey() {
		sysuserMapper.deleteByPrimaryKey("test009");
	}

	//插入用户信息
	public void testInsert() {
		
		Sysuser sysuser = new Sysuser();
		sysuser.setId(UUIDBuild.getUUID());//生成uuid主键
		
		sysuser.setUserid("");
		sysuser.setUsername("");
		sysuserMapper.insert(sysuser);
	}

	//自定义查询条件查询
	public void testSelectByExample() {
		SysuserExample sysuserExample  =new SysuserExample();
		SysuserExample.Criteria criteria = sysuserExample.createCriteria();
		//自定义查询条件
		criteria.andUsernameEqualTo("test009");
		criteria.andGroupidEqualTo("4");
		
		List<Sysuser> list = sysuserMapper.selectByExample(sysuserExample);
		
		System.out.println(list.get(0));
	}

	//根据主键查询用户信息
	public void testSelectByPrimaryKey() {
		Sysuser sysuser =  sysuserMapper.selectByPrimaryKey("18e6c4bc2f3244bfa146ec6e3f73919a");
		System.out.println(sysuser);
	}

	//根据主键更新，传入的po类的属性不为空才更新
	public void testUpdateByPrimaryKeySelective() {
		//定义一个新的对象
		Sysuser sysuser = new Sysuser();
		//对象设置id
		sysuser.setId("18e6c4bc2f3244bfa146ec6e3f73919a");
		//再设置要更新的值
		sysuser.setUsername("test009999");
		sysuserMapper.updateByPrimaryKeySelective(sysuser);
	}
	//根据主键更新，不管传入的po类的属性是否为空，都更新
	public void testUpdateByPrimaryKey() {
		
		//先查询对象
		Sysuser sysuser = sysuserMapper.selectByPrimaryKey("18e6c4bc2f3244bfa146ec6e3f73919a");
		//向对象中设置要更新的值
		sysuser.setUsername("test009999");
		//执行更新
		sysuserMapper.updateByPrimaryKey(sysuser);
	}

}
