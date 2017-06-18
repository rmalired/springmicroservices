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
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rakesh.malireddy
 *
 */
@RestController
@ConfigurationProperties(prefix="bookstore")
public class PricingController {
	
	String discountPercentage;
	
	static Map<String,Price> priceMap = new HashMap<>();
	
	static{
		Price learn001 = new Price();
		Price learn002 = new Price();
		Price con001 = new Price();
		
		learn001.setPrice("$44.99");
		learn001.setSkuId("learn001");
		
		
		learn002.setPrice("$2.99");
		learn002.setSkuId("learn002");
		
		
		con001.setPrice("$34.99");
		con001.setSkuId("con001");
		
		
		
		priceMap.put("learn001", learn001);
		priceMap.put("learn002", learn002);
		priceMap.put("con001", con001);
	}
	
	
	public String getDiscountPercentage() {
		return discountPercentage;
	}


	public void setDiscountPercentage(String discountPercentage) {
		this.discountPercentage = discountPercentage;
	}


	private static final Logger LOG = Logger.getLogger(PricingController.class.getName());
	
	
	@RequestMapping("/price/{skuId}")
	public Price getPriceOnItem(@PathVariable String skuId){
		
		LOG.log(Level.INFO,"pricing service invoked for skuId :"+ skuId);
		Price price = null;
		price = priceMap.getOrDefault(skuId, new Price());
		price.setDiscountPercentage(discountPercentage);
		
		return price;
	}
	
	
	@RequestMapping("/price")
	public @ResponseBody List<Price> getAllPrices(){
		
		LOG.log(Level.INFO,"pricing service invoked for all services");
		
        List<Price> allPrices = new ArrayList<>();
        
        for(Price price: priceMap.values()){
        	price.setDiscountPercentage(discountPercentage);
        	allPrices.add(price);
        }
		
		return allPrices;
		
		
	}
	
	
	

}
