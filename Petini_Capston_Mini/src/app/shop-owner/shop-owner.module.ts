import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ShopOwnerRoutingModule } from './shop-owner-routing.module';
import { ShopOwnerComponent } from './shop-owner.component';

import {MatSidenavModule} from '@angular/material/sidenav';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatListModule} from '@angular/material/list';
import {MatGridListModule} from '@angular/material/grid-list';
import { MatButtonModule } from '@angular/material/button';
import { MdbCarouselModule } from 'mdb-angular-ui-kit/carousel';
import { MatIconModule } from '@angular/material/icon';
import { AddItemsComponent } from './add-items/add-items.component';
import { matFormFieldAnimations, MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { FormsModule } from '@angular/forms';
import { NgxDropzoneModule } from 'ngx-dropzone';


@NgModule({
  declarations: [
    ShopOwnerComponent,
    AddItemsComponent
  ],
  imports: [
    CommonModule,
    ShopOwnerRoutingModule,
    MatSidenavModule,
    MatToolbarModule,
    MatListModule,
    MatGridListModule,
    MatButtonModule,
    MdbCarouselModule,
    MatIconModule,
    MatInputModule,
    MatFormFieldModule,
    FormsModule,
    NgxDropzoneModule
  ]
})
export class ShopOwnerModule { }
