import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddItemsComponent } from './add-items/add-items.component';
import { ShopOwnerComponent } from './shop-owner.component';

const routes: Routes = [
  {
    path:'',
    component: ShopOwnerComponent,
    children:[{
      path:'AddItems',
      component:AddItemsComponent
    }]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ShopOwnerRoutingModule { }
