import { Component, OnInit } from '@angular/core';
import { MessageComponent } from '../pop-up/message/message.component';
import { MatDialog } from '@angular/material/dialog';
import { ImageService } from '../services/image.service';
import { ManageItemsService } from '../services/manage-items.service';
import { ActivatedRoute, Router } from '@angular/router';
import { SuccessComponent } from '../pop-up/success/success.component';

@Component({
  selector: 'app-items',
  templateUrl: './items.component.html',
  styleUrls: ['./items.component.scss'],
})
export class ItemsComponent implements OnInit {
  isLogin = false;
  ngOnInit(): void {
    try {
      if (localStorage.getItem('userToken')) {
        const name = localStorage.getItem('getItemsName') as string;
        console.log(name);
        this.http.getItem(name).subscribe(
          async (data) => {
            console.log(data);
            this.name = data['name'];
            this.description = data['description'];
            this.status = '';
            this.quantity = data['quantity'];
            this.price = data['price'];

            // get file image
            await this.image
              .getImage('items/' + data['imageUrl'])
              .then((url) => {
                this.imageUrl = url;
              })
              .catch((error) => {});
            console.log(this.imageUrl);
          },
          (error) => {
            this.message = error.message;
            this.openDialogMessage();
          }
        );
      } else {
        this.router.navigate(['/Login'], { relativeTo: this.route });
      }
    } catch (error) {}
  }
  constructor(
    private image: ImageService,
    public dialog: MatDialog,
    private http: ManageItemsService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  message = '';
  name = '';
  description = '';
  status = '';
  imageUrl = '';
  quantity = 0;
  price = '';
  amount = 0;

  openDialogMessage() {
    this.dialog.open(MessageComponent, {
      data: this.message,
    });
  }

  addToCart() {
    console.log(this.amount)
    this.http.addToCart(this.name, this.amount).subscribe((data)=>{
      console.log("suces");
      this.message = "Thành Công";
      this.openDialogSuccess();
    },
    (error) => {
      this.message = error;
      this.openDialogMessage();
    })
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
}
