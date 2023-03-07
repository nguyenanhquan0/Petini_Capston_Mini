import { Dialog } from '@angular/cdk/dialog';
import { Component, OnInit,Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-success',
  templateUrl: './success.component.html',
  styleUrls: ['./success.component.scss']
})
export class SuccessComponent implements OnInit{
  constructor(@Inject(MAT_DIALOG_DATA) public data: string, public dialogRef: MatDialogRef<SuccessComponent>) {}
  closeDialog(): void {

    this.dialogRef.close();
  }
  ngOnInit(): void {

    if (localStorage.getItem('accept-landlord-detail') === 'true') {
      this.dialogRef.disableClose = true;
    }
  }
}
