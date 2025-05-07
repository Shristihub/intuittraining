package com.productinfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.productinfo.model.Product;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductInfoServiceImpl implements IProductInfoService {

	private final RestTemplate restTemplate;
	private static final String BASEURL = "http://product-catalog/catalog-service/v1/products";

	@Autowired
	private LoadBalancerClient balancerClient;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Override
	public List<Product> getAllProducts() {
		// list of instances for a particular microservice
		List<ServiceInstance> serviceInstances =  
				discoveryClient.getInstances("product-catalog");
		serviceInstances.stream()
		.forEach(serviceInstance ->{
			System.out.println("Host"+serviceInstance.getHost());
			System.out.println("InstanceId"+serviceInstance.getInstanceId());
			System.out.println("Schema"+serviceInstance.getScheme());
			System.out.println("serviceId"+serviceInstance.getServiceId());
			System.out.println("Port"+serviceInstance.getPort());
		});
		System.out.println(".........................");
		
		ServiceInstance serviceInstance = balancerClient.choose("product-catalog");
		System.out.println("Host"+serviceInstance.getHost());
		System.out.println("InstanceId"+serviceInstance.getInstanceId());
		System.out.println("Schema"+serviceInstance.getScheme());
		System.out.println("serviceId"+serviceInstance.getServiceId());
		System.out.println("Port"+serviceInstance.getPort());
		
		
		ResponseEntity<List<Product>> entity = (ResponseEntity) restTemplate.getForEntity(BASEURL, List.class);
		List<Product> products = entity.getBody();
		System.out.println(entity.getStatusCode());
		return products;
	}

//	http://localhost:8082/catalog-service/v1/products/category/electronics/price/40000
	@Override
	public List<Product> getByCategoryLessPrice(String category, double price) {
		String url = BASEURL.concat("/category/").concat(category).concat("/price/") + price;
		ResponseEntity<List<Product>> entity = (ResponseEntity) restTemplate.getForEntity(url, List.class);
		List<Product> products = entity.getBody();
		System.out.println(entity.getStatusCode());
		return products;
	}
	
//	http://localhost:8082/catalog-service/v1/products/brand/Samsung
	@Override
	public List<Product> getByBrand(String brand) {
		String url = BASEURL.concat("/brand/").concat(brand);
		ResponseEntity<List<Product>> entity = (ResponseEntity) restTemplate.getForEntity(url, List.class);
		List<Product> products = entity.getBody();
		System.out.println(entity.getStatusCode());
		return products;
	}

//	http://localhost:8082/catalog-service/v1/products/productId/1
	@Override
	public Product getById(int productId) {
		String url = BASEURL.concat("/productId/")+productId;
		ResponseEntity<Product> entity = (ResponseEntity)restTemplate.getForEntity(url,Product.class);
		Product product = entity.getBody();
		System.out.println(entity.getStatusCode());
		System.out.println(entity.getHeaders());
		return product;
	}

	

}
