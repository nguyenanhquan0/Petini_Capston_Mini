import { Component, OnInit } from '@angular/core';
import { ManageItemsService } from '../../services/manage-items.service';
import { MatDialog } from '@angular/material/dialog';
import { SuccessComponent } from '../../pop-up/success/success.component';
import { MessageComponent } from '../../pop-up/message/message.component';

@Component({
  selector: 'app-view-cart',
  templateUrl: './view-cart.component.html',
  styleUrls: ['./view-cart.component.scss']
})
export class ViewCartComponent implements OnInit{
  value:data[] = [];
  cart:any;
  ngOnInit(): void {
    this.http.getCart().subscribe((data)=>{
  this.value = data['cartProduct'];
  console.log(data);
  console.log(this.value);
    },
    (error) =>{
      console.log(error)
      this.message = error;
      this.openDialogMessage();
    })
  }
  message:any;
  constructor(private http: ManageItemsService,public dialog: MatDialog,){

  }
  openDialogSuccess() {
    localStorage.setItem('registerSuccess', '');

    const timeout = 3000;
    const dialogRef = this.dialog.open(SuccessComponent, {
      data: this.message,
    });
    dialogRef.afterOpened().subscribe((_) => {
      setTimeout(() => {
        dialogRef.close();
      }, timeout);
    });
  }
  openDialogMessage() {
    this.dialog.open(MessageComponent, {
      data: this.message,
    });
  }
}

export interface data {

  name: string;
  description: string;
  status: string;
  imageUrl: string;
  quantity: string;
  price: string;
}
