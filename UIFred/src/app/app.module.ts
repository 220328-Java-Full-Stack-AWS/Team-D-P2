import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { Routes, RouterModule, Router} from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';

import { ProductService } from './services/product.service';

import { ProductComponent } from './components/product/product.component';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'; // <-- bannana box lives here
//ours ///
import { RegistrationComponent } from './components/registration/registration.component';
import { RegistrationService } from './services/registration.service';







    // Redirect the user to your custom login page
   

const routes: Routes = [

  {path: 'search/:keyword', component: ProductComponent},
  {path: 'category/:id', component: ProductComponent},
  {path: 'category', component: ProductComponent},
  {path: 'products', component: ProductComponent},
  {path: 'register', component:RegistrationComponent},
  //{path: '', redirectTo: '/products', pathMatch: 'full'},
  //{path: '', redirectTo: '/products', pathMatch: 'full'}
];

@NgModule({
  declarations: [
    AppComponent,
    ProductComponent,
    RegistrationComponent
  
    
    
  ],
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
	  FormsModule
   
  ],
  providers: [ProductService,RegistrationService],
              
  bootstrap: [AppComponent]
})
export class AppModule { }







