import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'
import { AppComponent } from './app.component';
import { FormsModule} from '@angular/forms';
import { AppRoutingModule } from './app-routing.model';
import { ProductListComponent } from 'src/product-list/product-list.component';
import { CreateProductComponent } from 'src/create-product/create-product.component';
import { ProductDetailsComponent } from 'src/product-details/product-details.component';
import { UpdateProductComponent } from 'src/update-product/update-product.component';

@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent,
    CreateProductComponent,
    UpdateProductComponent,
    ProductDetailsComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
