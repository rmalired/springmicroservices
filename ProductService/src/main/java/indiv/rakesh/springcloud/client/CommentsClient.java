/**
 * 
 */
package indiv.rakesh.springcloud.client;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author rakesh.malireddy
 *
 */
@FeignClient("COMMENTSSERVICE")
public interface CommentsClient {
	
	@RequestMapping(method=RequestMethod.GET, value="/comments/{skuId}")
	public List<String> getComments(@PathVariable("skuId") String skuId);

}
