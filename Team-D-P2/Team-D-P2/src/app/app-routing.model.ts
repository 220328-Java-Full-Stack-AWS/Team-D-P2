import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateProductComponent } from 'src/create-product/create-product.component';
import { ProductListComponent } from 'src/product-list/product-list.component';
import { ProductDetailsComponent } from 'src/product-details/product-details.component';
import { UpdateProductComponent } from 'src/update-product/update-product.component';

const routes: Routes = [
  {path: 'product', component: ProductListComponent},
  {path: 'create-product', component: CreateProductComponent},
  {path: '', redirectTo: 'product', pathMatch: 'full'},
  {path: 'update-product/:id', component: UpdateProductComponent},
  {path: 'product-details/:id', component: ProductDetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],                                                                                                                                                                                                                                                                                                          
  exports: [RouterModule]
})
export class AppRoutingModule { }
