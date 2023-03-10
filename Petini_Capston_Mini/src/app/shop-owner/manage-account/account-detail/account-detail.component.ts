import { Component } from '@angular/core';
import { UserService } from 'src/app/services/user.service';

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

  constructor(private http : UserService){
    const currentYear = new Date().getFullYear();
    const currentDate = new Date();
    currentDate.setDate(currentDate.getDate() - 1);
    this.minDate = new Date(currentYear - 100, 0, 0);
    this.maxDate = new Date(currentDate);
  }
  ngOnInit(){
    this.getProfile()
  }
  value: any;
  getProfile(){
    this.http.getUserInfo().subscribe((data =>{
      console.log(data)
      this.username = data["username"]
      this.email = data["email"]
      this.phone = data["phone"]
      this.dob = data["dob"]
      this.address = data["address"];
    }))
  }
}
