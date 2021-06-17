import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListProductComponent } from './components/Product/list-product/list-product.component';
import { HeaderComponent } from './components/header/header.component';
import { FormsModule } from '@angular/forms';
import { ServiceProductService } from './service/service-product.service';
import{ HttpClientModule } from '@angular/common/http';
import { NewProductComponent } from './components/Product/new-product/new-product.component';
import { HomeComponent } from './components/home/home.component';
import { HomeUserComponent } from './components/User/home-user/home-user.component';
import { LoginComponent } from './components/User/login/login.component';
import { HeaderUserComponent } from './components/User/header-user/header-user.component';
import { EditProductComponent } from './components/Product/edit-product/edit-product.component';
import { NgxPaginationModule } from 'ngx-pagination';
import { ReactiveFormsModule } from '@angular/forms';
import { ShoppingComponent } from './components/Product/shopping/shopping.component';
import { OrderComponent } from './components/Order/order/order.component';
import { EditorderComponent } from './components/Order/editorder/editorder.component';
import { IdfinderComponent } from './components/Order/idfinder/idfinder.component';
import { FinalComponent } from './components/Order/final/final.component';
import { OrderdisplayComponent } from './components/Order/orderdisplay/orderdisplay.component'

@NgModule({
  declarations: [
    AppComponent,
    ListProductComponent,
    HeaderComponent,
    NewProductComponent,
    HomeComponent,
    HomeUserComponent,
    LoginComponent,
    HeaderUserComponent,
    EditProductComponent,
    ShoppingComponent,
    OrderComponent,
    EditorderComponent,
    IdfinderComponent,
    FinalComponent,
    OrderdisplayComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgxPaginationModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [ServiceProductService],
  bootstrap: [AppComponent]
})
export class AppModule { }
