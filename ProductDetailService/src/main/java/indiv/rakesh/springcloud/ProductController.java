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
public class ProductController {
	
	static Map<String,ProductDetail> productMap = new HashMap<>();
	
	static{
		
		
		ProductDetail learn001Product = new ProductDetail();
		learn001Product.setAuthor("Aurélien Géron");
		learn001Product.setSkuId("learn001");
		learn001Product.setTitle("Hands-On Machine Learning with Scikit-Learn and TensorFlow");
		learn001Product.setImageCover("image-url");
		learn001Product.setDescription("Through a series of recent breakthroughs, deep learning has boosted the entire field of machine learning. Now, even programmers who know close to nothing about this technology can use simple, efficient tools to implement programs capable of learning from data. This practical book shows you how.");	
		
		
		
		ProductDetail learn002Product = new ProductDetail();
		learn002Product.setAuthor("Scott Hartshorn");
		learn002Product.setSkuId("learn002");
		learn002Product.setTitle("Machine Learning With Random Forests And Decision Trees");
		learn002Product.setImageCover("image-url");
		learn002Product.setDescription("If you are looking for a book to help you understand how the machine learning algorithms Random Forest and Decision Trees work behind the scenes, then this is a good book for you.  Those two algorithms are commonly used in a variety of applications including big data analysis for industry and data analysis competitions like you would find on Kaggle. This book explains how Decision Trees work and how they can be combined into a Random Forest to reduce many of the common problems with decision trees, such as overfitting the training data.");

		

		
		ProductDetail con001Product = new ProductDetail();
		con001Product.setAuthor("Jonathan Baier");
		con001Product.setSkuId("con001");
		con001Product.setTitle("Getting Started with Kubernetes");
		con001Product.setImageCover("image-url");
		con001Product.setDescription("Orchestrate and manage large-scale Docker deployments with Kubernetes to unlock greater control over your infrastructure and extend your containerization strategy");

        productMap.put("learn001", learn001Product);
        productMap.put("learn002", learn002Product);
        productMap.put("con001", con001Product);
			
		
	}
	
	
	
	@RequestMapping("/product/{skuId}")
	public @ResponseBody ProductDetail getProductDetail(@PathVariable String skuId){
		
		return productMap.get(skuId);
	}
	
	@RequestMapping("/products")
	public @ResponseBody List<ProductDetail> getProducts(){		
		return new ArrayList<>(productMap.values());
	}

}
