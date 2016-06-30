package yycg.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import yycg.base.dao.mapper.SysuserMapper;
import yycg.base.dao.mapper.SysuserMapperCustom;
import yycg.base.dao.mapper.UsergysMapper;
import yycg.base.dao.mapper.UserjdMapper;
import yycg.base.dao.mapper.UseryyMapper;
import yycg.base.pojo.po.Sysuser;
import yycg.base.pojo.po.SysuserExample;
import yycg.base.pojo.po.Usergys;
import yycg.base.pojo.po.UsergysExample;
import yycg.base.pojo.po.Userjd;
import yycg.base.pojo.po.UserjdExample;
import yycg.base.pojo.po.Useryy;
import yycg.base.pojo.po.UseryyExample;
import yycg.base.pojo.vo.SysuserCustom;
import yycg.base.pojo.vo.SysuserQueryVo;
import yycg.base.process.result.ExceptionResultInfo;
import yycg.base.process.result.ResultInfo;
import yycg.base.service.UserService;
import yycg.util.UUIDBuild;

public class UserServiceImpl implements UserService {

	// 注入 mapper
	@Autowired
	private SysuserMapper sysuserMapper;

	@Autowired
	private UserjdMapper userjdMapper;

	@Autowired
	private UseryyMapper useryyMapper;

	@Autowired
	private UsergysMapper usergysMapper;

	@Autowired
	private SysuserMapperCustom sysuserMapperCustom;

	@Override
	public List<SysuserCustom> findSysuserList(SysuserQueryVo sysuserQueryVo)
			throws Exception {
		return sysuserMapperCustom.findSysuserList(sysuserQueryVo);
	}

	@Override
	public int findSysuserCount(SysuserQueryVo sysuserQueryVo) throws Exception {
		return sysuserMapperCustom.findSysuserCount(sysuserQueryVo);
	}

	// 根据账号查询用户方法
	public Sysuser findSysuserByUserid(String userId) throws Exception {
		SysuserExample sysuserExample = new SysuserExample();
		SysuserExample.Criteria criteria = sysuserExample.createCriteria();
		// 设置查询条件，根据账号查询
		criteria.andUseridEqualTo(userId);
		List<Sysuser> list = sysuserMapper.selectByExample(sysuserExample);

		if (list != null && list.size() == 1) {
			return list.get(0);
		}
		return null;
	}

	// 根据单位名称 查询单位信息
	public Userjd findUserjdByMc(String mc) throws Exception {

		UserjdExample userjdExample = new UserjdExample();
		UserjdExample.Criteria criteria = userjdExample.createCriteria();
		criteria.andMcEqualTo(mc);
		List<Userjd> list = userjdMapper.selectByExample(userjdExample);

		if (list != null && list.size() == 1) {
			return list.get(0);
		}
		return null;

	}
	public Useryy findUseryyByMc(String mc) throws Exception {

		UseryyExample useryyExample = new UseryyExample();
		UseryyExample.Criteria criteria = useryyExample.createCriteria();
		criteria.andMcEqualTo(mc);
		List<Useryy> list = useryyMapper.selectByExample(useryyExample);

		if (list != null && list.size() == 1) {
			return list.get(0);
		}
		return null;

	}
	public Usergys findUsergysByMc(String mc) throws Exception {

		UsergysExample usergysExample = new UsergysExample();
		UsergysExample.Criteria criteria = usergysExample.createCriteria();
		criteria.andMcEqualTo(mc);
		List<Usergys> list = usergysMapper.selectByExample(usergysExample);

		if (list != null && list.size() == 1) {
			return list.get(0);
		}
		return null;

	}

	@Override
	public void insertSysuser(SysuserCustom sysuserCustom) throws Exception {
		
		//参数校验
		//通用的参数合法校验，非空校验，长度校验
		//...使用一些工具类来完成
		
		//数据业务合法性校验
		//账号唯一性校验，查询数据库校验出来
		//思路：根据用户账号查询sysuser表，如果查询到说明 账号重复
		Sysuser sysuser = this.findSysuserByUserid(sysuserCustom.getUserid());
		if(sysuser!=null){
			//账号重复
			//抛出异常，可预知异常
			//throw new Exception("账号重复");
			
			//使用系统自定义异常类
			ResultInfo resultInfo = new ResultInfo();
			resultInfo.setType(ResultInfo.TYPE_RESULT_FAIL);
			resultInfo.setMessage("账号重复");
			throw new ExceptionResultInfo(resultInfo);
		}

		//根据用户类型，输入单位名称必须存在对应的单位表
		String groupid = sysuserCustom.getGroupid();//用户类型
		String sysmc = sysuserCustom.getSysmc();//单位名称
		String sysid = null;//单位id
		if(groupid.equals("1") || groupid.equals("2")){
			//监督单位
			//根据单位名称查询单位信息
			Userjd userjd = this.findUserjdByMc(sysmc);
			if(userjd==null){
				//抛出异常，可预知异常
				throw new Exception("单位名称输入错误");
			}
			sysid = userjd.getId();
		}else if(groupid.equals("3")){
			//卫生室
			//根据单位名称查询单位信息
			Useryy useryy = this.findUseryyByMc(sysmc);
			if(useryy==null){
				//抛出异常，可预知异常
				throw new Exception("单位名称输入错误");
			}
			sysid = useryy.getId();
		}else if(groupid.equals("4")){
			//供货商
			//根据单位名称查询单位信息
			Usergys usergys = this.findUsergysByMc(sysmc);
			if(usergys==null){
				//抛出异常，可预知异常
				throw new Exception("单位名称输入错误");
			}
			sysid = usergys.getId();
		}
		//设置主键
		sysuserCustom.setId(UUIDBuild.getUUID());
		//设置单位id
		sysuserCustom.setSysid(sysid);
		sysuserMapper.insert(sysuserCustom);
		
		
	}
}
