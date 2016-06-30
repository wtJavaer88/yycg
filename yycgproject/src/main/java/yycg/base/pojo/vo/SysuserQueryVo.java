package yycg.base.pojo.vo;

/**
 * 
 * <p>Title: SysuserQueryVo</p>
 * <p>Description:包装类，用于页面向action传递参数，将数据传到mybatis </p>
 * <p>Company: www.itcast.com</p> 
 * @author	苗润土
 * @date	2014年11月26日上午10:32:50
 * @version 1.0
 */
public class SysuserQueryVo {
	
	//分页参数
	private PageQuery pageQuery;
	//用户的查询条件
	private SysuserCustom sysuserCustom;
	//可以扩展多个属性
	//....

	public SysuserCustom getSysuserCustom() {
		return sysuserCustom;
	}

	public void setSysuserCustom(SysuserCustom sysuserCustom) {
		this.sysuserCustom = sysuserCustom;
	}

	public PageQuery getPageQuery() {
		return pageQuery;
	}

	public void setPageQuery(PageQuery pageQuery) {
		this.pageQuery = pageQuery;
	}
	
	

}
