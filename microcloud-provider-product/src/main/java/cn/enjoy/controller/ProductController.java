package cn.enjoy.controller;

import javax.annotation.Resource;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.enjoy.service.IProductService;
import cn.enjoy.vo.Product;

@RestController
@RequestMapping("/prodcut")
public class ProductController {

	@Resource
	private DiscoveryClient discoveryClient;
	
	
    @Resource
    private IProductService iProductService;

    @RequestMapping(value="/get/{id}")
    public Object get(@PathVariable("id") long id) {
        return this.iProductService.get(id) ;
    }
    @RequestMapping(value="/add")
    public Object add(@RequestBody Product product) {
        return this.iProductService.add(product) ;
    }
    @RequestMapping(value="/list")
    public Object list() {
        return this.iProductService.list() ;
    }
    
    @RequestMapping(value="discovery")
    public Object discovery() {
    	return this.discoveryClient;
    }
    
    
}
