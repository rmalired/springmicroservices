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
public class CommentsController {
	
	static Map<String,List<String>> comments = null;
	
	
	static{
		comments = new HashMap<>();		
		List<String> learn001Comments = new ArrayList<>();
		learn001Comments.add("I am very much a machine learning novice although with a technical background much of the math with its focus on linear algebra and probability and statistics is familiar. I have purchased several other ML books in the past year and have found some better than others. This new book I really like. I downloaded the sample first chapter which is length and a great read and I knew the authors writing style and combination of theory (without a lot of equations) and practice (the hands-on) via Python was just right to encourage me to purchase and read the rest of this book.");
		learn001Comments.add("This book has the quality and utility I expect from O'Reilly titles. There is a mix of theory and example I prefer and when learning new topics, and I have always found these titles provide a quick entry into a new topic. The author is very knowledgeable and covers a lot of material. This book has a better combination of breadth and depth than most O'Reilly titles. Different methods and approaches are described in greater detail than usually found in these books.");
		// Hands-On Machine Learning with Scikit-Learn and TensorFlow: Concepts, Tools, and Techniques to Build Intelligent Systems
		
		List<String> learn002Comments = new ArrayList<>();
		learn002Comments.add("Great starter book on the concept. High level selection of topics, conversational presentation, and most importantly a fast read. This is an excellent strategy because it covers all the essentials, while still leaving you enough time to dig into some application or play with a build as you go along (which is ultimately the point). Leaves you free time to explore the topic and truly digest it, without assuming prior experience. Well done!");
		// Machine Learning With Random Forests And Decision Trees: A Visual Guide For Beginners
		
		List<String> con001Comments = new ArrayList<>();
		con001Comments.add("Better documentation then the kubernetes.io one. I bought this book with the hope that Getting started means instructions and help to install Kubernetes. No, the author uses ready made cloud providers, where Kubernetes is already installed. Too bad that I didn't see this in the preview of this book. Hope you know it through this comment.");
		con001Comments.add("It is fine, given the limited alternatives out there, but it reads as if the author gathered together a lot of material and examples and put them into the book without enough attention to providing conceptual background. To a large extent, the approach reads like: type these commands and you'll get it. The book is slightly dated now, since the software is changing. This makes the demo-first method more of an issue than it otherwise would be.");
		
		// Getting Started with Kubernetes
		
		comments.put("learn001", learn001Comments);
		comments.put("learn002",learn002Comments);
		comments.put("con001",  con001Comments);
		
	}
	
	
	@RequestMapping("/comments/{skuId}")
	public @ResponseBody List<String> getCommentsOnProduct(@PathVariable String skuId){
		return comments.getOrDefault(skuId, new ArrayList<>());
	}

}
