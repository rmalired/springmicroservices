/**
 * 
 */
package indiv.rakesh.springcloud;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rakesh.malireddy
 *
 */
@RestController
public class RatingController {
	
	static Map<String,Rating> itemRating = new HashMap<>();
	
	static{
		itemRating.put("learn001", new Rating("learn001","4.7","3"));
		itemRating.put("learn002", new Rating("learn002","4.5","12"));
		itemRating.put("con001", new Rating("con001","4.7","5"));
	}
	
	@RequestMapping("/rating/{skuId}")
	public @ResponseBody Rating getRatingOnItem(@PathVariable String skuId){
		return itemRating.getOrDefault(skuId, new Rating());
	}
	
	
	@RequestMapping("/rating")
	public @ResponseBody List<Rating> getRatingOnItem(){
		return new ArrayList<>(itemRating.values());
	}

}
