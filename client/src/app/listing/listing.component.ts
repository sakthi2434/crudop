import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../service/customer.service';

@Component({
  selector: 'app-listing',
  templateUrl: './listing.component.html',
  styleUrls: ['./listing.component.css']
})
export class ListingComponent implements OnInit {

  customerdata: any = [];

  constructor(private service: CustomerService) { }

  ngOnInit(): void {
    this.LoadCustomer();
  }

  LoadCustomer() {
    this.service.LoadCustomer().subscribe(data => {
      this.customerdata = data;
    });
  }

  delete(code:any){
    if(confirm("Do you want to remove")){
    this.service.RemoveCustomerbycode(code).subscribe(data => {
      this.LoadCustomer();
    });
  }
}
}
