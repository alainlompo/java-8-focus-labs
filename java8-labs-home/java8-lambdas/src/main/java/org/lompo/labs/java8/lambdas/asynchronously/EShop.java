package org.lompo.labs.java8.lambdas.asynchronously;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class EShop {
	private String shopName;
	private Map<String, Article> articleBase;
	
	public EShop(String shopName) {
		this.shopName = shopName;
		articleBase = new HashMap<String, Article>();
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public Map<String, Article> getArticleBase() {
		return articleBase;
	}

	public void setArticleBase(Map<String, Article> articleBase) {
		this.articleBase = articleBase;
	}
	
	public EShop add(Article article) {
		this.articleBase.put(article.getName(), article);
		return this;
	}
	
	public Optional<Article> getArticleOptional(String articleName) {
		
		return Optional.ofNullable(this.articleBase.get(articleName));
	}
	
	public Article getArticle(String articleName) {
		if (this.articleBase.containsKey(articleName)) {
			return this.articleBase.get(articleName);
		}
		
		return null;
	}
	

}
