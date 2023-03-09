import { Component, OnInit } from '@angular/core';
import { ImageService } from '../../../services/image.service';
import { MatDialog } from '@angular/material/dialog';
import { MessageComponent } from '../../../pop-up/message/message.component';
import { SuccessComponent } from '../../../pop-up/success/success.component';

@Component({
  selector: 'app-item-detail',
  templateUrl: './item-detail.component.html',
  styleUrls: ['./item-detail.component.scss'],
})
export class ItemDetailComponent implements OnInit {
  ngOnInit(): void {}
  constructor(private image: ImageService, public dialog: MatDialog) {}

  message!: string;
  isUpdate = false;
  name!: string;
  description!: string;
  status!: string;
  imageUrl!: string;
  quantity!: string;
  price!: string;

  updateItems() {

  }
  getItems(){

  }
  openDialogMessage() {
    this.dialog.open(MessageComponent, {
      data: this.message,
    });
  }
  openDialogSuccess() {
    this.dialog.open(SuccessComponent, {
      data: this.message,
    });
  }

  files: File[] = [];
  file!: File;
  itemFile!: File;
  showReview = false;
  onSelect(files: any) {
    console.log(event);
    this.files.push(...files.addedFiles);
    for (this.file of this.files) {
      this.itemFile = this.file;
      console.log(this.itemFile);
    }
    if (this.files.length >= 1) {
      this.showReview = true;
    }
  }

  onRemove(event: File) {
    console.log(event);
    this.files.splice(this.files.indexOf(event), 1);
    if (this.files.length >= 1) {
      this.showReview = true;
    } else {
      this.itemFile;
      this.showReview = false;
    }
  }
}
