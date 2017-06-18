/**
 * 
 */
package indiv.rakesh.springcloud.client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import indiv.rakesh.springcloud.domain.Rating;

/**
 * @author rakesh.malireddy
 *
 */
@FeignClient("RATINGSERVICE")
public interface RatingClient {

	
	@RequestMapping(method=RequestMethod.GET, value="/rating")
	public List<Rating> getAllRating();
	
	@RequestMapping(method=RequestMethod.GET, value="/rating/{skuId}")	
	public Rating getRating(@PathVariable("skuId") String skuId);
	

}
