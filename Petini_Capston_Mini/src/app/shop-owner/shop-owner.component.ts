import { MediaMatcher } from '@angular/cdk/layout';
import { Component, OnInit,ChangeDetectorRef } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-shop-owner',
  templateUrl: './shop-owner.component.html',
  styleUrls: ['./shop-owner.component.scss'],
})
export class ShopOwnerComponent implements OnInit {
  public username :any
  public role:any
  constructor(
    private router: Router,
    private route: ActivatedRoute,
    changeDetectorRef: ChangeDetectorRef,
    media: MediaMatcher
  ) {
    this.mobileQuery = media.matchMedia('(max-width: 600px)');
    this._mobileQueryListener = () => changeDetectorRef.detectChanges();
    this.mobileQuery.addListener(this._mobileQueryListener);
  }
  public avatarUrl = '';
  ngOnInit(): void {
    this.username = localStorage.getItem('username');
    this.role = localStorage.getItem('roles');
  }

  public logout() {
    localStorage.clear();
    this.router.navigate(['/Login'], { relativeTo: this.route });
  }

  isExpanded = true;
  showSubmenu: boolean = false;
  isShowing = false;
  showSubSubMenu: boolean = false;

  mobileQuery: MediaQueryList;
  private _mobileQueryListener: () => void;
  ngOnDestroy(): void {
    this.mobileQuery.removeListener(this._mobileQueryListener);
  }
}
