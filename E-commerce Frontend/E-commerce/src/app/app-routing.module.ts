import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeUserComponent } from './components/User/home-user/home-user.component';
import { HomeComponent } from './components/home/home.component';
import { ListProductComponent } from './components/Product/list-product/list-product.component';
import { NewProductComponent } from './components/Product/new-product/new-product.component';
import { LoginComponent } from './components/User/login/login.component';
import { EditProductComponent } from './components/Product/edit-product/edit-product.component';
import { ShoppingComponent } from './components/Product/shopping/shopping.component';
import { OrderComponent } from './components/Order/order/order.component';
import { EditorderComponent } from './components/Order/editorder/editorder.component';
import { IdfinderComponent } from './components/Order/idfinder/idfinder.component';
import { FinalComponent } from './components/Order/final/final.component';
import { OrderdisplayComponent } from './components/Order/orderdisplay/orderdisplay.component';

const routes: Routes = [
  {
    path:'', component:HomeComponent
  },
  {
    path:'newproduct', component:NewProductComponent
  },
  {
    path:'listproduct', component:ListProductComponent
  },
  {
    path:'homeuser', component:HomeUserComponent
  },
  {
    path: 'login', component:LoginComponent
  },
  {
    path: 'homeuser/editproduct/:id', component:EditProductComponent
  },
  {
    path: 'shopping', component:ShoppingComponent
  },
  {
    path: 'order', component:OrderComponent
  },
  {
    path: 'order/editorder/:id', component:EditorderComponent
  },
  {
    path: 'idfinder', component:IdfinderComponent
  },
  {
    path: 'idfinder/final/:id', component:FinalComponent
  },
  {
    path: 'orders', component:OrderdisplayComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
