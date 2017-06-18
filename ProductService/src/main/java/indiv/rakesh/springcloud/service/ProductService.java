/**
 * 
 */
package indiv.rakesh.springcloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import indiv.rakesh.springcloud.client.CommentsClient;
import indiv.rakesh.springcloud.client.PricingClient;
import indiv.rakesh.springcloud.client.ProductDetailClient;
import indiv.rakesh.springcloud.client.RatingClient;
import indiv.rakesh.springcloud.domain.Price;
import indiv.rakesh.springcloud.domain.ProductDetail;
import indiv.rakesh.springcloud.domain.Rating;

/**
 * @author rakesh.malireddy
 *
 */
@Service
public class ProductService implements Product {
	
	
	
	@Autowired CommentsClient commentsClient;
	@Autowired PricingClient pricingClient;
	@Autowired ProductDetailClient pdClient;
	@Autowired RatingClient ratingClient;

	
	@Override
	public List<ProductDetail> getAllProducts() {
		return pdClient.getAllProducts();
	}

	
	@Override
	public List<Rating> getAllRatings() {
	   return ratingClient.getAllRating();
	}

	
	@Override
	public List<Price> getAllPricing() {
		return pricingClient.getAllPricing();
	}


	@Override
	public ProductDetail getProduct(String skuId) {
		return pdClient.getProduct(skuId);
	}

	
	@Override
	@HystrixCommand(fallbackMethod="getFallbackRating")
	public Rating getRating(String skuId) {
		return ratingClient.getRating(skuId);
	}

	
	@Override
	public Price getPrice(String skuId) {
		
		return pricingClient.getPrice(skuId);
	}

	
	@Override
	public List getComments(String skuId) {
	    return commentsClient.getComments(skuId);
	}
	
	public Rating getFallbackRating(String skuId) {
		return new Rating(skuId,"Not Yet Rated",null);
	}

}
