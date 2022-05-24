import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { Routes, RouterModule, Router} from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';

import { ProductService } from './services/product.service';

import { ProductComponent } from './components/product/product.component';
import { NgModule } from '@angular/core';










    // Redirect the user to your custom login page
   

const routes: Routes = [

  {path: 'search/:keyword', component: ProductComponent},
  {path: 'category/:id', component: ProductComponent},
  {path: 'category', component: ProductComponent},
  {path: 'products', component: ProductComponent},
  {path: '', redirectTo: '/products', pathMatch: 'full'},
  {path: '**', redirectTo: '/products', pathMatch: 'full'}
];

@NgModule({
  declarations: [
    AppComponent,
  ProductComponent
 
  
    
    
  ],
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule
   
  ],
  providers: [ProductService],
              
  bootstrap: [AppComponent]
})
export class AppModule { }







function ProductGridComponent(ProductGridComponent: any) {
  throw new Error('Function not implemented.');
}

