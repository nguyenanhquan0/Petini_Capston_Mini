import { Component } from '@angular/core';

@Component({
  selector: 'app-account-detail',
  templateUrl: './account-detail.component.html',
  styleUrls: ['./account-detail.component.scss']
})
export class AccountDetailComponent {

  id:any
  username:any
  email:any
  status:any
  avatarUrl:any
  phone:any
  dob:any
  address:any

  minDate!: Date;
  maxDate!: Date;

  constructor(){
    const currentYear = new Date().getFullYear();
    const currentDate = new Date();
    currentDate.setDate(currentDate.getDate() - 1);
    this.minDate = new Date(currentYear - 100, 0, 0);
    this.maxDate = new Date(currentDate);
  }
}
