import { Component, OnInit } from '@angular/core';
import { Payment } from 'src/app/common/Models';
import { User } from 'src/app/common/User';
import { LoginService } from 'src/app/services/login/login.service';
import { PaymentService } from '../../services/payment/payment.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  constructor(private loginService:LoginService,private paymentService :PaymentService) { }

  user:any={}
  fakeUser:any={}
  count:number=1;
  ngOnInit(): void {
    let x=sessionStorage.getItem("user")
    console.log(x)
    this.user=JSON.parse(x);
    this.fakeUser=JSON.parse(x);
    this.fakeUser.paymentMethods=null;
    
    console.log(this.user)
  }
  update():void{
    console.log(this.user)//correct
    //for(let y of this.user.paymentMethods){
    //this.paymentService.updatePayment(y)
    //}
    this.loginService.updateUser(this.user).subscribe((user:User)=>{
      console.log(user)//wrong
      this.user=user;
    })
    sessionStorage.setItem("user",JSON.stringify(this.user))
  }
  addPayment():void{
    let x:Payment =new Payment("","","");
    x.user=this.fakeUser;
  }
  removePayment(payment:any){
    console.log(payment)
    //delete this.user.paymentMethods[payment]
    for(let i=0; i<this.user.paymentMethods.length;i++){
      console.log(this.user.paymentMethods[i])
      if(payment.cardNumber == this.user.paymentMethods[i].cardNumber){
        this.user.paymentMethods.splice(i,1)
        console.log('DELETE ONE ITEM')
      }
    }
    //window.location.reload()
  }
}
