import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CartComponent } from './components/cart/cart.component';
import { CategoryComponent } from './components/category/category.component';
import { ProductComponent } from './components/product/product.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { UserComponent } from './components/user/user.component';
import { LoginComponent } from './components/login/login.component';


const routes: Routes = [
  {path: 'cart',component: CartComponent},
  {path: 'category',component: CategoryComponent},
  {path: 'product',component: ProductComponent},
  {path: 'user',component: UserComponent},
  {path: 'registration',component:RegistrationComponent},
  {path: 'login', component:LoginComponent}

]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
