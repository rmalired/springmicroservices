/**
 * 
 */
package indiv.rakesh.springcloud.domain;

import java.util.List;

/**
 * @author rakesh.malireddy
 *
 */
public class ProductVO {
	
	private Price price;
	private ProductDetail productDetail;
	private Rating rating;
    private List<String> comments;
    
    
    
	public ProductVO() {
		super();		
	}



	public ProductVO(Price price, ProductDetail product, Rating rating, List<String> comments) {
		super();
		this.price = price;
		this.productDetail = product;
		this.rating = rating;
		this.comments = comments;
	}



	public Price getPrice() {
		return price;
	}



	public void setPrice(Price price) {
		this.price = price;
	}



	public ProductDetail getProduct() {
		return productDetail;
	}



	public void setProduct(ProductDetail product) {
		this.productDetail = product;
	}



	public Rating getRating() {
		return rating;
	}



	public void setRating(Rating rating) {
		this.rating = rating;
	}



	public List<String> getComments() {
		return comments;
	}



	public void setComments(List<String> comments) {
		this.comments = comments;
	}
    
    
    

}
