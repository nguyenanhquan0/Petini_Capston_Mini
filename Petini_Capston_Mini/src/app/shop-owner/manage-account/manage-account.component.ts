import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MessageComponent } from '../../pop-up/message/message.component';
import { SuccessComponent } from '../../pop-up/success/success.component';

@Component({
  selector: 'app-manage-account',
  templateUrl: './manage-account.component.html',
  styleUrls: ['./manage-account.component.scss'],
})
export class ManageAccountComponent implements OnInit {
  valuesCustomer: data[] = [];
  valuesOwner: data[] = [];
  message!: string;

  constructor(public dialog: MatDialog) {}
  ngOnInit(): void {}

  title = 'pagination';
  page: number = 1;
  count: number = 0;
  tableSize: number = 5;

  // Customer
  onTableDataChangeCustomer(event: any) {
    this.page = event;
    this.valuesCustomer;
  }

  // Owner
  onTableDataChangeOwner(event: any) {
    this.page = event;
    this.valuesOwner;
  }

  public onItemSelector(id: number, username: string) {
    localStorage.setItem('id', id + '');
    localStorage.setItem('usernameSelector', username);
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
  openDialogAction(){}
  accept(){}
  reject(){}
}

export interface data {
  id: number;
  username: string;
  email: string;
  status: string;
  avatarUrl:string;
  phone:string;
}
