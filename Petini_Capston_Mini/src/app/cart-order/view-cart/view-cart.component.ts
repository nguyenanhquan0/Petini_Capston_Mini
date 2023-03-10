import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { SuccessComponent } from '../../pop-up/success/success.component';
import { MessageComponent } from '../../pop-up/message/message.component';
import { ImageService } from '../../services/image.service';
import { ProductService } from '../../services/product.service';
import { CartService } from '../../services/cart.service';

@Component({
  selector: 'app-view-cart',
  templateUrl: './view-cart.component.html',
  styleUrls: ['./view-cart.component.scss'],
})
export class ViewCartComponent implements OnInit {
  value: data[] = [];
  cart: any;

  ngOnInit(): void {
    this.http.getCustomerShoppingCart().subscribe(
      async (data) => {
         const cartProduct = data['cartProduct'];
         let imgUrl ='';
         for( let i of cartProduct){
          await this.image
              .getImage('items/' + i.product.imageUrl)
              .then((url) => {
                imgUrl = url;
              })
              .catch((error) => {});

          this.value.push({
            name:i.product.name,
            description:i.product.description,
            price:i.product.price,
            quantity:i.quantity,
            imageUrl:imgUrl
          })
         }

        console.log(data);
        console.log(this.value);
      },
      (error) => {
        console.log(error);
        this.message = error;
        this.openDialogMessage();
      }
    );
  }
  message: any;
  constructor(private http: CartService, public dialog: MatDialog, private image: ImageService,) {}
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
  imageUrl: string;
  quantity: number;
  price: number;
}
