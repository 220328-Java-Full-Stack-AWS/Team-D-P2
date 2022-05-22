import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CartComponent } from './cart-details.component';
import { CategoryComponent } from '../category/category.component';
import { ProductComponent } from '../product/product.component';
import { UserComponent } from '../user/user.component';

const routes: Routes = [
  {path: 'cart',component: CartComponent},
  {path: 'category',component: CategoryComponent},
  {path: 'product',component: ProductComponent},
  {path: 'user',component: UserComponent},
  {path: 'registration',component: RegistrationComponent},
  {path: 'login', component: LoginComponent}

]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
