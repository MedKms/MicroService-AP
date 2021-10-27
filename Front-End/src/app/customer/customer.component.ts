import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-customer',
  templateUrl: './customer.component.html',
  styleUrls: ['./customer.component.css']
})
export class CustomerComponent implements OnInit {
  public customers;
  constructor(private http:HttpClient) { }

  ngOnInit(): void {
    this.http.get("http://localhost:9999/CUSTOMER-SERVICE/customers")
      .subscribe(data=>{
        this.customers=data
    },err=>{
      console.log(err)
    })
  }

}
