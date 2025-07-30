import { Component, OnInit } from '@angular/core';
import{FormGroup,FormControl, Validators} from '@angular/forms'
import { CustomerService } from '../service/customer.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-addnew',
  templateUrl: './addnew.component.html',
  styleUrls: ['./addnew.component.css']
})
export class AddnewComponent implements OnInit {
  
  messageclass=''
  message:any='';
  editdata:any;
  customercode:any;
  constructor(private service:CustomerService,private route:ActivatedRoute) {
     this.customercode=this.route.snapshot.paramMap.get('code');
   
    }

  ngOnInit(): void {
    if(this.customercode!=null){
      this.updateCustomer(this.customercode);
    }
  }

  register=new FormGroup({
  code: new FormControl(null),
   name:new FormControl("",Validators.required),
   email:new FormControl("",Validators.compose([Validators.required,Validators.email])),
   phone:new FormControl("",Validators.maxLength(10))
  });
 
  SaveCustomer(){
   
    if(this.register.valid){
      this.service.SaveCustomer(this.register.value).subscribe(result=>{
      if(result!=null){
        this.message="Customer saved successfully"
      this.messageclass="sucess";

      }   
      });
    }
    else{
      this.message="Please Enter valid data"
      this.messageclass="error";
    }
  }

  
 updateCustomer(code: any) {
  this.service.LoadCustomerbycode(code).subscribe(data => {
    this.editdata = data;
    this.register = new FormGroup({
      code: new FormControl(this.editdata.code),  
      name: new FormControl(this.editdata.name, Validators.required),
      email: new FormControl(this.editdata.email, Validators.compose([Validators.required, Validators.email])),
      phone: new FormControl(this.editdata.phone, Validators.maxLength(10))
    });
  });
}

}
