/**
 * 
 */
package indiv.rakesh.springcloud;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import indiv.rakesh.springcloud.domain.Price;
import indiv.rakesh.springcloud.domain.ProductDetail;
import indiv.rakesh.springcloud.domain.ProductVO;
import indiv.rakesh.springcloud.domain.Rating;
import indiv.rakesh.springcloud.service.Product;

/**
 * @author rakesh.malireddy
 *
 */
@RestController
public class ProductServiceController {
	
	@Autowired LoadBalancerClient lbClient;
	
	@Autowired Product productService;
	
	
	private static final Logger LOG = Logger.getLogger(ProductServiceController.class.getName());
	
	@RequestMapping("/productdetail/{skuId}")
	public @ResponseBody ProductVO getProductDetail(@PathVariable String skuId){
		
		LOG.log(Level.INFO, "Retrieving the product detail for skuId "+ skuId);
		
		Price _price = productService.getPrice(skuId);
		ProductDetail _productDetail = productService.getProduct(skuId);
		Rating _rating = productService.getRating(skuId);
		List<String> _comments = productService.getComments(skuId);
		
		ProductVO productVo = new ProductVO();
		
		productVo.setComments(_comments);
		productVo.setPrice(_price);
		productVo.setProduct(_productDetail);
		productVo.setRating(_rating);
		
		return productVo;
		
		/*URI commentsServiceURI =getClientInstance("COMMENTSSERVICE").getUri();
		URI pricingServiceURI =getClientInstance("PRICING SERVICE").getUri();
		URI productServiceURI =getClientInstance("PRODUCT SERVICE").getUri();
		URI ratingServiceURI =getClientInstance("RATING SERVICE").getUri();
		String commentsEndpoint="";
		String pricingEndpoint="";
		String productEndpoint = "";
		String ratingEndpoint = "";
		try {
			commentsEndpoint = commentsServiceURI.toURL().toString();
			pricingEndpoint = pricingServiceURI.toURL().toString();
			productEndpoint = productServiceURI.toURL().toString();
			ratingEndpoint = ratingServiceURI.toURL().toString();
			
			System.out.println("comments service endpoint"+commentsEndpoint);
			System.out.println("pricing service endpoint "+pricingEndpoint);
			System.out.println("Product Service endpoint "+ productEndpoint);
			System.out.println("Rating service endpoint "+ ratingEndpoint);
			
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String finalcommentsEndpoint = commentsEndpoint+"/comments/"+skuId;
		String finalPricingEndpoint = pricingEndpoint+"/price/"+skuId;
		String finalProductEndpoint = productEndpoint+"/product/"+skuId;
		String finalRatingEndpoint = ratingEndpoint+"/rating/"+skuId;
		
		
		String comments = new RestTemplate().getForObject(finalcommentsEndpoint, String.class);	
		System.out.println("Comments "+ comments);
		
		String pricing = new RestTemplate().getForObject(finalPricingEndpoint, String.class);
		System.out.println("Pricing : "+ pricing);
		
		String rating = new RestTemplate().getForObject(finalRatingEndpoint, String.class);
		System.out.println("rating : "+ rating);
		
		String product = new RestTemplate().getForObject(finalProductEndpoint, String.class);
		System.out.println("product : "+ product);
*/
		
	}
	
	
	/*private ServiceInstance getClientInstance(String serviceName){
		
		return lbClient.choose(serviceName);	
		
	}*/
	
	@RequestMapping("/products")
	public @ResponseBody List<ProductVO> getAllProductDetail(){
		
		LOG.log(Level.INFO, "Retrieving all products information");
		
		Map<String,ProductVO> productMap = new HashMap<>();
		/*Map<String,Price> priceMap = new HashMap<>();
		Map<String,Rating> ratingMap = new HashMap<>();*/
		
		List<ProductVO> products = new ArrayList<>();
		
		List<ProductDetail> productDetails = productService.getAllProducts();
		List<Price> prices  = productService.getAllPricing();
		List<Rating> ratings = productService.getAllRatings();
		
		
		
		for(ProductDetail productDetail: productDetails){
			ProductVO product = new ProductVO();
			product.setProduct(productDetail);
			productMap.put(productDetail.getSkuId(), product);
		}		
		
		for(Price price: prices){
			productMap.get(price.getSkuId()).setPrice(price);
		}
		
		
		for(Rating rating: ratings){
			productMap.get(rating.getSkuId()).setRating(rating);
		}
		return new ArrayList<>(productMap.values());
	}
	
}
