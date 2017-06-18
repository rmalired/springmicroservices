/**
 * 
 */
package indiv.rakesh.springcloud.client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import indiv.rakesh.springcloud.domain.Price;

/**
 * @author rakesh.malireddy
 *
 */
@FeignClient("PRICINGSERVICE")
public interface PricingClient {
	
	
	@RequestMapping(method=RequestMethod.GET, value="/price")
	public List<Price> getAllPricing();
	
	@RequestMapping(method=RequestMethod.GET, value="/price/{skuId}")
	public Price getPrice(@PathVariable("skuId") String skuId);

}
