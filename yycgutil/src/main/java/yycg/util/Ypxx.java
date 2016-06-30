package yycg.util;
public class Ypxx {
	private String bm;
	private String mc;
	private float price;
	
	public Ypxx(String bm,String mc,float price){
		this.bm = bm;
		this.mc = mc;
		this.price = price;
	}
	public String getBm() {
		return bm;
	}
	public void setBm(String bm) {
		this.bm = bm;
	}
	public String getMc() {
		return mc;
	}
	public void setMc(String mc) {
		this.mc = mc;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Ypxx [bm=" + bm + ", mc=" + mc + ", price=" + price + "]";
	}
	
	
}
