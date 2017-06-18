/**
 * 
 */
package indiv.rakesh.springcloud.client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import indiv.rakesh.springcloud.domain.ProductDetail;

/**
 * @author rakesh.malireddy
 *
 */
@FeignClient("PRODUCTSERVICE")
public interface ProductDetailClient {

	
	
	@RequestMapping(method=RequestMethod.GET, value="/products")
	public List<ProductDetail> getAllProducts();
	
	@RequestMapping(method=RequestMethod.GET, value="/product/{skuId}")
	public ProductDetail getProduct(@PathVariable("skuId") String skuId);
}
