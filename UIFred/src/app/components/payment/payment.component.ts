import { Component, OnInit } from '@angular/core';
import { Payment } from 'src/app/common/Models';
import { PaymentService } from 'src/app/services/payment/payment.service';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {

  constructor(private paymentService: PaymentService) { }

  ngOnInit(): void {
  }

  cardNumber : string = ""
  expirationDate : string = ""
  cvvNumber : number = 0


  addPayment(){
    let payment: Payment = new Payment(this.cardNumber,this.expirationDate,this.cvvNumber);
    console.log(payment);
    this.paymentService.createPayment(payment).subscribe((data: any) => console.log("user added"))
  }

}
