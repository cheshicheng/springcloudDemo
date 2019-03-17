package cn.enjoy.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import cn.enjoy.vo.Product;

@RestController
@RequestMapping("/consumer")
public class ConsumerProductController {
	@Value("${PRODUCT_GET_URL}")
	public  String PRODUCT_GET_URL;// = "http://localhost:8080/prodcut/get/";
	@Value("${PRODUCT_LIST_URL}")
	public  String PRODUCT_LIST_URL;// = "http://localhost:8080/prodcut/list/";
	@Value("${PRODUCT_ADD_URL}")
	public  String PRODUCT_ADD_URL; //= "http://localhost:8080/prodcut/add/";
	@Resource
    private RestTemplate restTemplate;

    @Resource
    private HttpHeaders httpHeaders;

	/*
	 * @Resource private RestTemplate restTemplate;
	 * 
	 * @RequestMapping("/product/get") public Object getProduct(long id) { Product
	 * product = restTemplate.getForObject(PRODUCT_GET_URL + id, Product.class);
	 * return product; }
	 * 
	 * @RequestMapping("/product/list") public Object listProduct() { List<Product>
	 * list = restTemplate.getForObject(PRODUCT_LIST_URL, List.class); return list;
	 * }
	 * 
	 * @RequestMapping("/product/add") public Object addPorduct(Product product) {
	 * Boolean result = restTemplate.postForObject(PRODUCT_ADD_URL, product,
	 * Boolean.class); return result; }
	 */
	
	@RequestMapping("/product/get")
    public Object getProduct(long id) {
        Product product = restTemplate.exchange(PRODUCT_GET_URL + id,HttpMethod.GET,new HttpEntity<Object>(httpHeaders), Product.class).getBody();
        return  product;
    }

    @RequestMapping("/product/list")
    public  Object listProduct() {
        List<Product> list = restTemplate.exchange(PRODUCT_LIST_URL,HttpMethod.GET,new HttpEntity<Object>(httpHeaders), List.class).getBody();
        return  list;
    }

    @RequestMapping("/product/add")
    public Object addPorduct(Product product) {
        Boolean result = restTemplate.exchange(PRODUCT_ADD_URL, HttpMethod.POST,new HttpEntity<Object>(product,httpHeaders), Boolean.class).getBody();
        return  result;
    }


}
