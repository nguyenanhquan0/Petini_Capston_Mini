import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-shop-owner',
  templateUrl: './shop-owner.component.html',
  styleUrls: ['./shop-owner.component.scss']
})
export class ShopOwnerComponent {
  constructor( private router: Router,private route: ActivatedRoute,){

  }
  public logout() {
    localStorage.clear();
    this.router.navigate(['/Login'], { relativeTo: this.route });
  }
}
