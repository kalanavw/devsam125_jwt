import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from './pages/login/login.component';
import {ProductListComponent} from './pages/product-list/product-list.component';
import {AddProductComponent} from './pages/add-product/add-product.component';
import {AuthGuard} from './config/auth-guard';

const routes: Routes = [
  {path: '', pathMatch: 'full', component: LoginComponent},
  {path: 'login', component: LoginComponent},
  {path: 'product-list', component: ProductListComponent, canActivate: [AuthGuard]},
  {path: 'add-product', component: AddProductComponent, canActivate: [AuthGuard]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
