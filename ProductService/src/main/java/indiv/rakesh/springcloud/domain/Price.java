/**
 * 
 */
package indiv.rakesh.springcloud.domain;

/**
 * @author rakesh.malireddy
 *
 */
public class Price {
	
	private String price;
	private String skuId;
	private String discountPercentage;
	
	
	
	public Price() {
		super();		
	}



	public Price(String price, String skuId, String discountPercentage) {
		super();
		this.price = price;
		this.skuId = skuId;
		this.discountPercentage = discountPercentage;
	}



	public String getPrice() {
		return price;
	}



	public void setPrice(String price) {
		this.price = price;
	}



	public String getSkuId() {
		return skuId;
	}



	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}



	public String getDiscountPercentage() {
		return discountPercentage;
	}



	public void setDiscountPercentage(String discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	
	
	
	
	
	

}
