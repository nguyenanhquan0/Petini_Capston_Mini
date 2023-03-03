import { Component } from '@angular/core';
import {
  FormControl,
  FormGroupDirective,
  NgForm,
  Validators,
} from '@angular/forms';
import { ErrorStateMatcher } from '@angular/material/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginService } from '../services/login.service';
import { BehaviorSubject, Observable } from 'rxjs';
import { Output, EventEmitter } from '@angular/core';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent {
  hide = true;
  passwordFormControl = new FormControl('', [Validators.required]);
  usernameFormControl = new FormControl('', [Validators.required]);
  matcher = new MyErrorStateMatcher();

  constructor(
    private http: LoginService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  private loggedIn: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(
    false
  );

  protected login() {
    this.http
      .login(
        this.usernameFormControl.value + '',
        this.passwordFormControl.value + ''
      )
      .subscribe((data) => {
        localStorage.setItem('userToken', data['token']);
        localStorage.setItem('username', data['username']);
this.updateData = "true"
        this.updateDataEvent.emit(this.updateData);
        console.log(this.updateDataEvent);
        console.log(data);
        console.log(data['role']);
        if (data['role'] === 'CUSTOMER') {
          this.router.navigate([''], { relativeTo: this.route });
        }
        else if (data['role'] === 'SHOPOWNER') {
          this.router.navigate(['/ShopOwner'], { relativeTo: this.route });
        }
      });
  }

  @Output() updateDataEvent  = new EventEmitter<string>();
  updateData = "";

}

/** Error when invalid control is dirty, touched, or submitted. */
export class MyErrorStateMatcher implements ErrorStateMatcher {
  isErrorState(
    control: FormControl | null,
    form: FormGroupDirective | NgForm | null
  ): boolean {
    const isSubmitted = form && form.submitted;
    return !!(
      control &&
      control.invalid &&
      (control.dirty || control.touched || isSubmitted)
    );
  }
}
