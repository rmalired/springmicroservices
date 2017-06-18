/**
 * 
 */
package indiv.rakesh.springcloud.domain;

/**
 * @author rakesh.malireddy
 *
 */
public class ProductDetail {
	
	private String skuId;
	private String author;
	private String description;
	private String imageCover;
	private String title;
	
	
	public ProductDetail() {
		super();		
	}


	public ProductDetail(String skuId, String author, String description, String imageCover, String title) {
		super();
		this.skuId = skuId;
		this.author = author;
		this.description = description;
		this.imageCover = imageCover;
		this.title = title;
	}


	public String getSkuId() {
		return skuId;
	}


	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getImageCover() {
		return imageCover;
	}


	public void setImageCover(String imageCover) {
		this.imageCover = imageCover;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
	
	

}
