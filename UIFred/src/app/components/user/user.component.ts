import { Component, OnInit } from '@angular/core';
import { Payment } from 'src/app/common/Models';
import { User } from 'src/app/common/User';
import { LoginService } from 'src/app/services/login/login.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  constructor(private loginService:LoginService) { }

  user:any={}
  ngOnInit(): void {
    let x=sessionStorage.getItem("user")
    console.log(x)
    this.user=JSON.parse(x);
    console.log(this.user)
  }
  update():void{
    console.log(this.user)//correct
    this.loginService.updateUser(this.user).subscribe((user:User)=>{
      console.log(user)//wrong
      this.user=user;
    })
    sessionStorage.setItem("user",JSON.stringify(this.user))
  }
  addPayment():void{
    let x:Payment =new Payment("","","");
    if(this.user.paymentMethods.length==0){
      x.id=1;
    }else{
    x.id=this.user.paymentMethods[this.user.paymentMethods.length-1].id+1;
    }
    this.user.paymentMethods.push(x);
    
  }
  removePayment(payment:any){
    console.log(payment)
    //delete this.user.paymentMethods[payment]
    for(let i=0; i<this.user.paymentMethods.length;i++){
      console.log(this.user.paymentMethods[i])
      if(payment.id == this.user.paymentMethods[i].id){
        this.user.paymentMethods.splice(i,1)
        console.log('DELETE ONE ITEM')
      }
    }
    //window.location.reload()
  }
}
