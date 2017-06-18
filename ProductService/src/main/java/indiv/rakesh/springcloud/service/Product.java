/**
 * 
 */
package indiv.rakesh.springcloud.service;

import java.util.List;

import indiv.rakesh.springcloud.domain.Price;
import indiv.rakesh.springcloud.domain.ProductDetail;
import indiv.rakesh.springcloud.domain.Rating;

/**
 * @author rakesh.malireddy
 *
 */
public interface Product {
	
	List<ProductDetail> getAllProducts();
	
	List<Rating> getAllRatings();
	
	List<Price> getAllPricing();
	
	
	ProductDetail getProduct(String skuId);
	
	Rating getRating(String skuId);
	
	Price getPrice(String skuId);
	
	List getComments(String skuId);
	

}
