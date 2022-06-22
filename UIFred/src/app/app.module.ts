import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { Routes, RouterModule, Router} from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { ProductService } from './services/product.service';
import { ProductComponent } from './components/product/product.component';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RegistrationComponent } from './components/registration/registration.component';
import { RegistrationService } from './services/registration.service';
import { PaymentService } from './services/payment.service';
import { PaymentComponent } from './components/payment/payment.component';
import { LoginComponent } from './components/login/login.component';
import { CartComponent } from './components/cart/cart.component';
import { UserComponent } from './components/user/user.component';
import { SearchComponent } from './components/search/search.component';
import { ShareService } from './services/share.service';
    // Redirect the user to your custom login page

const routes: Routes = [

  {path: 'search/:keyword', component: ProductComponent},
  {path: 'category/:categoryName', component: ProductComponent},
  {path: 'login', component: LoginComponent},
  {path: 'category', component: ProductComponent},
  {path: '', component: ProductComponent},
  {path: 'register', component:RegistrationComponent},
  {path: 'cart', component:CartComponent},
  {path: 'userPage',component:UserComponent}
  //{path: '', redirectTo: '/products', pathMatch: 'full'},
  //{path: '', redirectTo: '/products', pathMatch: 'full'}
];

@NgModule({
  declarations: [
    AppComponent,
    ProductComponent,
    LoginComponent,
    RegistrationComponent,
    PaymentComponent,
    CartComponent,
    UserComponent,
    SearchComponent


  ],
  imports: [
    RouterModule.forRoot(routes,{onSameUrlNavigation:'reload'}),
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
	  FormsModule

  ],
  providers: [PaymentService,ProductService,RegistrationService,ShareService],

  bootstrap: [AppComponent]
})
export class AppModule { }

function ProductGridComponent(ProductGridComponent: any) {
  throw new Error('Function not implemented.');
}


