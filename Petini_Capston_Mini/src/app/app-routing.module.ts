import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { ShopComponent } from './shop/shop.component';
import { PetComponent } from './pet/pet.component';
import { ServiceComponent } from './service/service.component';
import { GuestComponent } from './guest/guest.component';
import { GuestModule } from './guest/guest.module';

const routes: Routes = [


  {
    path: '',
    redirectTo: 'Home',
    pathMatch: 'full',
  },
  {
    path: '',
    component: GuestComponent,
    children: [{
      path: '',
      loadChildren: () => import('./guest/guest.module').then(m => m.GuestModule)
    }]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
