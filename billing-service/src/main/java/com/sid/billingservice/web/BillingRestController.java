package com.sid.billingservice.web;

import com.sid.billingservice.entities.Bill;
import com.sid.billingservice.feign.CustomerRestClient;
import com.sid.billingservice.feign.ProductItemRestClient;
import com.sid.billingservice.model.Customer;
import com.sid.billingservice.model.Product;
import com.sid.billingservice.repository.BillRepository;
import com.sid.billingservice.repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillingRestController {
    @Autowired
    private BillRepository billRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClient customerRestClient;
    private ProductItemRestClient productItemRestClient;

    public BillingRestController(BillRepository billRepository, ProductItemRepository productItemRepository, CustomerRestClient customerRestClient, ProductItemRestClient productItemRestClient) {
        this.billRepository = billRepository;
        this.productItemRepository = productItemRepository;
        this.customerRestClient = customerRestClient;
        this.productItemRestClient = productItemRestClient;
    }

    @GetMapping(path = "/fullbill/{id}")
    public Bill getBill(@PathVariable Long id){
        Bill bill=billRepository.findById(id).get();
        Customer customer=customerRestClient.getCustomerById(bill.getCustomerId());
        bill.setCustomer(customer);
        bill.getProductItems().forEach(p->{
            Product product=productItemRestClient.getProductById(p.getProductId());
            p.setProduct(product);
        });
        return bill;
    }

}
