import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-bill',
  templateUrl: './bill.component.html',
  styleUrls: ['./bill.component.css']
})
export class BillComponent implements OnInit {
  public bills
  constructor(private http:HttpClient) { }

  ngOnInit(): void {
    this.http.get("http://localhost:9999/BILLING-SERVICE/fullbill/1")
      .subscribe(data=>{
        this.bills=data
      },error => {
        console.log(error)
      })
  }

}
