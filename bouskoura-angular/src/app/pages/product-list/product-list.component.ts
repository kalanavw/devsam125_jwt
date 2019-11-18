import {Component, OnInit} from '@angular/core';
import {AuthService} from '../../service/auth.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  constructor(private auth: AuthService) {
  }

  ngOnInit() {
  }

  logout() {
    this.auth.logout();
  }
}
