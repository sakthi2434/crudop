import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
 apiurl='http://localhost:8080/api/users'
  constructor(private http:HttpClient) {

   }

   LoadCustomer(){
    return this.http.get(this.apiurl);
   }

   SaveCustomer(customerdata:any){
   return this.http.post(this.apiurl,customerdata);
   }

   LoadCustomerbycode(code:any){
    return this.http.get(this.apiurl+'/'+code);
    }

    RemoveCustomerbycode(code:any){
      return this.http.delete(this.apiurl+'/'+code);
      }
}
