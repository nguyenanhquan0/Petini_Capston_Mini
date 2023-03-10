import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { GuestRoutingModule } from './guest-routing.module';
import { MdbDropdownModule } from 'mdb-angular-ui-kit/dropdown';


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    GuestRoutingModule,
    MdbDropdownModule
  ]
})
export class GuestModule { }
