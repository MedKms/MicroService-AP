import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { BillComponent } from './bill/bill.component';
import { AppRoutingModule } from './app-routing.module';
import { CustomerComponent } from './customer/customer.component';
import {HttpClientModule} from "@angular/common/http";
import { ProductComponent } from './product/product.component';

@NgModule({
  declarations: [
    AppComponent,
    BillComponent,
    CustomerComponent,
    ProductComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
