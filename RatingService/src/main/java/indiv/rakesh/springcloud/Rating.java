/**
 * 
 */
package indiv.rakesh.springcloud;

/**
 * @author rakesh.malireddy
 *
 */
public class Rating {
	
	private String skuId;
	private String rating;
	private String count;
	
	
	
	public Rating(){
		
	}
	
	public Rating(String skuId, String rating, String count) {
		super();
		this.skuId = skuId;
		this.rating = rating;
		this.count = count;
	}
	
	
	public String getSkuId() {
		return skuId;
	}
	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	
	
	

}
