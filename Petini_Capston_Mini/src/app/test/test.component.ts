import { Component, OnInit } from '@angular/core';
import { MyErrorStateMatcher } from '../register/register.component';
import { FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.scss']
})
export class TestComponent implements OnInit{
ngOnInit(): void {

}
matcher = new MyErrorStateMatcher();
usernameFormControl = new FormControl('', [Validators.required]);
usernameFormControl2 = new FormControl('', [Validators.required]);
usernameFormControl3 = new FormControl('', [Validators.required]);
}
